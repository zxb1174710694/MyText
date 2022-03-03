package com.mybatis.service.impl;

import com.mybatis.dao.StudentDao;
import com.mybatis.dao.studentImpl.StudentDaoImpl;
import com.mybatis.service.Student;
import com.mybatis.service.StudentServiceFace;

public class StudentServiceImpl implements StudentServiceFace {

    StudentDao dao = new StudentDaoImpl();
    //这里是事务层，所以要调用dao层来进行数据库操作
    @Override
    public Student select(String id) {


        Student student = dao.select(id);

        return student;
    }

    @Override
    public void add(Student s) {
        dao.add(s);
    }
}
