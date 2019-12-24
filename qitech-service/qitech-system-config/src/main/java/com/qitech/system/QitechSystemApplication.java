package com.qitech.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author xinbj
 */
@Import(AppConfig.class)
@MapperScan("com.qitech.system.mapper")
@SpringBootApplication(scanBasePackages = "com.qitech.system")
public class QitechSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(QitechSystemApplication.class, args);
    }

}
