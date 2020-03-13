package com.dhn.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 测试堆内存异常
 * @author: Dong HuaNan
 * @date: 2020/3/13 9:41
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true){
            list.add(new HeapOOM());
        }

    }
}
