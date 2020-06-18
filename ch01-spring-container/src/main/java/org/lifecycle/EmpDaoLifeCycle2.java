package org.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *    实例化(instantiation)与初始化(initialization)的问题
 *
 *     实例化:指的就是对象的创建,就是new一个对象
 *     其过程是:
 *     1.静态字段
 *     2.静态代码块(这两个是在类第一次加载才执行)
 *     3.实例代码块
 *     4.构造函数
 *
 *     初始化:指的是对象已经实例化完成之后,还要干一些必要的事情
 *     在非spring的环境下,一般是写一个init方法,并且在构造函数被调用
 *
 *     在spring的环境下,初始化方法有下面这几种设置方法
 *     bean 的init-method
 *     beans 的default-init-method
 *     bean实现接口Initializable接口(afterPropertiesSet)
 * @author yu
 * @date 2020/5/15
 */
public class EmpDaoLifeCycle2 implements InitializingBean, DisposableBean {

    /**
     * 这个方法名取名叫:"在属性设置完毕之后"
     * 其意思就是此类中各种setter方法被调用后
     * 才调用这个初始化方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("after properties set :初始化");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("destroy---");
    }
}
