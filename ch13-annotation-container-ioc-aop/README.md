# 容器
1.xml:compent-scan
2 Controller,Service,Repository,Componet
3.PostConstruct,PreDestroy
4.Scope

# IOC
Autowire
    注意List与Map的注入.
Resource

Inject(注入)
    多个候选的解决办法
    @Primary
    @Qulifier
# AOP
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
  # 读取外部属性文件
  利用PropertySource注解读取外部文件到Environment
  
  使用外部文件的数据,方法有2种
  1.利用Environment.getProperty
  2.利用Value注解