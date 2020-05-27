package com.dhn.javabasic.thread.cas;

/**
 * @description: 两个线程竞争，其中一个落败
 * @author: Dong HuaNan
 * @date: 2020/5/27 15:09
 */
public class TwoThreadsCompetition implements Runnable {
    private volatile int value;
    public synchronized int compareAndSet(int expectedValue,int newValue){
        int oldValue = value;
        if (oldValue == expectedValue){
            value = newValue;
        }
        return oldValue;
    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadsCompetition r = new TwoThreadsCompetition();
        r.value = 0;
        Thread t1 = new Thread(r,"Thread1");
        Thread t2 = new Thread(r,"Thread2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.value);
    }
    @Override
    public void run() {
        compareAndSet(0,1);
    }
}
