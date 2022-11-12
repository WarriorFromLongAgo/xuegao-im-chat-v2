package com.xuegao.wechatservermonolith.friend.controller.controller;

import com.xuegao.core.model.Result;
import com.xuegao.mapper.model.GenericModelDTO;
import com.xuegao.mapper.model.PageResult;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendUser;
import com.xuegao.wechatservermonolith.friend.service.FriendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户与朋友关系 前端控制器
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/sysuser/friend-user")
public class FriendUserController {

    @Autowired
    private FriendUserService friendUserService;

    @RequestMapping(value = "/friendUser/save", method = {RequestMethod.POST})
    public Result<FriendUser> save(@RequestBody FriendUser friendUser) {
        return Result.success(friendUserService.insertService(friendUser));
    }

    @RequestMapping(value = "/friendUser/update", method = {RequestMethod.POST})
    public Result<Integer> update(@RequestBody FriendUser friendUser) {
        return Result.success(friendUserService.updateService(friendUser));
    }

    @RequestMapping(value = "/friendUser/batchDisable", method = {RequestMethod.POST})
    public Result<Integer> batchDisable(@RequestBody GenericModelDTO<FriendUser> dto) {
        return Result.success(friendUserService.batchDisableService(dto));
    }

    @RequestMapping(value = "/friendUser/list", method = {RequestMethod.POST})
    public Result<List<FriendUser>> list(@RequestBody GenericModelDTO<FriendUser> dto) {
        return Result.success(friendUserService.listService(dto));
    }

    @RequestMapping(value = "/friendUser/search", method = {RequestMethod.POST})
    public PageResult<FriendUser> search(@RequestBody GenericModelDTO<FriendUser> dto) {
        return PageResult.ok(friendUserService.searchService(dto));
    }

}
