package com.xuegao.wechatservermonolith.framework.netty.support.request;

import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;

public class SysUserMsgReq extends CommonMsgReq {
    @Override
    public Integer getMessageTypeHandler() {
        return MsgSendTypeEnum.BING_SESSION.getCode();
    }

    public static SysUserMsgReq buildMsgReqByReq(String msg) {
        SysUserMsgReq req = new SysUserMsgReq();
        req.setMessageType(MsgSendTypeEnum.BING_SESSION.getCode());
        req.setMessageName(MsgSendTypeEnum.BING_SESSION.getMsg());
        req.setContent(msg);
        return req;
    }
}
