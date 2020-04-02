package com.dhn.javabasic.io.serializable;

import java.io.Serializable;

/**
 * @description: 引用类必须是可序列化的
 * @author: Dong HuaNan
 * @date: 2020/4/2 10:45
 */
public class Teacher implements Serializable {
    private String name;
    private Person student;

    public Teacher(String name, Person student) {
        System.out.println("Teacher有参数的构造器");
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }
}
