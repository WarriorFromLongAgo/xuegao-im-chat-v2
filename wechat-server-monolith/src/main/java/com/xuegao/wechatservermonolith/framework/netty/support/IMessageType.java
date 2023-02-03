package com.xuegao.wechatservermonolith.framework.netty.support;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;

public interface IMessageType {
    /**
     *
     */
    static Integer getMessageTypeHandler() {
        return MsgSendTypeEnum.UNKNOWN.getCode();
    }
}
