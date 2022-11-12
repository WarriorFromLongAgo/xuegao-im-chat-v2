package com.xuegao.wechatservermonolith.common.model.sysjob.doo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xuegao.mapper.model.GenericModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统定时任务表
 * </p>
 *
 * @author xuegao
 * @since 2022-11-12
 */
@Accessors(chain = true)
@Getter
@Setter
@TableName("sys_job")
public class SysJob extends GenericModel<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 消息执行时间,消息执行时间到了。那么立刻就会执行
     */
    @TableField("execute_time")
    private LocalDateTime executeTime;

    /**
     * 消息内容
     */
    @TableField("content")
    private String content;

    /**
     * 执行标志，10：已执行，20：未执行
     */
    @TableField("execute_flag")
    private Integer executeFlag;

    /**
     * 执行次数
     */
    @TableField("execute_count")
    private Integer executeCount;

    /**
     * 执行开始时间
     */
    @TableField("execute_begin_time")
    private Integer executeBeginTime;

    /**
     * 执行结束时间
     */
    @TableField("execute_end_time")
    private Integer executeEndTime;

    /**
     * 执行时长（秒数）
     */
    @TableField("execute_cost")
    private Integer executeCost;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 业务类型，这个数据从哪里来，delay_msg_job
     */
    @TableField("business_type")
    private String businessType;


}
