package com.xuegao.wechatservermonolith.friend.manage;

import com.google.common.collect.Lists;
import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.friend.mapper.FriendMessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class FriendMessageMpManage extends AbstractMpServiceV2<FriendMessageMapper, FriendMessage, Long> {
    private static final Logger log = LoggerFactory.getLogger(FriendMessageMpManage.class);

    public List<FriendMessage> listChatInfo(Long userId) {
        if (Objects.isNull(userId)) {
            return Lists.newArrayList();
        }
        List<FriendMessage> friendMessageList = getBaseMapper().listChatInfo(userId);
        if (log.isDebugEnabled()) {
            log.info("[wechat-server-monolith][FriendMessageMpManage][listChatInfo][friendMessageList={}]", JsonUtil.toJsonString(friendMessageList));
        }
        friendMessageList = super.dealReturnList(friendMessageList);
        friendMessageList.sort(Comparator.comparing(FriendMessage::getCreatedTime).reversed());
        return friendMessageList;
    }
}
