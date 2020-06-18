package config.annosupport;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ComponentScan类似于xml中的context:componentScan
 * 要求被管理的bean有相关的的注解
 * @author yu
 * @date 2020/6/18
 */
@Configuration
@ComponentScan("com")
public class AnnoSupportConfig {
}
