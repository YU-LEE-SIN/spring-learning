package org.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 此监听器用来创建spring容器对象
 * 因为这个监听器是servletContext监听器,在容器启动时会被调用
 * 并且只会调用一次
 * @author yu
 * @date 2020/5/18
 */
public class ApplicationContextInstantiateListener implements ServletContextListener {
    public static final String SPRING_CONTAINER_KEY = "SPRING_CONTAINER";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(SPRING_CONTAINER_KEY,context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
