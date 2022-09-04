/**
 * 
 */
package com.atguigu.crowd.mvc.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Auth;
import com.atguigu.crowd.service.api.AuthService;
import com.atguigu.crowd.util.ResultEntity;

/**
 * @ClassName: AuthHandler
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月3日 下午6:15:21
 * @param:
 */
@Controller
public class AuthHandler {
    @Autowired
    private AuthService authService;

    @ResponseBody
    @RequestMapping("assign/do/role/assign/auth.json")
    public ResultEntity<List<Integer>> saveRoleAuthRelationship(@RequestBody Map<String, List<Integer>> map) {
        authService.saveRoleAuthRelationship(map);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("assign/get/assignedAuthId/by/roleId.json")
    public ResultEntity<List<Integer>> getAssignedAuthIdByRoleId(@RequestParam("roleId") Integer roleId) {
        List<Integer> authId = authService.getAssignedAuthIdByRoleId(roleId);
        return ResultEntity.successWithData(authId);
    }

    @ResponseBody
    @RequestMapping("assign/get/all/auth.json")
    public ResultEntity<List<Auth>> getAllAuth() {
        List<Auth> list = authService.getAll();
        return ResultEntity.successWithData(list);
    }
}
