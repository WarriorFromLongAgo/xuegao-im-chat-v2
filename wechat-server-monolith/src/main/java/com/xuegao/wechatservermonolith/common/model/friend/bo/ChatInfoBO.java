package com.xuegao.wechatservermonolith.common.model.friend.bo;

import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendUser;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupMessage;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupUser;
import com.xuegao.wechatservermonolith.common.model.sysuser.bo.SysUserBO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ChatInfoBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer index;

    private Integer newMsgNum;

    private LocalDateTime lastMsgTime;

    private Integer chatType;

    private SysUserBO friendInfo;

    private FriendMessage lastFriendMessage;

    private FriendUser friendUser;

    private SysUserBO groupInfo;

    private GroupMessage lastGroupMessage;

    private GroupUser groupUser;
}
