# 微服务Spring Security OAuth2例子

## OAuth2 Server 端

配置客户端信息，客户端信息存储在数据库及redis 中,授权模式使用 `password` 模式

数据库表结构使用`flyway`进行管理

1. OAuth2 信息存储到数据库中,表结构 `resource/db/migration/V0__init_create_table.sql`
2. 初始化 客户端信息 `resource/db/migration/V1__init_data.sql`

## 登录方式

登录方式支持 用户名密码登录及扩展自定义登录，如，手机验证码登录，邮件验证码登录，可添加其它登录方式

## Tips:

更新项目版本号

    mvn versions:set -DnewVersion=1.0.0