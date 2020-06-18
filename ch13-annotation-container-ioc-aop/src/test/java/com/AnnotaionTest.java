package com;

import com.service.impl.EmpServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/6/18
 */
public class AnnotaionTest {
    @Test
    public void testAnnoIoc(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpServiceImpl service = ctx.getBean(EmpServiceImpl.class);
        System.out.println(service);
        //service.update();
        //service.displayAutowireCollectionInject();
    }
}
