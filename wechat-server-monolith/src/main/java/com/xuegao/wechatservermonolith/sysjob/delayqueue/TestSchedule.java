package com.xuegao.wechatservermonolith.sysjob.delayqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestSchedule {
    private static final Logger log = LoggerFactory.getLogger(TestSchedule.class);

    // @Scheduled(cron = "0/10 * * * * *")
    public void work() {
        log.info("[xuegao-im-chat-v2][TestSchedule][work][]");
    }


}
