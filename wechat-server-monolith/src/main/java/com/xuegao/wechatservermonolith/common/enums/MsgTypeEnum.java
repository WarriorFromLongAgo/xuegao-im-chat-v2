package com.xuegao.wechatservermonolith.common.enums;

public enum MsgTypeEnum {
    // region 消息类型
    /**
     * 1 = 文字消息
     */
    Text("text", "文字消息"),
    /**
     * 2 = 图片消息
     */
    Image("image", "图片消息"),
    /**
     * 3 = 音频消息
     */
    Audio("audio", "音频消息"),
    /**
     * 4 = 视频消息
     */
    Video("video", "视频消息"),
    /**
     * 5 = 文件消息
     */
    File("file", "文件消息"),

    // endregion

    ;

    private final String code;
    private final String desc;

    MsgTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}