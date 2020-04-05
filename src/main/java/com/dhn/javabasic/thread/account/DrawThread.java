package com.dhn.javabasic.thread.account;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/5 19:00
 */
public class DrawThread extends Thread{
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        synchronized (account){
            if(account.getBalance() > drawAmount){
                System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
                try {
                    Thread.sleep(1);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                //修改余额
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("\t余额为： " + account.getBalance());
            }else {
                System.out.println(getName() + "取钱失败！余额不足！");
            }
        }
    }
}
