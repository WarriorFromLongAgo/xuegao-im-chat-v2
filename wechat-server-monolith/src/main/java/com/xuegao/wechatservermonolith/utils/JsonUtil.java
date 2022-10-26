package com.xuegao.wechatservermonolith.utils;

import com.alibaba.fastjson2.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON 转换
 */
public final class JsonUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 把Java对象转换成json字符串
     *
     * @param object 待转化为JSON字符串的Java对象
     * @return json 串 or null
     */
    public static String parseObjToJson(Object object) {
        String string = null;
        try {
            string = JSON.toJSONString(object);
        } catch (Exception e) {
            log.info("[xuegao-im-chat-2022][JsonUtil][parseObjToJson][object={}]", JSON.toJSONString(object), e);
        }
        return string;
    }

    /**
     * 将Json字符串信息转换成对应的Java对象
     *
     * @param json json字符串对象
     * @param c    对应的类型
     */
    public static <T> T parseJsonToObj(String json, Class<T> c) {
        try {
            return JSON.parseObject(json, c);
        } catch (Exception e) {
            log.info("[xuegao-im-chat-2022][JsonUtil][parseJsonToObj][json={}]", json, e);
        }
        return null;
    }
}
