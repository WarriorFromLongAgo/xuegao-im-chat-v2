package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.framework.netty.support.request.FriendMsgReq;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
public class FriendMsgReqHandler extends SimpleChannelInboundHandler<FriendMsgReq> {
    private static final Logger log = LoggerFactory.getLogger(FriendMsgReqHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FriendMsgReq msg) {
        log.info("[wechat-server-monolith][FriendMsgReqHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
    }
}
