create database if not exists xue_gao_im_chat_v2;

# username#uid，一般人登录就是这么展示
CREATE TABLE xue_gao_user
(
    `id`              BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键id，也是userid',
    `username`        VARCHAR(32) NOT NULL COMMENT '账号',
    `password`        VARCHAR(32) NOT NULL COMMENT '密码',
    `uid`             VARCHAR(32) NOT NULL COMMENT 'uuid，用户的唯一标识',
    `nickname`        VARCHAR(32) NOT NULL COMMENT '展示出来的昵称',
    `gender`          tinyint(2)  NOT NULL default 1 COMMENT '性别,1男，2女，3其他',
    `avatar`          VARCHAR(1024) COMMENT '头像',
    `mobile_phone`    VARCHAR(32) COMMENT '手机号码',
    `landline_phone`  VARCHAR(32) COMMENT '固定电话',
    `email`           VARCHAR(32) COMMENT '邮箱',
    `last_login_time` DATETIME    NOT NULL DEFAULT now() COMMENT '最后登录的年月日',
    `user_status`     tinyint(2)  not null default 10 COMMENT '用户状态,10:正常,20:3个月未登录进行删除',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`      VARCHAR(32) NOT NULL COMMENT '创建人',
    `created_time`    DATETIME    NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`      VARCHAR(32) NOT NULL COMMENT '更新人',
    `updated_time`    DATETIME    NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`        VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_username (username),
    INDEX idx_nickname (nickname),
    UNIQUE INDEX (nickname, uid)
) COMMENT = '用户信息'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;
insert into xue_gao_user (id, username, password, uid, nickname, created_by, updated_by)
values (1, 'gm999999', 'gm999999', 'gm999999', 'gm999999', '系统初始化', '系统初始化');
insert into xue_gao_user (id, username, password, uid, nickname, created_by, updated_by)
values (2, 'test', 'test', 'test', 'test', '系统初始化', '系统初始化');

CREATE TABLE sys_role
(
    `id`           INT         NOT NULL AUTO_INCREMENT COMMENT '',
    `role_type`    int(4)      NOT NULL COMMENT '默认是0，最大的管理员是999999',
    `role_remark`  VARCHAR(32) NOT NULL COMMENT '权限说明，999999，最大的管理员，0，普通用户',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`   VARCHAR(32) NOT NULL COMMENT '创建人',
    `created_time` DATETIME    NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`   VARCHAR(32) NOT NULL COMMENT '更新人',
    `updated_time` DATETIME    NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`     VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_role_type (role_type)
) COMMENT = '权限表'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;
insert into sys_role (id, role_type, role_remark, created_by, created_time, updated_by, updated_time)
values (1, '999999', '最大的管理员', '系统初始化', now(), '系统初始化', now());
insert into sys_role (id, role_type, role_remark, created_by, created_time, updated_by, updated_time)
values (2, '0', '普通用户', '系统初始化', now(), '系统初始化', now());

# 这里的1,是 sys_role 的默认id
# `role_id`        INT    NOT NULL default 1 COMMENT 'sys_role',
CREATE TABLE sys_user_role
(
    `id`             BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`        BIGINT      NOT NULL COMMENT 'xue_gao_user的主键id',
    `role_id`        INT         NOT NULL default 1 COMMENT 'sys_role',
    `operate_remark` VARCHAR(255) COMMENT '操作说明',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`     VARCHAR(32) NOT NULL COMMENT '创建人',
    `created_time`   DATETIME    NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`     VARCHAR(32) NOT NULL COMMENT '更新人',
    `updated_time`   DATETIME    NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`       VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_user_id (user_id),
    INDEX idx_role_id (role_id)
) COMMENT = '用户与权限的关联表'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;
insert into sys_user_role (user_id, role_id, operate_remark, created_by, created_time, updated_by, updated_time)
values (1, 1, '给gm999999赋予最大的管理员权限', '系统初始化', now(), '系统初始化', now());
insert into sys_user_role (user_id, role_id, operate_remark, created_by, created_time, updated_by, updated_time)
values (2, 2, '给test赋予普通用户权限', '系统初始化', now(), '系统初始化', now());

CREATE TABLE friend_user
(
    `id`           bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '',
    `user_id`      bigint(20)  NOT NULL COMMENT 'user_id',
    `friend_id`    bigint(20)  NOT NULL COMMENT '朋友的user_id',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`   VARCHAR(32) NOT NULL COMMENT '创建人',
    `created_time` DATETIME    NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`   VARCHAR(32) NOT NULL COMMENT '更新人',
    `updated_time` DATETIME    NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`     VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_user_id (user_id),
    INDEX idx_friend_id (friend_id)
) COMMENT = '用户与朋友关系'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;

CREATE TABLE friend_message
(
    `id`           bigint      NOT NULL AUTO_INCREMENT COMMENT '',
    `user_id`      bigint(20)  NOT NULL COMMENT '发送人id',
    `friend_id`    bigint(20)  NOT NULL COMMENT '接收人id',
    `message_type` VARCHAR(32) not null COMMENT '消息类型，text，image，audio，video，',
    `content`      VARCHAR(2048) COMMENT '消息内容',
    `delivered`    tinyint(2)  not null default 10 COMMENT '消息是否送达10已送达，20未送达',
    `data_status`  tinyint(2) COMMENT '消息状态，10正常，20撤回',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`   VARCHAR(32) NOT NULL COMMENT '创建人',
    `created_time` DATETIME    NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`   VARCHAR(32) NOT NULL COMMENT '更新人',
    `updated_time` DATETIME    NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`     VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_user_id (user_id),
    INDEX idx_friend_id (friend_id)
) COMMENT = '私聊消息表'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;

