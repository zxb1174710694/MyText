package service.impl;


import dao.StudentDao;
import doMain.Student;
import service.StudentServiceFace;
import util.SqlSessionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentServiceImpl implements StudentServiceFace {

    private StudentDao studentDao = SqlSessionUtil.getConnection().getMapper(StudentDao.class);
    @Override
    public Student select(String id) {

        //业务层调用dao层的方法将数据传过去
        //StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.select(id);

        return student;
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public ArrayList<Student> getAll() {
        ArrayList list = studentDao.getAll();
        return list;
    }

    @Override
    public ArrayList<Student> getMap(Map<String, Object> map) {
        ArrayList<Student> map1 = studentDao.getMap(map);
        return map1;
    }

    @Override
    public ArrayList selectLike(String name) {
        ArrayList<Student> arrayList = studentDao.selectLike(name);
        return arrayList;
    }

    @Override
    public ArrayList<Map<String, Object>> selectList_map() {
        ArrayList<Map<String, Object>> maps = studentDao.selectList_map();
        return maps;
    }

    @Override
    public ArrayList<Map<String, Object>> getZhang(String name) {
        ArrayList<Map<String, Object>> list = studentDao.getZhang(name);
        return list;
    }

    @Override
    public ArrayList<Student> getLess(Student name) {
        ArrayList<Student> less = studentDao.getLess(name);
        return less;
    }

    @Override
    public ArrayList<Map<String, Object>> selectmap() {
        ArrayList<Map<String, Object>> selectmap = studentDao.selectmap();
        return selectmap;
    }


}
