create table study_circle.auth_permission
(
    id             bigint                             not null
        primary key,
    name           varchar(64)                        null,
    parent_id      bigint                             null,
    type           tinyint                            null,
    menu_url       varchar(255)                       null,
    status         tinyint(2)                         null,
    `show`         tinyint(2)                         null,
    icon           varchar(128)                       null,
    permission_key varchar(64)                        null,
    created_by     varchar(32)                        null comment '创建人',
    created_time   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by      varchar(32)                        null comment '更新人',
    update_time    datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted     int      default 0                 null
)
    charset = utf8;

create table study_circle.auth_role
(
    id           bigint                             not null
        primary key,
    role_name    varchar(32)                        null,
    role_key     varchar(64)                        null,
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    charset = utf8;

create table study_circle.auth_role_Permission
(
    id            bigint                             not null
        primary key,
    role_id       bigint                             null,
    permission_id bigint                             null,
    created_by    varchar(32)                        null comment '创建人',
    created_time  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by     varchar(32)                        null comment '更新人',
    update_time   datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted    int      default 0                 null
)
    charset = utf8;

create table study_circle.auth_user
(
    id           bigint                             null,
    user_name    varchar(32)                        null,
    nick_name    varchar(32)                        null,
    email        varchar(32)                        null,
    phone        varchar(32)                        null,
    password     varchar(64)                        null,
    sex          tinyint(2)                         null,
    avatar       varchar(255)                       null,
    status       tinyint(2)                         null,
    introduce    varchar(255)                       null,
    ext_json     varchar(255)                       null,
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    charset = utf8;

create table study_circle.auth_user_role
(
    id           bigint                             null,
    user_id      bigint                             null,
    role_id      bigint                             null,
    created_by   varchar(32)                        null comment '创建人',
    created_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    varchar(32)                        null comment '更新人',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted   int      default 0                 null
)
    charset = utf8;

