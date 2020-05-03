package com.dhn.zookeeper;

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
    @Test
    public void init(){
        zkClient = new ZooKeeper(connectString,sessionTimeout,new Watcher(){
            @Override
            public void process(WatchedEvent event){

            }
        });
    }

}
