package com.xuegao.wechatservermonolith.sysuser.manage;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xuegao.mapper.enums.DelFlagEnum;
import com.xuegao.mapper.model.GenericModel;
import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.wechatservermonolith.common.Constant;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.common.model.sysuser.enums.UserStatusEnum;
import com.xuegao.wechatservermonolith.sysuser.mapper.SysUserMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserMpManage extends AbstractMpServiceV2<SysUserMapper, SysUser, Long> {
    private static final Logger log = LoggerFactory.getLogger(SysUserMpManage.class);

    /**
     * getByUsernameAndPassword
     *
     * @param username:
     * @param nickname:
     * @return com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser
     * @author xuegao
     * @date 2022/11/12 23:30
     */
    public SysUser getByUsernameOrNickName(String username, String nickname) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setNickname(nickname);
        sysUser.setUserStatus(UserStatusEnum.NORMAL.getCode());

        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(GenericModel::getDelFlag, DelFlagEnum.DEL_FLAG_1);
        queryWrapper.eq(SysUser::getUserStatus, UserStatusEnum.NORMAL.getCode());
        queryWrapper.or(sysUserLambdaQueryWrapper -> {
            sysUserLambdaQueryWrapper.eq(SysUser::getUsername, username);
            sysUserLambdaQueryWrapper.eq(SysUser::getNickname, nickname);
        });
        List<SysUser> sysUserList = super.list(queryWrapper);
        if (ObjectUtils.isEmpty(sysUserList)) {
            return null;
        }
        if (sysUserList.size() > Constant.INT_1) {
            log.error("SysUserMpManage.getByUsernameAndPassword() username:{} nickname:{} sysUserList.size():{}", username, nickname, sysUserList.size());
            return sysUserList.get(0);
        }
        return sysUserList.get(0);
    }

}
