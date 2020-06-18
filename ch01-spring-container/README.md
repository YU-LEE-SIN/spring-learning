#Spring 
- Spring框架概述
- Spring IoC容器和Bean
- Spring HelloWorld 
- 

## Spring框架概述

Spring是一个开源免费的框架，为了解决企业应用开发的复杂性而创建。Spring框架是一个轻量级的解决方案，可以一站式地构建企业级应用。Spring是模块化的，所以可以只使用其中需要的部分。可以在任何web框架上使用控制反转（IoC），也可以只使用Hibernate集成代码或JDBC抽象层。它支持声明式事务管理、通过RMI或web服务实现远程访问，并可以使用多种方式持久化数据。它提供了功能全面的MVC框架，可以透明地集成AOP到软件中。

## Spring IoC容器和Bean

Spring通过一种称作控制反转（IoC），IoC也称为依赖注入（DI）。技术促进了低耦合。当应用了IoC，一个对象依赖的其它对象会通过被动的方式传递进来，而不是这个对象自己创建或者查找依赖对象。然后，容器在创建bean时注入那些依赖项，就是所有被spring管理的bean，当它依赖一个其它项，被spring管理的bean的时候，spring负责把其注入进来（依赖注入（DI）。

在Spring中，构成应用程序主干并由Spring IoC容器管理的对象称为bean。Bean是由Spring IoC容器实例化，组装和以其他方式管理的对象。否则，bean仅仅是应用程序中许多对象之一。Bean及其之间的依赖关系反映在容器使用的配置元数据中。
## Spring HelloWorld 
### 添加spring-context的依赖即可
```xml
 <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
        </dependency>
    </dependencies>
```
### 创建一个spring xml配置文件(配置元数据)
配置元数据表示您作为应用程序开发人员如何告诉Spring容器实例化，配置和组装应用程序中的对象。
- 基于XML的配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--
            哪些类应该被spring管理?
            dao,service,部分工具类可以被spring管理
            但是servlet是一定不能被spring管理的.
            实体类,一般不被spring管理,从技术角度是可以被spring管理的
            
            
            spring 管理bean的作用域(scope)
            作用域就是:你的脸有多大,你说的话有多大的效果
            在spring中作用域其实指的就是被spring管理的bean的存活时间
            spring的作用域有4种
            1.prototype:(原型):每次getbean的时候都重新创建一个新的对象
            2.singleton:(单例):此作用域类型的bean,在spring容器启动时已经被创建,
                每次getbean的时候,直接从容器中获取即可
            3.request:(请求):request与session作用域都是在web环境下才有效
            被spring管理的bean,它的生存期就是在一个完整的请求周期里面
            4.session(会话):就是bean的作用范围是一个完整的session
            不同人有不同的会话,互相不干扰.
            
            
            默认情况下,被spring管理的bean的作用域是singleton
            用得最多的就是1,2
            
            singleton作用域的bean,其实例是在容器启动时创建
            以后就不再创建
            
            prototype作用的bean是在每次getBean的时候都反复创建
            bean的实例出来.
        -->
    
    <!--这里用构造函数实例化Bean-->
    <bean id="firstBean"
          class="org.helloworld.EmpDao"
          scope="prototype">
    </bean>
</beans>
```
- 基于注释的配置
- 基于Java的配置

### 实例化容器及使用
提供给`ApplicationContext`构造函数的一个或多个位置路径是资源字符串，这些资源字符串使容器可以从各种外部资源（例如本地文件系统，Java等）加载配置元数据`CLASSPATH`。

ApplicationContext代表着spring容器,是个接口
spring的容器指的就是ApplicationContext这种类型的接口体系
ApplicationContext是一个容器类

```java
public class Main {

    public static void main(String[] args) {

      /*容器的启动:指的就是实例化一个容器实现类的时候,
        容器的关闭:一般是容器对象被销毁或者调用其close方法*/
      // 1. 实例化容器 创建ApplicationContext对象,一般是子类ClasspathXmlApplicationContext.实例化的时候传递配置文件名
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      // 2. 使用容器
        //方式一  getBean(id:配置文件bean元素的id)
        EmpDao dao = (EmpDao) context.getBean("firstBean");
        //方式二
        EmpDao dao2 = context.getBean("firstBean", EmpDao.class);

        System.out.println("debug: dao = " + dao);
        System.out.println("debug: dao = " + dao2);
    }
}
```
## Spring Bean
### 用构造函数实例化
```xml
  <bean id="factory" class="org.factory.ExampleA">
  </bean>
```
### 用静态工厂方法实例化
```java
public class Afactory {
    private static ExampleA exampleA = new ExampleA();

    public static ExampleA createA(){
        return exampleA;
    }
    public ExampleA createB(){
        return new ExampleA();
    }
}
```
利用一个工厂性质的类+静态方法
   注意:这种配置方法createA方法必须是静态的
```xml
    <bean id="factory2"
             class="org.factory.Afactory"
             factory-method="createA">
    </bean>
