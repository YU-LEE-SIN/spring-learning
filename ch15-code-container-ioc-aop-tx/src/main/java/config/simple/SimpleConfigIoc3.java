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
public class SimpleConfigIoc3 {
    @Bean
    public UserInfoDaoImpl userInfoDao() {
        return new UserInfoDaoImpl();
    }

    /**
     * 利用bean方法的参数来实现注入
     * @return
     */
    public UserInfoService userInfoService(){
        UserInfoServiceImpl userInfoService=new UserInfoServiceImpl();
        userInfoService.setDao(userInfoDao());
        return userInfoService;
    }
}
