package com.xuegao.wechatservermonolith.framework.netty.support.request;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.framework.netty.support.IMessageType;
import com.xuegao.wechatservermonolith.framework.netty.support.MessageTypeFactory;

import java.io.Serializable;

public class CommonMessage implements Serializable, IMessageType {
    private static final long serialVersionUID = 1L;

    /**
     * 消息类型，0 = 未知
     */
    private Integer messageType;
    /**
     * 消息内容
     */
    private String content;

    @Override
    public Integer getMessageTypeHandler() {
        MessageTypeFactory.register(MsgSendTypeEnum.UNKNOWN.getCode(), this);
        return MsgSendTypeEnum.UNKNOWN.getCode();
    }
}
