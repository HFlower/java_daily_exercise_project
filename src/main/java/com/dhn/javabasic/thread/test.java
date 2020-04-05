package com.dhn.javabasic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/5 13:17
 */
public class test implements Callable {
    private int i;

    @Override
    public Object call() throws Exception {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }

    public static void main(String[] args) {
        try {
            FutureTask<Integer> task = new FutureTask<Integer>(new test());
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                if (i == 20) {
                    //实质还是以Callable对象来创建并启动线程
                    new Thread(task, "有返回值的线程").start();
                }
            }
            System.out.println("子线程的返回值：" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
