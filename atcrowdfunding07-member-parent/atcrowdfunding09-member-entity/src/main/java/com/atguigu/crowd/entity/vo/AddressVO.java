package com.atguigu.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className AddressVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 10:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String receiveName;

    private String phoneNum;

    private String address;

    private Integer memberId;
}
