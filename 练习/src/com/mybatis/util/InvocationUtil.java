package com.mybatis.util;

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
        SqlSession session  = null;
        Object result = null;

        //try catch一下，当没有获取连接的时候方便将数据库的内容回滚

        try{
            session = SqlSessionUtil.getSession();
            result =  method.invoke(target,args);

            session.commit();
        }catch (Exception e){

            session.rollback();
            e.printStackTrace();
        }

        return result;
    }

    //获取动态对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                        target.getClass().getInterfaces(),
                                        this);
    }

}
