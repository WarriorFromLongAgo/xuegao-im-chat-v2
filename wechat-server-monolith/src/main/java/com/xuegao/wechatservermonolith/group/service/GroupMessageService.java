package com.xuegao.wechatservermonolith.group.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupMessage;
import com.xuegao.wechatservermonolith.group.manage.GroupMessageMpManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 群聊消息表 服务实现类
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Service
public class GroupMessageService {

    @Autowired
    private GroupMessageMpManage groupMessageMpManage;

    public GroupMessage insertService(GroupMessage input) {
        groupMessageMpManage.mpInsert(input);
        return input;
    }

    public int updateService(GroupMessage input) {
        return groupMessageMpManage.mpUpdate(input);
    }

    public int batchDisableService(GenericModelDTO<GroupMessage> dto) {
        // GroupInfoMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<GroupMessage> listService(GenericModelDTO<GroupMessage> dto) {
        // GroupInfoMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }

    public Page<GroupMessage> searchService(GenericModelDTO<GroupMessage> dto) {
        // GroupInfoMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }
}
