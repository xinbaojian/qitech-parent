package com.qitech.qitechoauth2.service;

import com.qitech.qitechoauth2.entity.SysUser;

import java.util.Optional;

/**
 * @author xinbj
 * @date 2019/12/20 15:11
 */
public interface ISysUserService {

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return SysUser
     */
    Optional<SysUser> selectByUsername(String username);
}
