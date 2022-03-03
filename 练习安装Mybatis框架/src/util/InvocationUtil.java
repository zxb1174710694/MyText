package util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationUtil implements InvocationHandler {
    private  Object target = null;

    public InvocationUtil(Object obj) {
        this.target = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;

        try {
            session = sqlSessionUtil.getConnection();
            //动态代理对象处理业务逻辑，返回的结果集
            obj = method.invoke(target,args);
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }
        return obj;
    }

    //获取动态代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                        target.getClass().getInterfaces(),
                                        this);
    }
}
