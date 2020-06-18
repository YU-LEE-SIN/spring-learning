package com.service;

/**
 * @author yu
 * @date 2020/6/9
 */
public class EmpServiceImpl {

    public void insert(){
        System.out.println("开始插入(insert)-----");
        throw new RuntimeException("asdfasd");
    }


    public void update() {
        System.out.println("开始更新(update)-----");
    }


    public int add(int x, int y) {
        System.out.println("add---------");
        return x + y;
    }
}
