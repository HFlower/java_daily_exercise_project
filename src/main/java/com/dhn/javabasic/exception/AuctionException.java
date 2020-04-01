package com.dhn.javabasic.exception;

/**
 * @description: 自定义异常类
 * @author: Dong HuaNan
 * @date: 2020/3/31 11:44
 */
public class AuctionException extends RuntimeException{

    public AuctionException() {
    }

    /**
     * 用于getMessage()
     * @param message
     */
    public AuctionException(String message) {
        super(message);
    }

    /**
     * cause为原始异常，可实现异常链
     * @param cause
     */
    public AuctionException(Throwable cause) {
        super(cause);
    }
}
