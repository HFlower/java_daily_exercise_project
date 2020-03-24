package com.dhn.test;

import java.util.*;
import java.util.function.Predicate;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/13 17:41
 */
public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //1.java8输出集合
//        list.forEach(str -> System.out.println("输出集合元素："+str));
        //2.迭代循环
        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            String item = (String) iterator.next();
//            System.out.println(item);
//            if ("a".equals(item)){
////                iterator.remove();
        //不能在迭代时修改集合，会抛出ConcurrentModificationException异常
//                list.remove(item);
//            }
        //不会改变原集合中的元素
////            item = "k";
//        }
//        System.out.println(list);
        //3.用iterator的forEachRemaining（）方法输出元素
//        iterator.forEachRemaining(itr -> System.out.println("输出元素："+ itr));

        Set<String> books = new HashSet<>();
        books.add("aa");
        books.add("深入理解java虚拟机");
        books.add("java编程思想");
        books.add("springboot实战");
        //Predicate谓词函数式编程
        //1.删除长度小于3的元素
        books.removeIf(ele -> ele.length() < 3);
        System.out.println(books.toString());
        //2.统计书名出现java字样的图书数量
//        System.out.println(calAll(books, ele -> ele.toString().contains("java")));
        System.out.println(books.stream().filter(ele -> ele.toString().contains("java")).count());
        //3.统计长度大于5的元素数量
//        System.out.println(calAll(books, ele -> ele.toString().length() > 5));
        System.out.println(books.stream().filter(ele -> ele.length()>5).count());
        books.stream().mapToInt(ele -> ele.toString().length()).forEach(System.out::print);

    }

    public static int calAll(Collection con, Predicate p) {
        int total = 0;
        for (Object obj : con) {
            //用Predicate的test方法判断该对象是否满足条件p
            if (p.test(obj)) {
                total++;
            }
        }
        return total;
    }
}
