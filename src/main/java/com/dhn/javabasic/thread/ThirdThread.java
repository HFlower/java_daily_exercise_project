package com.dhn.javabasic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description: 使用Callable和Future创建线程
 *              步骤：（1）创建Callable接口的实现类，实现call方法(线程执行体),再创建Callable实现类的实例
 *              （2）使用FutureTask类包装Callable对象
 *              （3）使用FutureTask对象作为Thread对象的target创建并启动新线程
 *              （4）调用FutureTask对象的get方法获得子线程执行结束后的返回值
 * @author: Dong HuaNan
 * @date: 2020/4/5 12:18
 */
public class ThirdThread{
    public static void main(String[] args) {
        ThirdThread rt = new ThirdThread();
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)() -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            //call方法可以有返回值
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                //实质还是以Callable对象来创建并启动线程
                new Thread(task,"有返回值的线程").start();
            }
        }
        try{
            System.out.println("子线程的返回值：" + task.get());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
