package com.xuegao.wechatservermonolith.friend.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.friend.service.FriendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 私聊消息表 前端控制器
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/sysuser/friend-message")
public class FriendMessageController {

    @Autowired
    private FriendMessageService friendMessageService;

    @RequestMapping(value = "/friendMessage/save", method = {RequestMethod.POST})
    public Result<FriendMessage> save(@RequestBody FriendMessage friendMessage) {
        return Result.success(friendMessageService.insertService(friendMessage));
    }

    @RequestMapping(value = "/friendMessage/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody FriendMessage friendMessage) {
        return Result.success(friendMessageService.updateService(friendMessage));
    }

    @RequestMapping(value = "/friendMessage/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<FriendMessage> dto) {
        return Result.success(friendMessageService.batchDisableService(dto));
    }

    @RequestMapping(value = "/friendMessage/list", method = {RequestMethod.POST})
    public Result<List<FriendMessage>> list(@RequestBody GenericModelDTO<FriendMessage> dto) {
        return Result.success(friendMessageService.listService(dto));
    }

    @RequestMapping(value = "/friendMessage/search", method = {RequestMethod.POST})
    public PageResult<FriendMessage> search(@RequestBody GenericModelDTO<FriendMessage> dto) {
        return PageResult.ok(friendMessageService.searchService(dto));
    }

}
