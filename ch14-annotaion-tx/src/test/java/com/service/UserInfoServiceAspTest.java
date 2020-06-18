package com.service;

import com.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserInfoServiceAspTest {
    @Test
    public void updateTest(){
        ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
        UserInfoService service = cxt.getBean(UserInfoService.class);
        service.txDemo();
    }
}
