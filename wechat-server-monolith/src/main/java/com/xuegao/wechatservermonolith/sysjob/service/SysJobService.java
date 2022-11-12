package com.xuegao.wechatservermonolith.sysjob.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.wechatservermonolith.common.model.sysjob.doo.SysJob;
import com.xuegao.wechatservermonolith.sysjob.manage.SysJobMpManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统定时任务表 服务实现类
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Service
public class SysJobService {

    @Autowired
    private SysJobMpManage sysJobMpManage;

    public SysJob insertService(SysJob input) {
        sysJobMpManage.mpInsert(input);
        return input;
    }

    public int updateService(SysJob input) {
        return sysJobMpManage.mpUpdate(input);
    }

    public int batchDisableService(GenericModelDTO<SysJob> dto) {
        // SysJobMpManage.mpDisable(dto.getIds());
        return 1;
    }

    public List<SysJob> listService(GenericModelDTO<SysJob> dto) {
        // SysJobMpManage.mpGetByIds(dto.getIds());
        return Lists.newArrayList();
    }

    public Page<SysJob> searchService(GenericModelDTO<SysJob> dto) {
        // SysJobMpManage.mpGetByIds(dto.getIds());
        return new Page<>();
    }
}
