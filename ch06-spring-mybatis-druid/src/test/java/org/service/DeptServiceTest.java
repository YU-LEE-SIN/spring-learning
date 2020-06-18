package org.service;

import org.pojo.Dept;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * @author yu
 * @date 2020/5/21
 */
public class DeptServiceTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService service = context.getBean("deptService", DeptService.class);
        List<Dept> deptList = service.getAll(2,4);
    }
}