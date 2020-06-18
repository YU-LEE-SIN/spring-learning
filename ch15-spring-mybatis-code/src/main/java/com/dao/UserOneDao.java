package com.dao;

import com.pojo.UserOne;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yu
 * @date 2020/6/18
 */
public interface UserOneDao {
    List<UserOne> getPageAll(@Param("pageNum") int pageNo, @Param("pageSize") int pageSize);
}
