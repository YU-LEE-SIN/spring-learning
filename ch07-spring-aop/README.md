## Spring AOP

####AOP:面向切面编程
能够将那些与业务无关，
却为业务模块所共同调用的逻辑或责任（例如事务处理、日志管理、权限控制等）封装起来，
便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可拓展性和可维护性。

####Spring实现AOP：
Spring AOP就是基于动态代理的，如果要代理的对象，实现了某个接口，
那么Spring AOP会使用JDK Proxy，去创建代理对象，而对于没有实现接口的对象，
就无法使用 JDK Proxy 去进行代理了，这时候Spring AOP会使用Cglib ，
这时候Spring AOP会使用 Cglib 生成一个被代理对象的子类来作为代理

####JDK动态代理和CGLIB代理 ：
JDK动态代理：其代理对象必须是某个接口的实现，
它是通过在运行期间创建一个接口的实现类来完成对目标对象的代理；其核心的两个类是InvocationHandler和Proxy。 
GLIB代理：实现原理类似于JDK动态代理，只是它在运行期间生成的代理对象是针对目标类扩展的子类。
####aop的几个术语
1.切面(aspect):案例中指的就是LogImpl这个类
2.切点(pointcut):它也称为切点表达式,目的是描述符合条件的方法
3.目标(target):就是案例中的EmployeeServiceImpl对象
4.连接点(join point):就是目标对象中的insert,update方法
5.通知(advice):就是切面类中的beforeXXX这个方法
6.aop代理(aopProxy):spring aop的实现就是靠代理来做到的,默认利用jdk代理和cglib代理来实现
7.织入(weaving):是个动词,表示把切面类的通知与目标对象连接点糅合在一起的过程就叫织入

```xml
 <bean id="log" class="org.LogImpl"/>

    <bean id="deptService" class="org.service.impl.DeptServiceImpl"/>
    <!--
   proxy-target-class的作用:
   默认情况,spring生成动态代理,会考虑被代理对象是否实现有接口
   如果有,就利用jdk的动态代理技术来做,生成的代理类,不是目标类型的子类

   如果目标没有实现接口,就只能用cglib创建动态代理,是一种建立子类的方式来实现

   所以你可以通过设定proxy-target-class(代理目标类)为true,就是让spring不管
   你有没有实现接口,都统一用cglib子类的形式来创建动态代理类

   -->
    <aop:config proxy-target-class="true">
        <!--

       Aspect:切面
       pointcut:切点

       总目标:就是把Logimpl的before方法糅合到EmployeeServiceImpl的两个方法执行之前

       有这么几个问题要解决
       1.如果找到业务类的insert,update方法?
       2.谁糅合到谁里去.

       aop的几个术语
       1.切面(aspect):案例中指的就是LogImpl这个类
       2.切点(pointcut):它也称为切点表达式,目的是描述符合条件的方法
       3.目标(target):就是案例中的EmployeeServiceImpl对象
       4.连接点(join point):就是目标对象中的insert,update方法
       5.通知(advice):就是切面类中的beforeXXX这个方法
       6.aop代理(aopProxy):spring aop的实现就是靠代理来做到的,默认利用jdk代理和cglib代理
         来实现
       7.织入(weaving):是个动词,表示把切面类的通知与目标对象连接点糅合在一起的过程就叫织入

       aop:aspect Oriented programming:
       -->

        <!--这是切面类的配置-->
        <aop:aspect id="logAspect" ref="log">
            <!--这是切点表达式的配置-->
            <aop:pointcut id="myPointcut" expression="execution(* org.service.*.*())"/>
            <!--before的通知,主要用来确定当前这个切面类的什么方法在什么时候切入到
            切点表达式指向的方法里面.
            -->
            <!--advice-->
            <aop:before method="before" pointcut-ref="myPointcut"></aop:before>
        </aop:aspect>
    </aop:config>
```

