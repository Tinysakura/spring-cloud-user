package com.cfh.practice.user.repository;

import com.cfh.practice.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: cfh
 * @Date: 2018/9/24 14:49
 * @Description:
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    public UserInfo findUserInfoByOpenid(String openid);
}
