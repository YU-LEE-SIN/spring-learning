package config.multi;


import com.dao.UserInfoDao;
import com.service.UserInfoService;
import com.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author yu
 * @date 2020/6/18
 */
@Configuration
@Import(DaoConfig.class)//可以类比与xml中的import
@ImportResource//这个注解是用来导入其它的xml文件
public class ServiceConfig {
    @Autowired
    private UserInfoDao dao;

    @Bean
    public UserInfoService employeeService() {
        UserInfoServiceImpl service = new UserInfoServiceImpl();
        service.setDao(dao);
        return service;
    }
}
