/**
 * 
 */
package com.atguigu.crowd.mvc.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;

/**
 * @ClassName: TestHandler
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年8月31日 下午12:15:42
 * @param:
 */
@Controller
public class TestHandler {
    @Autowired
    private AdminService adminService;
    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @RequestMapping("/test/ssm.html")
    public String testSssm(ModelMap modelMap, HttpServletRequest request) {
        boolean type = CrowdUtil.judgeRequestType(request);
        logger.info(type + "=================================");
        List<Admin> list = adminService.getAll();
        modelMap.addAttribute("list", list);
        System.out.println(10 / 0);
        return "target";
    }

    @ResponseBody
    @RequestMapping("send/array.html")
    public String testReceiveOne(@RequestParam("array") List<Integer> array) {
        for (Integer number : array) {
            System.out.println(number);
        }
        return "success";
    }

}
