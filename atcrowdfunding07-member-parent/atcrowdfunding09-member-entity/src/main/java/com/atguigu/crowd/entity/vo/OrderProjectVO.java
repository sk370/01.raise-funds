package com.atguigu.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className OrderProjectVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 08:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProjectVO implements Serializable {
    private Integer id;
    private String projectName;
    private String launchName;
    private String returnContent;
    private Integer returnCount;
    private Integer supportPrice;
    private Integer freight;
    private Integer orderId;
    private Integer signalPurchase;
    private Integer purchase;
}
