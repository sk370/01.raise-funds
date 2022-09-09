package com.atguigu.crowd.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className ZuulMainClass
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 14:14
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulMainClass {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMainClass.class, args);
    }
}
