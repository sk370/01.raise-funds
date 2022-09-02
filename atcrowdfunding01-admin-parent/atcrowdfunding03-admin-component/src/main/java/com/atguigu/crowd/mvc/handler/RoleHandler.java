/**
 * 
 */
package com.atguigu.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.RoleService;
import com.atguigu.crowd.util.ResultEntity;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: RoleHandler
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月2日 上午9:10:07
 * @param:
 */
@Controller
public class RoleHandler {
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/role/remove/by/roleId/array.json")
    public ResultEntity<String> removeByRoleIdAarry(@RequestBody List<Integer> roleIdList) {
        roleService.removeByRoleIdAarry(roleIdList);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/role/update.json")
    public ResultEntity<String> updateRole(Role role) {
        roleService.updateRole(role);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/role/save.json")
    public ResultEntity<String> saveRole(Role role) {
        roleService.saveRole(role);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/role/get/page/info.json")
    public ResultEntity<PageInfo<Role>> getPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer PageSize) {
        PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, PageSize, keyword);// 老师称这里的异常处理走向：spring捕获，然后交给CrowdExceptionResolver.java处理。
        // 个人疑问：确实CrowdExceptionResolver.java中定义了Common判断请求类型，但是首先这个Common方法不需要调用吗？其次，Common只是处理请求类型啊，如果查不到数据或查到的数据有问题呢？不明白
        return ResultEntity.successWithData(pageInfo);
    }
}
