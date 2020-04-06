package com.dhn.javabasic.thread.account;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 使用Condition控制线程通信
 * @author: Dong HuaNan
 * @date: 2020/4/6 12:55
 */
@Getter
@Setter
public class AccountLock {
    /**
     * 定义锁对象
     */
    private final Lock lock = new ReentrantLock();
    /**
     * 获得指定锁对象对应的condition
     */
    private final Condition condition = lock.newCondition();
    /**
     * 封装账户编号，余额两个成员变量
     */
    private String accountNo;
    private double balance;
    /**
     * 标识账户中是否已有存款的旗标(false时，账户没有存款)
     */
    private boolean flag = false;

    public AccountLock() {
    }

    public AccountLock(String accountNo, double balance) {
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
     * 取款
     * @param drawAmount
     */
    public void draw(double drawAmount){
        //显式的使用lock来充当同步监视器
        lock.lock();
        try{
            if(!flag){
                condition.await();
            }else {
                //flag为true，取钱者线程向下执行
                System.out.println(Thread.currentThread().getName() + "取钱" + drawAmount);
                balance -= drawAmount;
                System.out.println("\t余额为： " + balance);
                flag = false;
                condition.signalAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 存款
     * @param depositAmount
     */
    public void deposit(double depositAmount){
        lock.lock();
        try {
            if (flag){
                condition.await();
            }else {
                //flag为false，没有存款，存款者线程向下执行
                System.out.println(Thread.currentThread().getName() + "存钱" + depositAmount);
                balance += depositAmount;
                System.out.println("\t余额为： " + balance);
                flag = true;
                condition.signalAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
