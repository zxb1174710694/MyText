package com.mybatis.exit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class exit {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        //io流读取文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);

            //将读取的文件转换成对象，为了下一步创建sqlSession对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取sqlSession对象
            SqlSession Session = sqlSessionFactory.openSession();

            List<Student> list = Session.selectList("Exit.exit");

            //遍历集合
            for (Student s:list){
                System.out.println(s);
            }

            //添加(默认情况下是没有开启自动提交的，所以要手动提交)
            Student s = new Student();
            s.setId("A006");
            s.setName("赵六");
            s.setAge("18");
            Session.insert("Exit.add",s);
            //提交
            Session.commit();

            //关闭资源
            Session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
