package com.atguigu.crowd.auth.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 加载首页
 * @author zhuyuqi
 * @version v0.0.1
 * @className PortalHandler
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 13:55
 */
@Controller
public class PortalHandler {
    @RequestMapping("/")
    public String showPortalPage(){
        // TODO 实际工作中首页数据需要动态获取数据（时间关系没做）
        return "portal";
    }
}
