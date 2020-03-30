package com.dhn.javabasis.Generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @description: 泛型方法
 * @author: Dong HuaNan
 * @date: 2020/3/30 17:05
 */
public class GenericTest {
    /**
     * 泛型方法语法格式：修饰符 <T,S> 返回值类型 方法名（形参列表）{}
     * @param a
     * @param c
     * @param <T>
     */
    static <T> void fromArrayToCollection(T[] a, Collection<T> c){
        for (T t : a){
            c.add(t);
        }
    }

    public static void main(String[] args) {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<>();
        fromArrayToCollection(oa,co);
        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<>();
        fromArrayToCollection(sa,cs);
        Collection<Number> cn = new ArrayList<>();
        //T代表Object类型，String是它的子类
        fromArrayToCollection(sa,co);
        //T代表Number类型，String不是它的子类
//        fromArrayToCollection(sa,cn);
    }
}
