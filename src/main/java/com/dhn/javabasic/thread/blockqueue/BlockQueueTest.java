package com.dhn.javabasic.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/6 13:40
 */
public class BlockQueueTest {
    public static void main(String[] args) {
        //创建容量为1的阻塞队列
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        //启动三个生产者线程
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();
        //启动一个消费者线程
        new Consumer(bq).start();
    }
}
