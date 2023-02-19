package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.util.SpringUtil;
import com.xuegao.util.time.LocalDateTimeUtil;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.framework.netty.support.request.CommonMsgReq;
import com.xuegao.wechatservermonolith.framework.netty.support.request.FriendMsgReq;
import com.xuegao.wechatservermonolith.friend.manage.FriendMessageMpManage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler.Sharable
// @Component
public class FriendMsgReqHandler extends SimpleChannelInboundHandler<FriendMsgReq> {
    private static final Logger log = LoggerFactory.getLogger(FriendMsgReqHandler.class);

    // @Autowired
    // private FriendMessageMpManage friendMessageMpManage;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FriendMsgReq msg) {
        // log.info("[wechat-server-monolith][FriendMsgReqHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
        String msgContent = msg.getContent();
        CommonMsgReq commonMsgReq = JsonUtil.toClass(msgContent, CommonMsgReq.class);
        log.info("[wechat-server-monolith][FriendMsgReqHandler][channelRead0][1 commonMsgReq={}]", JsonUtil.toJsonString(commonMsgReq));
        String content = commonMsgReq.getContent();
        FriendMessage friendMessage = JsonUtil.toClass(content, FriendMessage.class);
        FriendMessageMpManage friendMessageMpManage = SpringUtil.getBean(FriendMessageMpManage.class);
        // Context context = ContextUtil.get();
        // FmkUserInfo fmkUserInfo = context.getFmkUserInfo();
        friendMessage.setCreatedBy(friendMessage.getUserId().toString());
        friendMessage.setCreatedTime(LocalDateTimeUtil.now());
        friendMessage.setUpdatedBy(friendMessage.getUserId().toString());
        friendMessage.setUpdatedTime(LocalDateTimeUtil.now());
        friendMessageMpManage.save(friendMessage);
        log.info("[wechat-server-monolith][FriendMsgReqHandler][channelRead0][2 friendMessage={}]", JsonUtil.toJsonString(friendMessage));
    }
}
