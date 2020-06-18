package com.dao;
/**
 * @author yu
 * @date 2020/6/18
 */
public class UserInfoDao extends BaseDao {
    public void deleteUserById(int id) {
        String sql="delete from userinfo where dept_id=?";
        jdbcTemplate.update(sql, id);
        System.out.println("deleteUserById===succeed");
    }
}
