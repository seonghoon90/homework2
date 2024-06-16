package com.sparta.homework2.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j(topic = "API Request 정보")
@Aspect
@Component
public class ApiRequestInforAop {

    @Pointcut("execution(* com.sparta.homework2.controller..*(..))")
    private void controller() {}

    @Before("controller()")
    public void apiLog() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        log.info("Request URL : " + request.getRequestURI());
        log.info("HTTP Method : " + request.getMethod());
    }

}
