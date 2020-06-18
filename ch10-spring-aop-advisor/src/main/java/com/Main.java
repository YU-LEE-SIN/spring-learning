package com;

import com.service.EmpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/6/18
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpService service = ctx.getBean("empService", EmpService.class);
        int result=service.add(6, 6);
        System.out.println("result=="+result);
    }
}
