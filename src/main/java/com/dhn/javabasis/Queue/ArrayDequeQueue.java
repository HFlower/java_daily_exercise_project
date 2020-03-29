package com.dhn.javabasis.Queue;

import java.util.ArrayDeque;

/**
 * @description: ArrayDeque当队列用
 * @author: Dong HuaNan
 * @date: 2020/3/29 18:29
 */
public class ArrayDequeQueue {
    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        queue.offer("疯狂java讲义");
        queue.offer("疯狂iOS讲义");
        queue.offer("轻量级Java EE企业应用实战");
        System.out.println(queue);
        //访问队头元素但不出队
        System.out.println(queue.peek());
        System.out.println(queue);
        //poll出第一个元素
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
