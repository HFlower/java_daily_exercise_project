package com.dhn.javabasic.Generic;

/**
 * @description: 匿名内部类中的泛型
 * @author: Dong HuaNan
 * @date: 2020/3/30 14:57
 */
public class AnnoymousTest {
    public static void main(String[] args) {
        Foo<String> f = new Foo<String>() {
            @Override
            public void test(String s) {
                System.out.println("test方法的s参数为："+s);
            }
        };
        //使用泛型通配符，相当于通配符的上限为Object
        Foo<?> fo = new Foo<Object>() {
            @Override
            public void test(Object o) {
                System.out.println("test方法的o参数为："+o);
            }
        };
        //使用泛型通配符，通配符的上限为Number
        Foo<? extends Number> fn = new Foo<Number>() {
            @Override
            public void test(Number number) {
                System.out.println("test方法的number参数为："+number);
            }
        };
    }
}
interface Foo<T>{
    void test(T t);
}