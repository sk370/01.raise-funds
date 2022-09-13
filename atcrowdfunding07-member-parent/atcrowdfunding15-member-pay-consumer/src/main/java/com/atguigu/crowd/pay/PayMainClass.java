package com.atguigu.crowd.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className PayMainClass
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 14:08
 */
@SpringBootApplication
@EnableFeignClients("com.atguigu.crowd.api")
public class PayMainClass {
    public static void main(String[] args) {
        SpringApplication.run(PayMainClass.class, args);
    }
}
