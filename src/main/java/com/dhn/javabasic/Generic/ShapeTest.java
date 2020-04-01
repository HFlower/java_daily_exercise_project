package com.dhn.javabasic.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/30 16:02
 */
public class ShapeTest {
    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        Canvas canvas = new Canvas();
        //方法为drawAll(List<Shape> shapes)时不能把List<Circle>当成List<Shape>使用,
        // 修改成drawAll(List<? extends Shape> shapes)即可
        canvas.drawAll(circleList);
    }
}
