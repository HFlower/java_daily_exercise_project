package com.dhn.javabasic.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @description: 原子数组的使用方法
 * @author: Dong HuaNan
 * @date: 2020/5/27 9:35
 */
public class AtomicArrayDemo {
    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
        Incrementer incrementer = new Incrementer(atomicIntegerArray);
        Decrementer decrementer = new Decrementer(atomicIntegerArray);
        Thread[] threadsIn = new Thread[100];
        Thread[] threadsIDe = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threadsIDe[i] = new Thread(decrementer);
            threadsIn[i] = new Thread(incrementer);
            threadsIDe[i].start();
            threadsIn[i].start();
        }
//        Thread.sleep(10000);

        for (int i = 0; i < 100; i++) {
            try {
                threadsIDe[i].join();
                threadsIn[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < atomicIntegerArray.length(); i++) {
//            if (atomicIntegerArray.get(i) != 0){
//                System.out.println("发现了错误"+i);
//            }

            System.out.println(atomicIntegerArray.get(i));
        }

        System.out.println("运行结束！");

    }
}

class Decrementer implements Runnable{

    private AtomicIntegerArray array;

    public Decrementer(AtomicIntegerArray array){
        this.array = array;
    }
    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndDecrement(i);
        }

    }
}

class Incrementer implements Runnable{

    private AtomicIntegerArray array;

    public Incrementer(AtomicIntegerArray array){
        this.array = array;
    }
    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }

    }
}
