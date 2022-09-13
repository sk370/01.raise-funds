package com.atguigu.crowd.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className OrderMainClass
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/12 21:48
 */
@SpringBootApplication
@EnableFeignClients("com.atguigu.crowd.api") // 启用feign，调用mysql服务用
public class OrderMainClass {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainClass.class, args);
    }
}
