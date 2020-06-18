package config.annosupport;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * ComponentScan类似于xml中的context:componentScan
 * 要求被管理的bean有相关的的注解
 *
 * EnableAspectJAutoProxy注解等价于xml中的aop:aspectj-Auto-Proxy
 *
 * EnableTransactionManagement注解等价于xml中tx:annotation-driven
 *
 * 只需要保证事务管理器的bean的名称为txManager和transactionManager就可以了

 * @author yu
 * @date 2020/6/18
 */
@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AnnoSupportTxConfig {
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
}
