package org.service.impl;

import org.service.DeptService;

/**
 * @author yu
 * @date 2020/5/22
 */
public class DeptServiceImpl implements DeptService {

    @Override
    public void delete() {
        System.out.println("开始插入(delete)-----");
    }
    /**
     * 因为此类没有实现接口,所以spring利用cglib创建子类的方式来创建出aop代理类
     * 加了final就无法进行代理操作,也就无法织入了.
     */
    public final void insert(){
        System.out.println("开始插入(insert)-----");
    }
}
