package com.dhn.javabasic.file;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @description: 使用字符串作为物理节点的字符输入、输出
 * @author: Dong HuaNan
 * @date: 2020/4/1 15:08
 */
public class StringNodeTest {
    public static void main(String[] args) {
        String src = "面朝大海，春暖花开";
        char[] buffer = new char[32];
        int hasRead = 0;
        try (StringReader sr = new StringReader(src)) {
            while ((hasRead = sr.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, hasRead));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建StringWriter对象时，实际上是已StringBuffer作为输出节点
        try (StringWriter sw = new StringWriter()) {
            sw.write("月遇从云,");
            sw.write("花遇和风。");
            System.out.println("***********sw***********");
            System.out.println(sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
