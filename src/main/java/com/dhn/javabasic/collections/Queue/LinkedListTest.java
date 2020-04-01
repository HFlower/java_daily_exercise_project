package com.dhn.javabasic.collections.Queue;


import java.util.LinkedList;

/**
 * @description: LinkedList是List和Deque接口的实现类
 * @author: Dong HuaNan
 * @date: 2020/3/29 18:34
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        //队列尾部添加元素
        linkedList.offer("疯狂java讲义");
        //栈顶加入元素
        linkedList.push("轻量级Java EE企业应用实战");
        //队列头部加入元素（相当于栈顶）
        linkedList.offerFirst("疯狂Android讲义");
        linkedList.forEach(ele -> System.out.println("遍历中：" + ele));

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        System.out.println(linkedList.pollLast());
        System.out.println(linkedList);

    }
}
