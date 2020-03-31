package com.dhn.javabasis.exception;

/**
 * @description: 自定义异常类
 * @author: Dong HuaNan
 * @date: 2020/3/31 11:44
 */
public class AuctionException extends RuntimeException{
    //两个构造器
    public AuctionException() {
    }
    //用于getMessage()
    public AuctionException(String message) {
        super(message);
    }
}
