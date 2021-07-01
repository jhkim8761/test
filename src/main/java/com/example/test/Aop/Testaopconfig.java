package com.example.test.Aop;

import com.example.test.dto.Mongodbdto;
import com.example.test.service.Testservice;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@Slf4j
@Aspect
@Component
public class Testaopconfig {

    private final Logger Logger = LoggerFactory.getLogger(Testaopconfig.class);

    @Autowired
    private Testservice testservice;

    @Before("execution(* com.example.test.controller.Testcontroller.*(..))")
    public void testControllerBefore(JoinPoint joinPoint) {
        log.info("AOP Test : Before Start");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Mongodbdto mongodbdto = new Mongodbdto();
        mongodbdto.setThreadId(String.valueOf(Thread.currentThread().getId()));
        mongodbdto.setMethod(request.getMethod());
        mongodbdto.setUri(request.getRequestURI());
        if(!Objects.isNull(joinPoint.getArgs()) && joinPoint.getArgs().length > 0){
            mongodbdto.setParameter(String.valueOf(joinPoint.getArgs()[0]));
        }else{
            mongodbdto.setParameter("파라미터 없음");
        }

        testservice.saveMongodb(mongodbdto);

        log.info("AOP Test : Before End");
    }

    @After("execution(* com.example.test.controller.Testcontroller.*(..)) ")
    public void testControllerAfter(JoinPoint joinPoint) {
        log.info("AOP Test : After Start");
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

        Mongodbdto mongodbdto = new Mongodbdto();
        mongodbdto.setThreadId(String.valueOf(Thread.currentThread().getId()));
        mongodbdto.setStatus(response.getStatus());

        testservice.saveMongodb(mongodbdto);

        log.info("AOP Test : After End");
    }
}

