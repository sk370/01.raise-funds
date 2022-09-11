package com.atguigu.crowd.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className AuthMainClass
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 13:49
 */
@SpringBootApplication
@EnableFeignClients("com.atguigu.crowd.api")
// @EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600, redisNamespace = "auth")
public class AuthMainClass {
    public static void main(String[] args) {
        SpringApplication.run(AuthMainClass.class, args);
    }
}
