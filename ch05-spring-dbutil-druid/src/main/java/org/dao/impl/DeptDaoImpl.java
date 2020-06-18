package org.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.dao.DeptDao;
import org.pojo.Dept;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yu
 * @date 2020/5/18
 */
public class DeptDaoImpl implements DeptDao {
    private QueryRunner queryRunner;

    /**set 注入时使用*/
    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Dept> getDept() {
        String sql = "select id, deptname from dept";
        BeanListHandler<Dept> handler = new BeanListHandler<>(Dept.class);
        List<Dept> deptList = null;
        try {
            deptList = queryRunner.query(sql, handler);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("query failed...");
        }
        return deptList;
    }
}
