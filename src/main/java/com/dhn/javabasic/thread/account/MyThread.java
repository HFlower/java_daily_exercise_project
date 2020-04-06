package com.dhn.javabasic.thread.account;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/6 17:55
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + "线程i的变量" + i);
        }
    }

    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字：" + mainGroup.getName());
        System.out.println("主线程组是否是后台线程组：" + mainGroup.isDaemon());
        new MyThread("主线程组的线程").start();

        ThreadGroup tg = new ThreadGroup("新线程组");
        tg.setDaemon(true);
        System.out.println("tg线程组是否是后台线程组：" + tg.isDaemon());

        MyThread tt = new MyThread(tg,"tg组的线程甲");
        tt.start();
        new MyThread(tg,"tg组的线程乙").start();
    }
}
