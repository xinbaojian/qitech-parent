package com.qitech.qitechoauth2.service;

import com.qitech.qitechoauth2.entity.SysRole;

/**
 * @author xinbj
 * @date 2019/12/20 15:27
 */
public interface ISysRoleService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysRole selectByPrimaryKey(String id);
}
