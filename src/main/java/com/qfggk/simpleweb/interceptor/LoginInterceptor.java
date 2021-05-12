package com.qfggk.simpleweb.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  登录检查
 *  1.配置好拦截器拦截哪些请求
 *  2.把拦截器放入容器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截请求
        String requestURI = request.getRequestURI();
//        log.info("preHandle拦截路径为："+requestURI);

        //登录检查
        HttpSession session=request.getSession();
        Object username = session.getAttribute("username");
        if(username!=null)
            return true;
        //未登录，跳转到登录页面
        response.sendRedirect("/");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle执行",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("afterHandle执行");
    }
}
