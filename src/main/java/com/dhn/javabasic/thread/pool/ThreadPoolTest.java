package com.dhn.javabasic.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 线程池
 * @author: Dong HuaNan
 * @date: 2020/4/6 18:46
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception{
        //创建一个具有固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        //创建Runnable对象
        Runnable target = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "的i的值为" + i);
            }
        };
        //向线程池提交两个线程
        pool.submit(target);
        pool.submit(target);
        //关闭线程池
        pool.shutdown();
    }
}
