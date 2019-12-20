package com.qitech.qitechoauth2.service;

import com.qitech.qitechoauth2.entity.SysUserRole;

import java.util.List;

/**
 * @author xinbj
 * @date 2019/12/20 15:29
 */
public interface ISysUserRoleService {

    List<SysUserRole> selectByUserId(String userId);
}
