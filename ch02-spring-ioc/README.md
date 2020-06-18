# spring IOC
IOC:控制反转(inverse of control)
DI:依赖注入(Dependency Injection)

假设有2个类UserService,UserDao

我们要使用Service类就需要

service = new UserService();

然后service 要使用dao 

service.setDao(new UserDao);

因为上面的UserService类需要userDao,给其添加
userDao实例的过程是由自己写代码控制,

就是一切都在自己的掌握中.这种情况就叫做不反转

控制反转就是
context.getBean("UserService",UserService.class);

上面的代码执行完毕后,userService已经帮其设置了userDao 

这里就会使用到 依赖注入，把dao 注入到service 中。

**IOC与DI**

那么IoC是如何做的呢？有点像通过婚介找女朋友，在我和女朋友之间引入了一个第三者：婚姻介绍所。

婚介管理了很多男男女女的资料，我可以向婚介提出一个列表，告诉它我想找个什么样的女朋友，比如长得像xx内之类的，

然后婚介就会按照我们的要求，提供一个mm，我们只需要去和她谈恋爱、结婚就行了。简单明了，如果婚介给我们的人选不符合要求，我们就会抛出异常。

整个过程不再由我自己控制，而是有婚介这样一个类似容器的机构来控制。Spring所倡导的开发方式就是如此，
所有的类都会在spring容器中登记，告诉spring你是个什么东西，你需要什么东西，然后spring会在系统运行到适当的时候，把你要的东西主动给你，

同时也把你交给其他需要你的东西。所有的类的创建、销毁都由 spring来控制，也就是说控制对象生存周期的不再是引用它的对象，而是spring。

对于某个具体的对象而言，以前是它控制其他对象，现在是所有对象都被spring控制，所以这叫控制反转。

原文链接：https://blog.csdn.net/Baple/java/article/details/53667767

## 依赖注入
依赖注入:所有被spring管理的bean,当它依赖一个其它
被spring管理的bean的时候,spring负责把其注入进来。
### 基于构造函数注入
　构造函数注入是除属性注入之外的另一种常用的注入方式，它可以保证一些必要的属性在bean实例化时就得到了设置，并在实例化后就可以使用。

　　使用构造函数注入的前提是：bean必须提供带参的构造函数。

　　对于构造函数的注入，配置文件可以有以下几种方式：

　　●  按类型匹配入参 (type)
 
　　●  按索引匹配入参 (index)

　　●  联合使用类型和索引匹配入参 (type+index)

　　●  通过自身类型反射匹配入参 (class)

    ```xml
     <!-- 构造函数注入  最后一个是用setter注入(可以混合使用[构造函数注入 + setter注入])-->
        <!--<bean id="dbConfig" class="org.basic.DbConfig" >
            <constructor-arg name="url" value="url.."/>
            <constructor-arg name="username" value="username"/>
            <constructor-arg name="password" value="root"/>
            <property name="driverClassname" value="driver"/>
        </bean>-->
    
        <!-- 下面的配置顺序与构造函数是一一对应,所以不再需要额外的设置-->
        <!--<bean id="dbConfig" class="com.basic.DbConfig">
            <constructor-arg value="url.."/>
            <constructor-arg value="root"/>
            <constructor-arg value="pwd"/>
            <property name="driverClassname" value="driver"/>
        </bean>-->
    
        <!--配置顺序与类的构造函数顺序不一致时，需要额外的信息告诉
       spring,谁赋值给谁-->
        <bean id="dbConfig" class="org.basic.DbConfig">
            <!--本来这个root应该是赋值给url,但因为加了name=username
            所以就把root 赋值给了构造函数的第二个参数-->
            <constructor-arg name="username" value="root" />
            <constructor-arg name="password" value="pwd"/>
            <constructor-arg name="url" value="url.."/>
            <constructor-arg name="driverClassname" value="driver.."/>
        </bean>
        <!--  可用index确定位置  -->
        <!--<bean id="dbConfig" class="com.basic.DbConfig>
           <constructor-arg value="root" index="1" />
           <constructor-arg value="pwd" index="2"/>
           <constructor-arg value="url.." index="0"/>
           <property name="driverClassname" value="driver"/>
       </bean>-->
    ```
### 基于属性（setter）注入
属性注入即通过setXXX( )方法注入bean的属性值或依赖对象。

Spring首先会调用bean的默认构造函数实例化bean对象，然后再通过反射的方法调用setter方法来注入属性值。

 属性注入要求bean提供一个默认的构造函数，并且得为需要注入的属性提供set方法。
 
 ```xml
  <!--setter方法注入(属性注入)-->
   <bean id="dbConfig" class="org.basic.DbConfig" >
        <property name="url" value="url.."/>
        <property name="username" value="username"/>
        <property name="password" value="root"/>
        <property name="driverClassname" value="driver"/>
    </bean>
```
 ### 工厂方法注入
 ch01-spring-container->resources->applicationContext-factory.xml 这里就是两种工厂方法的注入。
 
 ### 基本类型 和 Collections(集合) 的注入
 普通属性(name)
 对象属性(Address)
 List属性
 Map
 Set   
