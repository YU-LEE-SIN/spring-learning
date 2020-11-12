# 使用注解配置
## 容器
1.xml:compent-scan
2 Controller,Service,Repository,Componet
3.PostConstruct,初始化
PreDestroy 销毁
4.Scope 作用域

## IOC
Autowire
    注意List与Map的注入.
Resource

Inject(注入)

多个候选的解决办法
 - @Primary
 - Qulifier(?)    接口有两个实现类 ,spring 并不知道应当引用哪个实现类。
## AOP
1.aspectj-autoproxy.相当于让spring理解aop相关的注解
    proxy-target-class属性的作用
    默认情况,spring生成动态代理,会考虑被代理对象是否实现有接口
    如果有,就利用jdk的动态代理技术来做,生成的代理类,不是目标类型的子类。
    =true 时spring不管有没有实现接口,都统一用cglib子类的形式来创建动态代理类
2. Aspect 切面

3.通知:
    @Before
    @After
    @AfterReturning
    @AfterThrowing
    @Around
4 切点表达式
    方法是无参无返回值
## 读取外部属性文件
    
   DbConfig.java 

  利用PropertySource注解读取外部文件到Environment
  使用外部文件的数据,方法有2种
  1.利用Environment.getProperty
  2.利用Value注解
  
 配置元数据可以通过xml+注解的形式来实现
做法如下:
1.在xml中配置context:compent-scan
2.实例化classpathxmlapplicationContext,使用第一步的xml文件
3.在需要被管理的bean上面添加注解,这些bean所在的包必须是第一步设置的扫描
范围之内
注解有如下几个:
1.Controller
2.Repository
3.Service
4.Component

本质上,这4个注解作用是一样的...因为他们都是有Component修饰的

4个注解建议使用方式如下:
1.Controller注解用在控制器类上面,spring mvc之后就用到
目前不能用在servlet
2.Service注解用在业务类
3.Repository用在dao上面,在某个spring版本之后,对Repository注解
额外添加了功能,比如把数据库操作的相关异常,转换为spring的DataAccessException
异常体系
4.所有上面3个注解不合用的地方就用Component,比如读取properties文件到一个类上面
就可以用Component