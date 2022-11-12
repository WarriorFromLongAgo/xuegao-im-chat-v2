package com.xuegao.wechatservermonolith.group.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupMessage;
import com.xuegao.wechatservermonolith.group.mapper.GroupMessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GroupMessageMpManage extends AbstractMpServiceV2<GroupMessageMapper, GroupMessage, Long> {
    private static final Logger log = LoggerFactory.getLogger(GroupMessageMpManage.class);


}
