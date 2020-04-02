package com.dhn.javabasic.io.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @description: 处理流包装OutputStream
 * @author: Dong HuaNan
 * @date: 2020/4/1 14:50
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        try(
                //定义节点输出流
                FileOutputStream fileOutputStream = new FileOutputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\PrintStream.txt");
                //PrintStream包装节点输出流
                PrintStream printStream = new PrintStream(fileOutputStream);
                )
        {
            //PrintStream输出字符串
            printStream.print("普通字符串");
            //PrintStream输出对象
            printStream.print(new PrintStreamTest());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
