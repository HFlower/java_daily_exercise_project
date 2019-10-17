package com.dhn.java8;

import java.util.Optional;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2019/10/17 16:08
 */
public class Java8Test3 {

    public static void main(String[] args) {

        Java8Test3 test = new Java8Test3();

        Integer value1 = null;
        Integer value2 = new Integer(10);

        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println(test.sum(a,b));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());
        //orElse返回值（如果存在），否则返回other。
        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();

        return value1 + value2;


    }

}
