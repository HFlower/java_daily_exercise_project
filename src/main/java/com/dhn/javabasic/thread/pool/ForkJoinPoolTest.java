package com.dhn.javabasic.thread.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @description: 支持并行的线程池
 * @author: Dong HuaNan
 * @date: 2020/4/6 18:58
 */
public class ForkJoinPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        //提交可分解的PrintTask任务
        pool.submit(new PrintTask(0,300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}

/**
 * 实现"可分解"的任务（RecursiveAction代表没有返回值的任务，RecursiveTask代表有返回值的任务）
 */
class PrintTask extends RecursiveAction{
    /**
     * 每个“小任务”最多打印50个数
     */
    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < THRESHOLD){
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值" + i);
            }
        }else {
            //要打印的数大于THRESHOLD时，将大任务分解成两个“小任务”
            int middle = (start + end)/2;
            PrintTask left = new PrintTask(start,middle);
            PrintTask right = new PrintTask(middle,end);
            //并行执行两个小任务
            left.fork();
            right.fork();
        }

    }
}

