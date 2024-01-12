create table study_circle.subject_brief
(
    id             bigint auto_increment comment '主键'
        primary key,
    subject_id     int(20)                            null comment '题目id',
    subject_answer text                               null comment '题目答案',
    created_by     varchar(32)                        null comment '创建人',
    created_time   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by      varchar(32)                        null comment '更新人',
    update_time    datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted     int      default 0                 null
)
    comment '简答题信息表_题目信息' charset = utf8;

create table study_circle.subject_category
(
    id            bigint auto_increment comment '主键'
        primary key,
    category_name varchar(16)                          null comment '分类名称',
    category_type tinyint(2)                           null comment '分类类型',
    image_url     varchar(64)                          null comment '图标连接',
    parent_id     bigint                               null comment '父级id',
    created_by    varchar(32)                          null comment '创建人',
    created_time  datetime   default CURRENT_TIMESTAMP null comment '创建时间',
    update_by     varchar(32)                          null comment '更新人',
    update_time   datetime                             null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted    tinyint(1) default 0                 null comment '是否删除 0: 未删除 1: 已删除'
)
    comment '题目分类表' charset = utf8;

create table study_circle.subject_info
(
    id                bigint auto_increment comment '主键'
        primary key,
    subject_name      varchar(128)                       null comment '题目名称',
    subject_difficult tinyint                            null comment '题目难度',
    settle_name       varchar(32)                        null comment '出题人名',
    subject_type      tinyint                            null comment '题目类型 1单选 2多选 3判断 4简答',
    subject_score     tinyint                            null comment '题目分数',
    subject_parse     varchar(512)                       null comment '题目解析',
    created_by        varchar(32)                        null comment '创建人',
    created_time      datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by         varchar(32)                        null comment '修改人',
    update_time       datetime                           null comment '修改时间',
    is_deleted        int      default 0                 null
)
    comment '题目信息表' charset = utf8;

create table study_circle.subject_judge
(
    id           bigint auto_increment comment '主键'
        primary key,
    subject_id   bigint                             null comment '题目id',
    is_correct   tinyint(2)                         null comment '是否正确',
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    comment '判断题信息表_题目信息' charset = utf8;

create table study_circle.subject_label
(
    id           bigint auto_increment comment '主键'
        primary key,
    label_name   varchar(32)                        null comment '标签分类',
    sort_num     int                                null comment '排序',
    category_id  bigint                             null,
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    comment '题目标签表' charset = utf8;

create table study_circle.subject_mapping
(
    id           bigint auto_increment comment '主键'
        primary key,
    subject_id   bigint                             null comment '题目id',
    category_id  bigint                             null comment '分类id',
    label_id     bigint                             null comment '标签id',
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '修改人',
    update_time  datetime                           null comment '修改时间',
    is_deleted   int      default 0                 null
)
    comment '题目分类关系表' charset = utf8;

create table study_circle.subject_multiple
(
    id             bigint auto_increment comment '主键'
        primary key,
    subject_id     bigint                             null comment '题目id',
    option_type    bigint(4)                          null comment '选项类型',
    option_content varchar(64)                        null comment '选项内容',
    is_correct     tinyint(2)                         null comment '是否正确',
    created_by     varchar(32)                        null comment '创建人',
    created_time   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by      varchar(32)                        null comment '更新人',
    update_time    datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted     int      default 0                 null
)
    comment '多选题信息表_题目信息' charset = utf8;

create table study_circle.subject_radio
(
    id             bigint auto_increment comment '主键'
        primary key,
    subject_id     bigint                             null comment '题目id',
    option_type    tinyint                            null comment '选项a b c d e',
    option_content varchar(128)                       null comment '选项内容',
    is_correct     tinyint(2)                         null comment '是否正确',
    created_by     varchar(32)                        null comment '创建人',
    created_time   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by      varchar(32)                        null comment '修改人',
    update_time    datetime                           null comment '修改时间',
    is_deleted     int      default 0                 null
)
    comment '单选题信息表_题目信息' charset = utf8;

ALTER TABLE study_circle.subject_brief ALTER COLUMN is_deleted SET DEFAULT 0;
ALTER TABLE study_circle.subject_category ALTER COLUMN is_deleted SET DEFAULT 0;
ALTER TABLE study_circle.subject_info ALTER COLUMN is_deleted SET DEFAULT 0;
ALTER TABLE study_circle.subject_judge ALTER COLUMN is_deleted SET DEFAULT 0;
ALTER TABLE study_circle.subject_label ALTER COLUMN is_deleted SET DEFAULT 0;
ALTER TABLE study_circle.subject_radio ALTER COLUMN is_deleted SET DEFAULT 0;
ALTER TABLE study_circle.subject_multiple ALTER COLUMN is_deleted SET DEFAULT 0;
ALTER TABLE study_circle.subject_mapping ALTER COLUMN is_deleted SET DEFAULT 0;