package com.dhn.javabasic.thread.stopthread;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/28 10:12
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();

            for (int i = 0; i < 500000; i++) {
//            System.out.println("i="+(i+1));
//            i++;
                if (this.isInterrupted()) {
                    System.out.println("线程已经终止，循环不再执行");
                    break;
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("这是for循环外面的语句，也会被执行");
    }

}
