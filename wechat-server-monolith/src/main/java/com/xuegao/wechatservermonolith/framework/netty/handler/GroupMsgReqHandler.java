package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.framework.netty.support.request.GroupMsgReq;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class GroupMsgReqHandler extends SimpleChannelInboundHandler<GroupMsgReq> {
    private static final Logger log = LoggerFactory.getLogger(GroupMsgReqHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMsgReq msg) {
        log.info("[wechat-server-monolith][CommonMessageHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
    }
}
