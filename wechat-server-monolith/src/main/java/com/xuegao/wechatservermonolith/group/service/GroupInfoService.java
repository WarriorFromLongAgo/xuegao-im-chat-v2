package com.xuegao.wechatservermonolith.group.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupInfo;
import com.xuegao.wechatservermonolith.group.manage.GroupInfoMpManage;
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
public class GroupInfoService {

    @Autowired
    private GroupInfoMpManage groupInfoMpManage;

    public GroupInfo insertService(GroupInfo input) {
        groupInfoMpManage.mpInsert(input);
        return input;
    }

    public int updateService(GroupInfo input) {
        return groupInfoMpManage.mpUpdate(input);
    }

    public int batchDisableService(GenericModelDTO<GroupInfo> dto) {
        // GroupInfoMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<GroupInfo> listService(GenericModelDTO<GroupInfo> dto) {
        // GroupInfoMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }

    public Page<GroupInfo> searchService(GenericModelDTO<GroupInfo> dto) {
        // GroupInfoMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }
}
