package com.qfggk.simpleweb.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(value=Ordered.HIGHEST_PRECEDENCE)
//@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {

    public CustomerHandlerExceptionResolver() {
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.sendError(511,"自定义的错误解析器处理的");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView();
    }
}
