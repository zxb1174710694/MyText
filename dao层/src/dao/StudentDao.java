package dao;

import doMain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface StudentDao {
    Student select(String id);
    void add(Student student);

    ArrayList<Student> getAll();
    ArrayList<Student> getMap(Map<String, Object> map);
    ArrayList<Student> selectLike(String name);

    ArrayList<Map<String,Object>> selectList_map();

    ArrayList<Map<String, Object>> getZhang(String name);

    ArrayList<Student> getLess(Student name);

    ArrayList<Map<String, Object>> selectmap();
}
