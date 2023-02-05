package com.xuegao.wechatservermonolith.framework.netty.handler;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.framework.netty.support.request.HeartBeatPingMsgReq;
import com.xuegao.wechatservermonolith.framework.netty.support.response.HeartBeatPongResp;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@ChannelHandler.Sharable
@Component
public class HeartBeatPingHandler extends SimpleChannelInboundHandler<HeartBeatPingMsgReq> {
    private static final Logger log = LoggerFactory.getLogger(HeartBeatPingHandler.class);
    private int readTimeOutCount = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                HeartBeatPingMsgReq msg) {
        log.info("[wechat-server-monolith][HeartBeatPingHandler][channelRead0][msg={}]", JsonUtil.toJsonString(msg));
        ctx.channel().writeAndFlush(new TextWebSocketFrame(JsonUtil.toJsonString(HeartBeatPongResp.buildPongByPing())));
    }

    // 如果同时有 channelRead0 和 channelRead，会先触发 channelRead0
    // @Override
    // public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    //     log.info("[wechat-server-monolith][HeartBeatPingHandler][channelRead][msg={}]", msg);
    // }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("[wechat-server-monolith][HeartBeatPingHandler][channelActive][channelActive]");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("[wechat-server-monolith][HeartBeatPingHandler][channelActive][channelInactive]");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 入站的消息就是 IdleStateEvent 具体的事件
        if (!(evt instanceof IdleStateEvent)) {
            return;
        }
        IdleStateEvent event = (IdleStateEvent) evt;

        String eventType = null;
        // 我们在 IdleStateHandler 中也看到了，它有读超时，写超时，读写超时等
        // 所以，这里我们需要判断事件类型
        switch (event.state()) {
            case READER_IDLE:
                eventType = "读空闲";
                readTimeOutCount++; // 读空闲的计数加 1
                break;
            case WRITER_IDLE:
                eventType = "写空闲";
                break; // 不处理
            case ALL_IDLE:
                eventType = "读写空闲";
                break; // 不处理
            default:
                System.out.println(" userEventTriggered  ============== ");
                break;
        }

        // 打印触发了一次超时警告
        log.info("[wechat-server-monolith][HeartBeatServerHandler][userEventTriggered][超时事件={}]", ctx.channel().remoteAddress() + " == " + eventType);

        // 当读超时超过 3 次，我们就端口该客户端的连接
        // 注：读超时超过 3 次，代表起码有 4 次 3s 内客户端没有发送心跳包或普通数据包
        if (readTimeOutCount > 3) {
            System.out.println(" [server]读空闲超过3次，关闭连接，释放更多资源");
            ctx.channel().writeAndFlush("idle close");
            ctx.channel().close(); // 手动断开连接
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
