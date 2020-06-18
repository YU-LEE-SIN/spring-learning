package org.namespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/5/17
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-namespace.xml");
        MyDataSource ds = context.getBean("dataSource", MyDataSource.class);
        System.out.println(ds);
    }
}
