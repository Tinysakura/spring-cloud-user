package com.cfh.practice.user.service.impl;

import com.cfh.practice.user.dataobject.UserInfo;
import com.cfh.practice.user.repository.UserInfoRepository;
import com.cfh.practice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: cfh
 * @Date: 2018/9/24 14:51
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findUserByOpenid(String openId) {
        return userInfoRepository.findUserInfoByOpenid(openId);
    }

    @Override
    public void createUser(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }
}
