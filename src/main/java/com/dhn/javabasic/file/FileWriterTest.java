package com.dhn.javabasic.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @description: 字符输出流
 * @author: Dong HuaNan
 * @date: 2020/4/1 14:41
 */
public class FileWriterTest {
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\poem.txt")){
            fileWriter.write("锦瑟 - 李商隐\r\n");
            fileWriter.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
            fileWriter.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
            fileWriter.write("沧海月明珠有泪，蓝田日暖玉生烟。\r\n");
            fileWriter.write("此情可待成追忆，只是当时已惘然。\r\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
