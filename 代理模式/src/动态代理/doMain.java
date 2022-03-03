package 动态代理;

import java.lang.reflect.Proxy;

public class doMain {
    public static void main(String[] args){
        //创建代理类对象

        //创建代理对象的方法里面有三个参数
        /*
        * 第一个：一个反射机制对象
        * 第二个：实现的接口
        * 第三个：实现了jdk代理的类*/

        //第一个参数
        UsbSell project = new UsbKingProject();



        //注意：这里要转换成接口类型，因为你project实现了接口，所以可以转接口类型，这样可以调方法

        UsbSell target = (UsbSell) Proxy.newProxyInstance(project.getClass().getClassLoader()
                                            ,project.getClass().getInterfaces(),
                                            new handle(project));


        //调用方法
        double price = target.sell(1);
        System.out.println("向商家购买时的价格:"+price);

    }
}
