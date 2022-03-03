package Method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class doMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //正常调用text01的方法
        text01 t = new text01();
        t.singHello("张三");

        //通过反射的Method来调用方法
        text01 t2 = new text01();
        Method method = t2.getClass().getMethod("singHello", String.class);
        method.invoke(t2,"李四");
        //System.out.println(t2.getClass());

        text01 t3 = new text01();
        Method m = t3.getClass().getMethod("singHello", String.class);
        m.invoke(t3,"王五");

    }
}
