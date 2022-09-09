package com.atguigu.crowd.mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className MySqlMainClass
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 09:45
 */
@MapperScan("com.atguigu.crowd.mysql.mapper")
@SpringBootApplication
public class MySqlMainClass {
    public static void main(String[] args) {
        SpringApplication.run(MySqlMainClass.class, args);
    }
}
