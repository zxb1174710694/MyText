package doMain;



import dao.StudentDao;
import service.StudentServiceFace;
import service.impl.StudentServiceImpl;
import util.InvocationUtil;
import util.SqlSessionFactory;
import util.SqlSessionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class text {
    public static void main(String[] args) {
        /*SqlSession session = SqlSessionUtil.getConnection();

        Student student = session.selectOne("text.select", "A001");
        System.out.println(student);

        SqlSessionUtil.sqlClose(session);*/

        //创建厂家
        StudentServiceFace s = new StudentServiceImpl();

        //动态代理(正常写法)
       // Proxy.newProxyInstance(s.getClass().getClassLoader(),s.getClass().getInterfaces())

        //调用封装好了的写法
        InvocationUtil util = new InvocationUtil(s);
        StudentServiceFace proxy = (StudentServiceFace) util.getProxy();    //动态代理对象
        Student s1 = proxy.select("A001");
        System.out.println(s1);


        //调用封装了工厂模式写法
        StudentServiceFace target = (StudentServiceFace) SqlSessionFactory.getSession(s);
        Student s2 = target.select("A002");

        System.out.println(s2);

        ///////////////////////////////
        //调用业务层的方式

        //这样的s3只是单纯的一个厂家，并不是代理，所以不能commit
        StudentServiceFace s3 = new StudentServiceImpl();

        //通过我们封装的类进行获取到一个动态代理的对象
        StudentServiceFace target2 = (StudentServiceFace) SqlSessionFactory.getSession(s3);

        Student student = new Student();
        student.setId("B015");
        student.setName("姚子元");
        student.setAge("15");

        //注意：这里添加的时候必须是代理对象来添加，不能是厂家
        //target2.add(student);

        Map<String,Object> map = new HashMap<>();
        map.put("id","A001");
        map.put("name","张三");

        ArrayList<Student> arrayList = target2.getMap(map);
        for (Student slist:arrayList){
            System.out.println("map查询的："+slist);
        }


        //查询所有表
        ArrayList<Student> list = target2.getAll();
        for (Student stu:list){
            System.out.println(stu);
        }

        //模糊查询
        ArrayList<Student> arr = target2.selectLike("姚");
        for (Student a:arr){
            System.out.println("模糊查询："+a);
        }

        //将数据用map集合保存
        ArrayList<Map<String,Object>> sList = target2.selectList_map();

        for (Map<String,Object> m:sList){

            Set<String> set = map.keySet();
            for (String ss:set){
                String key = ss;
                Object value = m.get(key);

                System.out.println("key："+key);
                System.out.println("value："+value);
            }
            System.out.println("_____________");
        }

        //用map集合保存不能用类对象保存的数据：查询姓张的有几个人？
        ArrayList<Map<String,Object>>list1 = target2.getZhang("李");

        for (Map<String,Object> m:list1){
            Set<String> set = m.keySet();
            for (String ss :set){
                System.out.println("key:"+ss);
                System.out.println("value:"+m.get(ss));
            }
            System.out.println("-------------------");
        }



       /* //动态sql
        //查询姓李并且年龄17的人
        Student user = new Student();
        user.setName("李");
        user.setAge("17");
        ArrayList<Student> aaList = target2.getLess(user);

        for (Student u:aaList){
            System.out.println(u);
        }*/


        //多表联查
        //查询学生所在班级的名称
        ArrayList<Map<String,Object>> Arr = target2.selectmap();
        for (Map<String,Object> mm:Arr){
            Set<String> set = mm.keySet();
            for (String mess : set){
                System.out.println("多表联查");
                System.out.println("key:"+mess);
                System.out.println("value:"+mm.get(mess));
            }
            System.out.println("__________________");
        }
    }

}
