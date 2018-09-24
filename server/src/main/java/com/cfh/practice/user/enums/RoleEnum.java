package com.cfh.practice.user.enums;

import lombok.Getter;

/**
 * @Author: cfh
 * @Date: 2018/9/24 14:57
 * @Description:
 */
@Getter
public enum RoleEnum {
    CUSTOMER(1, "买家"),
    SELLER(0, "卖家")
    ;

    int code;
    String role;

    RoleEnum(int code, String role) {
        this.code = code;
        this.role = role;
    }
}
