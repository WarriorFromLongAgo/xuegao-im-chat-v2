package com.xuegao.wechatservermonolith.sysrole.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.sysrole.doo.SysUserRole;
import com.xuegao.wechatservermonolith.sysrole.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户与权限的关联表 前端控制器
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/sysuser/sys-user-role")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @RequestMapping(value = "/sysUserRole/save", method = {RequestMethod.POST})
    public Result<SysUserRole> save(@RequestBody SysUserRole sysUserRole) {
        return Result.success(sysUserRoleService.insertService(sysUserRole));
    }

    @RequestMapping(value = "/sysUserRole/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody SysUserRole sysUserRole) {
        return Result.success(sysUserRoleService.updateService(sysUserRole));
    }

    @RequestMapping(value = "/sysUserRole/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<SysUserRole> dto) {
        return Result.success(sysUserRoleService.batchDisableService(dto));
    }

    @RequestMapping(value = "/sysUserRole/list", method = {RequestMethod.POST})
    public Result<List<SysUserRole>> list(@RequestBody GenericModelDTO<SysUserRole> dto) {
        return Result.success(sysUserRoleService.listService(dto));
    }

    @RequestMapping(value = "/sysUserRole/search", method = {RequestMethod.POST})
    public PageResult<SysUserRole> search(@RequestBody GenericModelDTO<SysUserRole> dto) {
        return PageResult.ok(sysUserRoleService.searchService(dto));
    }

}
