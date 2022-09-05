/**
 * 
 */
package com.atguigu.crowd.mvc.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.atguigu.crowd.entity.Admin;

/**
 * @ClassName: SecurityAdmin
 * @Description: 登录的封装账号(springsecurity的user对象只包含账号和密码，这里扩展了它的功能，使其具备了角色和权限的信息）
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月5日 上午10:52:23
 * @param:
 */
public class SecurityAdmin extends User {

    private static final long serialVersionUID = 1L;

    private Admin originlAdmin;

    /**
     * 
     * @param originalAdmin
     * @param authorities 角色、权限信息的集合
     */
    public SecurityAdmin(Admin originalAdmin, List<GrantedAuthority> authorities) {
        super(originalAdmin.getLoginAcct(), originalAdmin.getUserPswd(), authorities);
        this.originlAdmin = originalAdmin;// 重新包装后的admin对象，具有了角色和权限信息

        // 将原始 Admin 对象中的密码擦除
        this.originlAdmin.setUserPswd(null);
    }

    /**
     * @return the originlAdmin
     */
    public Admin getOriginlAdmin() {
        return originlAdmin;
    }

}
