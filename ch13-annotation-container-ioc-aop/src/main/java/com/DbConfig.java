package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Component: 创建对象,默认创建的是单例对象
 *        属性:  value,表示对象的id
 *        位置:  在类的上面,表示创建该类的对象
 * @Component(value="myStudent")等同于<bean id="myStudent" class="com.atChina.Test.Student" />
 * @author yu
 * @date 2020/6/18
 */
@Component
@PropertySource("classpath:db.properties")
public class DbConfig {
    /**
     * Environment:环境的意思
     *
     * 里面存放的是各种来源的数据,
     * 比如os的全局的环境变量
     * jvm的一些变量
     * 外部的属性文件
     */
    @Autowired
    private Environment environment;

    public String getDataOne(){
        return environment.getProperty("username");
    }

    /**
     * 方法二
     * Value注解有以下几个特点:
     * 1.支持spring的el表达式
     * 2.冒号分隔表示是默认值
     */
    @Value("${username:myroot}")
    private String username;
    @Value("${url}")
    private String url;
    @Value("${password}")
    private String password;

    public String getData(){
        return username + "," + password+ "," +url;
    }
}
