package com.xuegao.wechatservermonolith.common.enums;

public enum MsgTypeEnum {
    // region 消息类型
    /**
     * 1 = 文字消息
     */
    Text(1, "文字消息"),
    /**
     * 2 = 图片消息
     */
    Image(2, "图片消息"),
    /**
     * 3 = 音频消息
     */
    Audio(3, "音频消息"),
    /**
     * 4 = 视频消息
     */
    Video(4, "视频消息"),
    /**
     * 5 = 文件消息
     */
    File(5, "文件消息"),

    // endregion

    ;

    private final Integer code;
    private final String desc;

    MsgTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}