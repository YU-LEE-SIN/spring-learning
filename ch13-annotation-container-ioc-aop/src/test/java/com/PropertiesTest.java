package com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesTest {
    @Test
    public void testReadExternalFile(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DbConfig dbConfig = context.getBean(DbConfig.class);
        System.out.println(dbConfig.getData());
    }
}
