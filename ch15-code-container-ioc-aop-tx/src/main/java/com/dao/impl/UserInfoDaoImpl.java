package com.dao.impl;

import com.dao.UserInfoDao;

/**
 * @author yu
 * @date 2020/6/18
 */
public class UserInfoDaoImpl implements UserInfoDao {
    public UserInfoDaoImpl() {
        System.out.println("dao的构造函数-----");
    }
    @Override
    public void update() {
        System.out.println("update in UserInfoDaoImpl");
    }
}
