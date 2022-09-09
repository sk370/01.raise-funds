package com.atguigu.crowd.api;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className MySqlRemoteService
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 11:07
 */
@FeignClient("atguigu-crowd-mysql")
public interface MySqlRemoteService {
    @RequestMapping("/get/member/by/login/acct/remote")
    ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct);

    @RequestMapping("save/member/remote")
    ResultEntity<String> saveMember(@RequestBody MemberPO memberPO);
}