```java
public class UserInfo {
    private String name;
    private Address address;
    private List<Address> addressList;
    private List<String> hobbyList;
    private Set<String> xueLi;
    private Map<String,Integer> xueFen;
    private Properties properties;
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<String> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<String> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public Set<String> getXeuLi() {
        return xueLi;
    }

    public void setXeuLi(Set<String> xueLi) {
        this.xueLi = xueLi;
    }

    public Map<String, Integer> getXueFen() {
        return xueFen;
    }

    public void setXueFen(Map<String, Integer> xueFen) {
        this.xueFen = xueFen;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", addressList=" + addressList +
                ", hobbyList=" + hobbyList +
                ", xuLi=" + xueLi +
                ", xueFen=" + xueFen +
                ", properties=" + properties +
                '}';
    }
}
```
元数据
```xml
<bean id="userInfo" class="org.basic.UserInfo">
        <property name="name" value="Fiona"/>
        <!--    bean(内部bean)
        只是给address属性使用,无法通过getBean方式得到这个对象
        <property name="address" >
            <bean class="com.basic.Address"/>
        </property>
        -->
        <property name="address">
            <bean class="org.basic.Address">
                <property name="city" value="Demacia"/>
                <property name="province" value="Valoran"/>
            </bean>
        </property>

        <property name="addressList">
            <list>
                <ref bean="addr"/><!--引用addr这个bean-->
                <!--<bean class="com.basic.Address">
                    <property name="city" value="gd"/>
                    <property name="province" value="zhuhai"/>
                </bean>-->
            </list>
        </property>

        <property name="hobbyList">
            <list>
                <value>basketball</value>
                <value>play games</value>
            </list>
        </property>

        <property name="xeuLi">
            <set>
                <value>junior middle school</value>
                <value>middle school</value>
            </set>
        </property>

        <property name="xueFen">
            <map>
                <entry key="Chinese" value="100"/>
                <entry key="Mathematics" value="50"/>
                <entry key="English" value="50"/>
            </map>
        </property>
        <!--如果用props配置,值只能是字符串类型-->
        <property name="properties">
            <props>
                <prop key="java">j</prop>
                <prop key=".net">n</prop>
            </props>
        </property>
    </bean>
```
## c-namespace(名称空间)
在Spring 3.1中引入的c-namespace允许使用内联属性来配置构造函数参数，而不是嵌套`constructor-arg`元素。

注意： c: 基于 构造函数
       p:基于属性​
       
       下例使用p:username="root" bean类中必须要有属性（get,set）
        c:url="jdbc:mysql://url.." > 必须要有构造函数-> public MyDataSource(String url) {this.url = url;}
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--    以下示例使用c:名称空间 基于构造函数的依赖注入相同的操作,
     P: 基于属性
      -->
    <bean id="dataSource"
          class="org.namespace.MyDataSource"
          p:username="root" c:url="jdbc:mysql://url.." >
        <property name="password">
            <!--            该<null/>元素处理null的值。以下清单显示了一个示例-->
            <null></null>
        </property>
    </bean>

    <bean id="factory"
             class="org.namespace.MySqlFactory"
             p:dateSource-ref="dataSource"
             c:_0-ref="dataSource">
     </bean>
</beans>
```
###总结
IOC：依赖注入
，即组件之间的依赖关系由容器在运行期决定，即由容器动态地将某种依赖关系注入到组件之中。
IoC（Inverse of Control:控制反转）是一种设计思想，

就是 将原本在程序中手动创建对象的控制权，交由Spring框架来管理。 

  IoC 容器实际上就是个Map（key，value）,Map 中存放的是各种对象。
将对象之间的相互依赖关系交给 IOC 容器来管理，并由 IOC 容器完成对象的注入。

这样可以很大程度上简化应用的开发，把应用从复杂的依赖关系中解放出来。 
 IOC 容器就像是一个工厂一样，当我们需要创建一个对象的时候，
 只需要配置好配置文件/注解即可，完全不用考虑对象是如何被创建出来的


DI:控制反转
所有的类都会在spring容器中登记，告诉spring这是个什么东西，你需要什么东西，
然后spring会在系统运行到适当的时候，把你要的东西主动给你，
同时也把你交给其他需要你的东西。所有的类的创建、销毁都由 spring来控制，
也就是说控制对象生存周期的不再是引用它的对象，而是spring。对于某个具体的对象而言，
以前是它控制其他对象，现在是所有对象都被spring控制，所以这叫控制反转

在传统的对象创建方式中，通常由调用者来创建被调用者的实例，而在Spring中创建被调用者的工作由Spring来完成，

依赖注入原理：
依赖注入的思想是通过反射机制实现的，在实例化一个类时，
它通过反射调用类中set方法将事先保存在HashMap中的类属性注入到类中。