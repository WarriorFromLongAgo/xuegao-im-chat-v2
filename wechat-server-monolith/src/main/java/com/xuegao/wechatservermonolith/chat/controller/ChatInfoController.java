package com.xuegao.wechatservermonolith.chat.controller;

import com.xuegao.core.model.Result;
import com.xuegao.wechatservermonolith.chat.service.ChatInfoService;
import com.xuegao.wechatservermonolith.common.model.friend.bo.ChatInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatInfoController {

    @Autowired
    private ChatInfoService chatInfoService;

    @RequestMapping(value = "/chatInfo/listChatInfo", method = {RequestMethod.POST})
    public Result<List<ChatInfoBO>> listChatInfo() {
        return Result.ok(chatInfoService.listChatInfo());
    }
}
