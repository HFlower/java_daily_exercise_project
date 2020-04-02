package com.dhn.javabasic.io.file;

import java.io.*;

/**
 * @description: 指定文件的指定位置插入内容
 * @author: Dong HuaNan
 * @date: 2020/4/1 17:37
 */
public class InsertContent {
    public static void main(String[] args) throws IOException {
        insert("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\InsertContent.java",30,"有点懵圈啊\r\n");
    }

    /**
     * 指定文件的指定位置插入内容
     * @param fileName 文件名
     * @param pos 插入点
     * @param insertContent 插入的内容
     * @throws IOException
     */
    private static void insert(String fileName, long pos, String insertContent) throws IOException {
        File tmp = File.createTempFile("tmp",null);
        tmp.deleteOnExit();
        try(
                RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
                //使用临时文件保存插入点后的内容
                FileOutputStream tmpOut = new FileOutputStream(tmp);
                FileInputStream tmpIn = new FileInputStream(tmp);
                )
        {
            raf.seek(pos);
            //将插入点后的内容读入临时文件进行保存
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while ((hasRead = raf.read(buffer)) > 0){
                tmpOut.write(buffer,0,hasRead);
            }
            //插入内容
            raf.seek(pos);
            //追加需要插入的内容
            raf.write(insertContent.getBytes());
            //追加之前保存的内容
            while ((hasRead = tmpIn.read(buffer)) > 0){
                raf.write(buffer,0,hasRead);
            }

        }
    }
}
