package com.xuegao.wechatservermonolith.netty.listener;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/4 16:19
 */
@Component
public class ServerStopListener1 implements DisposableBean, Ordered {
    @Override
    public void destroy() {
        System.out.println(getClass().getName() + "=============" + getOrder());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}