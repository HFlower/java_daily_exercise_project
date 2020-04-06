package com.dhn.javabasic.thread.exhandle;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/6 18:12
 */
public class  MyExHandle implements Thread.UncaughtExceptionHandler {
    /**
     * 该方法将处理线程的未处理异常
     * @param t
     * @param e
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + "线程出现了异常    " + e);
    }
}
