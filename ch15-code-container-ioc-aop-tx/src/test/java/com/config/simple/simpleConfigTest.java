package com.config.simple;

import com.service.impl.UserInfoServiceImpl;
import config.simple.SimpleConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class simpleConfigTest {

    @Test
    public void userInfoService() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleConfig.class);
        UserInfoServiceImpl service = ctx.getBean(UserInfoServiceImpl.class);
        service.update();
    }
}