package com.service.impl;

import com.dao.UserInfoDao;
import com.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yu
 * @date 2020/6/18
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao dao;

    public void setDao(UserInfoDao dao) {
        this.dao = dao;
    }

    @Override
    public void update() {
        dao.update();
    }

}