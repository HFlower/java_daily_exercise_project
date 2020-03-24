package com.dhn.test;

import com.sun.org.apache.xpath.internal.operations.String;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @description: TreeSet：底层红黑树，可排序，不可重复，只能添加同一种类型的对象。
 * 判断两个对象是否相等的唯一标准：两个对象通过compareTo(Object o)方法比较是否返回0。
 * @author: Dong HuaNan
 * @date: 2020/3/24 16:17
 */
public class TreeSetDemo{
    public static void main(String[] args) {
        TreeSet<Object> treeSet = new TreeSet<>();
        Z z1 = new Z(24);
        treeSet.add(z1);
        System.out.println(treeSet.add(z1));
        System.out.println(treeSet);
    }
}

class Z implements Comparable {
    int age;

    public Z(int age) {
        this.age = age;
    }

    /**
     * 总是返回true
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
