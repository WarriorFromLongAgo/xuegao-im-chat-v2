package com.xuegao.wechatservermonolith.sysjob.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.sysjob.doo.SysJob;
import com.xuegao.wechatservermonolith.sysjob.mapper.SysJobMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SysJobMpManage extends AbstractMpServiceV2<SysJobMapper, SysJob, Long> {
    private static final Logger log = LoggerFactory.getLogger(SysJobMpManage.class);


}
