package com.cfh.practice.user.Exception;

/**
 * @Author: cfh
 * @Date: 2018/9/24 16:15
 * @Description:
 */
public class UncorrectRoleException extends RuntimeException{
    public UncorrectRoleException() {
        super("当前用户权限异常");
    }
}
