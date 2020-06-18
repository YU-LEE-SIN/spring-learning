package org.complex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/5/16
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-complex.xml");
        UserServiceImpl service = context.getBean("userService2", UserServiceImpl.class);
        service.update();
    }
}
