package com.dhn.jvm.gc;

/**
 * @description: 测试垃圾回收
 * @author: Dong HuaNan
 * @date: 2020/3/20 15:59
 */
public class GcTest {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new GcTest();
            //强制系统进行垃圾回收的两种方式
            //System.gc();
            Runtime.getRuntime().gc();
        }
    }

    @Override
    public void finalize(){
        System.out.println("系统正在清理GcTest对象的资源……");
    }
}
