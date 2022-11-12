package com.xuegao.wechatservermonolith.sysuser.manage;

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
     * @param password:
     * @return com.xuegao.wechatservermonolith.common.model.sysuser.doo.SysUser
     * @author xuegao
     * @date 2022/11/12 23:30
     */
    public SysUser getByUsernameAndPassword(String username, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        sysUser.setUserStatus(UserStatusEnum.NORMAL.getCode());


        List<SysUser> sysUserList = super.mpListLimit(sysUser, Constant.INT_10);
        if (ObjectUtils.isEmpty(sysUserList)) {
            return null;
        }
        if (sysUserList.size() > Constant.INT_1) {
            log.error("SysUserMpManage.getByUsernameAndPassword() username:{} password:{} sysUserList.size():{}", username, password, sysUserList.size());
            return sysUserList.get(0);
        }
        return sysUserList.get(0);
    }

}
