package com.dhn.javabasic.thread;

/**
 * @description: join线程
 * @author: Dong HuaNan
 * @date: 2020/4/5 18:05
 */
public class JoinThread extends Thread {
    //提供一个有参数的构造器，用于设置该线程的名字
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //getName()返回当前线程的名字
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动子线程
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被join的线程");
                jt.start();
                //main线程必须等jt执行结束才会向下执行
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
