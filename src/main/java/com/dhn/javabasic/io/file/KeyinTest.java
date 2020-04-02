package com.dhn.javabasic.io.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 转换流
 * @author: Dong HuaNan
 * @date: 2020/4/1 15:36
 */
public class KeyinTest {
    public static void main(String[] args) {

        try(//将System.in对象转换成Reader对象
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            //将普通Reader对象包装成BufferReader(BufferReader具有缓冲功能，一次读取一行文本，以换行符为标志,常用于读取文本输入流)
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader))
        {
            String line = null;
            //朱行读取
            while ((line = bufferedReader.readLine()) != null){
                //如果读取的字符串为“exit”，则程序退出
                if (line.equals("exit")){
                    System.exit(1);
                }
                System.out.println("输入内容为：" + line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
