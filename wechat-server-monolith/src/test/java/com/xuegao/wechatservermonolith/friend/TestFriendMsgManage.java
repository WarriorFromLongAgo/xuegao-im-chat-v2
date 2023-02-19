package com.xuegao.wechatservermonolith.friend;

import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.friend.manage.FriendMessageMpManage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootTest
public class TestFriendMsgManage {

    @Autowired
    private FriendMessageMpManage friendMessageMpManage;

    public FriendMessage getFriendMessage(){
        FriendMessage friendMessage = new FriendMessage();
        friendMessage.setUserId(10000L);
        friendMessage.setFriendId(10000L);
        friendMessage.setMessageType("111111");
        friendMessage.setAckType(10);
        friendMessage.setDataStatus(10);
        friendMessage.setContent("SSAFDSFDSFSFS");
        friendMessage.setCreatedBy("11");
        friendMessage.setCreatedTime(LocalDateTime.now());
        friendMessage.setUpdatedBy("11");
        friendMessage.setUpdatedTime(LocalDateTime.now());
        return friendMessage;
    }

    @Test
    void testSave() throws IOException {
        friendMessageMpManage.save(getFriendMessage());
    }

    @Test
    void testMpInsert() throws IOException {
        friendMessageMpManage.mpInsert(getFriendMessage());
    }
}
