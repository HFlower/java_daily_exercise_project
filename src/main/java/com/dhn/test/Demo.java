package com.dhn.test;

import java.util.*;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/13 17:41
 */
public class Demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
//        list.forEach(str -> System.out.println("输出集合元素："+str));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String item = (String) iterator.next();
            System.out.println(item);
            if ("a".equals(item)){
//                iterator.remove();
                list.remove(item);
            }
//            item = "k";
        }
        System.out.println(list);
    }
}
