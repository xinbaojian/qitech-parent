package com.qitech.qitechoauth2.config;

import com.qitech.qitechoauth2.security.validate.tradition.TraditionSecurityConfig;
import com.qitech.qitechoauth2.security.validate.tradition.TraditionUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author xinbj
 * @date 2019/12/18 15:00
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TraditionSecurityConfig traditionSecurityConfig;

    @Autowired
    private TraditionUserDetailsService userDetailService;

    /**
     * 密码加密方式，spring 5 后必须对密码进行加密
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 不同登陆方式的配置
                .apply(traditionSecurityConfig)
                .and()
                .authorizeRequests()
                // 如果有允许匿名的url，填在下面
//                .antMatchers("/register", "/auth/register", "/auth/face-check", SecurityConstant.LOGIN_PROCESSING_URL_FACE).permitAll()
//                .antMatchers("/api/v1/public/**").permitAll()
                .anyRequest().authenticated().and()
                .logout().permitAll();

        // 关闭CSRF跨域
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    /**
     * 认证管理
     * Bean重点是这行，父类并没有将它注册为一个 Bean
     *
     * @return 认证管理对象
     * @throws Exception 认证异常信息
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
