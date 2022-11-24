package com.xuegao.wechatservermonolith.framework.netty.business;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// 客户端是这样的
// 客户端是这样的
// 客户端是这样的
// 客户端是这样的
// 客户端是这样的
// 客户端是这样的
// 客户端是这样的

@Component
public class NettyChannelManager {
    private static final Logger log = LoggerFactory.getLogger(NettyChannelManager.class);

    /**
     * {@link Channel#attr(AttributeKey)} 属性中，表示 Channel 对应的用户
     */
    private static final AttributeKey<String> CHANNEL_ATTR_KEY_USER = AttributeKey.newInstance("sysUser");

    /**
     * Channel 映射
     */
    private final ConcurrentMap<ChannelId, Channel> channelIdKeyMap = new ConcurrentHashMap<>();
    /**
     * 用户与 Channel 的映射。
     * <p>
     * 通过它，可以获取用户对应的 Channel。这样，我们可以向指定用户发送消息。
     */
    private final ConcurrentMap<String, Channel> userIdKeyMap = new ConcurrentHashMap<>();

    /**
     * 添加 Channel 到 {@link #channelIdKeyMap} 中
     *
     * @param channel Channel
     */
    public void add(Channel channel) {
        channelIdKeyMap.put(channel.id(), channel);
        log.info("[add][一个连接({})加入]", channel.id());
    }

    /**
     * 添加指定用户到 {@link #userIdKeyMap} 中
     *
     * @param channel Channel
     * @param user    用户
     */
    public void addUser(Channel channel, String user) {
        Channel existChannel = channelIdKeyMap.get(channel.id());
        if (existChannel == null) {
            log.error("[addUser][连接({}) 不存在]", channel.id());
            return;
        }
        // 设置属性
        channel.attr(CHANNEL_ATTR_KEY_USER).set(user);
        // 添加到 userChannels
        userIdKeyMap.put(user, channel);
    }

    /**
     * 将 Channel 从 {@link #channelIdKeyMap} 和 {@link #userIdKeyMap} 中移除
     *
     * @param channel Channel
     */
    public void remove(Channel channel) {
        // 移除 channels
        channelIdKeyMap.remove(channel.id());
        // 移除 userChannels
        if (channel.hasAttr(CHANNEL_ATTR_KEY_USER)) {
            userIdKeyMap.remove(channel.attr(CHANNEL_ATTR_KEY_USER).get());
        }
        log.info("[remove][一个连接({})离开]", channel.id());
    }
}