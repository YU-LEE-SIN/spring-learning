package org;
/**
 * 这是一个切面 类
 * @author yu
 * @date 2020/5/22
 */
public class LogImpl {
    public void before(){
        System.out.println("Spring-AOP****切面类*****开始执行");
    }
}
