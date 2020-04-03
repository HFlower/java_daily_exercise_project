package com.dhn.javabasic.io.nio;

import java.nio.CharBuffer;

/**
 * @description: buffer的常用方法
 * @author: Dong HuaNan
 * @date: 2020/4/3 11:47
 */
public class BufferTest {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("初始时：capacity="+buffer.capacity()+"***limit="+buffer.limit()+"***position="+buffer.position());
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        System.out.println("加入三个元素后position: "+buffer.position());
        buffer.flip();
        System.out.println("执行flip后--> limit:"+buffer.limit()+"  position:"+buffer.position());
        System.out.println("第一个元素：" + buffer.get());
        System.out.println("取出一个元素后，position = " + buffer.position());
        buffer.clear();
        System.out.println("执行clear后--> limit:"+buffer.limit()+"  position:"+buffer.position());
        System.out.println("执行clear后,缓冲区数据并没有被清除，第三个元素："+buffer.get(2)+"   position ="+buffer.position());

    }
}
