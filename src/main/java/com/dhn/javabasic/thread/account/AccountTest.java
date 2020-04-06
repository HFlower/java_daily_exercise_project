package com.dhn.javabasic.thread.account;

/**
 * @description: 用存取款测试线程通信
 * @author: Dong HuaNan
 * @date: 2020/4/6 12:09
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("1234567",0);
        new DrawThread("取钱者1",account,800).start();
        //new DrawThread("取钱者2",account,800).start();
        new DepositThread("存钱者甲",account,800).start();
        new DepositThread("存钱者乙",account,800).start();
        new DepositThread("存钱者丙",account,800).start();

    }
}
