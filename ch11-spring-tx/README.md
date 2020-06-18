## spring 事务

 spring事务写法要点:
        1.配置一个DataSource
        2.配置事务管理器,用上dataSource
        3.配置一个事务通知tx:advice
            3.1 对某些方法进行事务相关属性配置,比如超时(timeout),事务隔离级别
            事务传播方面的配置,只读配置
            3.2 一定要记得关联事务管理器,默认名字是transactionManager
        4.配置aopconfig,确定对哪些业务类的方法进行事务处理
        ***事务的处理是针对业务类,不是dao***