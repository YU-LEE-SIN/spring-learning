package org.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author yu
 * @date 2020/5/15
 */
public class SomeBean implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext context;

    public ApplicationContext getContext(){
        return this.context;
    }

    @Override
    public void setBeanName(String s) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void xx(){
        System.out.println("xx方法");
    }
}
