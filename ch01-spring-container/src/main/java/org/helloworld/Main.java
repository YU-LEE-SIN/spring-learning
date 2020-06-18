package org.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.rmi.transport.proxy.RMISocketInfo;

/**
 * @author yu
 * @date 2020/5/15
 */
public class Main {

    public static void main(String[] args) {
      /*  ApplicationContext代表着spring容器,是个接口
        spring的容器指的就是ApplicationContext这种类型的接口体系
        ApplicationContext是一个容器类
        容器的启动:指的就是实例化一个容器实现类的时候,
        容器的关闭:一般是容器对象被销毁或者调用其close方法*/
        // 1. 实例化容器 创建ApplicationContext对象,一般是子类ClasspathXmlApplicationContext.实例化的时候传递配置文件名
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 使用容器
        //方式一  getBean(id:配置文件bean元素的id)
        EmpDao dao = (EmpDao) context.getBean("firstBean");
        //方式二
        EmpDao dao2 = context.getBean("firstBean", EmpDao.class);

        System.out.println("debug: dao = " + dao);
        System.out.println("debug: dao = " + dao2);
    }
}
