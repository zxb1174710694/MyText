package com.mybatis.dao.studentImpl;

import com.mybatis.dao.StudentDao;
import com.mybatis.service.Student;
import com.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student select(String id) {

        SqlSession session = SqlSessionUtil.getSession();
        Student s = session.selectOne("text.select",id);
        return s;
    }

    @Override
    public void add(Student s) {
        SqlSession session = SqlSessionUtil.getSession();
        session.insert("text.add",s);
    }
}
