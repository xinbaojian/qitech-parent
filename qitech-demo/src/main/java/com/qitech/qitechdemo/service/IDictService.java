package com.qitech.qitechdemo.service;

import com.qitech.qitechdemo.entity.SysDict;

import java.util.List;

/**
 * @author xinbj
 */
public interface IDictService {

    /**
     * 查询列表
     *
     * @return
     */
    List<SysDict> list();
}
