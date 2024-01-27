create table study_circle.subject_liked
(
    id           bigint auto_increment comment '主键'
        primary key,
    subject_id   bigint                             null comment '题目id',
    like_user_id   varchar(32)                         null comment '点赞人id',
    status         int                              null comment '点赞状态',
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    comment '点赞信息' charset = utf8;