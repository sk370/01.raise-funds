package com.atguigu.crowd.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ProjectMainClass
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 18:10
 */
@SpringBootApplication
@EnableFeignClients("com.atguigu.crowd.api") // 启用feign，调用mysql服务用
public class ProjectMainClass {
    public static void main(String[] args) {
        SpringApplication.run(ProjectMainClass.class, args);
    }
}
