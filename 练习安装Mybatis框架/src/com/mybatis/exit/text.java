package com.mybatis.exit;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class text {
    public static void main(String[] args) {
        sqlSessionUtil sqlsession = new sqlSessionUtil();

        SqlSession session = sqlsession.getConnection();

        List<Student> list = session.selectList("Exit.exit");

        for (Student s:list){
            System.out.println(s);
        }

        sqlsession.myClose(session);

    }
}
