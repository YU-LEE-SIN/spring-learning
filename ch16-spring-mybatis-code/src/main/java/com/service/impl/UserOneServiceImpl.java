package com.service.impl;

import com.dao.UserOneDao;
import com.pojo.UserOne;
import com.service.UserOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yu
 * @date 2020/6/18
 */
@Service
public class UserOneServiceImpl implements UserOneService {
    @Autowired
    private UserOneDao dao;
    @Override
    public List<UserOne> getPageAll(int pageNum, int pageSize) {
        return dao.getPageAll(pageNum, pageSize);
    }
}
