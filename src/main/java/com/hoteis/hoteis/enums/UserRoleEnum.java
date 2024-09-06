package com.hoteis.hoteis.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
    ADMIN("ADMIN"),
    USER("USER"),
    GUEST("GUEST");

    private String userRole;

    UserRoleEnum(String userRole){
        this.userRole = userRole;
    }
}
