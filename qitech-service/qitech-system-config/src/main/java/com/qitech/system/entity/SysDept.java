package com.qitech.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author xinbj
 * @since 2019-12-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_sys_dept")
@ApiModel(value="SysDept对象", description="部门表")
public class SysDept extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "父主键")
    private String parentId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "部门全称")
    private String fullName;

    @ApiModelProperty(value = "排序，正序")
    private Integer sort;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "部门负责人")
    private String mangerId;

    @ApiModelProperty(value = "部门状态 ，是否停用")
    private Boolean status;


}
