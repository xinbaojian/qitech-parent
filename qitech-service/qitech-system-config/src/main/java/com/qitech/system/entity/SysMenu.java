package com.qitech.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author xinbj
 * @since 2019-12-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_sys_menu")
@ApiModel(value="SysMenu对象", description="菜单表")
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "父主键")
    private String parentId;

    @ApiModelProperty(value = "菜单编号")
    private String code;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单别名")
    private String alias;

    @ApiModelProperty(value = "路由地址")
    private String path;

    @ApiModelProperty(value = "菜单资源")
    private String source;

    @ApiModelProperty(value = "排序，正序")
    private Integer sort;

    @ApiModelProperty(value = "0 菜单; 1 按钮")
    private Integer category;

    @ApiModelProperty(value = "权限编码")
    private String permission;

    @ApiModelProperty(value = "是否打开新页面，默认false")
    private Boolean isOpen;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否已删除，默认false")
    private Boolean isDeleted;


}
