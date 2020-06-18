package config.multi;

import com.dao.UserInfoDao;
import com.dao.impl.UserInfoDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yu
 * @date 2020/6/18
 */
@Configuration
public class DaoConfig {
    @Bean
    public UserInfoDao dao(){
        return new UserInfoDaoImpl();
    }
}
