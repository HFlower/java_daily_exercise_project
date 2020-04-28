package com.dhn.javabasic.thread.stopthread;

/**
 * @description: 判断线程是否是停止状态：interrupted()方法
 * @author: Dong HuaNan
 * @date: 2020/4/28 10:48
 */
public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        //测试当前线程是否已经中断,线程的中断状态由该方法清除。 换句话说，如果连续两次调用该方法，则第二次调用返回false。
        System.out.println("stop 1??" + Thread.interrupted());
        System.out.println("stop 2??" + Thread.interrupted());

        System.out.println("END");
    }
}
