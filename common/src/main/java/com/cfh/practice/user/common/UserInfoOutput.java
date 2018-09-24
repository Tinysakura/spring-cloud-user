package com.cfh.practice.user.common;

import lombok.Data;

/**
 * @Author: cfh
 * @Date: 2018/9/24 15:26
 * @Description:
 */
@Data
public class UserInfoOutput {
    /** 主键(自动增长型)**/
    int id;

    /** 用户名 **/
    String username;

    /** 用户微信的open_id **/
    String openid;

    /** 用户的角色，0代表卖家1代表买家 **/
    int role;
}
