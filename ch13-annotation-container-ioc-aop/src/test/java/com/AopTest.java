package com;

import com.service.impl.CalcServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void testAnnoAop(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        CalcServiceImpl service = ctx.getBean(CalcServiceImpl.class);
        int result = service.add(6, 6);
        System.out.println("result = " + result);
    }
}
