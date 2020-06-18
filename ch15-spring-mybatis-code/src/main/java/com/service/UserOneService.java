package com.service;

import com.pojo.UserOne;

import java.util.List;

/**
 * @author yu
 * @date 2020/6/18
 */
public interface UserOneService {
    List<UserOne> getPageAll(int pageNum, int pageSize);
}
