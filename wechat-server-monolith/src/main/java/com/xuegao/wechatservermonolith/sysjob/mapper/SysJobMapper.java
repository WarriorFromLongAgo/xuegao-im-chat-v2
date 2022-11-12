package com.xuegao.wechatservermonolith.sysjob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.wechatservermonolith.common.model.sysjob.doo.SysJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统定时任务表 Mapper 接口
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Mapper
public interface SysJobMapper extends BaseMapper<SysJob> {

}
