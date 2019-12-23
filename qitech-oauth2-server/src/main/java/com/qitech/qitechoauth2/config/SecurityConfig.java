package com.qitech.qitechoauth2.config;

import com.qitech.qitechoauth2.constant.SecurityConstant;
import com.qitech.qitechoauth2.security.validate.filter.ValidateCodeFilter;
import com.qitech.qitechoauth2.security.validate.userdetails.DefaultUserDetailsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * @author xinbj
 * @date 2019/12/18 15:00
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DefaultUserDetailsService userDetailService;

    private final @NonNull ValidateCodeFilter validateCodeFilter;

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
                .authorizeRequests()
                // 如果有允许匿名的url，填在下面
                //获取验证码连接放行
                .antMatchers(SecurityConstant.CODE_SMS_URL).permitAll()
                .antMatchers(SecurityConstant.CUSTOM_OAUTH_URL_PATTERN).permitAll()
//                .antMatchers("/api/v1/public/**").permitAll()
                //放行所有OPTIONS请求,防止前端 axios 等框架发送的OPTION请求被拦截
                .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
                .anyRequest().authenticated().and()
                .logout().permitAll().and()
                //禁用session
                .sessionManagement().disable()
                // 禁用CSRF
                .csrf().disable()
                //禁用form登录
                .formLogin().disable()
                //支持跨域
                .cors();
        //添加过滤器
        http.addFilterBefore(validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
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
