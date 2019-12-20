package com.qitech.qitechoauth2.entity;

import java.io.Serializable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户角色关联表
 *
 * @author xinbj
 * @date 2019-12-20
 */
@Data
@Accessors(chain = true)
public class SysUserRole implements Serializable {
    /**
     * null
     */
    @Size(max = 32,  message = " null max length is 32")
    private String id;

    /**
     * 外键，关联用户表
     */
    @NotBlank(message = "外键，关联用户表Can not be empty")
    @Size(max = 32,  message = " 外键，关联用户表 max length is 32")
    private String userId;

    /**
     * 外键，关联角色表
     */
    @NotBlank(message = "外键，关联角色表Can not be empty")
    @Size(max = 32,  message = " 外键，关联角色表 max length is 32")
    private String roleId;

    private static final long serialVersionUID = 1L;
}