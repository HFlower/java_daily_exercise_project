package com.dhn.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2019/10/17 15:06
 */
public class Java8Test1 {

    public static void main(String[] args) {

        //方法引用：（1）静态方法（2）实例方法（3）使用new运算符构造函数(TreeSet::new)
        //静态方法引用
        List names = new ArrayList();
        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);


    }
}
