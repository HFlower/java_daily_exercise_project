package com.dhn.javabasic.io.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @description: 重定向标准输入
 * @author: Dong HuaNan
 * @date: 2020/4/1 16:25
 */
public class RedirectIn {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\poem.txt"))
        {
            //将标准输入重定向到fileInputStream输入流
            System.setIn(fileInputStream);
            Scanner sc = new Scanner(System.in);
            //把回车键作为分隔符
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                System.out.println("键盘输入的内容是：" + sc.next());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
