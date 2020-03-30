package com.dhn.javabasis.collections.Queue;

import java.util.ArrayDeque;

/**
 * @description: ArrayDeque 当"栈"用
 * @author: Dong HuaNan
 * @date: 2020/3/29 18:22
 */
public class ArrayDequeStack {
    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque(3);
        stack.push("疯狂java讲义");
        stack.push("疯狂iOS讲义");
        stack.push("轻量级Java EE企业应用实战");
        System.out.println(stack);
        //返回第一个元素但不删除
        System.out.println(stack.peek());
        System.out.println(stack);
        //pop出第一个元素
        System.out.println(stack.pop());
        System.out.println(stack);
    }

}
