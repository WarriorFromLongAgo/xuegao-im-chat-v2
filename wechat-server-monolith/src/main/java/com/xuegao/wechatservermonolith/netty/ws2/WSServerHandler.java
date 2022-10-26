package com.xuegao.wechatservermonolith.netty.ws2;// package com.xuegao.im.netty.ws2;
//
// import io.netty.channel.ChannelFutureListener;
// import io.netty.channel.ChannelHandlerContext;
// import io.netty.channel.ChannelInboundHandlerAdapter;
// import io.netty.handler.codec.http.*;
// import io.netty.handler.codec.http.websocketx.*;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;
//
// import java.text.SimpleDateFormat;
//
// @Component
// public class WSServerHandler extends ChannelInboundHandlerAdapter {
//     @Value("${netty.ws:ws://127.0.0.1:61013/ws}")
//     private String wsUrl;
//
//     //握手处理类
//     private WebSocketServerHandshaker handhaker = null;
//
//     @Override
//     public void channelActive(ChannelHandlerContext ctx) throws Exception {
//         System.out.println("channel is active");
//     }
//
//     @Override
//     public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//         System.out.println("channel is inactive");
//     }
//
//     @Override
//     public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//         //第一次接入要进行握手
//         if (msg instanceof FullHttpRequest) {
//             handHttpRequest(ctx, (FullHttpRequest) msg);
//             System.out.println("http");
//         } else if (msg instanceof WebSocketFrame) {
//             //WebSocket通信
//             System.out.println("websocket");
//             handWebSocketFrame(ctx, (WebSocketFrame) msg);
//         }
//     }
//
//     private void handHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {//进行握手处理
//         //解码失败或非WebSocket请求消息（一定是小写websocket！！！）
//         if (!request.decoderResult().isSuccess() || !"websocket".equals(request.headers().get("Upgrade"))) {
//             FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST);
//             byte[] msgBytes = HttpResponseStatus.BAD_REQUEST.toString().getBytes();
//             response.content().writeBytes(msgBytes);
//             response.headers().set(HttpHeaderNames.CONTENT_LENGTH, msgBytes.length);
//             response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=UTF-8");
//             ctx.channel().writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
//             return;
//         }
//         System.out.println("success");
//         //构造握手工厂对8888/websocket握手消息进行响应
//         WebSocketServerHandshakerFactory factory =
//                 new WebSocketServerHandshakerFactory(wsUrl, null, false);
//         //构造握手对象
//         handhaker = factory.newHandshaker(request);
//         //不支持socket_vision
//         if (handhaker == null) {
//             //返回不支持消息响应
//             WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
//         } else {
//             //进行握手响应添加编解码器
//             handhaker.handshake(ctx.channel(), request);
//         }
//     }
//
//     private void handWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {//进行消息处理
//         //关闭链路消息
//         if (frame instanceof CloseWebSocketFrame) {
//             handhaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());//关闭链路
//             return;
//         }
//         //Ping/Pong消息
//         if (frame instanceof PingWebSocketFrame) {
//             ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
//             return;
//         }
//         //非文本数据桢
//         if (!(frame instanceof TextWebSocketFrame)) {
//             System.out.println("服务器不支持非文本消息！");
//             return;
//         }
//         //构造响应返回
//         String request = ((TextWebSocketFrame) frame).text();
//         System.out.println("浏览器消息 ： " + request);
//         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//         String time = df.format(new java.util.Date());
//         String response = "欢迎使用WebSocket服务！现在时刻 ： 北京时间" + time;
//         ctx.channel().writeAndFlush(new TextWebSocketFrame(response));
//     }
//
//     @Override
//     public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//         cause.printStackTrace();
//         ctx.channel().close();
//     }
//
// }
//
