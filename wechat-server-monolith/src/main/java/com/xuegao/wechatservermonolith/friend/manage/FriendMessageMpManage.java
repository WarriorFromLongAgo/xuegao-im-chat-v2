package com.xuegao.wechatservermonolith.friend.manage;

import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.friend.mapper.FriendMessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FriendMessageMpManage extends AbstractMpServiceV2<FriendMessageMapper, FriendMessage, Long> {
    private static final Logger log = LoggerFactory.getLogger(FriendMessageMpManage.class);


}
