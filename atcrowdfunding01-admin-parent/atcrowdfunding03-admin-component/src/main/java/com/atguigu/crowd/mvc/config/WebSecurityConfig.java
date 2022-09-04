/**
 * 
 */
package com.atguigu.crowd.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: WebSecurityConfig
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月4日 下午8:57:40
 * @param:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);//1. 删除默认的处理机制
        http.authorizeRequests()// 2.1 给请求授权
            .antMatchers("/admin/to/login/page.html") // 针对/admin/to/login/page.html路径进行授权
            .permitAll() // 无条件访问
            .antMatchers("/bootstrap/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .antMatchers("/crowd/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .antMatchers("/css/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .antMatchers("/fonts/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .antMatchers("/img/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .antMatchers("/jquery/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .antMatchers("/layer/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .antMatchers("/script/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .antMatchers("/ztree/**") // 针对静态资源进行设置，无条件访问
            .permitAll() // 针对静态资源进行设置，无条件访问
            .anyRequest() // 任意请求
            .authenticated(); // 需要登录以后才可以访问
    }
}
