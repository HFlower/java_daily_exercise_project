package com.dhn.javabasic.thread;

/**
 * @description: 线程优先级
 * @author: Dong HuaNan
 * @date: 2020/4/5 18:36
 */
public class PriorityTest extends Thread {
    //提供一个有参数的构造器，用于设置该线程的名字
    public PriorityTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            //getName()返回当前线程的名字
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        //改变主线程的优先级
        Thread.currentThread().setPriority(6);
        for (int i = 0; i < 30; i++) {
            if(i == 10){
                PriorityTest low = new PriorityTest("低级");
                low.start();
                System.out.println("创建之初的优先级" + low.getPriority());
                //设置该线程为最低优先级
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if(i == 20){
                PriorityTest high = new PriorityTest("高级");
                high.start();
                System.out.println("创建之初的优先级" + high.getPriority());
                //设置该线程为最高优先级
                high.setPriority(Thread.MAX_PRIORITY);
            }

        }
    }
}
