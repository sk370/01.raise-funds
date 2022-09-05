/**
 * 
 */
package com.atguigu.crowd.service.api;

import java.util.List;
import java.util.Map;

import com.atguigu.crowd.entity.Auth;

/**
 * @ClassName: AuthService
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月3日 下午6:14:27
 * @param:
 */
public interface AuthService {

    /**
     * @return
     */
    List<Auth> getAll();

    /**
     * @param roleId
     * @return
     */
    List<Integer> getAssignedAuthIdByRoleId(Integer roleId);

    /**
     * @param map
     */
    void saveRoleAuthRelationship(Map<String, List<Integer>> map);

    /**
     * 用于springsecurity登录
     * 
     * @param adminId
     * @return
     */
    List<String> getAssignAuthNameByAdminId(Integer adminId);

}
