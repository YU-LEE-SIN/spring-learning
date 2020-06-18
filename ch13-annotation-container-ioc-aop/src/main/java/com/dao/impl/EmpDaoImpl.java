package com.dao.impl;

import com.dao.EmpDao;
import org.springframework.stereotype.Repository;

/**
 * @author yu
 * @date 2020/6/18
 */
@Repository
public class EmpDaoImpl implements EmpDao {
    @Override
    public void update() {
        System.out.println("update in EmpDaoImpl---");
    }
}
