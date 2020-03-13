package com.dhn.jvm.gc;

/**
 * @description: 测试虚拟机栈内存异常
 * @author: Dong HuaNan
 * @date: 2020/3/13 10:04
 */
public class StackOOM {
    public static void main(String[] args) {
        //从第三个月开始，每个月的兔子数等于前两个月之和
        int num = getRabbitNum(20);
        System.out.println(num);
    }

    public static int getRabbitNum(int month){
        return getRabbitNum(month-1) + getRabbitNum(month-2);
    }

}
