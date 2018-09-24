package com.cfh.practice.user.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: cfh
 * @Date: 2018/9/24 14:44
 * @Description:
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo {
    /** 主键(自动增长型)**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    /** 用户名 **/
    String username;

    /** 密码 **/
    String password;

    /** 用户微信的open_id **/
    String openid;

    /** 用户的角色，0代表卖家1代表买家 **/
    int role;

    /** 消息记录创建的时间戳 **/
    Date createTime;

    /** 消息记录修改的时间戳 **/
    Date updateTime;
}
