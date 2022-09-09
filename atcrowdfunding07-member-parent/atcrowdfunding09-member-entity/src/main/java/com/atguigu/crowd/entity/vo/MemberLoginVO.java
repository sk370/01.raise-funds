package com.atguigu.crowd.entity.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录成功后要放入session的信息
 * 
 * @author zhuyuqi
 * @version v0.0.1
 * @className MemberLoginVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 10:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLoginVO implements Serializable {

    private Integer id;

    private String username;

    private String email;
}
