package com.xuegao.wechatservermonolith.framework.netty.support.request;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;

public class GroupMsgReq extends CommonMsgReq {
    @Override
    public Integer getMessageTypeHandler() {
        return MsgSendTypeEnum.MANY_TO_MANY.getCode();
    }

    public static GroupMsgReq buildMsgReqByReq(String msg) {
        GroupMsgReq req = new GroupMsgReq();
        req.setMessageType(MsgSendTypeEnum.MANY_TO_MANY.getCode());
        req.setMessageName(MsgSendTypeEnum.MANY_TO_MANY.getMsg());
        req.setContent(msg);
        return req;
    }
}
