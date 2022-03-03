package com.mybatis.service;

public interface StudentServiceFace {
    //根据id查数据
    public abstract Student select(String id);

    //根据数据添加数据
    public abstract void add(Student s);
}
