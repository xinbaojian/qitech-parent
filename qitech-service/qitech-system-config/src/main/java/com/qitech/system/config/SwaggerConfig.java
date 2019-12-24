package com.qitech.system.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置
 * @ConditionalOnExpression 为Spring的注解，用户是否实例化本类，用于是否启用Swagger的判断（生产环境需要屏蔽Swagger）
 * @author xinbj
 * @date 2019/12/13 16:16
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qitech"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基于Swagger构建的qitech-system-config Rest API文档")
                .description("更多请咨询服务开发者xinbj")
                .contact(new Contact("北京奇观技术", "http://www.qi-tech.com.cn/", "xinbaojian@126.com"))
                .termsOfServiceUrl("http://www.qi-tech.com.cn/")
                .version("0.1")
                .build();
    }
}
