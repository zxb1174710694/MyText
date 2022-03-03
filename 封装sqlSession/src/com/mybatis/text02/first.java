package com.mybatis.text02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class first {
    public static void main(String[] args) throws IOException {

        //因为是创建在src目录之下的，所以直接就是文件名就行了
        String resource = "mybatis-config.xml";
        //io流读取文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //将读取的文件转换成对象，为了下一步创建sqlSession对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过连接数据库获取一个sqlSession对象，它封装了PreparedStatement、ResultSet、Connection
        //三个组件，所以我们以后都是控制这个对象来控制对应组件
        //获取java程序和数据库之间的会话SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        Student s = session.selectOne("text01.first", "A001");
        System.out.println(s);

    }
}
