package com.dhn.javabasic.io.nio2;

import java.io.IOException;
import java.nio.file.*;

/**
 * @description: 使用WatchService监控文件变化
 * @author: Dong HuaNan
 * @date: 2020/4/3 17:06
 */
public class WatchServiceTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建一个文件系统监听服务对象
        WatchService watchService = FileSystems.getDefault().newWatchService();
        //为d：盘根目录注册监听
        Paths.get("D:/").register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
        while (true){
            //获取下一个文件变化事件，没有watchKey就一直等待
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()){
                System.out.println(event.context() + "文件发生了 " +event.kind()+"事件！");
            }
            //重设watchKey
            boolean valid = key.reset();
            //重设失败，退出监听
            if (!valid){
                break;
            }
        }
    }
}
