package com.cfh.practice.user.controller;

import com.cfh.practice.user.dataobject.UserInfo;
import com.cfh.practice.user.enums.RoleEnum;
import com.cfh.practice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: cfh
 * @Date: 2018/9/24 15:05
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/create")
    public void testCreateUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("小二");
        userInfo.setPassword("12345");
        userInfo.setRole(RoleEnum.SELLER.getCode());
        userInfo.setOpenid("abc");
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUsername("客官");
        userInfo2.setPassword("12345");
        userInfo2.setRole(RoleEnum.CUSTOMER.getCode());
        userInfo2.setOpenid("xyz");
        userInfo2.setCreateTime(new Date());
        userInfo2.setUpdateTime(new Date());

        userService.createUser(userInfo);
        userService.createUser(userInfo2);
    }
}
