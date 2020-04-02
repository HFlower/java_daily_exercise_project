package com.dhn.javabasic.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @description: 文件后追加内容
 * @author: Dong HuaNan
 * @date: 2020/4/1 17:30
 */
public class AppendContent {
    public static void main(String[] args) {
        try(RandomAccessFile raf = new RandomAccessFile("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\RandomAccessOut.txt","rw"))
        {
            raf.seek(raf.length());
            raf.write("追加内容:阳光里像个孩子，风雨里像个大人\r\n".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
