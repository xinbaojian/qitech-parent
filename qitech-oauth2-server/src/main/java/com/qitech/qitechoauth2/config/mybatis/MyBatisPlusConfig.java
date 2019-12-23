package com.qitech.qitechoauth2.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatisPlus配置设置
 *
 * @author xinbj
 * @date 2019/12/23 11:52
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan("com.qitech.qitechdemo.*.mapper*")
public class MyBatisPlusConfig {

    /**
     * 配置分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        log.debug("注册分页插件");
        return new PaginationInterceptor();
    }

}
