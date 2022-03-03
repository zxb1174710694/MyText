package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//动态代理类
public class handle implements InvocationHandler {
    private Object target = null;

    //用构造方法将对象传过来
    public handle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        //里面是商家要写的内容，静态代理当中这里是new厂家对象，然后调用厂家的方法
        /*
        * proxy调用的时候填一个反射机制的包名
        * method调用填一个调用的对象，
        * args表示调用方法的参数
        * */


        result = method.invoke(target, args);   //这里的result接收的是方法的返回值结果
        System.out.println("商家进货价："+result);

        if (result != null){
            Double price = (double)result;
            price += 25;
            result = price;
        }
        System.out.println("获取一个优惠卷红包：25元");
        return result;
    }
}
