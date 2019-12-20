package com.qitech.qitechoauth2.security.validate.tradition;

import com.qitech.qitechoauth2.constant.SecurityConstant;
import com.qitech.qitechoauth2.security.handler.DefaultAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

/**
 * @author xinbj
 * @date 2019/12/20 17:03
 */
@Component
public class TraditionSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {


    @Autowired
    private TraditionUserDetailsService userDetailsService;

    @Autowired
    private DefaultAuthenticationFailureHandler defaultAuthenticationFailureHandler;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        TraditionAuthenticationFilter filter = new TraditionAuthenticationFilter(new AntPathRequestMatcher(SecurityConstant.LOGIN_PROCESSING_URL_FORM, "POST"));
        filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        //默认验证失败处理
        filter.setAuthenticationFailureHandler(defaultAuthenticationFailureHandler);

        //自动登录过滤器
        TraditionAuthenticationProvider provider = new TraditionAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(provider)
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class);
    }

}
