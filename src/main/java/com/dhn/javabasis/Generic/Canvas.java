package com.dhn.javabasis.Generic;

import java.util.List;

/**
 * @description: 类型通配符
 * @author: Dong HuaNan
 * @date: 2020/3/30 16:00
 */
public class Canvas {
    public void drawAll(List<? extends Shape> shapes){
        for (Shape s : shapes){
            s.draw(this);
        }
    }
}
