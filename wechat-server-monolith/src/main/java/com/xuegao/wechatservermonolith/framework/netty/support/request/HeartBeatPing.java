package com.xuegao.wechatservermonolith.framework.netty.support.request;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.framework.netty.support.IMessageType;

import java.io.Serializable;

public class HeartBeatPing implements Serializable, IMessageType {
    private static final long serialVersionUID = 1L;

    /**
     * 消息类型，HeartBeatPing = 3
     */
    private Integer messageType;
    /**
     * 消息内容
     */
    private String content;

    @Override
    public Integer getMessageTypeHandler() {
        // MessageTypeFactory.register(MsgSendTypeEnum.HeartBeatPing.getCode(), this);
        return MsgSendTypeEnum.HeartBeatPing.getCode();
    }
}
