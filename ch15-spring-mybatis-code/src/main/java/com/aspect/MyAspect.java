package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.service..*.*(..))")
    public void myPointCut(){}

    @Around("myPointCut()")
    public Object performance(ProceedingJoinPoint joinPoint) {
        Object result=null;
        try {
            Long start=System.currentTimeMillis();
            result = joinPoint.proceed();
            Long end=System.currentTimeMillis();
            System.out.println("耗时=" + (end - start));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
