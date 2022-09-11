package com.atguigu.crowd.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 不经过handler处理的请求映射。也可以配置拦截器
 * 
 * @author zhuyuqi
 * @version v0.0.1
 * @className CrowdWebMvcConfig
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 17:33
 */
@Configuration
public class ProjectWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/agree/protocol/page").setViewName("project-agree");
        registry.addViewController("/launch/project/page").setViewName("project-launch");
        registry.addViewController("/return/info/page").setViewName("project-return");
        registry.addViewController("/create/confirm/page").setViewName("project-confirm");
        registry.addViewController("/create/success").setViewName("project-success");
        // registry.addViewController("/show/detail").setViewName("project-detail");
    }
}
