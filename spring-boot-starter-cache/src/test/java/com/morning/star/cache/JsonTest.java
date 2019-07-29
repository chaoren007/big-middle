package com.morning.star.cache;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Student {
    private long id;
    private Date birthday;
    private String name;
    private List<Teacher> teacherList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}



class Teacher {

    private long id;
    private Date birthday;
    private String name;
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}


public class JsonTest {


    @Test
    public void test() {
        Student user = new Student();
        user.setBirthday(new Date());
        user.setId(666);
        user.setName("bin");

        JsonSerializer jsonSerializer = new JsonSerializer();
//        System.out.println(jsonSerializer.serializeToString(user));


        Teacher teacher = new Teacher();
        teacher.setBirthday(new Date());
        teacher.setName("bin2");
        teacher.setId(77);
//        teacher.setStudent(user);
//        System.out.println(jsonSerializer.serializeToString(teacher));


        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        user.setTeacherList(teachers);

        String json = jsonSerializer.serializeToString(user);
        System.out.println(json);

        System.out.println(jsonSerializer.deserialize(json.getBytes(), Student.class));

    }
}
