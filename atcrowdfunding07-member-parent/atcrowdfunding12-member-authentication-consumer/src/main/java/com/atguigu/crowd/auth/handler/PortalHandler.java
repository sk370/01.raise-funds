package com.atguigu.crowd.auth.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.crowd.api.MySqlRemoteService;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.util.ResultEntity;

/**
 * 加载首页
 * 
 * @author zhuyuqi
 * @version v0.0.1
 * @className PortalHandler
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 13:55
 */
@Controller
public class PortalHandler {
    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    @RequestMapping("/")
    public String showPortalPage(Model model) {
        ResultEntity<List<PortalTypeVO>> resultEntity = mySqlRemoteService.getPortalTypeProjectDataRemote();
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            List<PortalTypeVO> portalTypeVOList = resultEntity.getData();
            model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, portalTypeVOList);
        }
        return "portal";
    }
}
