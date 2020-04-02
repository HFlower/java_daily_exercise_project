package com.dhn.javabasic.io.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: Jvm读取其他进程的数据
 * @author: Dong HuaNan
 * @date: 2020/4/1 16:58
 */
public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        //运行javac,返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("javac");
        //以p进程的错误流创建BufferedReader对象
        try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream())))
        {
            String buff = null;
            while ((buff = br.readLine()) != null){
                System.out.println(buff);
            }
        }
    }
}
