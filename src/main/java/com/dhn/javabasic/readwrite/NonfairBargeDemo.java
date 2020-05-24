package com.dhn.javabasic.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 演示非公平和公平的情况
 * @author: Dong HuaNan
 * @date: 2020/5/24 10:51
 */
public class NonfairBargeDemo {
    private final ReentrantReadWriteLock mReentrantReadWriteLock = new ReentrantReadWriteLock(true);
}
