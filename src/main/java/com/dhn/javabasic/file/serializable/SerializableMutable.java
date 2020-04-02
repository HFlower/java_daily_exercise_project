package com.dhn.javabasic.file.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @description: 序列化可变对象
 * @author: Dong HuaNan
 * @date: 2020/4/2 11:13
 */
public class SerializableMutable {
    public static void main(String[] args) {
        try (
                //序列化：创建一个ObjectOutputStream
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\serializable\\mutable.txt"));
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\serializable\\mutable.txt"))

        ){
            Person p = new Person("孙悟空",500);
            objectOutputStream.writeObject(p);
            p.setName("猪八戒");
            //只输出序列化编号，改变后的name值不会被序列化
            objectOutputStream.writeObject(p);

            Person p1 = (Person) objectInputStream.readObject();
            Person p2 = (Person) objectInputStream.readObject();
            System.out.println(p1==p2);
            //仍为孙悟空
            System.out.println(p2.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
