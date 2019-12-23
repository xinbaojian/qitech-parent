package com.qitech.qitechdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xinbj
 * @date 2019/12/23 12:54
 */
@Getter
@Setter
public class BaseEntity {


    private String id;

    private String createdBy;

    private Date creationTime;

    private String modifiedBy;

    private Date modificationTime;
}
