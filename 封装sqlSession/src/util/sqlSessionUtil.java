package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class sqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory = null;
    //封装关闭和连接
    static {
        String resource = "mybatis-config.xml";
        //io流读取文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //建立本地存放线程的地方
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();


    //获取连接
    public static SqlSession getSession(){
        SqlSession sqlSession = t.get();
        if (sqlSession == null){

            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    //关闭资源
    public static void myClose(SqlSession session){
        if (session != null){
            session.close();
            //这个非常关键，因为tomcat支持多线程，所以我们关闭资源的时候，需要将
            //这个线程放回去，这个线程并不会消失，而是会回到线程池当中，等待下一次启动
            t.remove();
        }
    }
}
