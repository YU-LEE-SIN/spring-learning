package org.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yu
 * @date 2020/5/16
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-basic.xml");
        DbConfig dbConfig = context.getBean("dbConfig", DbConfig.class);
        System.out.println(dbConfig);
        UserInfo userInfo = context.getBean("userInfo", UserInfo.class);
        System.out.println(userInfo);
    }
}
