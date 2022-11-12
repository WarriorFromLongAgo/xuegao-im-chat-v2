package com.xuegao.wechatservermonolith.sysrole.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.sysrole.doo.SysRole;
import com.xuegao.wechatservermonolith.sysrole.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/sysuser/sys-role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/sysRole/save", method = {RequestMethod.POST})
    public Result<SysRole> save(@RequestBody SysRole sysRole) {
        return Result.success(sysRoleService.insertService(sysRole));
    }

    @RequestMapping(value = "/sysRole/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody SysRole sysRole) {
        return Result.success(sysRoleService.updateService(sysRole));
    }

    @RequestMapping(value = "/sysRole/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<SysRole> dto) {
        return Result.success(sysRoleService.batchDisableService(dto));
    }

    @RequestMapping(value = "/sysRole/list", method = {RequestMethod.POST})
    public Result<List<SysRole>> list(@RequestBody GenericModelDTO<SysRole> dto) {
        return Result.success(sysRoleService.listService(dto));
    }

    @RequestMapping(value = "/sysRole/search", method = {RequestMethod.POST})
    public PageResult<SysRole> search(@RequestBody GenericModelDTO<SysRole> dto) {
        return PageResult.ok(sysRoleService.searchService(dto));
    }

}
