package com.dhn.javabasic.thread.account;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/5 19:07
 */
public class DrawTest {
    public static void main(String[] args) {
        Account acct = new Account("1234567",1000);
        new DrawThread("甲",acct,800).start();
        new DrawThread("乙",acct,800).start();
    }
}
