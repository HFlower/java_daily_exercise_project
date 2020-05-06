package com.dhn.zookeeper;

import lombok.SneakyThrows;
import org.apache.zookeeper.*;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    @BeforeEach
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

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

}
