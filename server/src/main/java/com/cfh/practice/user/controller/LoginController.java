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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
}
