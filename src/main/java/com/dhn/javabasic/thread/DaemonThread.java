package com.dhn.javabasic.thread;

/**
 * @description: 后台线程
 * @author: Dong HuaNan
 * @date: 2020/4/5 18:15
 */
public class DaemonThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //getName()返回当前线程的名字
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonThread dt = new DaemonThread();
        //将此线程设置为后台线程
        dt.setDaemon(true);
        dt.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        //main线程结束，后台线程也跟着结束
    }
}
