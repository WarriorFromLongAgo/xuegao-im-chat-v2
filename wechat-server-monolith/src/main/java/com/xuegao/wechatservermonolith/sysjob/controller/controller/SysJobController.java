package com.xuegao.wechatservermonolith.sysjob.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.sysjob.doo.SysJob;
import com.xuegao.wechatservermonolith.sysjob.service.SysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统定时任务表 前端控制器
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/sysuser/sys-job")
public class SysJobController {

    @Autowired
    private SysJobService sysJobService;

    @RequestMapping(value = "/sysJob/save", method = {RequestMethod.POST})
    public Result<SysJob> save(@RequestBody SysJob sysJob) {
        return Result.success(sysJobService.insertService(sysJob));
    }

    @RequestMapping(value = "/sysJob/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody SysJob sysJob) {
        return Result.success(sysJobService.updateService(sysJob));
    }

    @RequestMapping(value = "/sysJob/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<SysJob> dto) {
        return Result.success(sysJobService.batchDisableService(dto));
    }

    @RequestMapping(value = "/sysJob/list", method = {RequestMethod.POST})
    public Result<List<SysJob>> list(@RequestBody GenericModelDTO<SysJob> dto) {
        return Result.success(sysJobService.listService(dto));
    }

    @RequestMapping(value = "/sysJob/search", method = {RequestMethod.POST})
    public PageResult<SysJob> search(@RequestBody GenericModelDTO<SysJob> dto) {
        return PageResult.ok(sysJobService.searchService(dto));
    }

}
