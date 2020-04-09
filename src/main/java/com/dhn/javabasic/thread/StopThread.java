package com.dhn.javabasic.thread;

/**
 * @description: 线程正常退出
 * @author: Dong HuaNan
 * @date: 2020/4/9 16:19
 */
public class StopThread extends Thread{
    int i = 0;
    boolean next = true;

    @Override
    public void run() {
        while (next){
            if (i == 10){
                next = false;
            }
            i++;
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        new StopThread().start();
    }

}
