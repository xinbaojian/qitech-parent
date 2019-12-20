package com.qitech.qitechoauth2.service.impl;

import com.qitech.qitechoauth2.dao.SysRoleMapper;
import com.qitech.qitechoauth2.entity.SysRole;
import com.qitech.qitechoauth2.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xinbj
 * @date 2019/12/20 15:28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements ISysRoleService {

    private SysRoleMapper roleMapper;

    @Autowired
    public SysRoleServiceImpl(SysRoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public SysRole selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
