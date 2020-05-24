package com.dhn.javabasic.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/24 10:42
 */
public class CinemaReadWrite {
    private static ReentrantReadWriteLock reentrantReadWriteLockLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLockLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLockLock.writeLock();

    private static void read(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"得到了读锁，正在读取");
        }finally {
            System.out.println(Thread.currentThread().getName() +"释放读锁");
            readLock.unlock();
        }
    }

    private static void write(){
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"得到了写锁，正在写入");
        }finally {
            System.out.println(Thread.currentThread().getName() +"释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> read(),"Thread1").start();
        new Thread(() -> read(),"Thread2").start();
        new Thread(() -> write(),"Thread3").start();
        new Thread(() -> write(),"Thread4").start();
    }
}
