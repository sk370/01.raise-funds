package com.atguigu.crowd.config.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className TestSaltPassword
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/05 15:19
 */
public class TestSaltPassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "123123";
        String encode = passwordEncoder.encode(password);
        System.out.println(encode);
        //$2a$10$YAqWlvhTelvI9/SCDoY.Deqa.fsyVXNV1S6QV.f4KjnJuS/zw9m62
        //$2a$10$.OIcx.wEBGuYaAVGFP0ZKOvlaUsy/1B9NLQ3KBDX7ipHfiwkqYQxK
    }
}
