package com.qitech.qitechoauth2.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户表
 *
 * @author xinbj
 * @date 2019-12-20
 */
@Data
@Accessors(chain = true)
public class SysUser implements Serializable {
    /**
     * null
     */
    @Size(max = 32,  message = " null max length is 32")
    private String id;

    /**
     * 登录名
     */
    @NotBlank(message = "登录名Can not be empty")
    @Size(max = 255,  message = " 登录名 max length is 255")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码Can not be empty")
    @Size(max = 255,  message = " 密码 max length is 255")
    private String password;

    /**
     * 用户锁定时间
     */
    private Date lockDate;

    private static final long serialVersionUID = 1L;
}