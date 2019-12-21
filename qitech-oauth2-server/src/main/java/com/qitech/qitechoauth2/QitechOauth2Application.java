package com.qitech.qitechoauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author xinbj
 */
@EnableDiscoveryClient
@EnableAuthorizationServer
@MapperScan("com.qitech.qitechoauth2.dao")
@SpringBootApplication(scanBasePackages = "com.qitech.qitechoauth2")
public class QitechOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(QitechOauth2Application.class, args);
    }

}
