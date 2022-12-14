/**
 * 
 */
package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.Role;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: RoleService
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月2日 上午9:08:03
 * @param:
 */
public interface RoleService {
    PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword);

    /**
     * @param role
     */
    void saveRole(Role role);

    /**
     * @param role
     */
    void updateRole(Role role);

    /**
     * @param roleIdList
     */
    void removeByRoleIdAarry(List<Integer> roleIdList);

    /**
     * @param adminId
     * @return
     */
    List<Role> getAssingedRole(Integer adminId);

    /**
     * @param adminId
     * @return
     */
    List<Role> getUnAssignedRole(Integer adminId);
}
