package com.xuegao.wechatservermonolith.chat.service;

import com.google.common.collect.Lists;
import com.xuegao.core.model.Context;
import com.xuegao.core.model.ContextUtil;
import com.xuegao.wechatservermonolith.common.enums.MsgSendTypeEnum;
import com.xuegao.wechatservermonolith.common.model.friend.bo.ChatInfoBO;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.common.model.sysuser.bo.SysUserBO;
import com.xuegao.wechatservermonolith.friend.manage.FriendMessageMpManage;
import com.xuegao.wechatservermonolith.group.manage.GroupMessageMpManage;
import com.xuegao.wechatservermonolith.sysuser.manage.SysUserMpManage;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChatInfoService {
    private static final Logger log = LoggerFactory.getLogger(ChatInfoService.class);

    @Autowired
    private FriendMessageMpManage friendMessageMpManage;

    @Autowired
    private GroupMessageMpManage groupMessageMpManage;

    @Autowired
    private SysUserMpManage sysUserMpManage;

    public List<ChatInfoBO> listChatInfo() {
        Context context = ContextUtil.get();
        String userId = context.getUserId();
        log.info("[wechat-server-monolith][FriendUserService][listChatInfo][userId={}]", userId);
        List<FriendMessage> friendMessageList = friendMessageMpManage.listChatInfo(Long.valueOf(userId));
        if (ObjectUtils.isEmpty(friendMessageList)) {
            return Lists.newArrayList();
        }
        Set<Long> userIdSet = new HashSet<>(friendMessageList.size());
        for (FriendMessage tempMsg : friendMessageList) {
            userIdSet.add(tempMsg.getUserId());
            userIdSet.add(tempMsg.getFriendId());
        }

        List<SysUserBO> sysUserBOList = sysUserMpManage.getByIdService(userIdSet.toArray(new Long[0]));
        if (ObjectUtils.isEmpty(sysUserBOList)) {
            return Lists.newArrayList();
        }
        Map<Long, SysUserBO> userIdMap = sysUserBOList.stream().collect(Collectors.toMap(SysUserBO::getId, c -> c, (key1, key2) -> key1));

        List<ChatInfoBO> chatInfoBOList = new ArrayList<>(friendMessageList.size());
        int index = 0;
        for (FriendMessage tempMsg : friendMessageList) {
            ChatInfoBO tempChatInfoBO = new ChatInfoBO();
            tempChatInfoBO.setIndex(index);
            tempChatInfoBO.setLastMsgTime(tempMsg.getCreatedTime());
            tempChatInfoBO.setChatType(MsgSendTypeEnum.ONE_TO_ONE.getCode());

            Long tempFriendId = tempMsg.getFriendId();
            if (!ObjectUtils.isEmpty(userIdMap.get(tempFriendId))) {
                tempChatInfoBO.setFriendInfo(userIdMap.get(tempFriendId));
            }
            tempChatInfoBO.setLastFriendMessage(tempMsg);

            chatInfoBOList.add(tempChatInfoBO);
            index++;
        }

        return chatInfoBOList;
    }
}
