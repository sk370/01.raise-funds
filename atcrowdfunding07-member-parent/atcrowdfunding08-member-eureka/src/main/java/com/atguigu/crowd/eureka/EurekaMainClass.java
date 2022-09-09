package com.atguigu.crowd.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className EurekaMainClass
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/07 23:36
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMainClass {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMainClass.class, args);
    }
}
