package com.dao.impl;

import com.dao.UserInfoDao;
import org.springframework.stereotype.Repository;

/**
 * @author yu
 * @date 2020/6/18
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    public UserInfoDaoImpl() {
        System.out.println("dao的构造函数-----");
    }

    @Override
    public void update() {
        System.out.println("update in UserInfoDaoImpl");
    }
}
