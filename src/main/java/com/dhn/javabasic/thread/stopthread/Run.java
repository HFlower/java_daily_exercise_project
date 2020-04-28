package com.dhn.javabasic.thread.stopthread;

/**
 * @description: 停止正在运行的线程
 * @author: Dong HuaNan
 * @date: 2020/4/28 10:14
 */
public class Run {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(2000);
            //interrupt()方法的使用效果并不像for+break语句那样，马上就停止循环。调用interrupt方法是在当前线程中打了一个停止标志，并不是真的停止线程
            thread.interrupt();
            //this.interrupted(): 测试当前线程是否已经中断；
            //this.isInterrupted(): 测试线程是否已经中断；
            System.out.println("stop 1??"+thread.interrupted());
            System.out.println("stop 2??"+thread.isInterrupted());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
