package com.dhn.redis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

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
        //关闭jedis
        jedis.close();
    }
}
