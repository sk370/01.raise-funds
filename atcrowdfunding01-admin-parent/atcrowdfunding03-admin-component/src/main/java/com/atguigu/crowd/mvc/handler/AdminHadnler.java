/**
 * 
 */
package com.atguigu.crowd.mvc.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: AdminHadnler
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月1日 上午9:47:48
 * @param:
 */
@Controller
public class AdminHadnler {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/do/logout.html")
    public String doLogout(HttpSession httpSession) {
        httpSession.invalidate();// 强制让session失效
        return "redirect:/admin/to/login/page.html";
    }

    @RequestMapping("/admin/do/login.html")
    public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPwd") String userPswd,
        HttpSession httpSession) {
        Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);
        httpSession.setAttribute(CrowdConstant.ATTR_LOGIN_NAME_ADMIN, admin);
        // return "admin-main";//请求转发，刷新页面会重新提交表单
        // return "redirect:/WE-INF/admin-main";//重定向，解决重复提交表单，但是前端请求不能发到/web-inf路径下（访问不到）
        return "redirect:/admin/to/main/page.html";// 让springdispatchservlet处理
    }

    @RequestMapping("/admin/get/page.html")
    public String getPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer PageSize, ModelMap modelMap) {
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, PageSize);
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
        return "admin-page";
    }

    @RequestMapping("admin/remove/{adminId}/{pageNum}/{keyword}.html")
    public String remove(@PathVariable("adminId") Integer adminId, @PathVariable("pageNum") Integer pageNum,
        @PathVariable("keyword") String keyword) {
        // TODO 删除本人时提示无法删除
        // TODO 将删除修改为逻辑删除

        adminService.remove(adminId);
        // return "forward:/admin/get/page.html";//请求转发，可以实现页面返回，但返回时会执行一遍删除，影响性能。
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }

    @RequestMapping("/admin/save.html")
    public String save(Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/admin/get/page.html?pageNum=" + Integer.MAX_VALUE;
    }

    @RequestMapping("/admin/to/edit/page.html")
    public String edit(@RequestParam(value = "adminId") Integer adminId, ModelMap modelMap) {
        // 将参数放到modelMap中去
        Admin admin = adminService.getadminById(adminId);
        modelMap.addAttribute("admin", admin);
        return "admin-edit";
    }

    @RequestMapping("/admin/update.html")
    public String update(Admin admin, @RequestParam(value = "keyword") String keyword,
        @RequestParam(value = "pageNum") Integer pageNum) {
        // 将参数放到modelMap中去
        adminService.update(admin);
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }
    // TODO 批量删除功能
}
