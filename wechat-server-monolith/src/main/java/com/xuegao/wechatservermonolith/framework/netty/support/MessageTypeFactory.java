package com.xuegao.wechatservermonolith.framework.netty.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageTypeFactory {
    public static Map<Integer, IMessageType> MSG_TYPE_MAP = new ConcurrentHashMap<>();

    public static IMessageType getByMessageType(Integer messageType) {
        return MSG_TYPE_MAP.get(messageType);
    }

    public static void register(Integer messageType, IMessageType messageTypeClass) {
        MSG_TYPE_MAP.put(messageType, messageTypeClass);
    }
}
