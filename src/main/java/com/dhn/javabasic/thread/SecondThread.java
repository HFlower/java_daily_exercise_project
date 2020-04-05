package com.dhn.javabasic.thread;

/**
 * @description: 实现Runnable接口创建线程类
 *              步骤：（1）定义Runnable接口的实现类，重写接口的run方法(线程执行体)
 *              （2）创建Runnable实现类的实例，并以此实例作为Thread的target来创建Thread对象（真正的线程对象）
 *              （3）调用线程对象的start()方法，启动线程
 * @author: Dong HuaNan
 * @date: 2020/4/5 11:59
 */
public class SecondThread implements Runnable{
    private int i;
    @Override
    public void run() {
        for (; i < 100; i++) {
            //当Thread类实现Runnable接口时，获取当前线程只能用Thread.currentThread().getName()方法
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //获取当前线程
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                SecondThread st = new SecondThread();
                //通过new Thread(target,name)方法创建新线程
                //多个线程共享同一个target，所以多个线程可共享同一个线程target类的实例变量
                new Thread(st,"新线程1").start();
                new Thread(st,"新线程2").start();
            }
        }
    }
}
