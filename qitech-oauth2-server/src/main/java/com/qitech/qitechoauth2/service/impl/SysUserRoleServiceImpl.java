package com.qitech.qitechoauth2.service.impl;

import com.qitech.qitechoauth2.dao.SysUserRoleMapper;
import com.qitech.qitechoauth2.entity.SysUserRole;
import com.qitech.qitechoauth2.entity.SysUserRoleExample;
import com.qitech.qitechoauth2.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xinbj
 * @date 2019/12/20 15:30
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserRoleServiceImpl implements ISysUserRoleService {

    private SysUserRoleMapper userRoleMapper;

    @Autowired
    public SysUserRoleServiceImpl(SysUserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public List<SysUserRole> selectByUserId(String userId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return userRoleMapper.selectByExample(example);
    }
}
