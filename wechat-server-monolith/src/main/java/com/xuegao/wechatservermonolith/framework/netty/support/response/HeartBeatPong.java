package com.xuegao.wechatservermonolith.framework.netty.support.response;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.framework.netty.support.IMessageType;
import com.xuegao.wechatservermonolith.framework.netty.support.MessageTypeFactory;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class HeartBeatPong implements Serializable, IMessageType {
    private static final long serialVersionUID = 1L;

    /**
     * 消息类型，HeartBeatPong = 4
     */
    private Integer messageType;
    /**
     * 消息内容
     */
    private String content;

    @Override
    public Integer getMessageTypeHandler() {
        MessageTypeFactory.register(MsgSendTypeEnum.HeartBeatPong.getCode(), this);
        return MsgSendTypeEnum.HeartBeatPong.getCode();
    }
}
