package com.qitech.qitechoauth2.security.validate.userdetails;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 传统用户名密码登录 UserDetailsService
 *
 * @author xinbj
 * @date 2019/12/20 16:34
 */
@Service
@Primary
public class DefaultUserDetailsService implements UserDetailsService {


    /**
     * 实现用户验证
     *
     * @param username 用户登录名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //TODO 获取用户信息、角色信息、权限信息
//        // 从数据库中取出用户信息
//        Optional<SysUser> userOptional = userService.selectByUsername(username);
//        // 判断用户是否存在
//        if (!userOptional.isPresent()) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//
//        SysUser user = userOptional.get();
//        // 添加权限
//        List<SysUserRole> userRoles = userRoleService.selectByUserId(user.getId());
//        for (SysUserRole userRole : userRoles) {
//            SysRole role = roleService.selectByPrimaryKey(userRole.getRoleId());
//            authorities.add(new SimpleGrantedAuthority(role.getCode()));
//        }
        // 返回UserDetails实现类
//        return new User(user.getUsername(), user.getPassword(), authorities);
        return new User("admin", "123456", authorities);
    }
}
