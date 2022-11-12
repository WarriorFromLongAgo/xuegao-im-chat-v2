package com.xuegao.wechatservermonolith.friend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.wechatservermonolith.common.model.friend.doo.FriendUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户与朋友关系 Mapper 接口
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Mapper
public interface FriendUserMapper extends BaseMapper<FriendUser> {

}
