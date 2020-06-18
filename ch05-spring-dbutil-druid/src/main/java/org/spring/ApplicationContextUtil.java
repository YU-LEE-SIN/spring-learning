package org.spring;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yu
 * @date 2020/5/20
 */
public class ApplicationContextUtil {
    public static ApplicationContext getApplicationContext(HttpServletRequest req ){
        ServletContext servletContext = req.getServletContext();
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute(ApplicationContextInstantiateListener.SPRING_CONTAINER_KEY);
        return context;
    }
}
