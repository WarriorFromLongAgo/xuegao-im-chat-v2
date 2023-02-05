package com.xuegao.wechatservermonolith.framework.netty.support.request;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.framework.netty.support.IMessageType;

import java.io.Serializable;

public class CommonMsgReq implements Serializable, IMessageType {
    private static final long serialVersionUID = 1L;

    /**
     * 消息类型
     * {@link MsgSendTypeEnum}
     */
    private Integer messageType;
    /**
     * 消息类型
     * {@link MsgSendTypeEnum}
     */
    private String messageName;
    /**
     * 消息内容
     */
    private String content;

    @Override
    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    @Override
    public Integer getMessageTypeHandler() {
        return MsgSendTypeEnum.UN_KNOWN.getCode();
    }

    // public static void registerMessageTypeHandler() {
    //     MessageTypeFactory.register(MsgSendTypeEnum.UN_KNOWN, this);
    // }

    public static CommonMsgReq buildMsgReqByReq(String msg) {
        CommonMsgReq req = new CommonMsgReq();
        req.setMessageType(MsgSendTypeEnum.UN_KNOWN.getCode());
        req.setMessageName(MsgSendTypeEnum.UN_KNOWN.getMsg());
        req.setContent(msg);
        return req;
    }
}
