package com.atguigu.crowd.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.util.ResultEntity;

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

    @RequestMapping("/create/confirm")
    ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO,
        @RequestParam("memberId") Integer memberId);

    @RequestMapping("get/portal/type/project/data")
    ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();

    @RequestMapping("get/project/detail/remote/{projectId}")
    ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId);

    @RequestMapping("get/order/project/vo/remote")
    ResultEntity<OrderProjectVO> getOrderProjectVORemote(@RequestParam("projectId") Integer projectId,
        @RequestParam("returnId") Integer returnId);

    @RequestMapping("/get/address/vo/remote")
    ResultEntity<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId);

    @RequestMapping("save/address/remote")
    ResultEntity<String> saveAddressRemote(@RequestBody AddressVO addressVO);

    @RequestMapping("save/order/remote")
    ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO);
}
