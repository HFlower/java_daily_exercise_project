package com.dhn.javabasic.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: AtomicInteger基本用法，对比非原子类的线程安全问题吗，使用了原子类后，不需要加锁，也能保证线程安全
 * @author: Dong HuaNan
 * @date: 2020/5/27 9:25
 */
public class AtomicIntegerDemo1 implements Runnable{
    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public void increamentAtomic(){
//        atomicInteger.getAndIncrement();
        atomicInteger.getAndAdd(10);
    }

    private static volatile int basicCount = 0;

    public synchronized void increamentBasic(){
        basicCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            increamentAtomic();
            increamentBasic();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo1 r = new AtomicIntegerDemo1();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("元子类的结果是："+atomicInteger.get());
        System.out.println("普通变量的结果是："+basicCount);
    }
}
