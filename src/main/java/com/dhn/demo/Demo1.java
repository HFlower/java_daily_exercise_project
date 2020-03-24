package com.dhn.demo;

/**
 * @description: 验证值传递与引用传递
 * @author: Dong HuaNan
 * @date: 2020/3/2 15:14
 */
public class Demo1 {


    public static void main(String[] args) {
        int e = 1;
        Entity entity = new Entity();
        entity.a = 10;
        System.out.println("e:"+ e+"///"+entity +"entity.a:"+entity.a);
        change(e,entity);
        System.out.println("e:"+ e+"///"+entity+"entity.a:"+entity.a);

    }

    public static void change(int e,Entity entity){
        //Java只有值传递，无论是对象还是基本类型，改变形参的值不会反应到实参上面去
        e = 0;
        entity.a = 100;
    }

}

class Entity{
    int a;
}

