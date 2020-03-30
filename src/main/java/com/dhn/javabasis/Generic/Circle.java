package com.dhn.javabasis.Generic;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/30 15:58
 */
public class Circle extends Shape {
    @Override
    public void draw(Canvas c) {
        System.out.println("在画布"+c+ "上画一个圆");
    }
}
