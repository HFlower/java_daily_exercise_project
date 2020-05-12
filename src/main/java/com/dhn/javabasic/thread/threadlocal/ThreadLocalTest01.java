package com.dhn.javabasic.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/11 20:42
 */
public class ThreadLocalTest01 {
    public static void main(String[] args) {
        new Service1().process();
    }
}

class Service1{
    public void process(){
        User user = new User("花花");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }

}
class Service2{

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2获取的用户："+user.getName());

        UserContextHolder.holder.remove();
        User user1 = new User("小花");
        UserContextHolder.holder.set(user1);

        new Service3().process();
    }
}

class Service3{

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3获取的用户："+user.getName());
    }


}

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };
}

class UserContextHolder{
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

