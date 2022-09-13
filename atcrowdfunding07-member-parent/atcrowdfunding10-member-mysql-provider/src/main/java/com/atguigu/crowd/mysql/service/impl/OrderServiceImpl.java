package com.atguigu.crowd.mysql.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crowd.entity.po.AddressPO;
import com.atguigu.crowd.entity.po.AddressPOExample;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.mysql.mapper.AddressPOMapper;
import com.atguigu.crowd.mysql.mapper.OrderPOMapper;
import com.atguigu.crowd.mysql.mapper.OrderProjectPOMapper;
import com.atguigu.crowd.mysql.service.OrderService;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className OrderServiceImpl
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 09:18
 */
@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderProjectPOMapper orderProjectPOMapper;
    @Autowired
    private OrderPOMapper orderPOMapper;
    @Autowired
    private AddressPOMapper addressPOMapper;

    @Override
    public OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId) {
        return orderProjectPOMapper.selectOrderProjectVO(returnId);
    }

    @Override
    public List<AddressVO> getAddressVOList(Integer memberId) {
        AddressPOExample addressPOExample = new AddressPOExample();
        addressPOExample.createCriteria().andMemberIdEqualTo(memberId);
        List<AddressPO> addressPOList = addressPOMapper.selectByExample(addressPOExample);
        List<AddressVO> addressVOList = new ArrayList<>();
        for (AddressPO addressPO : addressPOList) {
            AddressVO addressVO = new AddressVO();
            BeanUtils.copyProperties(addressPO, addressVO);
            addressVOList.add(addressVO);
        }
        return addressVOList;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void saveAddress(AddressVO addressVO) {
        AddressPO addressPO = new AddressPO();
        BeanUtils.copyProperties(addressVO, addressPO);
        addressPOMapper.insert(addressPO);
    }
}
