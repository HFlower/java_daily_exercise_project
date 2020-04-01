package com.dhn.javabasic.file;

import java.io.File;

/**
 * @description: 文件过滤器
 * @author: Dong HuaNan
 * @date: 2020/4/1 10:29
 */
public class FilenameFilterTest {
    public static void main(String[] args) {
        File file = new File(".");
        //使用Lambda表达式（目标类型为FilenameFilter）实现文件过滤器。如果文件名以.java结尾或者文件对应一个路径则返回true
        String[] nameList = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
        for (String name : nameList){
            System.out.println(name);
        }

    }
}
