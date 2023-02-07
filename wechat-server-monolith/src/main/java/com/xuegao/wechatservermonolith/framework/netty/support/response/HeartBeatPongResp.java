package com.xuegao.wechatservermonolith.framework.netty.support.response;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeartBeatPongResp extends CommonMsgResp {

    @Override
    public Integer getMessageTypeHandler() {
        return MsgSendTypeEnum.HEART_BEAT_PONG.getCode();
    }

    public static HeartBeatPongResp buildPongByPing() {
        HeartBeatPongResp resp = new HeartBeatPongResp();
        resp.setMessageType(MsgSendTypeEnum.HEART_BEAT_PONG.getCode());
        resp.setMessageName(MsgSendTypeEnum.HEART_BEAT_PONG.getMsg());
        resp.setContent("pong");
        return resp;
    }
}
