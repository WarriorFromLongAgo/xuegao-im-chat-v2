// package com.xuegao.wechatservermonolith.framework.netty.business;
//
// import org.springframework.stereotype.Component;
//
// @Component
// public class NettyChannelManager2 {
//
//     /**
//      * 向指定用户发送消息
//      *
//      * @param user       用户
//      * @param invocation 消息体
//      */
//     public void send(String user, Invocation invocation) {
//         // 获得用户对应的 Channel
//         Channel channel = userChannels.get(user);
//         if (channel == null) {
//             logger.error("[send][连接不存在]");
//             return;
//         }
//         if (!channel.isActive()) {
//             logger.error("[send][连接({})未激活]", channel.id());
//             return;
//         }
//         // 发送消息
//         channel.writeAndFlush(invocation);
//     }
//
//     /**
//      * 向所有用户发送消息
//      *
//      * @param invocation 消息体
//      */
//     public void sendAll(Invocation invocation) {
//         for (Channel channel : channels.values()) {
//             if (!channel.isActive()) {
//                 logger.error("[send][连接({})未激活]", channel.id());
//                 return;
//             }
//             // 发送消息
//             channel.writeAndFlush(invocation);
//         }
//     }
// }