package com.xuegao.wechatservermonolith.common.model.friend.enums;

import lombok.Getter;

@Getter
public enum DataStatusEnum {

    /**
     * 消息状态，10正常，20撤回
     */
    NORMAL(10, "正常"),
    /**
     * 锁定
     */
    RETRACT(20, "撤回"),

    ;

    private final Integer code;
    private final String desc;

    DataStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static DataStatusEnum getByCode(Integer code) {
        for (DataStatusEnum userStatusEnum : DataStatusEnum.values()) {
            if (userStatusEnum.getCode().equals(code)) {
                return userStatusEnum;
            }
        }
        return null;
    }

}
