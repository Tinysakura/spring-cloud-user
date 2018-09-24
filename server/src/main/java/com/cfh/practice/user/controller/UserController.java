package com.cfh.practice.user.controller;

import com.cfh.practice.user.common.UserInfoOutput;
import com.cfh.practice.user.dataobject.UserInfo;
import com.cfh.practice.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cfh
 * @Date: 2018/9/24 15:24
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findUserByOpenid")
    public UserInfoOutput findUserByOpenid(String openId){
        UserInfo userInfo = userService.findUserByOpenid(openId);
        UserInfoOutput userInfoOutput = new UserInfoOutput();
        BeanUtils.copyProperties(userInfo, userInfoOutput);

        return userInfoOutput;
    }
}
