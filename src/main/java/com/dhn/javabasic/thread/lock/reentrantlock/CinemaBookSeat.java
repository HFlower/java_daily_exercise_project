package com.dhn.javabasic.thread.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 演示多线程预定电影院座位
 * @author: Dong HuaNan
 * @date: 2020/5/12 16:59
 */
public class CinemaBookSeat {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> bookSeat()).start();
        new Thread(() -> bookSeat()).start();
        new Thread(() -> bookSeat()).start();
        new Thread(() -> bookSeat()).start();
    }

    public static void bookSeat(){
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"开始预定座位");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "预定座位完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }
}
