package com.xuegao.wechatservermonolith.framework.netty.support.request;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;

public class HeartBeatPingMsgReq extends CommonMsgReq {

    @Override
    public Integer getMessageTypeHandler() {
        return MsgSendTypeEnum.HEART_BEAT_PING.getCode();
    }

    public static HeartBeatPingMsgReq buildMsgReqByReq(String msg) {
        HeartBeatPingMsgReq req = new HeartBeatPingMsgReq();
        req.setMessageType(MsgSendTypeEnum.HEART_BEAT_PING.getCode());
        req.setMessageName(MsgSendTypeEnum.HEART_BEAT_PING.getMsg());
        req.setContent(msg);
        return req;
    }
}
