package com.dhn.test;

import java.util.*;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/13 17:41
 */
public class Demo {

    public static void main(String[] args) {
        int n = 4;
        for (int i = 1;i <= n; i++){
            for (int k = 1; k <=n-i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
