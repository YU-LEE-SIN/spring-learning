package com.dao.impl;

import com.dao.UserTwoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoTwoDaoImpl implements UserTwoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert() {
        String sql="insert into usertwo(name) values('w',error)";
        jdbcTemplate.update(sql);
    }
}
