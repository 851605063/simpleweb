package com.qfggk.simpleweb.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({NullPointerException.class,ArithmeticException.class})
    public String handlerArithException(Exception e)
    {

        log.error("异常是：{}",e);
        return "login";
    }
}
