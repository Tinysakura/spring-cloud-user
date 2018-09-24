package com.cfh.practice.user.controller;

import com.cfh.practice.user.Exception.UncorrectRoleException;
import com.cfh.practice.user.Exception.UnkonwUserException;
import com.cfh.practice.user.VO.ResultVO;
import com.cfh.practice.user.common.UserInfoOutput;
import com.cfh.practice.user.dataobject.UserInfo;
import com.cfh.practice.user.enums.RoleEnum;
import com.cfh.practice.user.service.UserService;
import com.cfh.practice.user.utils.CookieUtil;
import com.cfh.practice.user.utils.ResultVOUtil;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: cfh
 * @Date: 2018/9/24 15:58
 * @Description:
 */
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    static final String SELLER_OPENID_FOMATTER = "openid_%s";

    /**
     * 买家的登录接口
     * @param openid
     * @param response
     * @return
     */
    @PostMapping("/buyer")
    public ResultVO<UserInfoOutput> buyerLogin(@RequestParam("openid") String openid, HttpServletResponse response){
        UserInfo userInfo = userService.findUserByOpenid(openid);

        if (userInfo == null) {
            throw new UnkonwUserException();
        }

        if (userInfo.getRole() != RoleEnum.CUSTOMER.getCode()) {
            throw new UncorrectRoleException();
        }

        UserInfoOutput userInfoOutput = new UserInfoOutput();
        BeanUtils.copyProperties(userInfo, userInfoOutput);

        //将买家的openid放入cookie中
        CookieUtil.writeLoginToken(response, openid);

        return ResultVOUtil.success(userInfoOutput);
    }

    /**
     * 卖家登录的接口
     * 卖家的openid不保存在cookie中，cookie中保存一个uuid, 根据该uuid去Redis中读取openid
     * @param openid
     * @return
     */
    @PostMapping("/seller")
    public ResultVO<UserInfoOutput> sellerLogin(@RequestParam("openid") String openid, HttpServletResponse response, HttpServletRequest request) {
        if(CookieUtil.readLoginToken(request) != null) {
            return ResultVOUtil.repeateLogin(null);
        }

        UserInfo userInfo = userService.findUserByOpenid(openid);

        if (userInfo == null) {
            throw new UnkonwUserException();
        }

        if (userInfo.getRole() != RoleEnum.SELLER.getCode()) {
            throw new UncorrectRoleException();
        }

        UserInfoOutput userInfoOutput = new UserInfoOutput();
        BeanUtils.copyProperties(userInfo, userInfoOutput);

        //将卖家的openid间接存入redis中
        String uuid = UUID.randomUUID().toString();
        CookieUtil.writeLoginToken(response, uuid);
        String redisKey = StringFormatter.format(SELLER_OPENID_FOMATTER, uuid).get();
        redisTemplate.opsForValue().set(redisKey, openid);

        return ResultVOUtil.success(userInfoOutput);
    }

}
