package com.xuegao.wechatservermonolith.sysuser.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.common.model.sysuser.dto.SysLoginDTO;
import com.xuegao.wechatservermonolith.common.model.sysuser.vo.LoginInfoVO;
import com.xuegao.wechatservermonolith.sysuser.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SysUserController {
    private static final Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/sysUser/login", method = {RequestMethod.POST, RequestMethod.GET})
    public Result<LoginInfoVO> login(@RequestBody SysLoginDTO sysLoginDTO,
                                     @RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });
        return Result.success(sysUserService.login(sysLoginDTO));
    }

    @RequestMapping(value = "/sysUser/register", method = {RequestMethod.POST})
    public Result<Integer> registerService(@RequestBody SysUser sysUser) {
        return Result.success(sysUserService.registerService(sysUser));
    }

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
        return Result.success(sysUserService.listService(dto));
    }

    @RequestMapping(value = "/sysUser/search", method = {RequestMethod.POST})
    public PageResult<SysUser> search(@RequestBody GenericModelDTO<SysUser> dto) {
        return PageResult.ok(sysUserService.searchService(dto));
    }

    @RequestMapping(value = "/sysUser/getUserByToken", method = {RequestMethod.POST})
    public PageResult<SysUser> getUserByToken(@RequestBody GenericModelDTO<SysUser> dto) {
        return PageResult.ok(sysUserService.searchService(dto));
    }
}
