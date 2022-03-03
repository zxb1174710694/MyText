package util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationUtil implements InvocationHandler {
    private Object target = null;

    public InvocationUtil(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取数据库连接对象
        SqlSession session = null;

        //获取原对象方法的结果
        Object result = null;

        //防止数据错误
        try {
            session = SqlSessionUtil.getConnection();
            result = method.invoke(target, args);

            session.commit();
        }catch (Exception e){
            //出错时恢复数据
            session.rollback();

            e.printStackTrace();
        }
        //关闭资源
        //SqlSessionUtil.sqlClose(session);
        return result;
    }

    //获取动态代理对象
    public  Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                    target.getClass().getInterfaces(),
                                    this);
    }
}
