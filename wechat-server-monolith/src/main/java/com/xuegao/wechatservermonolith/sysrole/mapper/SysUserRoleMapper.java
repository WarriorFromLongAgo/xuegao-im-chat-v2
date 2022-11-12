package com.xuegao.wechatservermonolith.sysrole.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.wechatservermonolith.common.model.sysrole.doo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户与权限的关联表 Mapper 接口
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
