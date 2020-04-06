package com.dhn.javabasic.thread;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/4/5 20:31
 */
public class DeadLock extends Thread{
    A a = new A();
    B b = new B();
    public void init(){
        Thread.currentThread().setName("主线程");
        //调用a对象的foo()方法
        a.foo(b);
        System.out.println("进入主线程之后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入副线程之后");
    }

    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        new Thread(d).start();
        d.init();
    }
}

class A {
    public synchronized void foo(B b){
        System.out.println("当前线程名：" + Thread.currentThread().getName() +" 进入了A实例的foo（）方法");
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() +" 企图调用B实例的last()方法");
        b.last();
    }
    public synchronized void last(){
        System.out.println("进入了A类的last()方法内部");
    }

}

class B{

    public synchronized void bar(A a){
        System.out.println("当前线程名：" + Thread.currentThread().getName() +" 进入了B实例的bar（）方法");
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() +" 企图调用A实例的last()方法");
        a.last();
    }
    public void last() {
        System.out.println("进入了B类的last()方法内部");
    }
}
