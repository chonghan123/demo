package com.example.demo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author hc
 * @classname MyAspect
 * @description TODO
 * @date 2020/5/13
 */
@Aspect
@Component
public class MyAspect {
    @Around("execution(* com.example.demo.spring.controller.*Controller.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        String interfaceName = proceedingJoinPoint.getSignature().getName();
        Object object = proceedingJoinPoint.proceed();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (object != null) {
            if (servletRequestAttributes != null) {
            }
        }
        return object;
    }
}
