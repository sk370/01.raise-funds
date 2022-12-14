/**
 * 
 */
package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.exception.AccessForbiddenException;
import com.atguigu.crowd.exception.LoginAcctAlreadyInUseException;
import com.atguigu.crowd.exception.LoginAcctAlreadyInUseForUpdateException;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import com.google.gson.Gson;

/**
 * @ClassName: CrowdExceptionResolver
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年8月31日 下午7:19:38
 * @param:
 */
@ControllerAdvice // 声明该类为基于注解的异常处理类
public class CrowdExceptionResolver {

    /**
     * 修改账户名已存在
     * 
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = LoginAcctAlreadyInUseForUpdateException.class) // 关联异常类型和方法
    public ModelAndView resolveLoginAcctAlreadyInUseForUpdate(LoginAcctAlreadyInUseForUpdateException exception,
        HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = "system-error";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 新增用户已存在
     * 
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = LoginAcctAlreadyInUseException.class) // 关联异常类型和方法
    public ModelAndView resolveLoginAcctAlreadyInUse(LoginAcctAlreadyInUseException exception,
        HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = "admin-add";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 登录失败，返回登录界面
     * 
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = LoginFailedException.class) // 关联异常类型和方法
    public ModelAndView resolveLoginFalid(LoginFailedException exception, HttpServletRequest request,
        HttpServletResponse response) throws IOException {
        String viewName = "admin-login";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 登录未输入密码
     * 
     * @param exception
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = AccessForbiddenException.class) // 关联异常类型和方法
    public ModelAndView resolveArithmeticException(AccessForbiddenException exception, HttpServletRequest request,
        HttpServletResponse response) throws IOException {
        return commonResolve("system-error", exception, request, response);
    }

    /**
     * 通用异常处理方法
     * 
     * @param viewName 返回的页面
     * @param exception
     * @param request
     * @param response 处理ajax请求使用
     * @return
     * @throws IOException
     */
    private ModelAndView commonResolve(String viewName, Exception exception, HttpServletRequest request,
        HttpServletResponse response) throws IOException {
        boolean requestType = CrowdUtil.judgeRequestType(request);
        // ajax请求的异常
        if (requestType) {
            ResultEntity.failed(exception.getMessage());// 创建异常实体
            Gson gson = new Gson();
            String json = gson.toJson(gson);// 将异常实体转换为json字符串
            response.getWriter().write(json);// 使用httpresponse将json字符串传给前端
            return null;// 上面httpresponse已经处理了，不需要ModelAndView处理了
        }
        // 非ajax请求的异常
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);// 添加异常对象
        modelAndView.setViewName(viewName);// 指定返回的异常界面
        return modelAndView;
    }
}
