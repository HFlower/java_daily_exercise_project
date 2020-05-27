package com.dhn.javabasic.thread.cas;

/**
 * @description: 模拟cas操作，等价代码
 * @author: Dong HuaNan
 * @date: 2020/5/27 15:04
 */
public class SimulatedCAS{
    private volatile int value;
    public synchronized int compareAndSet(int expectedValue,int newValue){
        int oldValue = value;
        if (oldValue == expectedValue){
            value = newValue;
        }
        return oldValue;
    }

}
