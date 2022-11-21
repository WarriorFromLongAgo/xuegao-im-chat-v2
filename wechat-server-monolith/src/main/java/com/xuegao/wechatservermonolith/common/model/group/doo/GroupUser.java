package com.xuegao.wechatservermonolith.common.model.group.doo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuegao.mapper.model.GenericModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 群里面的每个人，特殊信息设置
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("group_user")
public class GroupUser extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 群id
     */
    @TableField("group_id")
    private Long groupId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 群里面，每个人设置展示自己在本群的昵称
     */
    @TableField("user_nickname")
    private String userNickname;

    /**
     * 群备注，方便自己知道这个群的用处
     */
    @TableField(exist = false)
    private String groupNote;
    /**
     * 免打扰，10正常，20免打扰
     */
    @TableField(exist = false)
    private Integer notDisturb;

    // /**
    //  * 置顶设置，这个应该单独处理
    //  */
    // @TableField(exist = false)
    // private String topSettings;
    // /**
    //  * 群助手，进行会话的折叠
    //  */
    // @TableField(exist = false)
    // private String groupAssistant;
}
