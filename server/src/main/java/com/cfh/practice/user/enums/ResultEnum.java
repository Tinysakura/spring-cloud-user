package com.cfh.practice.user.enums;

import lombok.Getter;

/**
 * Created by 廖师兄
 * 2017-12-10 17:32
 */
@Getter
public enum ResultEnum {
    REPEAT_LOGIN(1, "已登录不要重复登录"),
    LOGIN_SUCCESS(0, "登录成功")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
