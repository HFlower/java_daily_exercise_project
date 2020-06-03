package com.dhn.redis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @description: 认识Jedis
 * @author: Dong HuaNan
 * @date: 2020/6/3 14:12
 */
public class JedisTest {
    @Test
    public void testJedis(){
        //连接jedis
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //操作jedis
//        jedis.set("name","花花");
        String name = jedis.get("name");
        System.out.println(name);
//        jedis.lpush("list1","a","b","c");
//        jedis.rpush("list1","x");
        List<String> list1 = jedis.lrange("list1",0,-1);
        for (String s:list1) {
            System.out.println(s);
        }
        System.out.println(jedis.llen("list1"));

        jedis.hset("hash1","a1","a1");
        jedis.hset("hash1","a2","a2");
        jedis.hset("hash1","a3","a3");
        Map<String,String> hash1 = jedis.hgetAll("hash1");
        System.out.println(hash1);
        System.out.println(jedis.hlen("hash1"));
        //关闭jedis
        jedis.close();
    }
}
