package com.xuegao.wechatservermonolith.common.enums;

import com.xuegao.core.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum MsgSendTypeEnum {
    // region 系统层面的消息或者会话
    /**
     * 0 = 未知
     */
    UN_KNOWN(0, "未知"),
    /**
     * 1 = 链接 websocket
     */
    WS_OPEN(1, "链接 websocket"),
    /**
     * 2 = 断开 websocket
     */
    WS_CLOSE(2, "断开 websocket"),
    /**
     * 3 = 发送 websocket 消息
     */
    WS_MSG(3, "发送 websocket 消息"),
    /**
     * 4 = 异常 websocket
     */
    WS_ERROR(4, "异常 websocket"),
    /**
     * 10001 = 系统机器人
     */
    ROBOT(10001, "系统机器人"),
    /**
     * 10002 = 系统通知
     */
    SYSTEM_NOTIFY(10002, "系统通知"),
    /**
     * 10003 = 心跳，客户端发送
     */
    HEART_BEAT_PING(10003, "心跳，客户端发送"),
    /**
     * 10004 = 心跳，服务端发送
     */
    HEART_BEAT_PONG(10004, "心跳，服务端发送"),

    // endregion

    // region 人和人之间的会话
    /**
     * 10005 = 私聊
     */
    ONE_TO_ONE(10005, "私聊"),
    /**
     * 10006 = 群聊
     */
    MANY_TO_MANY(10006, "群聊"),
    // endregion

    // region 其他会话
    /**
     * 10007 = 文件发送助手
     */
    FILE_SEND(10007, "文件发送助手"),
    /**
     * 10008 = 服务订阅号
     */
    SERVICE_SUBSCRIPTION(10008, "服务订阅号"),
    // endregion

    ;

    private static final Logger log = LoggerFactory.getLogger(MsgSendTypeEnum.class);

    private final Integer code;
    private final String msg;

    MsgSendTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static MsgSendTypeEnum getEnumByCode(Integer code) {
        for (MsgSendTypeEnum anEnum : values()) {
            if (anEnum.getCode().equals(code)) {
                return anEnum;
            }
        }
        log.info("[wechat-server-monolith][MsgSendTypeEnum][getEnumByCode][code={}]", code);
        throw new ServiceException("MsgSendTypeEnum getEnumByCode 找不到数据");
    }

}