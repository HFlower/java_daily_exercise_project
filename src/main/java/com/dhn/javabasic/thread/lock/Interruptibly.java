package com.dhn.javabasic.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: lockInterruptibly();相当于tryLock(long time,TimeUnit unit)把超时时间设置为无限。在等待锁的过程中，线程可以被中断
 * @author: Dong HuaNan
 * @date: 2020/5/12 11:12
 */
public class Interruptibly implements Runnable {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Interruptibly interruptibly = new Interruptibly();
        Thread thread0 = new Thread(interruptibly);
        Thread thread1 = new Thread(interruptibly);
        thread0.start();
        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread0.interrupt();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"尝试获取锁");
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName()+"获取到了锁");
                Thread.sleep(5000);
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+"睡眠期间被中断了");
            }finally{
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"释放了锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+"获取锁期间被中断了");
        }
    }
}
