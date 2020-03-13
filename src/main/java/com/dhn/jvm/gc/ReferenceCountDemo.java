package com.dhn.jvm.gc;

/**
 * @description: 引用计数法
 * @author: Dong HuaNan
 * @date: 2020/3/13 10:13
 */
public class ReferenceCountDemo {

    private ReferenceCountDemo instance = null;
    private int _1m = 1024 * 1024;
    private  byte[] bytes = new byte[_1m * 2];
    public static void testGC(){
        ReferenceCountDemo objA = new ReferenceCountDemo();
        ReferenceCountDemo objB = new ReferenceCountDemo();
        objA = objB;
        objB = objA;
    }

    public static void main(String[] args) {
        ReferenceCountDemo.testGC();
    }

}
