package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className MemberVO
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 08:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    private String phoneNum;

    private String code;
}
