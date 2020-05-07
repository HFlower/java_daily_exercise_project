package com.dhn.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/6 20:20
 */
public class DistrubuteClient {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistrubuteClient client = new DistrubuteClient();
        //1.获取集群连接
        client.getConnect();
        //2.注册监听
        client.getChildren();
        //3.业务逻辑处理
        client.business();
    }

    private String connection = "192.168.31.116:2181,192.168.31.117:2181,192.168.31.118:2181";
    private int sessionTimeOut = 2000;
    private ZooKeeper zkClient;
    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connection, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //监听会走这个代码
                try {
                    //不放这个只注册依次，监听一次
                    getChildren();
                }catch (KeeperException e){
                    e.printStackTrace();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });
    }

    private void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/servers",true);
        //存储服务器节点主机名称集合
        List<String> hosts = new ArrayList<>();
        for (String child : children){
            byte[] data = zkClient.getData("/servers/"+child,false,null);
            hosts.add(new String(data));
        }
        //将所有在线主机名称打印到控制台
        System.out.println(hosts);
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }
}
