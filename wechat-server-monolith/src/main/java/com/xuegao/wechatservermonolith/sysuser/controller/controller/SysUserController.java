package com.xuegao.wechatservermonolith.sysuser.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.common.model.sysuser.dto.SysLoginDTO;
import com.xuegao.wechatservermonolith.common.model.sysuser.vo.LoginInfoVO;
import com.xuegao.wechatservermonolith.sysuser.service.SysUserService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/sysUser/login", method = {RequestMethod.POST, RequestMethod.GET})
    public Result<LoginInfoVO> login(@RequestBody SysLoginDTO sysLoginDTO) {
        return Result.success(sysUserService.login(sysLoginDTO));
    }

    @RequestMapping(value = "/sysUser/register", method = {RequestMethod.POST})
    public Result<Integer> registerService(@RequestBody SysUser sysUser) {
        return Result.success(sysUserService.registerService(sysUser));
    }

    // @RequestMapping(value = "/sysUser/save", method = {RequestMethod.POST})
    // public Result<SysUser> save(@RequestBody SysUser sysUser) {
    //     return Result.success(sysUserService.insertService(sysUser));
    // }

    @RequestMapping(value = "/sysUser/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody SysUser sysUser) {
        return Result.success(sysUserService.updateService(sysUser));
    }

    @RequestMapping(value = "/sysUser/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<SysUser> dto) {
        return Result.success(sysUserService.batchDisableService(dto));
    }

    @RequestMapping(value = "/sysUser/list", method = {RequestMethod.POST})
    public Result<List<SysUser>> list(@RequestBody GenericModelDTO<SysUser> dto) {
        String fmk_traceId = MDC.get("fmk_TraceId");
        System.out.println(fmk_traceId);

        return Result.success(sysUserService.listService(dto));
    }

    @RequestMapping(value = "/sysUser/search", method = {RequestMethod.POST})
    public PageResult<SysUser> search(@RequestBody GenericModelDTO<SysUser> dto) {
        return PageResult.ok(sysUserService.searchService(dto));
    }
}
