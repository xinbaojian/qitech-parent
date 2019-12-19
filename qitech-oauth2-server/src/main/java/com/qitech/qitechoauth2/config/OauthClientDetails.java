package com.qitech.qitechoauth2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.List;

/**
 * 读取客户端配置信息
 *
 * @author xinbj
 * @date 2019/12/19 16:30
 */
@Data
@Configuration
@ConfigurationProperties("application.security.oauth")
public class OauthClientDetails {

    private List<BaseClientDetails> client;
}
