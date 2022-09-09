package com.atguigu.crowd.api;

import com.atguigu.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqi
 * @version v2.0
 * @interfaceName RedisRemoteService
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 12:08
 */
@FeignClient("atguigu-crowd-redis")
public interface RedisRemoteService {
    /**
     * 设置：不带超时时间
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("set/redis/key/value/remote")
    ResultEntity<String> setRedisKeyValueRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value
    );

    /**
     * 设置：带超时时间
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     * @return
     */
    @RequestMapping("set/redis/key/value/remote/with/timeout")
    ResultEntity<String> setRedisKeyValueRemoteWithTimeout(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnix")TimeUnit timeUnit
            );

    /**
     * 获取
     * @param key
     * @return
     */
    @RequestMapping("get/redis/string/value/by/key")
    ResultEntity<String> getRedisStringValueByKey(@RequestParam("key") String key);

    /**
     * 删除
     * @param key
     * @return
     */
    @RequestMapping("remove/redis/string/value/by/key")
    ResultEntity<String> removeRedisStringValueByKey(@RequestParam("key") String key);

}
