package com.atguigu.crowd.mysql.service;

import java.util.List;

import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.entity.vo.OrderVO;

/**
 * @author zhuyuqi
 * @version v2.0
 * @interfaceName OrderService
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 09:18
 */
public interface OrderService {

    OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId);

    List<AddressVO> getAddressVOList(Integer memberId);

    void saveAddress(AddressVO addressVO);

    void saveOrder(OrderVO orderVO);
}
