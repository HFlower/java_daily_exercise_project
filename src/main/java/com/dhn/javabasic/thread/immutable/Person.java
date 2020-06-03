package com.dhn.javabasic.thread.immutable;

/**
 * @description: 不可变对象，其他类无法修改这个对象，public也不行
 * (具有不变性的对象，一定是线程安全的)
 * @author: Dong HuaNan
 * @date: 2020/5/27 15:29
 */
public class Person {
    final int age = 18;
    final String name = "花花";
}
