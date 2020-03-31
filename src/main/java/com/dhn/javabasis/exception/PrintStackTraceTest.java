package com.dhn.javabasis.exception;

/**
 * @description: 打印异常跟踪栈
 * @author: Dong HuaNan
 * @date: 2020/3/31 15:03
 */
public class PrintStackTraceTest {
    public static void main(String[] args) {
        firstMethod();
    }

    private static void firstMethod() {
        secondMethod();
    }

    private static void secondMethod() {
        thirdMethod();
    }

    private static void thirdMethod() {
        throw new SelfException("自定义异常信息");
    }
}

class SelfException extends RuntimeException{
    public SelfException() {
    }

    public SelfException(String message) {
        super(message);
    }

    public SelfException(Throwable cause) {
        super(cause);
    }
}
