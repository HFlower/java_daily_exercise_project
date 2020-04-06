package com.dhn.javabasic.thread;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/6 19:44
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        //启动两个线程，公用一个账户
        Account at = new Account("初始名");
        //每个线程都有各自账户名的副本，i=6后两个线程访问同一个账户时出现不同的账户名
        new MyTest("线程甲",at).start();
        new MyTest("线程乙",at).start();

    }
}
class Account{
    /**
     * 定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量
     */
    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String name) {
        this.name.set(name);
        //访问当前线程的name副本的值
        System.out.println("-------" + this.name.get());
    }
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
class MyTest extends Thread{
    private Account account;

    public MyTest(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 6){
                //设置账户名替换成当前线程名
                account.setName(getName());
            }
            System.out.println(account.getName() + " 账户i的值：" + i);
        }
    }
}
