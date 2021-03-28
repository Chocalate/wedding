package com.lingnan.wedding.admin.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-15 17:24
 **/
@Aspect
//@Component
public class LogAop {

    private static final Logger logger = LoggerFactory.getLogger(LogAop.class);

    @Pointcut("execution(* com.lingnan.wedding.admin.controller.PageController.*(..))")
    public void pointCut(){

    }

    //目标方法前增强
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){

        //接收请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes == null){
            return;
        }
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        //下面这个joinPoint.getSignature.getName()获取了方法名

        System.out.println();
        logger.info("--------------->aop日志打印ing<------------- : ");
        logger.info("---->请求URL : " + request.getRequestURL().toString());
        logger.info("---->HTTP方法 : " + request.getMethod());
        logger.info("---->方法名 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }


    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("返回体 : " + ret);
        System.out.println();
    }





}
