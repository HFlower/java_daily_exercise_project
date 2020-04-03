package com.dhn.javabasic.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @description: FileChannel的使用
 * @author: Dong HuaNan
 * @date: 2020/4/3 14:27
 */
public class FileChannelTest {
    public static void main(String[] args) {
        File file = new File("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio\\FileChannelTest.java");
        try(
                //以文件输入输出流创建FileChannel
                FileChannel inChannel = new FileInputStream(file).getChannel();
                FileChannel outChannel = new FileOutputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio\\FileChannel.txt").getChannel();
                )
        {
            //将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer byteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            //将buffer里的数据全部输出
            outChannel.write(byteBuffer);
            //复原position、limit的位置
            byteBuffer.clear();
            //使用GBK字符集创建解码器
            Charset charSet = Charset.forName("UTF-8");
            CharsetDecoder decoder = charSet.newDecoder();
            //使用解码器将ByteBuffer转成CharBuffer
            CharBuffer charBuffer = decoder.decode(byteBuffer);
            System.out.println(charBuffer.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
