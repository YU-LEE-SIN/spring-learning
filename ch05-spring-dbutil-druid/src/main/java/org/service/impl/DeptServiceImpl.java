package org.service.impl;

import org.dao.DeptDao;
import org.pojo.Dept;
import org.service.DeptService;

import java.util.List;

/**
 * @author yu
 * @date 2020/5/18
 */
public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao;

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public List<Dept> getDept() {
        return deptDao.getDept();
    }

}
