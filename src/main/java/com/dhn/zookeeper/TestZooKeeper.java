package com.dhn.zookeeper;

import lombok.SneakyThrows;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/3 16:36
 */
public class TestZooKeeper {

    /**
     * 访问服务器集群的ip:端口号
     */
    private String connectString = "192.168.31.116:2181,192.168.31.117:2181,192.168.31.118:2181";
    /**
     * 连接超时时间
     */
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;

    //在每个测试方法之前执行。注解在【非静态方法】上。
    @BeforeEach
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("*********************start*********************");
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/",true);
                    for (String child : children){
                        System.out.println(child);
                    }
                    System.out.println("*********************end*********************");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 创建节点
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        //访问控制权限，节点类型
        String path = zkClient.create("/animal","dog".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    /**
     * 获取子节点并监听节点的变化
     */
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/",true);
        for (String child : children){
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }
    /**
     * 判断节点是否存在
     */
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/cat",false);
        System.out.println(stat == null ? "not exist" : "exist");
    }

}
