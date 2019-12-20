package com.qitech.qitechoauth2.security.validate.tradition;

import com.qitech.qitechoauth2.entity.SysRole;
import com.qitech.qitechoauth2.entity.SysUser;
import com.qitech.qitechoauth2.entity.SysUserRole;
import com.qitech.qitechoauth2.service.ISysRoleService;
import com.qitech.qitechoauth2.service.ISysUserRoleService;
import com.qitech.qitechoauth2.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 传统用户名密码登录 UserDetailsService
 *
 * @author xinbj
 * @date 2019/12/20 16:34
 */
@Service
public class TraditionUserDetailsService implements UserDetailsService {

    private ISysUserService userService;

    private ISysRoleService roleService;

    private ISysUserRoleService userRoleService;

    @Autowired
    public TraditionUserDetailsService(ISysUserService userService, ISysRoleService roleService, ISysUserRoleService userRoleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
    }

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
        // 从数据库中取出用户信息
        Optional<SysUser> userOptional = userService.selectByUsername(username);
        // 判断用户是否存在
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        SysUser user = userOptional.get();
        // 添加权限
        List<SysUserRole> userRoles = userRoleService.selectByUserId(user.getId());
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleService.selectByPrimaryKey(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        // 返回UserDetails实现类
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
