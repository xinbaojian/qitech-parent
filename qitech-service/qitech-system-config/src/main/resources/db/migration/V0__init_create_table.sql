-- 字典表
-- 字典表
create table tb_sys_dict
(
    id         char(32) not null
        constraint tb_sys_dict_pk
            primary key,
    parent_id  char(32)          default 0,
    code       varchar(255),
    dict_key   varchar(255),
    dict_value varchar(255),
    sort       int,
    is_system  boolean           default false,
    remark     varchar(255),
    type       int2     not null default 0,
    is_deleted int2              default 0,
    created_by        char(32),
    creation_time     timestamp,
    modified_by       char(32),
    modification_time timestamp
);

comment on table tb_sys_dict is '系统字典表';

comment on column tb_sys_dict.parent_id is '父主键';

comment on column tb_sys_dict.code is '字典编号';

comment on column tb_sys_dict.dict_key is '字典名称';

comment on column tb_sys_dict.dict_value is '字典值';

comment on column tb_sys_dict.sort is '排序，正序排列';

comment on column tb_sys_dict.is_system is 'true 系统字典 false 业务字典';

comment on column tb_sys_dict.remark is '备注';

comment on column tb_sys_dict.type is '0 系统字典 1 业务字典';

comment on column tb_sys_dict.is_deleted is '是否删除 0 否 1 是';

-- 用户表

create table tb_sys_user
(
    id                char(32)     not null
        constraint tb_sys_user_pk
            primary key,
    account           varchar(255) not null,
    password          varchar(255) not null,
    name              varchar(255),
    real_name         varchar(10)  not null,
    avatar            varchar(255),
    phone             varchar(45),
    email             varchar(255),
    sex               char(32),
    status            char(32),
    dept_id           char(32)     not null,
    created_by        char(32),
    creation_time     timestamp,
    modified_by       char(32),
    modification_time timestamp
);

comment on table tb_sys_user is '用户表';

comment on column tb_sys_user.id is '主键';

comment on column tb_sys_user.account is '账号';

comment on column tb_sys_user.password is '密码';

comment on column tb_sys_user.name is '昵称';

comment on column tb_sys_user.real_name is '真名';

comment on column tb_sys_user.avatar is '头像';

comment on column tb_sys_user.phone is '手机';

comment on column tb_sys_user.email is '邮箱';

comment on column tb_sys_user.sex is '性别';

comment on column tb_sys_user.status is '角色状态';

comment on column tb_sys_user.dept_id is '所属部门';

-- 部门表
create table tb_sys_dept
(
    id                char(32)     not null
        constraint tb_sys_dept_pk
            primary key,
    parent_id         char(32),
    dept_name         varchar(255) not null,
    full_name         varchar(255),
    sort              int,
    remark            varchar(255),
    manger_id         char(32),
    status            boolean default false,
    created_by        char(32),
    creation_time     timestamp,
    modified_by       char(32),
    modification_time timestamp
);

comment on table tb_sys_dept is '部门表';

comment on column tb_sys_dept.parent_id is '父主键';

comment on column tb_sys_dept.dept_name is '部门名称';

comment on column tb_sys_dept.full_name is '部门全称';

comment on column tb_sys_dept.sort is '排序，正序';

comment on column tb_sys_dept.remark is '备注';

comment on column tb_sys_dept.manger_id is '部门负责人';

comment on column tb_sys_dept.status is '部门状态 ，是否停用';

-- 菜单表

create table tb_sys_menu
(
    id         char(32)              not null
        constraint tb_sys_menu_pk
            primary key,
    parent_id  char(32),
    code       varchar(255),
    name       varchar(255),
    alias      varchar(255),
    path       varchar(255),
    source     varchar(255),
    sort       int     default 0,
    category   int                   not null,
    permission varchar(255),
    is_open    boolean default false not null,
    remark     varchar(255),
    is_deleted boolean default false not null,
    created_by        char(32),
    creation_time     timestamp,
    modified_by       char(32),
    modification_time timestamp
);

comment on table tb_sys_menu is '菜单表';

comment on column tb_sys_menu.id is '主键';

comment on column tb_sys_menu.parent_id is '父主键';

comment on column tb_sys_menu.code is '菜单编号';

comment on column tb_sys_menu.name is '菜单名称';

comment on column tb_sys_menu.alias is '菜单别名';

comment on column tb_sys_menu.path is '路由地址';

comment on column tb_sys_menu.source is '菜单资源';

comment on column tb_sys_menu.sort is '排序，正序';

comment on column tb_sys_menu.category is '0 菜单; 1 按钮';

comment on column tb_sys_menu.permission is '权限编码';

comment on column tb_sys_menu.is_open is '是否打开新页面，默认false';

comment on column tb_sys_menu.remark is '备注';

comment on column tb_sys_menu.is_deleted is '是否已删除，默认false';

-- 角色表

create table tb_sys_role
(
    id         char(32)     not null
        constraint tb_sys_role_pk
            primary key,
    parent_id  char(32),
    role_name  varchar(255) not null,
    role_alias varchar(255) not null,
    sort       int     default 0,
    status     boolean default true,
    data_scope char(1) default '1',
    is_deleted boolean default false,
    created_by        char(32),
    creation_time     timestamp,
    modified_by       char(32),
    modification_time timestamp
);

comment on table tb_sys_role is '角色表';

comment on column tb_sys_role.parent_id is '父主键';

comment on column tb_sys_role.role_name is '角色名';

comment on column tb_sys_role.role_alias is '角色别名';

comment on column tb_sys_role.sort is '排序，正序';

comment on column tb_sys_role.status is '角色状态 true 正常 false 停用';

comment on column tb_sys_role.sort is '数据范围 （1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）';

comment on column tb_sys_role.is_deleted is '是否已删除';

-- 用户角色表
create table tb_sys_user_role
(
    id      char(32) not null
        constraint tb_sys_user_role_pk
            primary key,
    user_id char(32) not null,
    role_id char(32) not null
);

comment on table tb_sys_user_role is '用户角色关联表';

comment on column tb_sys_user_role.user_id is '用户ID';

comment on column tb_sys_user_role.role_id is '角色ID';

-- 角色菜单表
create table tb_sys_role_menu
(
    id      char(32) not null
        constraint tb_sys_role_menu_pk
            primary key,
    role_id char(32) not null,
    menu_id char(32) not null
);

comment on table tb_sys_role_menu is '角色菜单关联表';

comment on column tb_sys_role_menu.id is '主键';

comment on column tb_sys_role_menu.role_id is '角色ID';

comment on column tb_sys_role_menu.menu_id is '菜单ID';


