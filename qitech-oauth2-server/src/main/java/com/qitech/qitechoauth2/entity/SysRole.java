package com.qitech.qitechoauth2.entity;

import java.io.Serializable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 角色表
 *
 * @author xinbj
 * @date 2019-12-20
 */
@Data
@Accessors(chain = true)
public class SysRole implements Serializable {
    /**
     * null
     */
    @Size(max = 32,  message = " null max length is 32")
    private String id;

    /**
     * 角色名-中文
     */
    @NotBlank(message = "角色名-中文Can not be empty")
    @Size(max = 255,  message = " 角色名-中文 max length is 255")
    private String name;

    /**
     * 角色编码 以ROLE_开头(spring security 规定)
     */
    @NotBlank(message = "角色编码 以ROLE_开头(spring security 规定)Can not be empty")
    @Size(max = 255,  message = " 角色编码 以ROLE_开头(spring security 规定) max length is 255")
    private String code;

    private static final long serialVersionUID = 1L;
}