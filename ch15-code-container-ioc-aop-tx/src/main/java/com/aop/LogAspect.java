package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author yu
 * @date 2020/6/18
 */
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.service..*.*(..))")
    public void myPointcut(){

    }

    @Before("myPointCut()")
    public void before(){
        System.out.println("before----");
    }
    @After("myPointCut()")
    public void after(){
        System.out.println("after----");
    }
}
