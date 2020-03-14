package com.dhn.jvm.gc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 测试如何使用jconsole工具
 * @author: Dong HuaNan
 * @date: 2020/3/14 15:36
 */
public class HeapTest {

    //定义一个大小为64k的字节数组

    private byte[] bytes = new byte[64 * 1024];

    public static void main(String[] args) throws IOException, InterruptedException {
        System.in.read();
        List<HeapTest> heapTestList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            heapTestList.add(new HeapTest());
        }
        System.gc();
    }
}
