package com.university.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.*;

public class LoggingInterceptor
        implements HandlerInterceptor {

    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler){

        System.out.println(
                "User Action : " +
                        request.getRequestURI()
        );

        return true;
    }

}