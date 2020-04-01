package com.dhn.javabasic.Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/30 16:19
 */
public class MyUtils {
    public static <T> T copy(Collection<? super T> dest, Collection<T> src){
        T last = null;
        for (T s : src){
            last = s;
            //逆变的泛型集合添加元素是安全的
            dest.add(s);
        }
        return last;
    }

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        List<Number> ln = new ArrayList<>();
        li.add(5);
        Integer last = copy(ln,li);
        System.out.println(last);
    }
}
