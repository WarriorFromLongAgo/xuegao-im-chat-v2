// package com.xuegao.wechatservermonolith.framework.netty.support;
//
// import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
// import com.xuegao.wechatservermonolith.framework.netty.support.request.CommonMsgReq;
// import com.xuegao.wechatservermonolith.framework.netty.support.request.FriendMsgReq;
// import com.xuegao.wechatservermonolith.framework.netty.support.request.GroupMsgReq;
// import com.xuegao.wechatservermonolith.framework.netty.support.request.HeartBeatPingMsgReq;
// import com.xuegao.wechatservermonolith.framework.netty.support.response.HeartBeatPong;
//
// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;
//
// public class MessageTypeFactory {
//     private static final Map<MsgSendTypeEnum, IMessageType> MSG_TYPE_MAP = new ConcurrentHashMap<>();
//
//     private MessageTypeFactory() {
//     }
//
//     static {
//         CommonMsgReq.registerMessageTypeHandler();
//
//         HeartBeatPingMsgReq.registerMessageTypeHandler();
//         HeartBeatPong.registerMessageTypeHandler();
//
//         FriendMsgReq.registerMessageTypeHandler();
//         GroupMsgReq.registerMessageTypeHandler();
//     }
//
//     public static void register(MsgSendTypeEnum anEnum, IMessageType messageTypeClass) {
//         MSG_TYPE_MAP.put(anEnum, messageTypeClass);
//     }
// }
