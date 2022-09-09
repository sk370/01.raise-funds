package com.atguigu.crowd.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * 网关放行：不需要登录检查的请求和静态资源
 * 
 * @author zhuyuqi
 * @version v0.0.1
 * @className AccessPassResources
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/09 14:32
 */
public class AccessPassResources {
    public static final Set<String> PASS_RES_SET = new HashSet<>();
    static {
        PASS_RES_SET.add("/");// 首页
        PASS_RES_SET.add("/auth/member/to/reg/page.html");// 注册页面
        PASS_RES_SET.add("/auth/member/to/login/page.html");// 登录页面
        PASS_RES_SET.add("auth/member/logout");// 退出登录
        PASS_RES_SET.add("/auth/member/do/login");// 执行登录
        PASS_RES_SET.add("atuh/do/member/register");// 执行注册
        PASS_RES_SET.add("auth/member/send/short/message.json");// 短信认证
    }
    public static final Set<String> STATIC_RES_SET = new HashSet<>();

    /**
     * 静态资源的一级路径
     */
    static {
        STATIC_RES_SET.add("bootstrap");
        STATIC_RES_SET.add("css");
        STATIC_RES_SET.add("fonts");
        STATIC_RES_SET.add("img");
        STATIC_RES_SET.add("jquery");
        STATIC_RES_SET.add("layer");
        STATIC_RES_SET.add("script");
        STATIC_RES_SET.add("ztree");
    }

    /**
     * 判断是不是静态资源请求
     * 
     * @param servletPath
     * @return
     */
    public static boolean judgeCurrentServletPathWetherStaticResource(String servletPath) {
        if (servletPath == null || servletPath.length() == 0) {
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }
        String[] split = servletPath.split("/");
        String firstLevelPath = split[1];// split[0]是/左边的元素，是空字符串
        return STATIC_RES_SET.contains(firstLevelPath);
    }

}
