package com.dhn.javabasic.io.serializable;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/2 9:38
 */
@Getter
@Setter
public class Person implements Serializable{
    private String name;
    //transient禁止系列化
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

    /**
     * 自定义序列化
     * @param out
     * @throws IOException
     */
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        //将name实例反转后写进二进制流
//        out.writeObject(new StringBuffer(name).reverse());
//        out.writeInt(age);
//    }
//
//    /**
//     * 自定义反序列化
//     * @param in
//     * @throws IOException
//     * @throws ClassNotFoundException
//     */
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        //将读取的字符串反转后赋给name实例变量
//        this.name = ((StringBuffer) in.readObject()).reverse().toString();
//        this.age = in.readInt();
//    }

}
