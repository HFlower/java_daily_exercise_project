package com.dhn.javabasic.exception;

import java.io.*;

/**
 * @description: 自动关闭资源
 * @author: Dong HuaNan
 * @date: 2020/3/31 11:05
 */
public class AutoCloseTest {
    public static void main(String[] args) throws IOException {
        //try后（）内可声明、初始化多个在程序结束时必须显式关闭的资源，资源实现类必须实现AutoCloseable或Closeable接口
        //自动关闭资源的try语句相当于包含了隐式的finally块，所以没有catch/finally块
        try (
                BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
                PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))
        )
        {
            System.out.println(br.readLine());
            ps.print("flower");
        }

        //java9:自动关闭的资源有final或者是有效的final
//        final BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
//        //不对变量重新赋值，就是有效地final
//        PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
//        try(br;ps){
//            System.out.println(br.readLine());
//            ps.print("flower");
//        }
    }
}
