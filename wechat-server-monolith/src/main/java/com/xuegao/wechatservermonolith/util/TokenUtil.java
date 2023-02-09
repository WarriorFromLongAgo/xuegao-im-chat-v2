package com.xuegao.wechatservermonolith.util;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TokenUtil {

    private TokenUtil() {
    }

    private static final Logger log = LoggerFactory.getLogger(TokenUtil.class);

    public static LoadingCache<String, String> TOKEN_USERID_CACHE = Caffeine.newBuilder()
            //cache的初始容量
            .initialCapacity(10)
            //cache最大缓存数,设置缓存最大条目数，超过条目则触发回收。
            .maximumSize(10000)
            // 写入后隔段时间过期,设置写缓存后n秒钟过期
            .expireAfterWrite(2, TimeUnit.HOURS)
            // 缓存淘汰监听器，配置监听器后，每个条目淘汰时都会调用该监听器
            .removalListener(new RemovalListener<Object, Object>() {
                @Override
                public void onRemoval(@Nullable Object o, @Nullable Object o2, @NonNull RemovalCause removalCause) {
                    log.info("[wechat-server-monolith][TokenUtil][TOKEN_USERID_CACHE][onRemoval][o={}][o2={}][removalCause={}]", o, o2, removalCause);
                }
            })
            .build(new CacheLoader<String, String>() {
                @Override
                public @Nullable String load(@NonNull String key) throws Exception {
                    return "";
                }
            });

    public static LoadingCache<String, String> USERID_TOKEN_CACHE = Caffeine.newBuilder()
            //cache的初始容量
            .initialCapacity(10)
            //cache最大缓存数,设置缓存最大条目数，超过条目则触发回收。
            .maximumSize(10000)
            // 写入后隔段时间过期,设置写缓存后n秒钟过期
            .expireAfterWrite(2, TimeUnit.HOURS)
            // 缓存淘汰监听器，配置监听器后，每个条目淘汰时都会调用该监听器
            .removalListener(new RemovalListener<Object, Object>() {
                @Override
                public void onRemoval(@Nullable Object o, @Nullable Object o2, @NonNull RemovalCause removalCause) {
                    log.info("[wechat-server-monolith][TokenUtil][USERID_TOKEN_CACHE][onRemoval][o={}][o2={}][removalCause={}]", o, o2, removalCause);
                }
            })
            .build(new CacheLoader<String, String>() {
                @Override
                public @Nullable String load(@NonNull String key) throws Exception {
                    return "";
                }
            });

    /**
     * 设置token
     * saveToken
     *
     * @param userId:
     * @param token:
     * @author xuegao
     * @date 2023/2/9 23:47
     */
    public static void saveUserIdAndToken(String userId, String token) {
        // 刚进来，直接将 token 和 userId 进行关联
        TOKEN_USERID_CACHE.put(token, userId);
        // 如果发现根据 userId 能够发现 token，说明登陆过，需要进行删除
        String oldToken = USERID_TOKEN_CACHE.get(userId);
        if (oldToken != null) {
            USERID_TOKEN_CACHE.invalidate(userId);
        }
        // 关联 userId 以及 token 的关系
        USERID_TOKEN_CACHE.put(userId, token);
    }

    /**
     * 根据token获取userId
     * getUserIdByToken
     *
     * @param token:
     * @return java.lang.String
     * @author xuegao
     * @date 2023/1/31 21:13
     */
    public static String getUserIdByToken(String token) {
        return TOKEN_USERID_CACHE.get(token);
    }
}
