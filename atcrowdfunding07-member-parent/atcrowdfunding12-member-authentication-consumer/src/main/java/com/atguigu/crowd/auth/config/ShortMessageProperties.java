package com.atguigu.crowd.auth.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 保存短信验证功能的部分固定信息，如短信服务地址，跟人accesskey
 * @author zhuyuqi
 * @version v0.0.1
 * @className ShortMessageProperties
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 18:21
 */
@Configuration
@ConfigurationProperties(prefix = "short.message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortMessageProperties {
    private String accessKeyId;//私有id
    private String accessKeySecret;//私有key
    private String endpoint;//短信服务域名
    private String signName;//短信签名
    private String templateCode;//短信模板
}
