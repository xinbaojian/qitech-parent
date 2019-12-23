-- 初始化测试数据(正式项目需修改)
-- 创建用户表
create table sys_user
(
    id        char(32)     not null
        constraint sys_user_pk
            primary key,
    username  varchar(255) not null,
    password  varchar(255) not null,
    lock_date timestamp
);

comment on table sys_user is '用户表';

comment on column sys_user.username is '登录名';

comment on column sys_user.password is '密码';

comment on column sys_user.lock_date is '用户锁定时间';

create unique index sys_user_username_uindex
    on sys_user (username);

-- 创建角色表
create table sys_role
(
    id   char(32)     not null
        constraint sys_role_pk
            primary key,
    name varchar(255) not null,
    code varchar(255) not null
);

comment on table sys_role is '角色表';

comment on column sys_role.name is '角色名-中文';

comment on column sys_role.code is '角色编码 以ROLE_开头(spring security 规定)';

-- 创建用户角色关联表
create table sys_user_role
(
    id      char(32) not null
        constraint sys_user_role_pk
            primary key,
    user_id char(32) not null
        constraint sys_user_role_sys_user_id_fk
            references sys_user (id),
    role_id char(32) not null
        constraint sys_user_role_sys_role_id_fk
            references sys_role (id)
);

comment on table sys_user_role is '用户角色关联表';

comment on column sys_user_role.user_id is '外键，关联用户表';

comment on column sys_user_role.role_id is '外键，关联角色表';


-- 初始化测试数据(正式项目需删除)

insert into sys_user(id, username, password)
values ('91715c25b229451684980fdf906ac5c7', 'admin', '123');
insert into sys_user(id, username, password)
values ('efd45272cde14b12ae37743e779e554f', 'user', '123');

insert into sys_role(id, name, code)
values ('e49556b94e8a456ab404f1deba457933', '管理员', 'ROLE_ADMIN');
insert into sys_role(id, name, code)
values ('6f0422960d6644a9bdf47e0241c7a397', '普通用户', 'ROLE_USER');

insert into sys_user_role(id, user_id, role_id)
values ('4c40778083ce426db20a1ac8843fe6e3', '91715c25b229451684980fdf906ac5c7', 'e49556b94e8a456ab404f1deba457933');
insert into sys_user_role(id, user_id, role_id)
values ('1c80d2390ca040b99997c3699a7c9a81', 'efd45272cde14b12ae37743e779e554f', '6f0422960d6644a9bdf47e0241c7a397');