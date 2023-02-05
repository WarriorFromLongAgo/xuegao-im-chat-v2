package com.xuegao.wechatservermonolith.framework.netty.support;

public interface IMessageType {

    Integer getMessageType();

    String getContent();

    /**
     *
     */
    Integer getMessageTypeHandler();
}
