package com.atguigu.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className OrderVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 13:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO implements Serializable {
    private static final long serialVersionUID = 1L;
    // 主键
    private Integer id;
    // 订单号
    private String orderNum;
    // 支付宝流水单号
    private String payOrderNum;
    // 订单金额
    private Double orderAmount;
    // 是否开发票
    private Integer invoice;
    // 发票抬头
    private String invoiceTitle;
    // 备注
    private String orderRemark;
    private String addressId;
    private OrderProjectVO orderProjectVO;
}
