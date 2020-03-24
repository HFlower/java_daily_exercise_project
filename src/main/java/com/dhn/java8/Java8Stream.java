package com.dhn.java8;

import java.util.stream.IntStream;

/**
 * @description: stream
 * @author: Dong HuaNan
 * @date: 2020/3/24 11:11
 */
public class Java8Stream {

    public static void main(String[] args) {
        IntStream is = IntStream.builder().add(2).add(5).add(7).add(8).add(3).build();
        //聚集方法每次只能执行一个
//        System.out.println("最大元素：" + is.max().getAsInt());
//        System.out.println("总和：" + is.sum());
//        System.out.println("总数：" + is.count());
//        System.out.println("所有元素的平方是否都大于10：" + is.allMatch(ele -> ele * ele > 10));
        //用is映射成一个新集合，新集合的每个元素的大小是原来的2倍+1
        IntStream newIS = is.map(ele -> ele * 2 +1);
        newIS.forEach(System.out::println);
    }
}
