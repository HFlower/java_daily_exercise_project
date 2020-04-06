package com.dhn.javabasic.thread.account;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 银行账户（同步方法、同步锁、线程通信）
 * @author: Dong HuaNan
 * @date: 2020/4/5 18:54
 */
@Getter
@Setter
public class Account {
    /**
     * 定义锁对象
     */
    private final ReentrantLock lock = new ReentrantLock();
    /**
     * 封装账户编号，余额两个成员变量
     */
    private String accountNo;
    private double balance;
    /**
     * 标识账户中是否已有存款的旗标(false时，账户没有存款)
     */
    private boolean flag = false;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null || o.getClass() == Account.class) {
            Account account = (Account) o;
            return account.getAccountNo().equals(accountNo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    /**
     * 提供一个线程安全的取钱方法
     * @param drawAmount
     */
    public synchronized void draw(double drawAmount){
        try{
            //flag为false，没有存款，取钱方法阻塞
            if (!flag){
                wait();
            }else {
                //flag为true，取钱者线程向下执行
                System.out.println(Thread.currentThread().getName() + "取钱" + drawAmount);
                //修改余额
                balance -= drawAmount;
                System.out.println("\t余额为： " + balance);
                flag = false;
                //唤醒其他线程
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 存款
     * @param depositAmount
     */
    public synchronized void deposit(double depositAmount){
        try{
            //flag为true，有存款，存款方法阻塞
            if(flag){
                wait();
            }else {
                //flag为false，没有存款，存款者线程向下执行
                System.out.println(Thread.currentThread().getName() + "存钱" + depositAmount);
                balance += depositAmount;
                System.out.println("\t余额为： " + balance);
                flag = true;
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    /**
     * 提供一个线程安全的取钱方法(用同步锁)
     * @param drawAmount
     */
    public synchronized void drawLock(double drawAmount){
        //加锁
        lock.lock();
        try{
            if(balance > drawAmount){
                System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
                try {
                    Thread.sleep(1);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                //修改余额
                balance -= drawAmount;
                System.out.println("\t余额为： " + balance);
            }else {
                System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
            }
        }finally {
            //修改完成、释放锁
            lock.unlock();
        }
    }
}
