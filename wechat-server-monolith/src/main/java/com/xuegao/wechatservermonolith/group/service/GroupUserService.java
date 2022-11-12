package com.xuegao.wechatservermonolith.group.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupUser;
import com.xuegao.wechatservermonolith.group.manage.GroupUserMpManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 群组信息 服务实现类
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Service
public class GroupUserService {

    @Autowired
    private GroupUserMpManage groupUserMpManage;

    public GroupUser insertService(GroupUser input) {
        groupUserMpManage.mpInsert(input);
        return input;
    }

    public int updateService(GroupUser input) {
        return groupUserMpManage.mpUpdate(input);
    }

    public int batchDisableService(GenericModelDTO<GroupUser> dto) {
        // GroupInfoMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<GroupUser> listService(GenericModelDTO<GroupUser> dto) {
        // GroupInfoMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }

    public Page<GroupUser> searchService(GenericModelDTO<GroupUser> dto) {
        // GroupInfoMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }
}
