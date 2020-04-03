package com.dhn.javabasic.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @description: 测试Externalizable
 * @author: Dong HuaNan
 * @date: 2020/4/2 15:27
 */
public class ExternalSerializable {
    public static void main(String[] args) {
        try (
                //序列化：创建一个ObjectOutputStream
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\serializable\\ExternalSerializable.txt"));
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\serializable\\ExternalSerializable.txt"))

        ) {
            Person2 p1 = new Person2("sssssssssss", 22);
            objectOutputStream.writeObject(p1);
            //此处会调用无参构造器
            Person2 pp = (Person2) objectInputStream.readObject();
            System.out.println(pp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
