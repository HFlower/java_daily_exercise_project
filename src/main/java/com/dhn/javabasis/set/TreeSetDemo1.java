package com.dhn.javabasis.set;

import java.util.TreeSet;

/**
 * @description: TreeSet定制排序
 * @author: Dong HuaNan
 * @date: 2020/3/27 10:29
 */
public class TreeSetDemo1 {
    public static void main(String[] args) {
        //定制排序（降序）
        TreeSet ts = new TreeSet((o1, o2) ->
        {
            M m1 = (M) o1;
            M m2 = (M) o2;
            //age越大，M对象越小
            return m1.age > m2.age ? -1 : m1.age < m2.age ? 1 : 0;
        });
        ts.add(new M(9));
        ts.add(new M(19));
        ts.add(new M(24));
        ts.forEach(System.out::println);

    }

}

class M{
    int age;
    public M(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "M{" +
                "age=" + age +
                '}';
    }
}
