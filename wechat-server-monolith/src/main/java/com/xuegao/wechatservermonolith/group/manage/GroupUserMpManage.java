package com.xuegao.wechatservermonolith.group.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupUser;
import com.xuegao.wechatservermonolith.group.mapper.GroupUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GroupUserMpManage extends AbstractMpServiceV2<GroupUserMapper, GroupUser, Long> {
    private static final Logger log = LoggerFactory.getLogger(GroupUserMpManage.class);


}
