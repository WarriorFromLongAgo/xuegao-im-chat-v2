package com.xuegao.wechatservermonolith.common.enums;

public enum MsgSendTypeEnum {
    // region 系统层面的消息或者会话
    /**
     * 0 = 未知
     */
    UNKNOWN(0, "未知"),
    /**
     * 1 = 系统机器人
     */
    Robot(1, "系统机器人"),
    /**
     * 2 = 系统通知
     */
    SystemNotify(2, "系统通知"),
    /**
     * 3 = 心跳，客户端发送
     */
    HeartBeatPing(3, "心跳，客户端发送"),
    /**
     * 4 = 心跳，服务端发送
     */
    HeartBeatPong(4, "心跳，服务端发送"),

    // endregion

    // region 人和人之间的会话
    /**
     * 5 = 私聊
     */
    OneToOne(5, "私聊"),
    /**
     * 6 = 群聊
     */
    ManyToMany(6, "群聊"),
    // endregion

    // region 其他会话
    /**
     * 7 = 文件发送助手
     */
    FileSend(7, "文件发送助手"),
    /**
     * 8 = 服务订阅号
     */
    ServiceSubscription(8, "服务订阅号"),
    // endregion

    ;

    private final Integer code;
    private final String desc;

    MsgSendTypeEnum(Integer code, String desc) {
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