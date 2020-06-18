package com.dao.impl;

import com.dao.UserOneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserOneDaoImpl implements UserOneDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void deleteById() {
        String sql=" delete from userone where id=3";
        jdbcTemplate.update(sql);
    }
}
