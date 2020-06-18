package org.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author yu
 * @date 2020/5/15
 */
public class MyFactoryBean implements FactoryBean {

    /**
     * 这个方法用来创建一个对象
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        return new ExampleA();
    }

    /**
     * 这个方法是用来表明此工厂Bean创建出来的对象的class
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return ExampleA.class;
    }

    /**
     * 这个方法表明此工厂Bean创建出来的对象,在spinrg管理下的作用域
     * true表示是singleton
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

}
