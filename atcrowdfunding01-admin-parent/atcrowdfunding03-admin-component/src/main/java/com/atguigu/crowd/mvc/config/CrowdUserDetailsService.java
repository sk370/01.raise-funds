/**
 * 
 */
package com.atguigu.crowd.mvc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.AuthService;
import com.atguigu.crowd.service.api.RoleService;

/**
 * @ClassName: CrowdUserDetailsService
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月5日 上午11:03:12
 * @param:
 */
@Component
public class CrowdUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 根据账号名查询Admin对象
        Admin admin = adminService.getAdminByLoginAcct(username);
        System.out.println("++++++++++++++++++++++++" + admin);
        // 2. 获取admin的id
        Integer adminId = admin.getId();
        // 3. 根据adminid查询角色信息
        List<Role> assingedRoleList = roleService.getAssingedRole(adminId);
        System.out.println(assingedRoleList);
        // 4. 根据adminId查询权限信息
        List<String> assignedAuthList = authService.getAssignAuthNameByAdminId(adminId);
        System.out.println(assignedAuthList);
        // 5. 创建集合对象存储Grantedauthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 6. 遍历角色和权限列表存入角色信息
        for (Role role : assingedRoleList) {
            String roleName = "ROLE_" + role.getName();// 注意WebSecurityConfig的role()方法需要添加前缀
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);
            authorities.add(simpleGrantedAuthority);
        }
        for (String authName : assignedAuthList) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authName);// 注意WebSecurityConfig的authorities()方法不需要添加前缀
            authorities.add(simpleGrantedAuthority);
        }
        // 7. 封装securityAdin对象
        SecurityAdmin securityAdmin = new SecurityAdmin(admin, authorities);
        return securityAdmin;
    }
}
