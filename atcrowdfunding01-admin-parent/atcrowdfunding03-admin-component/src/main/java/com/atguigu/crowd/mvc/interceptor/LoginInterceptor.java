/**
 * 
 */
package com.atguigu.crowd.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.exception.AccessForbiddenException;

/**
 * @ClassName: LoginInterceptor
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月1日 下午1:38:43
 * @param:
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute(CrowdConstant.ATTR_LOGIN_NAME_ADMIN);
        if (admin == null) {
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
        }
        return true;
    }
}
