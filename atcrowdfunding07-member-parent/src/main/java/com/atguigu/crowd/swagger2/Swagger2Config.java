package com.atguigu.crowd.swagger2;

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
 * @author zhuyuqi
 * @version v0.0.1
 * @className Swagger2Config
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 13:20
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API测试文档")
                .description("DEMO项目的接口测试文档")
                .termsOfServiceUrl("http://www.hangge.com")
                .version("1.0")
                .contact(new Contact("zyq",
                        "http://sk370.top",
                        "xxx@xxxx.com"))
                .build();
    }
}
