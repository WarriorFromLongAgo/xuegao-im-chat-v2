// package com.xuegao.wechatservermonolith.framework.netty.heartbeat;
//
// import com.xuegao.util.JsonUtil;
// import com.xuegao.wechatservermonolith.framework.netty.util.SessionUtil;
// import io.netty.channel.ChannelHandlerContext;
// import io.netty.handler.timeout.IdleStateEvent;
// import io.netty.handler.timeout.IdleStateHandler;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// import java.util.concurrent.TimeUnit;
//
// public class ImIdleStateHandler extends IdleStateHandler {
//     private static final Logger log = LoggerFactory.getLogger(ImIdleStateHandler.class);
//
//     private static final int READER_IDLE_TIME = 90;
//     private int readTimeOutCount = 0;
//
//     private ImIdleStateHandler() {
//         super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
//     }
//
//     public ImIdleStateHandler(long readerIdleTime, long writerIdleTime, long allIdleTime) {
//         super(readerIdleTime, writerIdleTime, allIdleTime, TimeUnit.SECONDS);
//     }
//
//     public ImIdleStateHandler(long readerIdleTime, long writerIdleTime, long allIdleTime, TimeUnit unit) {
//         super(readerIdleTime, writerIdleTime, allIdleTime, unit);
//     }
//
//     @Override
//     protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) {
//         log.info(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
//         SessionUtil.unbindSession(ctx.channel());
//         ctx.channel().close();
//     }
//
//     @Override
//     public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//         super.handlerAdded(ctx);
//     }
//
//     @Override
//     public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//         super.handlerRemoved(ctx);
//     }
//
//     @Override
//     public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//         super.channelRegistered(ctx);
//     }
//
//     @Override
//     public void channelActive(ChannelHandlerContext ctx) throws Exception {
//         log.info("[wechat-server-monolith][HeartBeatServerHandler][channelActive][active={}]", ctx.channel().remoteAddress());
//     }
//
//     @Override
//     public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//         log.info("[wechat-server-monolith][HeartBeatServerHandler][channelActive][channelInactive={}]", ctx.channel().remoteAddress());
//
//     }
//
//     @Override
//     public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//         // 将收到的消息打印出来
//         log.info("[wechat-server-monolith][ImIdleStateHandler][channelRead][={}]", JsonUtil.toJsonString(msg));
//         // 如果消息内容是 Heartbeat Packet 则说明这是一个心跳包，我们返回 ok
//         if ("Heartbeat Packet".equals(msg)) {
//             ctx.channel().writeAndFlush("ok");
//             // 其余情况说明收到的是一个正常消息，不做特殊处理
//         } else {
//             System.out.println(" 其他信息处理 ... ");
//         }
//     }
//
//     @Override
//     public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//         super.channelReadComplete(ctx);
//     }
//
//     @Override
//     public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
//         super.channelUnregistered(ctx);
//     }
//
//     @Override
//     public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
//         super.channelWritabilityChanged(ctx);
//     }
//
//     @Override
//     public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//         super.exceptionCaught(ctx, cause);
//     }
//
//     @Override
//     public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
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
//
// // 2023-01-31 19:22:40.014 [wechat-server-monolith] [port=10001] [nioEventLoopGroup-3-3] INFO  [,] c.x.w.framework.netty.ws.TextWsFrameHandler - [xuegao-im-chat-2022][WsServerHandler][channelRead0][收到的文本消息={"messageType":3,"content":"ping"}]
// // /0:0:0:0:0:0:0:1:53942超时事件：读空闲
// // /0:0:0:0:0:0:0:1:53942超时事件：读空闲
// // /0:0:0:0:0:0:0:1:53942超时事件：读空闲
// // /0:0:0:0:0:0:0:1:53942超时事件：读空闲
// // [server]读空闲超过3次，关闭连接，释放更多资源
// // 2023-01-31 19:28:30.102 [wechat-server-monolith] [port=10001] [nioEventLoopGroup-3-3] INFO  [,] c.x.w.framework.netty.ws.TextWsFrameHandler - [xuegao-im-chat-2022][WsServerHandler][handlerRemoved][长id=005056fffec00008-00002cec-00000003-2f1230ee5e44c917-83ebb3f8][短id=83ebb3f8]
//
// }
