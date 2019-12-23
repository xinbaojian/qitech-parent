package com.qitech.qitechdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author xinbj
 */
@Import(AppConfig.class)
@MapperScan("com.qitech.qitechdemo.dao")
@SpringBootApplication(scanBasePackages = "com.qitech.qitechdemo")
public class QitechDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QitechDemoApplication.class, args);
    }

}
