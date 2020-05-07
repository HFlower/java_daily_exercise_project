package com.dhn.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/6 19:59
 */
public class DistributeServer {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer server = new DistributeServer();
        //1.连接服务器集群
        server.getConnect();
        //2.注册节点
        server.register(args[0]);
        //3.业务逻辑处理
        server.business();
    }

    private String connection = "192.168.31.116:2181,192.168.31.117:2181,192.168.31.118:2181";
    private int sessionTimeOut = 2000;
    private ZooKeeper zkClient;
    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connection, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    /**
     * 注册（就是创建一个结点）
     * @param hostName
     * @throws KeeperException
     * @throws InterruptedException
     */
    private void register(String hostName) throws KeeperException, InterruptedException {
        //节点类型是暂时的带序号的
        String path = zkClient.create("/servers/server",hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostName + "is onLine!");
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }


}
