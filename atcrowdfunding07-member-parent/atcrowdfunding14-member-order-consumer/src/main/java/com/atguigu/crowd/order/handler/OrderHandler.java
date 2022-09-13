package com.atguigu.crowd.order.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.crowd.api.MySqlRemoteService;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.MemberLoginVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.util.ResultEntity;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className OrderHandler
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/13 08:52
 */
@Controller
public class OrderHandler {
    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    /**
     * 保存地址后，重定向到该页面
     * 
     * @param addressVO
     * @param session
     * @return
     */
    @RequestMapping("/save/address")
    public String saveAddress(AddressVO addressVO, HttpSession session) {
        ResultEntity<String> resultEntity = mySqlRemoteService.saveAddressRemote(addressVO);//
        OrderProjectVO orderProjectVO = (OrderProjectVO)session.getAttribute("orderProjectVO");
        Integer returnCount = orderProjectVO.getReturnCount();
        return "redirect:http://localhost:81/order/confirm/order/" + returnCount;
    }

    /**
     * 到确认订单界面
     * 
     * @param returnCount
     * @param session
     * @return
     */
    @RequestMapping("/confirm/order/{returnCount}")
    public String showConfirmOrderInfo(@PathVariable("returnCount") Integer returnCount, HttpSession session) {
        OrderProjectVO orderProjectVO = (OrderProjectVO)session.getAttribute("orderProjectVO");
        orderProjectVO.setReturnCount(returnCount);
        session.setAttribute("orderProjectVO", orderProjectVO);
        MemberLoginVO memberLoginVO = (MemberLoginVO)session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);// 当前登录用户
        Integer memberId = memberLoginVO.getId();
        ResultEntity<List<AddressVO>> resultEntity = mySqlRemoteService.getAddressVORemote(memberId);
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            List<AddressVO> addressVOList = resultEntity.getData();
            session.setAttribute("addressVOList", addressVOList);
        }
        return "confirm-order";
    }

    /**
     * 点击支持，到确认回报界面
     *
     * @param projectId
     * @param returnId
     * @param session
     * @return
     */
    @RequestMapping("/confirm/return/info/{projectId}/{returnId}")
    public String showReturnConfirmInfo(@PathVariable("projectId") Integer projectId,
        @PathVariable("returnId") Integer returnId, HttpSession session) {
        ResultEntity<OrderProjectVO> resultEntity = mySqlRemoteService.getOrderProjectVORemote(projectId, returnId);
        if (ResultEntity.SUCCESS.equals((resultEntity.getResult()))) {
            OrderProjectVO orderProjectVO = resultEntity.getData();
            // model.addAttribute("orderProjectVO", orderProjectVO);//由于下一个页面还需要这些信息，所以就放到session里面
            session.setAttribute("orderProjectVO", orderProjectVO);
        }
        return "confirm-return";
    }
}
