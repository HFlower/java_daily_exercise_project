package com.dhn.javabasic.io.serializable;

import java.io.Serializable;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/2 10:29
 */
public class Student extends Person implements Serializable {
    private String hobby;

    public Student(String name, int age, String hobby) {
        super(name, age);
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
