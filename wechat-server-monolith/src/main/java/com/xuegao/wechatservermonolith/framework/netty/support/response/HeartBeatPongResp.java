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
        HeartBeatPongResp pong = new HeartBeatPongResp();
        pong.setMessageType(MsgSendTypeEnum.HEART_BEAT_PONG.getCode());
        pong.setMessageName(MsgSendTypeEnum.HEART_BEAT_PONG.getMsg());
        pong.setContent("pong");
        return pong;
    }
}
