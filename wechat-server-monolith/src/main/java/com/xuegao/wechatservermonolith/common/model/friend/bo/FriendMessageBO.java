package com.xuegao.wechatservermonolith.common.model.friend.bo;

import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import com.xuegao.wechatservermonolith.common.model.sysuser.bo.SysUserBO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendMessageBO extends FriendMessage {

    /**
     * 是否展示时间，没批消息的第一条需要展示时间
     */
    private Boolean showTime;

    /**
     * 是否是自己发送的消息
     */
    private Boolean mySelfFlag;
    /**
     * 人物信息
     */
    private SysUserBO sysUserBO;
}
