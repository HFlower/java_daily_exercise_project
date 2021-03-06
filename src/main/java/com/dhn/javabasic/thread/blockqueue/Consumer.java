package com.dhn.javabasic.thread.blockqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @description: 消费者
 * @author: Dong HuaNan
 * @date: 2020/4/6 13:33
 */
public class Consumer extends Thread{
    private BlockingQueue<String> bq;

    public Consumer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(getName() + "消费者准备消费集合元素!");
            try {
                Thread.sleep(200);
                bq.take();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(getName() + "消费完成：" + bq);
        }
    }
}
