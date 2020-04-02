package com.dhn.javabasic.io.serializable;

import lombok.Getter;
import lombok.Setter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @description: 另一种序列化方式：实现Externalizable接口
 * @author: Dong HuaNan
 * @date: 2020/4/2 15:06
 */
@Getter
@Setter
public class Person2 implements Externalizable {
    private String name;
    private int age;

    //注意：必须提供无参构造器
    public Person2(){
        System.out.println("Person2无参数的构造器");
    }
    public Person2(String name, int age) {
        System.out.println("Person2有参数的构造器");
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //将name实例反转后写进二进制流
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }

    /**
     * 反序列化时，先调用无参构造器创建实例，再调用readExternal进行反序列化
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //将读取的字符串反转后赋给name实例变量
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.age = in.readInt();
    }
}
