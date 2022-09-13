package com.atguigu.crowd.pay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className PayProperties
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 14:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "ali.pay")
public class PayProperties {
    private String appId;
    private String merchantPrivateKey;
    private String alipayPublicKey;
    private String notifyUrl;
    private String returnUrl;
    private String signType;
    private String charset;
    private String gatewayUrl;
}
