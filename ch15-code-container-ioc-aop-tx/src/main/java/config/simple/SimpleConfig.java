package config.simple;

import com.dao.impl.UserInfoDaoImpl;
import com.service.UserInfoService;
import com.service.impl.UserInfoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yu
 * @date 2020/6/18
 */
@Configuration
public class SimpleConfig {
    @Bean
    public UserInfoDaoImpl userInfoDao(){
        return new UserInfoDaoImpl();
    }
    @Bean
    public UserInfoService userInfoService(){
        return new UserInfoServiceImpl();
    }
}
