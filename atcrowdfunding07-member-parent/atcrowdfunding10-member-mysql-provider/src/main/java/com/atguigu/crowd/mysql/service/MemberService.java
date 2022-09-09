package com.atguigu.crowd.mysql.service;

import com.atguigu.crowd.entity.po.MemberPO;

/**
 * @author zhuyuqi
 * @version v2.0
 * @interfaceName MemberService
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 11:15
 */
public interface MemberService {
    MemberPO getMemberPOByLoginAcct(String loginacct);

    void saveMember(MemberPO memberPO);
}
