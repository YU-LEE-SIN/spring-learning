package config.annosupport;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ComponentScan类似于xml中的context:componentScan
 * 要求被管理的bean有相关的的注解
 * EnableAspectJAutoProxy注解等价于xml中的aop:aspectj-Auto-Proxy
 *
 * @author yu
 * @date 2020/6/18
 */
@Configurable
@ComponentScan("com")
@EnableAspectJAutoProxy
public class AnnoSupportAopConfig {
}
