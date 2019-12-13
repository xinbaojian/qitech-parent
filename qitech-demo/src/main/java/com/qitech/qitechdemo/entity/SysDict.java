package com.qitech.qitechdemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 字典表
 *
 * @author xinbj
 * @date 2019-12-12
 */
@Data
@Accessors(chain = true)
public class SysDict implements Serializable {
    /**
     * 编号
     */
    @Size(max = 64, message = " 编号 max length is 64")
    private String id;

    /**
     * 数据值
     */
    @NotBlank(message = "数据值Can not be empty")
    @Size(max = 100, message = " 数据值 max length is 100")
    private String value;

    /**
     * 标签名
     */
    @NotBlank(message = "标签名Can not be empty")
    @Size(max = 100, message = " 标签名 max length is 100")
    private String label;

    /**
     * 类型
     */
    @NotBlank(message = "类型Can not be empty")
    @Size(max = 100, message = " 类型 max length is 100")
    private String type;

    /**
     * 描述
     */
    @NotBlank(message = "描述Can not be empty")
    @Size(max = 100, message = " 描述 max length is 100")
    private String description;

    /**
     * 排序（升序）
     */
    @NotNull(message = "排序（升序）Can not be null")
    private BigDecimal sort;

    /**
     * 父级编号
     */
    @Size(max = 64, message = " 父级编号 max length is 64")
    private String parentId;

    /**
     * 创建者
     */
    @Size(max = 64, message = " 创建者 max length is 64")
    private String createBy;

    /**
     * 创建时间
     */
    @NotNull(message = "创建时间Can not be null")
    private Date createDate;

    /**
     * 更新者
     */
    @Size(max = 64, message = " 更新者 max length is 64")
    private String updateBy;

    /**
     * 更新时间
     */
    @NotNull(message = "更新时间Can not be null")
    private Date updateDate;

    /**
     * 备注信息
     */
    @Size(max = 255, message = " 备注信息 max length is 255")
    private String remarks;

    /**
     * 删除标记
     */
    @NotBlank(message = "删除标记Can not be empty")
    @Size(max = 1, message = " 删除标记 max length is 1")
    private String delFlag;

    private static final long serialVersionUID = 1L;
}