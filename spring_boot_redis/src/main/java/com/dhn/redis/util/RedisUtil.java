package com.dhn.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description: redis工具类
 * @author: Dong HuaNan
 * @date: 2020/4/28 14:50
 */
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    // =============================common============================
    /**
     * 指定缓存失效时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if (time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     * @param key
     * @return
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unChecked")
    public void deleteCatch(String ... key){
        if(key != null && key.length > 0){
            if (key.length == 1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    // =============================String============================

    /**
     * 普通缓存获取
     * @param key
     * @return
     */
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     * @param key
     * @param value
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return
     */
    public boolean set(String key, Object value,long time){
        try {
            redisTemplate.opsForValue().set(key, value, time);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key
     * @param delta 要增加几（大于0）
     * @return
     */
    public long incr(String key,long delta){
        if (delta < 0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key
     * @param delta 要减少几（大于0）
     * @return
     */
    public long decr(String key,long delta){
        if (delta < 0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    // ================================Map=================================

    /**
     * Hash Get
     * @param key 不能为null
     * @param item 项 不能为null
     * @return
     */
    public Object hasGet(String key,String item){
        return redisTemplate.opsForHash().get(key,item);
    }

    /**
     * 获取hashKey对应的所有键值
     * @param key
     * @return
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     * @param key
     * @param map
     * @param time
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0){
                expire(key,time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key
     * @param item
     * @param value
     * @return
     */
    public boolean hset(String key,String item,Object value){
        try{
            redisTemplate.opsForHash().put(key,item,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * @param key
     * @param item
     * @param value
     * @param time 时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return
     */
    public boolean hset(String key, String item, Object value, long time) {
        try{
            redisTemplate.opsForHash().put(key,item,value);
            if (time > 0){
                expire(key,time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表中的值
     * @param key 不能为null
     * @param item 项 可以是多个 不能为null
     */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return
     */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key,item);
    }

    /**
     * hash递增
     * @param key
     * @param item
     * @param by 要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     * @param key
     * @param item
     * @param by
     * @return
     */
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    // ============================set=============================

    /**
     * 根据key获取Set中的所有值
     * @param key
     * @return
     */
    public Set<Object> sGet(String key){
        try{
            return redisTemplate.opsForSet().members(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     * @param key
     * @param value
     * @return
     */
    public boolean sHasKey(String key, Object value) {
        try{
            return redisTemplate.opsForSet().isMember(key,value);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     *将数据放入set缓存
     * @param key
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object... values) {
        try{
            return redisTemplate.opsForSet().add(key,values);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将数据放入set缓存并设置失效时间
     * @param key
     * @param time
     * @param values
     * @return
     */
    public long sSetAndTime(String key, long time, Object... values) {
        try{
            Long count = redisTemplate.opsForSet().add(key,values);
            if (time > 0){
                expire(key,time);
            }
            return count;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set缓存长度
     * @param key
     * @return
     */
    public long sGetSetSize(String key) {
        try{
            return redisTemplate.opsForSet().size(key);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     * @param key
     * @param values
     * @return 移除的个数
     */
    public long setRemove(String key, Object... values) {
        try{
            return redisTemplate.opsForSet().remove(key,values);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    // ===============================list=================================

    /**
     * 获取list缓存的内容
     * @param key
     * @param start 开始
     * @param end  结束 0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        try{
            return redisTemplate.opsForList().range(key, start, end);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     * @param key
     * @return
     */
    public long lGetListSize(String key) {
        try{
            return redisTemplate.opsForList().size(key);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取list中的值
     * @param key
     * @param index 索引index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key, long index) {
        try{
            return redisTemplate.opsForList().index(key, index);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将list放入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean lSet(String key, Object value) {
        try{
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存并设置过期时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        try{
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0){
                expire(key,time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean lSet(String key, List<Object> value) {
        try{
            redisTemplate.opsForList().rightPushAll(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存并设置过期时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try{
            redisTemplate.opsForList().rightPushAll(key,value);
            if (time > 0){
                expire(key,time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     * @param key
     * @param index
     * @param value
     * @return
     */
    public boolean lUpdateIndex(String key, long index, Object value) {
        try{
            redisTemplate.opsForList().set(key, index, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除N个值为value
     * @param key
     * @param count 移除个数
     * @param value
     * @return
     */
    public long lRemove(String key, long count, Object value) {
        try{
            long remove = redisTemplate.opsForList().remove(key,count,value);
            return remove;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
