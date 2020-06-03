package com.dhn.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @description: Jedis工具类
 * @author: Dong HuaNan
 * @date: 2020/6/3 15:03
 */
public class JedisUtil {
    private static JedisPool pool;
    private static String host;
    private static int port;
    private static int maxTotal;
    private static int maxIdle;

    static{
        ResourceBundle rb = ResourceBundle.getBundle("redis");
        host = rb.getString("redis.host");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
        maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxTotal);
        pool = new JedisPool(config,host,port);
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }

    public static void main(String[] args) {
        JedisUtil.getJedis();
    }
}
