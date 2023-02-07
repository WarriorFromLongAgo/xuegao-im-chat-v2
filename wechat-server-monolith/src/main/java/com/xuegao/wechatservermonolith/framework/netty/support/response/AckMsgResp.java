package com.xuegao.wechatservermonolith.framework.netty.support.response;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;

public class AckMsgResp extends CommonMsgResp {

    @Override
    public Integer getMessageTypeHandler() {
        return MsgSendTypeEnum.ACK.getCode();
    }

    public static AckMsgResp buildPongByPing() {
        AckMsgResp resp = new AckMsgResp();
        resp.setMessageType(MsgSendTypeEnum.ACK.getCode());
        resp.setMessageName(MsgSendTypeEnum.ACK.getMsg());
        return resp;
    }
}
