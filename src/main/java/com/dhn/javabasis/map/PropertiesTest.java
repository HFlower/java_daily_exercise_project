package com.dhn.javabasis.map;

import org.opensaml.xml.signature.P;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/29 20:18
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties properties1 = new Properties();
        properties1.setProperty("username","flower");
        properties1.setProperty("password","123456");
        //保存到a.ini文件
        properties1.store(new FileOutputStream("a.ini"),"comment line");

        Properties properties2 = new Properties();
        properties2.setProperty("gender","male");
        //将a.ini文件中的内容追加到properties2中
        properties2.load(new FileInputStream("a.ini"));
        System.out.println(properties2);
    }
}
