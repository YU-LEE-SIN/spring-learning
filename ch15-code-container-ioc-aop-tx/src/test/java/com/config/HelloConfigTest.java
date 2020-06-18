package com.config;

import com.service.impl.UserInfoServiceImpl;
import config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloConfigTest {

    @Test
    public void userInfoService() {
        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
        UserInfoServiceImpl service = context.getBean(UserInfoServiceImpl.class);
        service.update();
    }
}