// package com.xuegao.wechatservermonolith.framework.netty.heartbeat;
//
// import com.xuegao.util.JsonUtil;
// import io.netty.channel.ChannelHandlerContext;
// import io.netty.channel.SimpleChannelInboundHandler;
// import io.netty.handler.timeout.IdleStateEvent;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// public class HeartBeatServerHandler extends SimpleChannelInboundHandler<Object> {
//     private static final Logger log = LoggerFactory.getLogger(HeartBeatServerHandler.class);
//
//     private int readTimeOutCount = 0;
//
//     @Override
//     protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//         // 将收到的消息打印出来
//         log.info("[wechat-server-monolith][HeartBeatServerHandler][channelRead0][={}]", JsonUtil.toJsonString(msg));
//         // 如果消息内容是 Heartbeat Packet 则说明这是一个心跳包，我们返回 ok
//         if ("Heartbeat Packet".equals(msg)) {
//             ctx.channel().writeAndFlush("ok");
//             // 其余情况说明收到的是一个正常消息，不做特殊处理
//         } else {
//             System.out.println(" 其他信息处理 ... ");
//         }
//     }
//
//     /**
//      * 用户事件触发
//      * <p>
//      * 当 IdleStateHandler 发现读超时后，会调用 fireUserEventTriggered() 去执行后一个 Handler 的 userEventTriggered 方法。
//      * 所以，根据心跳检测状态去关闭连接的就写在这里！
//      */
//     @Override
//     public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//         log.info("[wechat-server-monolith][HeartBeatServerHandler][userEventTriggered][evt={}]", JsonUtil.toJsonString(evt));
//         // 入站的消息就是 IdleStateEvent 具体的事件
//         if (!(evt instanceof IdleStateEvent)) {
//             return;
//         }
//         IdleStateEvent event = (IdleStateEvent) evt;
//
//         String eventType = null;
//         // 我们在 IdleStateHandler 中也看到了，它有读超时，写超时，读写超时等
//         // 所以，这里我们需要判断事件类型
//         switch (event.state()) {
//             case READER_IDLE:
//                 eventType = "读空闲";
//                 readTimeOutCount++; // 读空闲的计数加 1
//                 break;
//             case WRITER_IDLE:
//                 eventType = "写空闲";
//                 break; // 不处理
//             case ALL_IDLE:
//                 eventType = "读写空闲";
//                 break; // 不处理
//             default:
//                 System.out.println(" userEventTriggered  ============== ");
//                 break;
//         }
//
//         // 打印触发了一次超时警告
//         log.info("[wechat-server-monolith][HeartBeatServerHandler][userEventTriggered][超时事件={}]", ctx.channel().remoteAddress() + " == " + eventType);
//
//         // 当读超时超过 3 次，我们就端口该客户端的连接
//         // 注：读超时超过 3 次，代表起码有 4 次 3s 内客户端没有发送心跳包或普通数据包
//         if (readTimeOutCount > 3) {
//             System.out.println(" [server]读空闲超过3次，关闭连接，释放更多资源");
//             ctx.channel().writeAndFlush("idle close");
//             ctx.channel().close(); // 手动断开连接
//         }
//     }
//     //
//     // @Override
//     // public void channelActive(ChannelHandlerContext ctx) throws Exception {
//     //     log.info("[wechat-server-monolith][HeartBeatServerHandler][channelActive][=active{}]", ctx.channel().remoteAddress());
//     // }
//
//
// }
