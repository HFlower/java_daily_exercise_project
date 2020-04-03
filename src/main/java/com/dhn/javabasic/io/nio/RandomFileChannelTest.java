package com.dhn.javabasic.io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description: RandomAccessFile使用channel
 * @author: Dong HuaNan
 * @date: 2020/4/3 14:49
 */
public class RandomFileChannelTest {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio\\FileChannel.txt");
        try(
                RandomAccessFile raf = new RandomAccessFile(file,"rw");
                FileChannel channel = raf.getChannel()
                )
        {
            ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            //指针移动到最后
            channel.position(file.length());
            channel.write(buffer);
        }
    }
}
