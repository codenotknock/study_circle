-- 讨论模块
create table study_circle.discuss_post
(
    id            bigint auto_increment comment '主键'
        primary key,
    user_id       bigint null comment '用户id',
    title         varchar(100) null comment '帖子表标题',
    content       text null comment '帖子内容',
    type          int(11) null comment '帖子类型 0普通 1置顶',
    comment_count int(11) null comment '评论数量',
    status        int(11) null comment '帖子状态：0普通 1精华 2拉黑',
    created_by    varchar(32) null comment '创建人',
    created_time  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by     varchar(32) null comment '更新人',
    update_time   datetime null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted    int      default 0 null
) comment '帖子表' charset = utf8mb4;


create table study_circle.discuss_comment
(
    id           bigint auto_increment comment '主键'
        primary key,
    user_id      bigint null comment '用户id',
    entity_id    bigint null comment '评论实体 id',
    entity_type  int(11) null comment '评论实体类型：1帖子评论 2评论回复',
    target_id    bigint null comment '评论目标 id',
    content      text null comment '评论内容',
    status       int(11) null comment '评论状态：0有效 1无效',
    created_by   varchar(32) null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32) null comment '更新人',
    update_time  datetime null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0 null
) comment '评论表' charset = utf8mb4;


create table study_circle.discuss_message
(
    id              bigint auto_increment comment '主键'
        primary key,
    from_id         bigint null comment '发消息的 id',
    to_id           bigint null comment '接收消息的 id',
    conversation_id varchar(45) null comment '会话 id，由通信双方 id 拼接',
    content         text null comment '消息内容',
    status          int(11) null comment '消息状态：0未读 1已读 2删除',
    created_by      varchar(32) null comment '创建人',
    created_time    datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by       varchar(32) null comment '更新人',
    update_time     datetime null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted      int      default 0 null
) comment '消息表' charset = utf8mb4;
