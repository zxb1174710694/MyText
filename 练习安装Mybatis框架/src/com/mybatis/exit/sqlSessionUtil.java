package com.mybatis.exit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class sqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory = null;


    static {
        String source = "mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(source);

        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //保持线程一致
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();


    //获取连接
    public static SqlSession getConnection(){
        SqlSession sqlSession = t.get();
        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }
    //关闭资源
    public static void myClose(SqlSession session){
        if (session !=null){
            session.close();
            t.remove();
        }
    }

}
