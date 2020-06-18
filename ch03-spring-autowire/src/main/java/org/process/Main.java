package org.process;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/5/17
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-process.xml");

        A a = context.getBean("a", A.class);
        System.out.println("看运行结果理解注入和生命周期");
    }
}
