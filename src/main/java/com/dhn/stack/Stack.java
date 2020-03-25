package com.dhn.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 栈
 * @author: Dong HuaNan
 * @date: 2020/3/9 15:09
 */
public class Stack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    @Override
    public String toString() {
        return "Stack:" +
                "queue1=" + queue1 +
                ", queue2=" + queue2;
    }

    /**
     * 入栈（哪个队列为空添加到哪个队列）
     * @param ele
     */
    public void push(int ele){
        if(queue1.isEmpty() && queue2.isEmpty()){
            queue1.offer(ele);
        }else if(queue2.size() == 0){
            queue1.offer(ele);
        }else {
            queue2.offer(ele);
        }
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop(){
        if (queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int temp = 0;
        if (!queue1.isEmpty()){
            while (queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            temp = queue1.poll();
        }
        if (!queue2.isEmpty()){
            while (queue2.size() > 1){
                queue1.offer(queue2.poll());
            }
            temp = queue2.poll();
        }
        return temp;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }


}
