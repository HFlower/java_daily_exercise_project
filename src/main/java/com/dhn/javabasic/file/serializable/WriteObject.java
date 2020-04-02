package com.dhn.javabasic.file.serializable;

import org.opensaml.xml.signature.P;

import java.io.*;

/**
 * @description: 将一个person对象进行序列化和反序列化
 * 反序列化读取的仅仅是java对象的数据，而不是java类，所以采用反序列化恢复java对象时，必须提供该java对象所属类的.class文件。反序列化机制无需通过构造器来初始化对象
 * @author: Dong HuaNan
 * @date: 2020/4/2 9:53
 */
public class WriteObject {
    public static void main(String[] args) {
        serializablePerson();
        System.out.println("_______________________________________");
        deserializablePerson();
    }

    /**
     * 序列化
     */
    private static void serializablePerson() {
        try (
                //序列化：创建一个ObjectOutputStream
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\serializable\\object.txt"))

        ) {
//            Person person1 = new Person("flower1", 22);
//            Person person2 = new Person("flower2", 23);
//            Person person3 = new Person("flower3", 24);
//            //将Person对象写入输入流
//            objectOutputStream.writeObject(person1);
//            objectOutputStream.writeObject(person2);
//            objectOutputStream.writeObject(person3);

//            Student student = new Student("花花",24,"睡觉");
//            objectOutputStream.writeObject(student);

//            Teacher teacher = new Teacher("花老师",person1);
//            objectOutputStream.writeObject(teacher);

            Person p1 = new Person("孙悟空",500);
            Teacher t1 = new Teacher("唐僧",p1);
            Teacher t2 = new Teacher("菩提祖师",p1);
            objectOutputStream.writeObject(t1);
            objectOutputStream.writeObject(t2);
            objectOutputStream.writeObject(p1);
            objectOutputStream.writeObject(t2);
            System.out.println("对象序列化成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    private static void deserializablePerson(){
        try(
                //反序列化：创建一个ObjectInputStream
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\serializable\\object.txt"))
        )
        {
            //从输入流中读取一个对象，强制转换为Person类
            //读取多个对象，只能一个一个读取
//            Person person1 = (Person) objectInputStream.readObject();
//            Person person2 = (Person) objectInputStream.readObject();
//            Person person3 = (Person) objectInputStream.readObject();
//            System.out.println("名字：" + person1.getName()+",年龄："+person1.getAge()+"||"+"名字：" + person2.getName()+",年龄："+person2.getAge()+"||"+"名字：" + person3.getName()+",年龄："+person3.getAge());


//            Student student = (Student) objectInputStream.readObject();
//            System.out.println(student.getName() +"||"+student.getAge()+"||"+student.getHobby());

//            Teacher teacher = (Teacher) objectInputStream.readObject();
//            System.out.println(teacher.getName()+"****"+teacher.getStudent());

            Teacher t1 = (Teacher) objectInputStream.readObject();
            Teacher t2 = (Teacher) objectInputStream.readObject();
            Person p = (Person) objectInputStream.readObject();
            Teacher t3 = (Teacher) objectInputStream.readObject();
            System.out.println(t1.getName()+"***"+t1.getStudent()+"|||||"+t2.getName()+t2.getStudent());
            System.out.println("t1.student和p是否相同："+(t1.getStudent() == p));
            System.out.println("t2.student和p是否相同："+(t2.getStudent() == p));
            System.out.println("t2/t3是否是同一个对象："+(t2 == t3));

            System.out.println("对象反序列化成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
