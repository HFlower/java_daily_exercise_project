package com.dhn.javabasic.file.serializable;

import java.io.Serializable;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/2 9:38
 */
public class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        System.out.println("Person有参数的构造器");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
