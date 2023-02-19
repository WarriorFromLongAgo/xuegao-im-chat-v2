package com.xuegao.wechatservermonolith.friend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.core.model.Context;
import com.xuegao.core.model.ContextUtil;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.friend.bo.FriendMessageBO;
import com.xuegao.wechatservermonolith.common.model.friend.convert.FriendMessageConvert;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.common.model.sysuser.bo.SysUserBO;
import com.xuegao.wechatservermonolith.friend.manage.FriendMessageMpManage;
import com.xuegao.wechatservermonolith.sysuser.manage.SysUserMpManage;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 私聊消息表 服务实现类
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Service
public class FriendMessageService {
    private static final Logger log = LoggerFactory.getLogger(FriendMessageService.class);

    @Autowired
    private FriendMessageMpManage friendMessageMpManage;

    @Autowired
    private SysUserMpManage sysUserMpManage;

    public FriendMessage insertService(FriendMessage friendMessage) {
        friendMessageMpManage.mpInsert(friendMessage);
        return friendMessage;
    }

    public int updateService(FriendMessage friendMessage) {
        return friendMessageMpManage.mpUpdate(friendMessage);
    }

    public int batchDisableService(GenericModelDTO<FriendMessage> dto) {
        // friendMessageMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<FriendMessageBO> listService(GenericModelDTO<FriendMessage> dto) {
        Context context = ContextUtil.get();
        String inputUserIdStr = context.getUserId();
        Long inputUserId = Long.valueOf(inputUserIdStr);
        log.info("[wechat-server-monolith][FriendUserService][listChatInfo][inputUserId={}]", inputUserId);
        FriendMessage vo = dto.getVo();
        List<FriendMessage> friendMessageList =
                friendMessageMpManage.listByUserIdAndFriendId(inputUserId, vo.getFriendId());
        if (ObjectUtils.isEmpty(friendMessageList)) {
            return Lists.newArrayList();
        }
        Set<Long> userIdSet = friendMessageList.stream().map(FriendMessage::getFriendId).collect(Collectors.toSet());
        userIdSet.add(inputUserId);
        Map<Long, SysUserBO> sysUserUserIdMap = sysUserMpManage.getByIdServiceToMap(userIdSet.toArray(new Long[0]));
        List<FriendMessageBO> friendMessageBOList = friendMessageList.stream().map(FriendMessageConvert::toFriendMessageBO).collect(Collectors.toList());
        for (FriendMessageBO tempBo : friendMessageBOList) {
            Long tempUserId = tempBo.getUserId();
            if (inputUserId.equals(tempUserId)) {
                tempBo.setMySelfFlag(Boolean.TRUE);
            }
            if (sysUserUserIdMap.containsKey(tempUserId)) {
                tempBo.setSysUserBO(sysUserUserIdMap.get(tempUserId));
            }
        }
        return friendMessageBOList;
    }

    public Page<FriendMessage> searchService(GenericModelDTO<FriendMessage> dto) {
        // friendMessageMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }


}
