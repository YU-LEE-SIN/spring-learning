package com.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * JoinPoint参数类型是一个比较特殊的类型,所有的通知方法的
 *  第一个参数如果是JoinPoint类型,会自动帮你传进来.
 *
 * 所有的通知方法默认spring都会传递一个参数给你,就是JoinPoint类型，而且这个参数只能通知方法的第一个参数.
 * @author yu
 * @date 2020/6/9
 */
public class LogImpl {
    public void before() {
        System.out.println("之前before*********");
    }

    public void after(){
        System.out.println("之后after*********");
    }

    public void throwAdvice( RuntimeException re){
        System.out.println("-----debug: re = " + re);
        System.out.println("异常throwAdvice*********");
    }

    public void afterReturn(){
        System.out.println("after return*********");
    }
    /**
     * 环绕通知的参数类型是ProceedingJointPoint类型
     * 它是JoinPoint的子类型
     *
     * 但环绕通知的参数不能写为JoinPoint类型

     * @param joinpoint
     */
    public Object aroundAdvice(ProceedingJoinPoint joinpoint){
        Object result = null;
        System.out.println("aroundAdvice before*********");
        try {
            //这个代码是让目标方法执行,不调用会导致目标方法不执行
            result = joinpoint.proceed();

        } catch (Throwable throwable) {
            System.out.println("aroundAdvice throw *********");
        }
        System.out.println("aroundAdvice after*********");
        return result;
    }

    public Object aroundAdvice2(ProceedingJoinPoint joinPoint)  {
        Object result=null;
        System.out.println("aroundAdvice2 before2********");
        //这个代码是让目标方法执行,不调用会导致目标方法不执行
        try {
            result=joinPoint.proceed();
            //System.out.println("aroundAdvice2 return********");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("aroundAdvice throwable2********");
        }
        System.out.println("aroundAdvice2 after******");
        return result;
    }
}
