package com.atguigu.crowd.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 不经过handler处理的请求映射。也可以配置拦截器
 * 
 * @author zhuyuqi
 * @version v0.0.1
 * @className WebMvcConfig
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 17:33
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        String regUrlPath = "/auth/member/to/reg/page.html";// 前端请求地址
        String regViewName = "member-reg";// 目标视图名称，路径会被thymeleaf处理

        String loginUrlPath = "/auth/member/to/login/page.html";
        String loginViewName = "member-login";

        String centerUrlPath = "auth/member/to/center/page";
        String centerViewName = "member-center";

        registry.addViewController(regUrlPath).setViewName(regViewName);
        registry.addViewController(loginUrlPath).setViewName(loginViewName);
        registry.addViewController(centerUrlPath).setViewName(centerViewName);

        registry.addViewController("/member/my/crowd").setViewName("member-crowd");
    }
}
