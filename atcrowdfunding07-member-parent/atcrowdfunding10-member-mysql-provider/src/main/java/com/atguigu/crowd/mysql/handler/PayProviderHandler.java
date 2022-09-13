package com.atguigu.crowd.mysql.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crowd.entity.vo.OrderVO;
import com.atguigu.crowd.mysql.service.OrderService;
import com.atguigu.crowd.util.ResultEntity;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className PayProviderHandler
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 15:56
 */
@RestController
public class PayProviderHandler {
    @Autowired
    private OrderService orderService;

    @RequestMapping("save/order/remote")
    ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO) {
        try {
            orderService.saveOrder(orderVO);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
}
