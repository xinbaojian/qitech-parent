package com.qitech.qitechoauth2.security.validate.userdetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 短信登录验证
 *
 * @author xinbj
 * @date 2019/12/21 17:26
 */
@Slf4j
@Service
public class SmsUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        //TODO 手机号短信验证登录,获取当前用户逻辑处理
        log.info("手机号是:{}", phone);
        return null;
    }
}
