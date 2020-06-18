package org.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/5/15
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aware.xml");
        SomeBean bean = context.getBean("someBean", SomeBean.class);
        ApplicationContext context1 = bean.getContext();
        System.out.println(context);
        System.out.println(context1);
    }
}
