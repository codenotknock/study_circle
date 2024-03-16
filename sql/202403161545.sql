-- 练题模块
create table study_circle.practice_set
(
    id           bigint auto_increment comment '主键'
        primary key,
    primary_category_id   bigint                             null comment '分类id 是大类',
    set_name     varchar(255)                         null comment '套卷名称',
    set_type     int(11)                         null comment '套卷类型 1专项练习 2预设套题',
    set_heat     int(11)                         null comment '套卷热度',
    set_desc     varchar(255)                         null comment '套卷描述',
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    comment '题卷表' charset = utf8mb4;


create table study_circle.practice_set_detail
(
    id           bigint auto_increment comment '主键'
        primary key,
    set_id   bigint                                 null comment '题卷id',
    subject_id   bigint                             null comment '题目id',
    subject_type   int(11)                          null comment '题目类型',
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    comment '题卷明细表' charset = utf8mb4;



create table study_circle.practice_info
(
    id           bigint auto_increment comment '主键'
        primary key,
    set_id   bigint                                 null comment '题卷id',
    complete_status   int(11)                       null comment '完成状态 0未完成 1完成',
    time_use   varchar(32)                          null comment '用时',
    summit_time   datetime                          null comment '交卷时间',
    correct_rate   decimal(10)                      null comment '正确率',
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    comment '练习结果表' charset = utf8mb4;


create table study_circle.practice_info_detail
(
    id           bigint auto_increment comment '主键'
        primary key,
    practice_id   bigint                            null comment '练习结果id',
    subject_id   bigint                             null comment '题目id',
    subject_type   int(11)                          null comment '题目类型',
    answer_status   int(11)                         null comment '回答状态 0未回答 1已回答',
    answer_content  varchar(255)                    null comment '回答内容',
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    comment '练习结果明细表' charset = utf8mb4;
