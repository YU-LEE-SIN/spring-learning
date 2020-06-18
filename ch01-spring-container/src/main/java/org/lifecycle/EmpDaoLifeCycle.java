package org.lifecycle;

/**
 * @author yu
 * @date 2020/5/15
 */
public class EmpDaoLifeCycle {
    public void init(){
        System.out.println("这个类的初始化代码,不是在构造函数");
    }
    public void destroy(){
        System.out.println("销毁");
    }
}
