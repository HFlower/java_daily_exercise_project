package com.dhn.javabasic.thread.exhandle;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/6 18:15
 */
public class ExHandle {
    public static void main(String[] args) {
        //设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandle());
        int a = 5/0;
        System.out.println("程序正常结束！");
    }
}
