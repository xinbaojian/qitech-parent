package com.qitech.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统字典表
 * </p>
 *
 * @author xinbj
 * @since 2019-12-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_sys_dict")
@ApiModel(value="SysDict对象", description="系统字典表")
public class SysDict extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "父主键")
    private String parentId;

    @ApiModelProperty(value = "字典编号")
    private String code;

    @ApiModelProperty(value = "字典名称")
    private String dictKey;

    @ApiModelProperty(value = "字典值")
    private String dictValue;

    @ApiModelProperty(value = "排序，正序排列")
    private Integer sort;

    @ApiModelProperty(value = "true 系统字典 false 业务字典")
    private Boolean isSystem;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "0 系统字典 1 业务字典")
    private Integer type;

    @ApiModelProperty(value = "是否删除 0 否 1 是")
    private Integer isDeleted;


}
