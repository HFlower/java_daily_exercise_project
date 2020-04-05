package com.dhn.javabasic.thread;

/**
 * @description: 继承Thread类创建线程类
 *               步骤：（1）定义Thread子类，重写run方法(线程执行体)
 *               （2）创建Thread子类的实例，即创建了线程对象
 *               （3）调用线程对象的start()方法，启动线程
 * @author: Dong HuaNan
 * @date: 2020/4/5 11:40
 */
public class FirstThread extends Thread{
    private int i;
    @Override
    public void run(){
        for (; i < 100; i++) {
            //getName()返回当前线程的名字
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //获取当前线程
            System.out.println(Thread.currentThread() + " " + i);
            if (i == 20){
                //创建并启动第一个线程
                new FirstThread().start();
                //创建并启动第二个线程
                new FirstThread().start();
            }
        }
    }
}
