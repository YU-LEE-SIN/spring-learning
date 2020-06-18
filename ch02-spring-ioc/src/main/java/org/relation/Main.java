package org.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/5/17
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-relation.xml");
        ChildOne childOne = context.getBean("child", ChildOne.class);
        System.out.println(" == " + childOne);
    }
}
