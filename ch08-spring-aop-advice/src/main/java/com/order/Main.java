package com.order;

import com.service.EmpServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/6/17
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-order.xml");
        EmpServiceImpl service = context.getBean("serviceOrder", EmpServiceImpl.class);
        int result=service.add(6,6);
        System.out.println("result = " + result);
    }
}
