package com.cfh.practice.user.service;

import com.cfh.practice.user.dataobject.UserInfo;

/**
 * @Author: cfh
 * @Date: 2018/9/24 14:43
 * @Description:
 */
public interface UserService {

    void createUser(UserInfo userInfo);

    UserInfo findUserByOpenid(String openId);
}
