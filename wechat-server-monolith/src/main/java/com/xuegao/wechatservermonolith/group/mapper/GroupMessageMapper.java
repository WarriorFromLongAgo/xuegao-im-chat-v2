package com.xuegao.wechatservermonolith.group.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.wechatservermonolith.common.model.group.doo.GroupMessage;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 群聊消息表 Mapper 接口
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Mapper
public interface GroupMessageMapper extends BaseMapper<GroupMessage> {

}
