package com.dhn.javabasic.thread;

/**
 * @description: yield关键字
 * @author: Dong HuaNan
 * @date: 2020/5/7 15:01
 */
public class YieldThread implements Runnable{
    YieldThread(){
        Thread t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 5 == 0){
                System.out.println(Thread.currentThread() + "yield cpu...");
                //让出CPU执行权，放下一轮调度弃时间片，等待
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new YieldThread();
        new YieldThread();
        new YieldThread();
    }
}
