package com.xuegao.wechatservermonolith.friend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.friend.manage.FriendMessageMpManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private FriendMessageMpManage friendMessageMpManage;

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

    public List<FriendMessage> listService(GenericModelDTO<FriendMessage> dto) {
        // friendMessageMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }

    public Page<FriendMessage> searchService(GenericModelDTO<FriendMessage> dto) {
        // friendMessageMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }
}
