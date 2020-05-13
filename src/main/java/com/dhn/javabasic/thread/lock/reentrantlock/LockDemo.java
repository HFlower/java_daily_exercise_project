package com.dhn.javabasic.thread.lock.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 演示ReentrantLock的基本用法，演示被打断
 * @author: Dong HuaNan
 * @date: 2020/5/12 17:04
 */
public class LockDemo {
    public static void main(String[] args) {
        new LockDemo().init();
    }
    private void init(){
        final OutPuter outPuter = new OutPuter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(5);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    outPuter.OutPut("花花");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(5);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    outPuter.OutPut("楠楠");
                }
            }
        }).start();
    }
    static class OutPuter{
        Lock lock = new ReentrantLock();
        //字符串打印方法，一个个字符的打印
        public void OutPut(String name){
            int len = name.length();
            lock.lock();
            try{
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println("");
            }finally {
                lock.unlock();
            }
        }
    }

}
