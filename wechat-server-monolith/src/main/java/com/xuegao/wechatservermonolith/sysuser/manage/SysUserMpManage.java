package com.xuegao.wechatservermonolith.sysuser.manage;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xuegao.mapper.enums.DelFlagEnum;
import com.xuegao.mapper.model.GenericModel;
import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.util.time.LocalDateTimeUtil;
import com.xuegao.wechatservermonolith.common.Constant;
import com.xuegao.wechatservermonolith.common.model.sysuser.bo.SysUserBO;
import com.xuegao.wechatservermonolith.common.model.sysuser.convert.SysUserConvert;
import com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser;
import com.xuegao.wechatservermonolith.common.model.sysuser.enums.UserStatusEnum;
import com.xuegao.wechatservermonolith.sysuser.mapper.SysUserMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class SysUserMpManage extends AbstractMpServiceV2<SysUserMapper, SysUser, Long> implements InitializingBean {
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
    public SysUserBO getByUsernameOrNickName(String username, String nickname) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setNickname(nickname);
        sysUser.setUserStatus(UserStatusEnum.NORMAL.getCode());

        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(GenericModel::getDelFlag, DelFlagEnum.DEL_FLAG_1.getCode());
        queryWrapper.eq(SysUser::getUserStatus, UserStatusEnum.NORMAL.getCode());
        queryWrapper.and(new Consumer<LambdaQueryWrapper<SysUser>>() {
            @Override
            public void accept(LambdaQueryWrapper<SysUser> sysUserLambdaQueryWrapper) {
                sysUserLambdaQueryWrapper.eq(StringUtils.isNotBlank(username), SysUser::getUsername, username);
                if (StringUtils.isNotBlank(nickname)) {
                    sysUserLambdaQueryWrapper.or(new Consumer<LambdaQueryWrapper<SysUser>>() {
                        @Override
                        public void accept(LambdaQueryWrapper<SysUser> sysUserLambdaQueryWrapper) {
                            sysUserLambdaQueryWrapper.eq(StringUtils.isNotBlank(nickname), SysUser::getNickname, nickname);
                        }
                    });
                }
            }
        });
        List<SysUser> sysUserList = super.list(queryWrapper);
        if (ObjectUtils.isEmpty(sysUserList)) {
            return null;
        }
        if (sysUserList.size() > Constant.INT_1) {
            log.error("SysUserMpManage.getByUsernameAndPassword() username:{} nickname:{} sysUserList.size():{}", username, nickname, sysUserList.size());
            return SysUserConvert.toSysUserBO(sysUserList.get(0));
        }
        return SysUserConvert.toSysUserBO(sysUserList.get(0));
    }

    public SysUserBO getByIdService(SysUserBO sysUserBO) {
        return getByIdService(sysUserBO.getId());
    }

    public SysUserBO getByIdService(Long id) {
        SysUser sysUser = super.mpGetById(id);
        return SysUserConvert.toSysUserBO(sysUser);
    }

    public List<SysUserBO> getByIdService(Long... idArr) {
        List<SysUser> sysUserList = super.mpGetByIds(idArr);
        return SysUserConvert.toSysUserBO(sysUserList);
    }

    public Map<Long, SysUserBO> getByIdServiceToMap(Long... idArr) {
        List<SysUser> sysUserList = super.mpGetByIds(idArr);
        SysUserConvert.toSysUserBO(sysUserList);
        return sysUserList.stream().map(SysUserConvert::toSysUserBO).collect(Collectors.toMap(SysUserBO::getId, c -> c, (key1, key2) -> key1));
    }

    public Integer updateByIdService(SysUserBO sysUserBO) {
        SysUser update = new SysUser();
        update.setId(sysUserBO.getId());
        update.setLastLoginTime(LocalDateTimeUtil.now());
        return super.mpUpdateFilterNull(update);
    }

    public Integer updateService(SysUserBO sysUserBO) {
        SysUser update = new SysUser();
        update.setId(sysUserBO.getId());
        update.setLastLoginTime(LocalDateTimeUtil.now());

        return super.mpUpdate(update);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" afterPropertiesSet ");
    }
}
