package com.dhn.javabasic.file;

import java.io.File;
import java.io.IOException;
import java.time.Clock;

/**
 * @description: File可操作文件和目录，但不能访问文件内容
 * @author: Dong HuaNan
 * @date: 2020/4/1 9:34
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        System.out.println("1."+file.getName());
        System.out.println("2."+file.getParent());
        //获取绝对路径
        System.out.println("3."+file.getAbsoluteFile());
        //获取此对象对应的路径名
        //System.out.println("3.1、+file.getPath());
        //获取此对象对应的绝对咯经名
        //System.out.println("3.2、"+file.getAbsolutePath());
        //获取上一级路径
        System.out.println("4."+file.getAbsoluteFile().getParent());
        //在当前路径下创建一个临时文件
        File tempFile = File.createTempFile("aaa",".txt",file);
        //当jvm退出时删除该文件
        tempFile.deleteOnExit();
        //以系统当前时间作为新文件名创建一个新文件
        File newFile = new File(Clock.systemDefaultZone().millis() + "");
        System.out.println("newFile对象是否存在："+newFile.exists());
        //以指定newFile对象来创建一个文件
        newFile.createNewFile();
        //以newFile对象来创建一个目录，因为newFile已经存在，所以无法创建（调用此方法时File对象对应的必须是一个路径，而不是文件）
        newFile.mkdir();
        //列出当前路径下所有文件和路径如下
        String[] fileList = file.list();
        System.out.println("==============当前路径下所有文件和路径如下================");
        for (String fileName : fileList){
            System.out.println(fileName);
        }
        //列出所有磁盘根路径
        File[] roots = File.listRoots();
        System.out.println("==============系统所有根路径如下================");
        for (File root : roots){
            System.out.println(root);
        }
    }

}
