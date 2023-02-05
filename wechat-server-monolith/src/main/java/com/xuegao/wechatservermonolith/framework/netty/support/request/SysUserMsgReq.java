package com.xuegao.wechatservermonolith.framework.netty.support.request;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.util.JsonUtil;
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
        JSONObject jsonObject = JsonUtil.toClass(msg, JSONObject.class);
        String content = jsonObject.getString("content");
        req.setContent(content);
        return req;
    }
}
