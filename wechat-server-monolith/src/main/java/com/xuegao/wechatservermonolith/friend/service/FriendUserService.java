package com.xuegao.wechatservermonolith.friend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.core.model.Context;
import com.xuegao.core.model.ContextUtil;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.friend.bo.ChatInfoBO;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendUser;
import com.xuegao.wechatservermonolith.friend.manage.FriendUserMpManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户与朋友关系 服务实现类
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Service
public class FriendUserService {

    @Autowired
    private FriendUserMpManage friendUserMpManage;

    public FriendUser insertService(FriendUser friendUser) {
        friendUserMpManage.mpInsert(friendUser);
        return friendUser;
    }

    public int updateService(FriendUser friendUser) {
        return friendUserMpManage.mpUpdate(friendUser);
    }

    public int batchDisableService(GenericModelDTO<FriendUser> dto) {
        // FriendUserMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<FriendUser> listService(GenericModelDTO<FriendUser> dto) {
        // FriendUserMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }

    public Page<FriendUser> searchService(GenericModelDTO<FriendUser> dto) {
        // FriendUserMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }

    public List<ChatInfoBO> listChatInfo() {
        Context context = ContextUtil.get();
        String userId = context.getUserId();

        // FriendUserMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }
}
