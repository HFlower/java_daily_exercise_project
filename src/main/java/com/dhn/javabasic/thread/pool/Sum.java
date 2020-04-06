package com.dhn.javabasic.thread.pool;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/6 19:15
 */
public class Sum {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = new int[100];
        //测试计算结果，与CalTask计算结果比对
        Random random = new Random();
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = random.nextInt(20);
            //对数组元素赋值，并把数组元素的值添加到sum总和中
            total += (arr[i] = tmp);
        }
        System.out.println(total);

        //创建一个通用池
        ForkJoinPool pool = ForkJoinPool.commonPool();
        //提交一个可分解的CalTask任务
        Future<Integer> future = pool.submit(new CalTask(arr,0,arr.length));
        System.out.println(future.get());

        pool.shutdown();
    }
}
class CalTask extends RecursiveTask<Integer>{
    /**
     * 每个“小任务”最多累加20个数
     */
    private static final int THRESHOLD = 20;
    private int[] arr;
    private int start;
    private int end;

    public CalTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if ((end - start) < THRESHOLD){
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }else {
            int middle = (start + end)/2;
            CalTask left = new CalTask(arr,start,middle);
            CalTask right = new CalTask(arr,middle,end);
            left.fork();
            right.fork();
            //把两个小任务结果合并起来
            //int tmp = left.join() + right.join();
            return left.join() + right.join();
        }
    }
}