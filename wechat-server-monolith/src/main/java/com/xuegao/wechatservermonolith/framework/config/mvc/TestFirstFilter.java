package com.xuegao.wechatservermonolith.framework.config.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;

import javax.servlet.*;
import java.io.IOException;

public class TestFirstFilter implements Filter, Ordered {
    private static final Logger log = LoggerFactory.getLogger(TestFirstFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("[xuegao-im-chat-v2][TestFirstFilter][doFilter][TestFirstFilter][order={}]", getOrder());
        // 对request或 response 进行处理
        // 调用filter链中的下一个filter
        filterChain.doFilter(servletRequest, servletResponse);
        MDC.put("xuegao", "xuegao");
    }


    @Override
    public int getOrder() {
        return -1;
    }
}
