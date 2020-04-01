package com.dhn.javabasic.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @description: 重定向标准输出
 * @author: Dong HuaNan
 * @date: 2020/4/1 16:16
 */
public class RedirectOut {
    public static void main(String[] args) {
        try(PrintStream ps = new PrintStream(new FileOutputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\RedirectOut.txt")))
        {
            //将标准输出重定向到ps输出流
            System.setOut(ps);
            //向标准输出输出一个字符串
            System.out.println("此情可待成追忆，只是当时已惘然");
            //向标准输出输出一个对象
            System.out.println(new RedirectOut());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
