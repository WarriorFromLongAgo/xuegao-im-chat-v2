package com.xuegao.wechatservermonolith.framework.netty.heartbeat;

import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.framework.netty.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ImIdleStateHandler extends IdleStateHandler {
    private static final Logger log = LoggerFactory.getLogger(ImIdleStateHandler.class);
    private int readTimeOutCount = 0;
    private static final int READER_IDLE_TIME = 90;

    private ImIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    public ImIdleStateHandler(long readerIdleTime, long writerIdleTime, long allIdleTime) {
        super(readerIdleTime, writerIdleTime, allIdleTime, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) {
        Channel channel = ctx.channel();
        log.info(READER_IDLE_TIME + "秒内未读到数据，关闭连接，" + channel.remoteAddress() + ", " + JsonUtil.toJsonString(evt));
        SessionUtil.unbindSession(channel);
        channel.close();
    }

    /**
     * 用户事件触发
     * <p>
     * 当 IdleStateHandler 发现读超时后，会调用 fireUserEventTriggered() 去执行后一个 Handler 的 userEventTriggered 方法。
     * 所以，根据心跳检测状态去关闭连接的就写在这里！
     */
    // @Override
    // public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    //     log.info("[wechat-server-monolith][HeartBeatServerHandler][userEventTriggered][evt={}]", JsonUtil.toJsonString(evt));
    //     // 入站的消息就是 IdleStateEvent 具体的事件
    //     if (!(evt instanceof IdleStateEvent)) {
    //         return;
    //     }
    //     IdleStateEvent event = (IdleStateEvent) evt;
    //
    //     String eventType = null;
    //     // 我们在 IdleStateHandler 中也看到了，它有读超时，写超时，读写超时等
    //     // 所以，这里我们需要判断事件类型
    //     switch (event.state()) {
    //         case READER_IDLE:
    //             eventType = "读空闲";
    //             readTimeOutCount++; // 读空闲的计数加 1
    //             break;
    //         case WRITER_IDLE:
    //             eventType = "写空闲";
    //             break; // 不处理
    //         case ALL_IDLE:
    //             eventType = "读写空闲";
    //             break; // 不处理
    //         default:
    //             System.out.println(" userEventTriggered  ============== ");
    //             break;
    //     }
    //
    //     // 打印触发了一次超时警告
    //     log.info("[wechat-server-monolith][HeartBeatServerHandler][userEventTriggered][超时事件={}]", ctx.channel().remoteAddress() + " == " + eventType);
    //
    //     // 当读超时超过 3 次，我们就端口该客户端的连接
    //     // 注：读超时超过 3 次，代表起码有 4 次 3s 内客户端没有发送心跳包或普通数据包
    //     if (readTimeOutCount > 3) {
    //         System.out.println(" [server]读空闲超过3次，关闭连接，释放更多资源");
    //         ctx.channel().writeAndFlush("idle close");
    //         ctx.channel().close(); // 手动断开连接
    //     }
    // }


}