CREATE TABLE group_info
(
    `id`           bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '',
    `name`         VARCHAR(32)  NOT NULL COMMENT '群名字',
    `description`  VARCHAR(255) NOT NULL default '' COMMENT '群介绍',
    `owner_id`     bigint(20)   NOT NULL COMMENT '群主的user_id',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`   VARCHAR(32)  NOT NULL COMMENT '创建人',
    `created_time` DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`   VARCHAR(32)  NOT NULL COMMENT '更新人',
    `updated_time` DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`     VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_owner_id (owner_id),
    INDEX idx_created_by (created_by)
) COMMENT = '群组信息'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;
# 本群创建于2017/8/30:  群主很懒,什么都没有留下
insert into group_info (id, name, description, owner_id, created_by, created_time, updated_by, updated_time)
values (1, '雪糕家online', '所有出生在雪糕家的人物记录群（雪糕家出自种花家）', 1, '1', now(), '系统初始化', now());

# http://www.52im.net/thread-1616-1-1.html
CREATE TABLE group_user
(
    `id`             bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '',
    `user_nickname`  varchar(32) COMMENT '群展示昵称',
    `group_id`       bigint(20)  NOT NULL COMMENT '群id',
    `user_id`        bigint(20)  NOT NULL COMMENT '用户id',
    `last_ack_msgid` bigint(20)  NULL COMMENT '最后ack的消息表id',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`     VARCHAR(32) NOT NULL COMMENT '创建人',
    `created_time`   DATETIME    NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`     VARCHAR(32) NOT NULL COMMENT '更新人',
    `updated_time`   DATETIME    NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`       VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_user_id (user_id),
    INDEX idx_group_id (group_id)
) COMMENT = '群组信息'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;
# 将管理员拉入到初始的 雪糕家online
insert into group_user (id, group_id, user_id, created_by, created_time, updated_by, updated_time)
values (1, 1, 1, '系统初始化', now(), '系统初始化', now());

CREATE TABLE group_message
(
    `id`           bigint      NOT NULL AUTO_INCREMENT COMMENT '',
    `group_id`     bigint      NOT NULL COMMENT '群id',
    `user_id`      bigint(20)  NOT NULL COMMENT '发送人id',
    `message_type` VARCHAR(32) not null COMMENT '消息类型，text，image，audio，video，',
    `content`      VARCHAR(2048) COMMENT '消息内容',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`   VARCHAR(32) NOT NULL COMMENT '创建人',
    `created_time` DATETIME    NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`   VARCHAR(32) NOT NULL COMMENT '更新人',
    `updated_time` DATETIME    NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`     VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_user_id (user_id),
    INDEX idx_group_id (group_id)
) COMMENT = '群聊消息表'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;


CREATE TABLE sys_job
(
    `id`                 bigint        NOT NULL AUTO_INCREMENT COMMENT '',
    `execute_time`       DATETIME      NOT NULL COMMENT '消息执行时间,消息执行时间到了。那么立刻就会执行',
    `content`            VARCHAR(2048) not null COMMENT '消息内容',
    `execute_flag`       tinyint(2)    NOT NULL DEFAULT 20 COMMENT '执行标志，10：已执行，20：未执行',
    `execute_count`      tinyint(2)    NOT NULL DEFAULT 0 COMMENT '执行次数',
    `execute_begin_time` tinyint(2) COMMENT '执行开始时间',
    `execute_end_time`   tinyint(2) COMMENT '执行结束时间',
    `execute_cost`       tinyint(2) COMMENT '执行时长（秒数）',
    `remark`             varchar(255) COMMENT '备注',
    `business_type`      varchar(255) COMMENT '业务类型，这个数据从哪里来，delay_msg_job',
    `del_flag`        tinyint     NOT NULL DEFAULT 1 COMMENT '0已删除，1默认值，未删除',
    `created_by`         VARCHAR(32)   NOT NULL COMMENT '创建人',
    `created_time`       DATETIME      NOT NULL DEFAULT now() COMMENT '创建时间',
    `updated_by`         VARCHAR(32)   NOT NULL COMMENT '更新人',
    `updated_time`       DATETIME      NOT NULL DEFAULT now() COMMENT '更新时间',
    `trace_id`           VARCHAR(32) COMMENT '',
    PRIMARY KEY (id),
    INDEX idx_execute_time (execute_time)
) COMMENT = '系统定时任务表'
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;











