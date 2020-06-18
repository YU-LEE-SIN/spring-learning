package org.dynamic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/5/15
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dynamic.xml");
        DynamicRegistrator registrator = context.getBean("registrator", DynamicRegistrator.class);
        ExampleB b = registrator.register("b", ExampleB.class);
        System.out.println("-----debug: b = " + b);
        ExampleB b2 = context.getBean("b", ExampleB.class);
        System.out.println("-----debug: b2 = " + b2);
        System.out.println(b==b2);
    }
}
