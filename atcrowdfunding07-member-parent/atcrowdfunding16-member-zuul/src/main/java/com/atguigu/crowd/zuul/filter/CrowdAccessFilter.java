package com.atguigu.crowd.zuul.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.atguigu.crowd.constant.AccessPassResources;
import com.atguigu.crowd.constant.CrowdConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 请求过滤：过滤无需登录就可访问的请求和静态资源
 * 
 * @author zhuyuqi
 * @version v0.0.1
 * @className CrowdAccessFilter
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 15:47
 */
@Component
public class CrowdAccessFilter extends ZuulFilter {
    /**
     * 何时执行过滤
     * 
     * @return pre:在目标微服务前（auth服务）执行过滤
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否放行
     * 
     * @return false放行，true拦截进行登录检查
     */
    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();// 获取RequestContext
        HttpServletRequest request = currentContext.getRequest();// 获取当前请求对象，框架底层是利用ThreadLocal从当前线程上获取事先绑定好的请求
        String servletPath = request.getServletPath();
        boolean contains = AccessPassResources.PASS_RES_SET.contains(servletPath);// 判断当前请求是否在05Util模块中定义
        if (contains) {
            return false;// 进行放行
        }
        return !AccessPassResources.judgeCurrentServletPathWetherStaticResource(servletPath);
    }

    /**
     * 登录检查操作
     * 
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();// 获取RequestContext
        HttpServletRequest request = currentContext.getRequest();// 获取当前请求对象，框架底层是利用ThreadLoca从当前线程上获取事先绑定好的请求
        HttpSession session = request.getSession();
        Object loginMember = session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        if (loginMember == null) {
            // 当前用户未登录，应当返回登录页面，但是zuul和登录（auth）不是一个模块，如法转发到达，只能重定向
            HttpServletResponse response = currentContext.getResponse();
            session.setAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
            try {
                response.sendRedirect("/auth/member/to/login/page.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
