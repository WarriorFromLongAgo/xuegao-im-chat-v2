package com.xuegao.wechatservermonolith.util;

import com.xuegao.wechatservermonolith.common.model.sysuser.bo.SysUserBO;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WsSessionUtil {

    private static final Map<String, Channel> USERID_CHANNEL_MAP = new ConcurrentHashMap<>();

    private static final AttributeKey<SysUserBO> SESSION = AttributeKey.newInstance("session");

    private WsSessionUtil() {
    }

    public static boolean hasLogin(Channel channel) {
        SysUserBO sysUser = channel.attr(SESSION).get();
        return ObjectUtils.isNotEmpty(sysUser) && ObjectUtils.isNotEmpty(sysUser.getId());
    }

    public static Channel getChannel(String userId) {
        return USERID_CHANNEL_MAP.get(userId);
    }

    public static Collection<Channel> getAllChannel() {
        return USERID_CHANNEL_MAP.values();
    }

    public static void bindSession(SysUserBO session, Channel channel) {
        USERID_CHANNEL_MAP.put(session.getId().toString(), channel);
        channel.attr(SESSION).set(session);
    }

    public static void unbindSession(Channel channel) {
        if (hasLogin(channel)) {
            SysUserBO session = channel.attr(SESSION).get();
            USERID_CHANNEL_MAP.remove(session.getId().toString());
            channel.attr(SESSION).set(null);
        }
    }

}
