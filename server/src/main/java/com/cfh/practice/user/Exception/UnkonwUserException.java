package com.cfh.practice.user.Exception;

/**
 * @Author: cfh
 * @Date: 2018/9/24 16:08
 * @Description:
 */
public class UnkonwUserException extends RuntimeException{
    public UnkonwUserException() {
        super("未知的用户，请检查openID是否正确");
    }
}
