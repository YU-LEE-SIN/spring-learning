package org.dao;

import org.apache.ibatis.annotations.Param;
import org.pojo.Dept;

import java.util.List;

/**
 * @author yu
 * @date 2020/5/18
 */
public interface DeptDao {

    List<Dept> getAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
