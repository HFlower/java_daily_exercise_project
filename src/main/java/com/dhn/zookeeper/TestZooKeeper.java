package com.dhn.zookeeper;

import lombok.SneakyThrows;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/3 16:36
 */
public class TestZooKeeper {

    /**
     * 访问服务器集群的ip:端口号
     */
    private String connectString = "hadoop102:2181,hadoop103:2181,hadoop104:2181";
    /**
     * 连接超时时间
     */
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;

    @SneakyThrows
    @Test
    public void init(){
        zkClient = new ZooKeeper(connectString,sessionTimeout,new Watcher(){
            @Override
            public void process(WatchedEvent event){

            }
        });
    }

}
