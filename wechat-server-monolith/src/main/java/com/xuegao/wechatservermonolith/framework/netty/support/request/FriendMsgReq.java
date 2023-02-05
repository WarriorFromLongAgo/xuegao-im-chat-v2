package com.xuegao.wechatservermonolith.framework.netty.support.request;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;

public class FriendMsgReq extends CommonMsgReq {
    @Override
    public Integer getMessageTypeHandler() {
        return MsgSendTypeEnum.ONE_TO_ONE.getCode();
    }

    public static FriendMsgReq buildMsgReqByReq(String msg) {
        FriendMsgReq req = new FriendMsgReq();
        req.setMessageType(MsgSendTypeEnum.ONE_TO_ONE.getCode());
        req.setMessageName(MsgSendTypeEnum.ONE_TO_ONE.getMsg());
        req.setContent(msg);
        return req;
    }
}
