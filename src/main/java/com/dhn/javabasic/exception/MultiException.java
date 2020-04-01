package com.dhn.javabasic.exception;

/**
 * @description: java7新增多异常捕获
 * @author: Dong HuaNan
 * @date: 2020/3/31 10:13
 */
public class MultiException {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a/b;
            System.out.println("计算结果："+c);
        }catch (IndexOutOfBoundsException|NumberFormatException|ArithmeticException ie){
            System.out.println("程序发生数组越界、数字格式、算数异常之一");
            //捕获多异常时，异常变量默认有final修饰
//            ie = new ArithmeticException("test");
        }catch (Exception e){
            System.out.println("其他异常");
            //捕获一种异常时，异常变量没有final修饰
            e = new RuntimeException("test");
        }
    }
}
