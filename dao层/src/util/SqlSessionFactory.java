package util;

public class SqlSessionFactory {
    //传进来一个厂家，返回一个动态代理对象
    public static Object getSession(Object sqlSession){
        InvocationUtil util = new InvocationUtil(sqlSession);
        Object proxy = util.getProxy();

        return proxy;
    }
}
