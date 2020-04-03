package com.dhn.javabasic.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @description: 文件锁
 * @author: Dong HuaNan
 * @date: 2020/4/3 15:24
 */
public class FileLockTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        try(FileChannel channel = new FileOutputStream("E:\\MyIntellijSpace3\\project\\src\\main\\java\\com\\dhn\\javabasic\\io\\nio\\FileChannel.txt").getChannel())
        {
            //使用非阻塞方式对指定文件进行加锁
            FileLock lock = channel.tryLock();
            Thread.sleep(10000);
            lock.release();
        }
    }
}
