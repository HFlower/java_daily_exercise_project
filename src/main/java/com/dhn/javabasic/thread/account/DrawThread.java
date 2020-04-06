package com.dhn.javabasic.thread.account;

/**
 * @description: 取钱线程
 * @author: Dong HuaNan
 * @date: 2020/4/5 19:00
 */
public class DrawThread extends Thread{
    /**
     * 模拟用户账户
     */
    private Account account;
    /**
     * 当前取款线程所希望取的钱数
     */
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        //同步方法的监视器是this，this代表调用draw()方法的对象，即线程进入draw()之前，必须先对account对象加锁
//       account.draw(drawAmount);
//       account.drawLock(drawAmount);

        //测试存钱、取钱
        //重复100次取钱操作
        for (int i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }

    }
}
