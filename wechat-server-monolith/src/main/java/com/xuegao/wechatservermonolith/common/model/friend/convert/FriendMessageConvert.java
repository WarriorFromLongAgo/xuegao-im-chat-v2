package com.xuegao.wechatservermonolith.common.model.friend.convert;

import com.xuegao.wechatservermonolith.common.model.friend.bo.FriendMessageBO;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;

public class FriendMessageConvert {

    public static FriendMessageBO toFriendMessageBO(FriendMessage friendMessage) {
        FriendMessageBO friendMessageBO = new FriendMessageBO();
        friendMessageBO.setUserId(friendMessage.getUserId());
        friendMessageBO.setFriendId(friendMessage.getFriendId());
        friendMessageBO.setMessageType(friendMessage.getMessageType());
        friendMessageBO.setContent(friendMessage.getContent());
        friendMessageBO.setAckType(friendMessage.getAckType());
        friendMessageBO.setDataStatus(friendMessage.getDataStatus());
        friendMessageBO.setId(friendMessage.getId());
        friendMessageBO.setDelFlag(friendMessage.getDelFlag());
        friendMessageBO.setCreatedBy(friendMessage.getCreatedBy());
        friendMessageBO.setCreatedTime(friendMessage.getCreatedTime());
        friendMessageBO.setUpdatedBy(friendMessage.getUpdatedBy());
        friendMessageBO.setUpdatedTime(friendMessage.getUpdatedTime());
        friendMessageBO.setTraceId(friendMessage.getTraceId());
        return friendMessageBO;
    }

}
