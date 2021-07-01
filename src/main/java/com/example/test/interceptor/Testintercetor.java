package com.example.test.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;


import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
public class Testintercetor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
/*        ServletInputStream is = request.getInputStream();
        InputStreamReader ir = new InputStreamReader(is);
        Stream<String> stream = new BufferedReader(ir).lines();
        String s = stream.collect(Collectors.joining());
        log.info("{}", s);

        log.info("===========================before Method============================");
        log.info("==============================request===============================");
        log.info("========URI="+request.getRequestURI()+"=============================");
        log.info("========URI="+request.getMethod()+"=============================");
        log.info("========URI="+Thread.currentThread().getId()+"=============================");
        log.info("========URI="+request.getQueryString()+"=============================");
        log.info("================================END=================================");*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
/*        log.info("==============================request===============================");
        log.info("============================"+response.getStatus()+"=============================");
        log.info("============================"+request.getRequestURL()+"=============================");
        log.info("===========================after Method============================");*/
    }
}
