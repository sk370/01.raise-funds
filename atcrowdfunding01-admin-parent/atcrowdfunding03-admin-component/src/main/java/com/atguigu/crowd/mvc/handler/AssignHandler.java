/**
 * 
 */
package com.atguigu.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.RoleService;

/**
 * @ClassName: AssignHandler
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月3日 下午3:06:28
 * @param:
 */
@Controller
public class AssignHandler {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/assign/to/assign/role/page.html")
    public String toAssignRolePage(@RequestParam("adminId") Integer adminId, ModelMap modelMap) {
        List<Role> assignedRoleList = roleService.getAssingedRole(adminId);// 查询当前角色已有的角色

        List<Role> unAssignedRoleList = roleService.getUnAssignedRole(adminId);// 查询当前角色未分配的角色

        modelMap.addAttribute("assignedRoleList", assignedRoleList);
        modelMap.addAttribute("unAssignedRoleList", unAssignedRoleList);
        return "admin-assign-role";
    }

    @RequestMapping("/assign/do/role/assign.html")
    public String saveAdminRoleRelationship(@RequestParam("adminId") Integer adminId,
        @RequestParam("pageNum") Integer pageNum, @RequestParam("keyword") String keyword,
        @RequestParam(value = "roleIdList", required = false) List<Integer> roleIdList) {
        adminService.updateRelationShip(adminId, roleIdList);
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }
}
