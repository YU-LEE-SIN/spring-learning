package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author yu
 * @date 2020/6/18
 */
public class BaseDao {
    protected JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
