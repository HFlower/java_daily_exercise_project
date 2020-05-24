package com.dhn.javabasic.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 乐观锁
 * @author: Dong HuaNan
 * @date: 2020/5/12 11:43
 */
public class PessimismOptimismLock{
    int a;
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

    public synchronized void testMethod(){
        a++;
    }
}
