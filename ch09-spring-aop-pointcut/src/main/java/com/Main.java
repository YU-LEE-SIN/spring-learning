package com;

import com.service.user.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/6/17
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoService service = ctx.getBean("service", UserInfoService.class);
        service.getAll();
        service.getById();
        service.updateById();
        int a=service.add(1, 2);
        System.out.println("a = " + a);
    }
}