```
### 使用实例工厂方法实例化
- 这种方法表明，工厂Bean本身可以通过依赖项注入（DI）进行管理和配置。
利用一个工厂性质的类+实例方法
    注意:这种配置方式,在配置factory-bean时不需要指定class属性
```xml
 <bean id="factoryA" class="org.factory.Afactory"></bean>
    <bean id="factory3"
          factory-bean="factoryA"
          factory-method="createB">
    </bean>
```
### 利用FactoryBean实例化
 下面配置方式返回的A这个类的实例
    原因是因为MyFactoryBean这个类实现了FactoryBean这个接口
    ,执行这个接口的方法。
    如果没有这个实现,那么返回的就是MyFactoryBean这个实例本身
```java
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
```
元数据:
```xml
  <bean id="factory4"
          class="org.factory.MyFactoryBean">
  </bean>
```
### Spring Bean的作用域与生命周期
　　在Spring中，那些组成应用程序的主体及由Spring IoC容器所管理的对象，
    被称之为bean。简单地讲，bean就是由IoC容器初始化、装配及管理的对象，
    除此之外，bean就与应用程序中的其他对象没有什么区别了。
    而bean的定义以及bean相互间的依赖关系将通过配置元数据来描述。
#### Bean的作用域
在spring中作用域其实指的就是被spring管理的bean的存活时间spring的作用域有4种

1. prototype:(原型):每次getbean的时候都重新创建一个新的对象。

2. singleton:(单例):此作用域类型的bean,在spring容器启动时已经被创建,
       每次getbean的时候,直接从容器中获取即可。

3. request:(请求):request与session作用域都是在web环境下才有效
   被spring管理的bean,它的生存期就是在一个完整的请求周期里面。

4. session(会话):就是bean的作用范围是一个完整的session
   不同人有不同的会话,互相不干扰。

   默认情况下,被spring管理的bean的作用域是singleton
   用得最多的就是1，2。
#### Bean的生命周期
 Spring 只帮我们管理单例模式 Bean 的完整生命周期，对于 prototype 的 bean ，Spring 在创建好交给使用者之后则不会再管理后续的生命周期。
 
 **生命周期的概要流程**
 Bean 的生命周期概括起来就是 4 个阶段：
- 实例化（Instantiation）
- 属性赋值（Populate）
- 初始化（Initialization）
- 销毁（Destruction）

**Bean自身的方法：<Bean>的init-method和destor-method方法Bean级生命周期接口方法：包含了BeanNameAware、BeanFacotyAware、InitialiZingBean和DisposableBean 接口方法 
Spring容器生命周期接口方法：有BeanPostProcessor"后处理器"**

**详细流程如下:**
1. 实例化Bean实例 ->   1. instantiate
2. 设置对象属性->         2. populate properties
3. 检擦Aware的相关接口并设置相关依赖 ->     3. BeanNameAware.setBeanName()   4. BeanFactoryAware.setBeanFactory()
4. BeanPostProcessor 前置处理->   5. BeanPostProcessor.postProcessBeforeInitialization()
5. 是否实现initializeBean 接口->     6. InitializingBean.afterPropertiesSet()
6. 是否实现自定义int-method->    7. 调用指定的init-method 
7. BeanPostProcessor 后置处理->    8. BeanPostProcessor.postProcessAfterInitiallization()
8. 注册必要的Destruction 相关回调接口
9. Bean 就绪 使用->    9. Bean可以用了
10. 是否实现DisposableBean接口 
11. 是否自定义destroy()->  11. DisposableBean.destroy()



1.bean对象实例化,默认Bean作用域singleton

2.Spring对bean进行依赖注入

3.Bean实现了BeanNameAware，Spring会将Bean的ID透传给setBeanName

Bean实现了BeanFacotryAware或ApplicationContentAware，Spring会调用设置工厂setBeanFatory
方法并将BeanFacoty实例透传进来，或SetApplicationContext方法被调用，Spring将应用上下文引用透传到Bean里。

Bean实现了BeanPostProcessor(后处理),bean的postProcessBeforeInitialization方法会被执行

Bean实现了InitializingBean，bean的afterPropertiesSet方法 就会被调用
<bean init-method="init"> 初始化方法init

BeanPostProcessor(后处理),执行postProcessAfterInitialization

这时Bean准备就绪，可以执行业务逻辑被服务方调用了，Bean会一直存活在应用上下文中，直到应用上下文被销毁。

Bean实现DisposableBean，spring将执行destory方法
<bean destroy-method="destroy"> 指定销毁方法 destroy



### 总结
首先是实例化、属性赋值、初始化、销毁这 4 个大阶段；
再是初始化的具体操作，有 Aware 接口的依赖注入、BeanPostProcessor 在初始化前后的处理以及 InitializingBean 和 init-method 的初始化操作；
销毁的具体操作，有注册相关销毁回调接口，最后通过DisposableBean 和 destory-method 进行销毁。
 