package com.dhn.javabasic.io.nio2;


import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description: Paths接口功能和用法
 * @author: Dong HuaNan
 * @date: 2020/4/3 15:33
 */
public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get("javabasic\\io\\nio2\\.");
        System.out.println("Path包含的路径数量："+path.getNameCount());
        System.out.println("Path的根路径："+path.getRoot());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Path的绝对路径："+absolutePath);
        System.out.println("Path的绝对路径的根路径："+absolutePath.getRoot());
        Path path1 = Paths.get("E:\\","MyIntellijSpace3\\project\\src\\main\\","java\\com\\dhn\\javabasic\\io\\nio");
        System.out.println(path1);
    }
}
