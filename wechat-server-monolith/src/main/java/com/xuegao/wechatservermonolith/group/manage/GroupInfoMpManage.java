package com.xuegao.wechatservermonolith.group.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupInfo;
import com.xuegao.wechatservermonolith.group.mapper.GroupInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GroupInfoMpManage extends AbstractMpServiceV2<GroupInfoMapper, GroupInfo, Long> {
    private static final Logger log = LoggerFactory.getLogger(GroupInfoMpManage.class);


}
