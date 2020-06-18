package com.dao;

/**
 * @author yu
 * @date 2020/6/18
 */
public class DeptDao  extends BaseDao{
    public void deleteDeptById(int id){
        String sql="delete from dept where pk_id=?";
        jdbcTemplate.update(sql,id);
        System.out.println("deleteDeptById===succeed");
    }
}
