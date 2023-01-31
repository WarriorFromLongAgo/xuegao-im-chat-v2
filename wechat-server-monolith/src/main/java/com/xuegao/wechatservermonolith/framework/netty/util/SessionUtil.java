package com.xuegao.wechatservermonolith.framework.netty.util;

import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zed
 * date: 2019/08/20.
 * description:
 */
@Component
public class SessionUtil {

    // private static final Map<String, String> TOKEN_MAP = new ConcurrentHashMap<>();
    // private static final Map<String, String> USER_MAP = new ConcurrentHashMap<>();

    private static final Map<String, Channel> USERID_CHANNEL_MAP = new ConcurrentHashMap<>();
    // /**
    //  * Channel 映射
    //  */
    // private final ConcurrentMap<ChannelId, Channel> channelIdMap = new ConcurrentHashMap<>();

    private static final AttributeKey<SysUser> SESSION = AttributeKey.newInstance("session");

    // private static final String TOKEN_USER_KEY = "token:userId:map:";
    // private static final String USER_TOKEN_KEY = "user:token:map:";

    public static boolean hasLogin(Channel channel) {
        return channel.attr(SESSION).get() != null;
    }

    public static Channel getChannel(String userId) {
        return USERID_CHANNEL_MAP.get(userId);
    }

    public static Collection<Channel> getAllChannel() {
        return USERID_CHANNEL_MAP.values();
    }

    public static void bindSession(SysUser session, Channel channel) {
        USERID_CHANNEL_MAP.put(session.getId().toString(), channel);
        channel.attr(SESSION).set(session);
    }

    public static void unbindSession(Channel channel) {
        if (hasLogin(channel)) {
            SysUser session = channel.attr(SESSION).get();
            USERID_CHANNEL_MAP.remove(session.getId().toString());
            channel.attr(SESSION).set(null);
        }
    }

    // public static void saveToken(String userId, String token) {
    //     String redisUserIdKey = USER_TOKEN_KEY + userId;
    //     String redisTokenKey = TOKEN_USER_KEY + token;
    //     // 刚进来，直接将 token 和 userId 进行关联
    //     TOKEN_MAP.put(redisTokenKey, userId);
    //
    //     // 如果发现根据 userId 能够发现 token，说明登陆过，需要进行删除
    //     String oldToken = USER_MAP.get(redisUserIdKey);
    //     if (oldToken != null) {
    //         TOKEN_MAP.remove(redisTokenKey);
    //     }
    //
    //     // 关联 userId 以及 token 的关系
    //     USER_MAP.put(redisUserIdKey, token);
    // }

    // /**
    //  * 根据token获取userId
    //  * getUserIdByToken
    //  *
    //  * @param token:
    //  * @return java.lang.String
    //  * @author xuegao
    //  * @date 2023/1/31 21:13
    //  */
    // public static String getUserIdByToken(String token) {
    //     String redisTokenKey = TOKEN_USER_KEY + token;
    //     return TOKEN_MAP.get(redisTokenKey);
    // }
}
