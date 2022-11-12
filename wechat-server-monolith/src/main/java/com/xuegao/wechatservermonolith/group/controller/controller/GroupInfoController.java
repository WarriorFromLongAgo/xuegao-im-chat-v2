package com.xuegao.wechatservermonolith.group.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupInfo;
import com.xuegao.wechatservermonolith.group.service.GroupInfoService;
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
@RequestMapping("/sysuser/group-info")
public class GroupInfoController {

    @Autowired
    private GroupInfoService groupInfoService;

    @RequestMapping(value = "/groupInfo/save", method = {RequestMethod.POST})
    public Result<GroupInfo> save(@RequestBody GroupInfo groupInfo) {
        return Result.success(groupInfoService.insertService(groupInfo));
    }

    @RequestMapping(value = "/groupInfo/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody GroupInfo groupInfo) {
        return Result.success(groupInfoService.updateService(groupInfo));
    }

    @RequestMapping(value = "/groupInfo/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<GroupInfo> dto) {
        return Result.success(groupInfoService.batchDisableService(dto));
    }

    @RequestMapping(value = "/groupInfo/list", method = {RequestMethod.POST})
    public Result<List<GroupInfo>> list(@RequestBody GenericModelDTO<GroupInfo> dto) {
        return Result.success(groupInfoService.listService(dto));
    }

    @RequestMapping(value = "/groupInfo/search", method = {RequestMethod.POST})
    public PageResult<GroupInfo> search(@RequestBody GenericModelDTO<GroupInfo> dto) {
        return PageResult.ok(groupInfoService.searchService(dto));
    }

}
