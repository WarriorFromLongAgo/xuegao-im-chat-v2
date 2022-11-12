package com.xuegao.wechatservermonolith.group.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupMessage;
import com.xuegao.wechatservermonolith.group.service.GroupMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 群聊消息表 前端控制器
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/sysuser/group-message")
public class GroupMessageController {

    @Autowired
    private GroupMessageService groupMessageService;

    @RequestMapping(value = "/groupMessage/save", method = {RequestMethod.POST})
    public Result<GroupMessage> save(@RequestBody GroupMessage groupMessage) {
        return Result.success(groupMessageService.insertService(groupMessage));
    }

    @RequestMapping(value = "/groupMessage/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody GroupMessage groupMessage) {
        return Result.success(groupMessageService.updateService(groupMessage));
    }

    @RequestMapping(value = "/groupMessage/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<GroupMessage> dto) {
        return Result.success(groupMessageService.batchDisableService(dto));
    }

    @RequestMapping(value = "/groupMessage/list", method = {RequestMethod.POST})
    public Result<List<GroupMessage>> list(@RequestBody GenericModelDTO<GroupMessage> dto) {
        return Result.success(groupMessageService.listService(dto));
    }

    @RequestMapping(value = "/groupMessage/search", method = {RequestMethod.POST})
    public PageResult<GroupMessage> search(@RequestBody GenericModelDTO<GroupMessage> dto) {
        return PageResult.ok(groupMessageService.searchService(dto));
    }

}
