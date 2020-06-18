package com.service.impl;

import com.service.EmpService;

/**
 * @author yu
 * @date 2020/6/18
 */
public class EmpServiceImpl implements EmpService {
    @Override
    public int add(Integer x, Integer y) {
        // throw new RuntimeException("failed----");
        return x + y;
    }
}
