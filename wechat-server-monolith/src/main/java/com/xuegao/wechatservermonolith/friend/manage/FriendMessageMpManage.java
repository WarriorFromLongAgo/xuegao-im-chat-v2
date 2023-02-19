package com.xuegao.wechatservermonolith.friend.manage;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.xuegao.mapper.enums.DelFlagEnum;
import com.xuegao.mapper.model.GenericModel;
import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.util.JsonUtil;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.common.model.friend.enums.DataStatusEnum;
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

    public List<FriendMessage> listByUserIdAndFriendId(Long userId,
                                                       Long friendId) {
        LambdaQueryWrapper<FriendMessage> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(GenericModel::getDelFlag, DelFlagEnum.DEL_FLAG_1.getCode());
        queryWrapper.eq(FriendMessage::getDataStatus, DataStatusEnum.NORMAL.getCode());
        queryWrapper.and(twoWrapper -> {
            twoWrapper.or(twoWrapper1 -> {
                twoWrapper1.eq(FriendMessage::getFriendId, friendId);
                twoWrapper1.eq(FriendMessage::getUserId, userId);
            });
            twoWrapper.or(twoWrapper2 -> {
                twoWrapper2.eq(FriendMessage::getFriendId, userId);
                twoWrapper2.eq(FriendMessage::getUserId, friendId);
            });
        });
        queryWrapper.orderByAsc(FriendMessage::getCreatedTime);
        List<FriendMessage> friendMessageList = super.list(queryWrapper);
        return dealReturnList(friendMessageList);
    }
}
