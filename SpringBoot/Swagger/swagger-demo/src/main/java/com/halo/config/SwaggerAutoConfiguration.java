package com.halo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Halo
 * @create 2021/11/12 下午 01:10
 * @description
 */
@Configuration
@EnableSwagger2
public class SwaggerAutoConfiguration {
    @Bean
    public Docket createRestApi1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).groupName("用户接口组")
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.halo.controller.user"))
                .build();
    }

    @Bean
    public Docket createRestApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).groupName("菜单接口组")
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.halo.controller.menu"))
                .build();
    }

    // 构建 API 文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("API 接口文档")
                // 创建人
                .contact(new Contact("Halo", "https://halo123.top", "885240677@qq.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }
}