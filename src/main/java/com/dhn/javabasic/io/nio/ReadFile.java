package com.dhn.javabasic.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @description: 用channel实现类似传统方式的多次取数据
 * @author: Dong HuaNan
 * @date: 2020/4/3 14:58
 */
public class ReadFile {
    public static void main(String[] args) {
        try(
                FileInputStream inputStream = new FileInputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio\\ReadFile.java");
                FileChannel fileChannel = inputStream.getChannel();
                )
        {
            ByteBuffer buffer = ByteBuffer.allocate(256);
            while (fileChannel.read(buffer) != -1){
                //锁定buffer空白区
                buffer.flip();
                Charset charset = Charset.forName("UTF-8");
                CharsetDecoder decoder = charset.newDecoder();
                CharBuffer charBuffer = decoder.decode(buffer);
                System.out.println(charBuffer);
                buffer.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
