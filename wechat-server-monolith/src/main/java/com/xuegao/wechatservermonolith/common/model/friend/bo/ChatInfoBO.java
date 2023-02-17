package com.xuegao.wechatservermonolith.common.model.friend.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendUser;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupInfo;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastMsgTime;

    private Integer chatType;

    private SysUserBO friendInfo;

    private FriendMessage lastFriendMessage;

    private FriendUser friendUser;

    // 这里要换成bo
    private GroupInfo groupInfo;

    private GroupMessage lastGroupMessage;

    private GroupUser groupUser;
}
