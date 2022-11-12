package com.xuegao.wechatservermonolith.friend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendMessage;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 私聊消息表 Mapper 接口
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Mapper
public interface FriendMessageMapper extends BaseMapper<FriendMessage> {

}
