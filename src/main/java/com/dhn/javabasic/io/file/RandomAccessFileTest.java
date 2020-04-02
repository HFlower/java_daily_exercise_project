package com.dhn.javabasic.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @description: 任意访问文件(可以访问文件的任意位置、可以向已存在的文件后追加内容。但只能读写文件，不能读写其他IO结点。)
 * @author: Dong HuaNan
 * @date: 2020/4/1 17:21
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try(
                RandomAccessFile raf = new RandomAccessFile("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\RandomAccessFileTest.java","r")
                )
        {
            System.out.println("指针初始位置：" + raf.getFilePointer());
            //移动指针位置
            raf.seek(300);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            while ((hasRead = raf.read(buff)) > 0){
                System.out.println(new String(buff,0,hasRead));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

