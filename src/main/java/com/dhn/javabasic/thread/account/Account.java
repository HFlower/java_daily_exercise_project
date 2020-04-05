package com.dhn.javabasic.thread.account;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/5 18:54
 */
@Getter
@Setter
public class Account {
    /**
     * 封装账户编号，余额两个成员变量
     */
    private String accountNo;
    private double balance;

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
}
