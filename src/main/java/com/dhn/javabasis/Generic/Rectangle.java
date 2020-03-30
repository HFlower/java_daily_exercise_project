package com.dhn.javabasis.Generic;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/30 15:59
 */
public class Rectangle extends Shape{
    @Override
    public void draw(Canvas c) {
        System.out.println("把一个矩形画在画布"+c+"上");
    }
}
