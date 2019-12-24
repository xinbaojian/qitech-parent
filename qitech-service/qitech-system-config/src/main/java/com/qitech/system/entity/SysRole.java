package com.qitech.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author xinbj
 * @since 2019-12-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_sys_role")
@ApiModel(value="SysRole对象", description="角色表")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "父主键")
    private String parentId;

    @ApiModelProperty(value = "角色名")
    private String roleName;

    @ApiModelProperty(value = "角色别名")
    private String roleAlias;

    @ApiModelProperty(value = "数据范围 （1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    private Integer sort;

    @ApiModelProperty(value = "角色状态 true 正常 false 停用")
    private Boolean status;

    private String dataScope;

    @ApiModelProperty(value = "是否已删除")
    private Boolean isDeleted;


}
