package org.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/5/15
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-factory.xml");
        //这样得到是利用工厂类创建出来的对象
        ExampleA instance = context.getBean("factory4", ExampleA.class);
        System.out.println(instance.getClass().getName());

    }
}
