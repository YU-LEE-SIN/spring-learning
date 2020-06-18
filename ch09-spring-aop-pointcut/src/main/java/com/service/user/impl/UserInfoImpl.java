package com.service.user.impl;

import com.service.user.UserInfoService;

/**
 * @author yu
 * @date 2020/6/17
 */
public class UserInfoImpl implements UserInfoService {
    @Override
    public void getAll() {
        System.out.println("get All-----");
    }

    @Override
    public void getById() {
        System.out.println("get getById-----");

    }

    @Override
    public void updateById() {
        System.out.println("get updateById-----");
    }

    @Override
    public int add(int x, int y){
        return x+y;
    }
}
