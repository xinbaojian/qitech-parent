package com.qitech.qitechdemo;

import com.qitech.common.config.RedisConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xinbj
 */
@Configuration
@EnableAutoConfiguration
@Import({RedisConfig.class})
public class AppConfig {
}
