package com.dhn.javabasic.thread.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 锁的升降级
 * @author: Dong HuaNan
 * @date: 2020/5/24 11:42
 */
public class Upgrading {
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private static void readUpgrading(){
        System.out.println(Thread.currentThread().getName()+"开始尝试获取读锁");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"得到读锁，正在读取");
            try {
                Thread.sleep(1000);
                System.out.println("升级会带来阻塞");
                writeLock.lock();
                System.out.println(Thread.currentThread().getName()+"得到写锁，升级成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放读锁");
            readLock.unlock();
        }
    }

    private static void writeUpgrading(){
        System.out.println(Thread.currentThread().getName()+"开始尝试获取写锁");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"得到写锁，正在写入");
            try {
                Thread.sleep(1000);
                readLock.lock();
                System.out.println(Thread.currentThread().getName()+"在不释放写锁情况下，直接获取读锁，成功降级");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("先演示降级是可以的");
        Thread thread1 = new Thread(() -> writeUpgrading(), "Thread1");
        thread1.start();
        thread1.join();
        System.out.println("--------------------------------");
        System.out.println("演示升级是不可以的");
        Thread thread2 = new Thread(() -> readUpgrading(), "Thread2");
        thread2.start();
    }
}
