package com.mybatis.util;

import java.lang.reflect.InvocationHandler;

public class SessionFactory {

    public static Object getSession(Object session){

        //这个用来获取代理的对象
        return new InvocationUtil(session).getProxy();
    }
}
