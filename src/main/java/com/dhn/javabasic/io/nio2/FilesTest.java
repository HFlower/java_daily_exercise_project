package com.dhn.javabasic.io.nio2;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: Files接口
 * @author: Dong HuaNan
 * @date: 2020/4/3 16:15
 */
public class FilesTest {
    public static void main(String[] args) throws Exception {
        //复制文件
        Files.copy(Paths.get("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio2\\FilesTest.java"),new FileOutputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio2\\FilesTest.txt"));
        //一次性读取文件所有行
        List<String> lines = Files.readAllLines(Paths.get("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio2\\FilesTest.java"), Charset.forName("UTF-8"));
        System.out.println("一次性读取文件所有行:"+lines);
        //判断文件大小
        System.out.println("文件大小："+Files.size(Paths.get("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio2\\FilesTest.java")));

        List<String> poem = new ArrayList<>();
        poem.add("天若有情天亦老，");
        poem.add("人间正道是沧桑。");
        //直接将多个字符串写入指定文件中
        Files.write(Paths.get("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio2\\poem.txt"),poem,Charset.forName("UTF-8"));
        //列出当前目录下所有文件和子目录
        Files.list(Paths.get(".")).forEach(path -> System.out.println("当前目录下所有文件和子目录："+path));
        System.out.println("*************************************");
        //读取文件内容
        Files.lines(Paths.get("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio2\\poem.txt"),Charset.forName("UTF-8")).forEach(line -> System.out.println(line));

        FileStore cStore = Files.getFileStore(Paths.get("c:"));
        System.out.println("c的共有空间：" + cStore.getTotalSpace());
        System.out.println("c的可用空间：" + cStore.getUsableSpace());

    }
}
