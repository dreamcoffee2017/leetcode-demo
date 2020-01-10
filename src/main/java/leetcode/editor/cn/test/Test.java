package leetcode.editor.cn.test;

import java.io.*;

/**
 * Test
 *
 * @author Administrator
 * @date 2019/12/25
 */
public class Test<T> {
    public static <T> void main(String[] args) throws Exception {
        Teacher teacher = new Teacher();
        teacher.setAge(23);
        teacher.setName("niesong");
    }
}
interface A<T>{
    
}

class Teacher implements Serializable {
//	private static final long serialVersionUID = 8940196742313994740L;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student implements Serializable {
    private int age;
    private String name;
    private Teacher teacher;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
