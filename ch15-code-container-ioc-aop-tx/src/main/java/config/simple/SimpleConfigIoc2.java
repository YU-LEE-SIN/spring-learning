package config.simple;

import com.dao.UserInfoDao;
import com.dao.impl.UserInfoDaoImpl;
import com.service.UserInfoService;
import com.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yu
 * @date 2020/6/18
 */
@Configuration
public class SimpleConfigIoc2 {
    @Autowired
    private UserInfoDao dao;

    @Bean
    public UserInfoDaoImpl userInfoDao() {
        return new UserInfoDaoImpl();
    }
    /**
     * 利用autowire来实现注入
     * 理论是Configuration修饰的类除了是个配置类,它本身也是一个被
     * spring管理的类,所以可以注入东西
     */
    @Bean
    public UserInfoService userInfoService() {
        UserInfoServiceImpl userInfoService=new UserInfoServiceImpl();
        userInfoService.setDao(dao);
        return userInfoService;
    }
}
