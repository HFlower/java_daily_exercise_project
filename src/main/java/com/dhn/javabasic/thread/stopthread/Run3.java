package com.dhn.javabasic.thread.stopthread;

/**
 * @description: 判断线程是否是停止状态：isInterrupted()方法
 * @author: Dong HuaNan
 * @date: 2020/4/28 10:53
 */
public class Run3 {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        thread.interrupt();
        //isInterrupted()并未清除状态，所以打印了两个true。
        System.out.println("stop 1??" + thread.isInterrupted());
        System.out.println("stop 1??" + thread.isInterrupted());

        System.out.println("END");
    }
}
