package com.dhn.javabasis.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description: 访问异常信息
 * @author: Dong HuaNan
 * @date: 2020/3/31 10:26
 */
public class AccessExceptionMsg {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("a.txt");
        }catch (IOException e){
            //返回该异常信息描述字符串
            System.out.println(e.getMessage());
            //将该异常的跟踪栈信息输出到标准错误输出
            //e.printStackTrace();
            return;
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //finally中的语句总会执行，即使catch有return
            System.out.println("执行finally回收资源");
        }
    }
}
