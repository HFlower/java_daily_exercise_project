package com.dhn.javabasic.thread;

import java.util.Date;

/**
 * @description: 线程睡眠sleep
 * @author: Dong HuaNan
 * @date: 2020/4/5 18:23
 */
public class SleepTest extends Thread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前时间：" + new Date());
            //将当前执行的线程暂停1s
            Thread.sleep(1000);
        }
    }
}
