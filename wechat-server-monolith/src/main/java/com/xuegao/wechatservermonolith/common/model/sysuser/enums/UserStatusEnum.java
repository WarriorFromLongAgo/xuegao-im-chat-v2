package com.xuegao.wechatservermonolith.common.model.sysuser.enums;

import lombok.Getter;

@Getter
public enum UserStatusEnum {

    /**
     * 正常
     */
    NORMAL(10, "正常"),
    /**
     * 锁定
     */
    LOCKED(20, "用户状态,10:正常,20:3个月未登录进行删除锁定,30自主销号"),
    /**
     * 注销
     */
    CANCEL(30, "注销"),

    ;

    private final Integer code;
    private final String desc;

    UserStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserStatusEnum getByCode(Integer code) {
        for (UserStatusEnum userStatusEnum : UserStatusEnum.values()) {
            if (userStatusEnum.getCode().equals(code)) {
                return userStatusEnum;
            }
        }
        return null;
    }

}
