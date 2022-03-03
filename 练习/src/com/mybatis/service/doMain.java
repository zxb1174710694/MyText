package com.mybatis.service;

import com.mybatis.dao.StudentDao;
import com.mybatis.dao.studentImpl.StudentDaoImpl;
import com.mybatis.service.impl.StudentServiceImpl;
import com.mybatis.util.SessionFactory;
import com.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class doMain {
    public static void main(String[] args) {
        //mybatis连接数据库
/*
        SqlSession session = SqlSessionUtil.getSession();
        Student s = session.selectOne("text.select","A001");
        System.out.println(s);*/

        //SqlSession session = SqlSessionUtil.getSession();

        //这样只是单纯的StudentDaoImpl对象，不会走动态代理的步骤，也就是不能提交事务
        //StudentDao ss = new StudentDaoImpl();
        StudentServiceFace ss = (StudentServiceFace) SessionFactory.getSession(new StudentServiceImpl());

        Student s = new Student();
        s.setId("A009");
        s.setAge("17");
        s.setName("李华");

       ss.add(s);





    }
}
