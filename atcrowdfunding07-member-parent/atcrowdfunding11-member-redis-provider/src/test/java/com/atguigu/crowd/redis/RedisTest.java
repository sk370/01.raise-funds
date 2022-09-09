package com.atguigu.crowd.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className RedisTest
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Test
    public void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("apple", "red");
    }

    @Test
    public void testExSet(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("banana", "yellow", 5000, TimeUnit.SECONDS);
    }
}
