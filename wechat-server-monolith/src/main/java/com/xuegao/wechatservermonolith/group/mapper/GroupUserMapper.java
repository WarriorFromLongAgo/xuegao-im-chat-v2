package com.xuegao.wechatservermonolith.group.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 群组信息 Mapper 接口
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Mapper
public interface GroupUserMapper extends BaseMapper<GroupUser> {

}
