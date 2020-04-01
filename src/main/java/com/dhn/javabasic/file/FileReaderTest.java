package com.dhn.javabasic.file;

import java.io.FileReader;
import java.io.IOException;

/**
 * @description: 字符输入流
 * @author: Dong HuaNan
 * @date: 2020/4/1 14:23
 */
public class FileReaderTest {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\file\\FileReaderTest.java"))
        {
            char[] cbuf = new char[32];
            int hasRead = 0;
            while ((hasRead = fileReader.read(cbuf)) > 0){
                System.out.println(new String(cbuf,0,hasRead));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
