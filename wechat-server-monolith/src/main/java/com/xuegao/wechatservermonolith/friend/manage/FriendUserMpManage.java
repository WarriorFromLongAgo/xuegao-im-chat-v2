package com.xuegao.wechatservermonolith.friend.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendUser;
import com.xuegao.wechatservermonolith.friend.mapper.FriendUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FriendUserMpManage extends AbstractMpServiceV2<FriendUserMapper, FriendUser, Long> {
    private static final Logger log = LoggerFactory.getLogger(FriendUserMpManage.class);


}
