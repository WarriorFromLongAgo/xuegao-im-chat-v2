package com.xuegao.wechatservermonolith.group.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupUser;
import com.xuegao.wechatservermonolith.group.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 群组信息 前端控制器
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/sysuser/group-user")
public class GroupUserController {

    @Autowired
    private GroupUserService groupUserService;

    @RequestMapping(value = "/groupUser/save", method = {RequestMethod.POST})
    public Result<GroupUser> save(@RequestBody GroupUser groupUser) {
        return Result.success(groupUserService.insertService(groupUser));
    }

    @RequestMapping(value = "/groupUser/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody GroupUser groupUser) {
        return Result.success(groupUserService.updateService(groupUser));
    }

    @RequestMapping(value = "/groupUser/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<GroupUser> dto) {
        return Result.success(groupUserService.batchDisableService(dto));
    }

    @RequestMapping(value = "/groupUser/list", method = {RequestMethod.POST})
    public Result<List<GroupUser>> list(@RequestBody GenericModelDTO<GroupUser> dto) {
        return Result.success(groupUserService.listService(dto));
    }

    @RequestMapping(value = "/groupUser/search", method = {RequestMethod.POST})
    public PageResult<GroupUser> search(@RequestBody GenericModelDTO<GroupUser> dto) {
        return PageResult.ok(groupUserService.searchService(dto));
    }

}
