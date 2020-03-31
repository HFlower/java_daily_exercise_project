package com.dhn.javabasis.exception;

/**
 * @description: 在finally块中使用return/throw语句，会导致try/catch中的return/throw语句失效
 * @author: Dong HuaNan
 * @date: 2020/3/31 10:55
 */
public class FinallyFlowTest {

    public static void main(String[] args) {
        boolean a = test();
        System.out.println(a);
    }

    private static boolean test() {
        try {
            //finally中包含了return语句，此语句将失效
            return true;
        }finally {
            return false;
        }
    }
}
