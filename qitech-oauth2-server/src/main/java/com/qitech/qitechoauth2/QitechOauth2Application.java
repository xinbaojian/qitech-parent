package com.qitech.qitechoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author xinbj
 */
@EnableAuthorizationServer
@SpringBootApplication
public class QitechOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(QitechOauth2Application.class, args);
    }

}
