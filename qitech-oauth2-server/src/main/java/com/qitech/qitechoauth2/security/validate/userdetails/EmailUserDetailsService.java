package com.qitech.qitechoauth2.security.validate.userdetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 邮箱登录验证
 *
 * @author xinbj
 * @date 2019/12/21 17:26
 */
@Service
public class EmailUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        //TODO 邮件验证登录，获取当前用户逻辑处理
        return null;
    }
}
