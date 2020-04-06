package com.dhn.javabasic.thread.account;

/**
 * @description: 存钱线程
 * @author: Dong HuaNan
 * @date: 2020/4/6 12:04
 */
public class DepositThread extends Thread{
    /**
     * 模拟用户账户
     */
    private Account account;
    /**
     * 当前存款线程所希望存款钱数
     */
    private double depositAmount;

    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    /**
     * 重复100次存钱操作
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }
}
