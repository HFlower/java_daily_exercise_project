package com.dhn.javabasic.exception;

/**
 * @description: 大型企业级应用中常用：catch和throw同时使用
 * @author: Dong HuaNan
 * @date: 2020/3/31 14:32
 */
public class AuctionTest {
    private double initPrice = 30.0;

    /**
     * 方法中显式抛出了异常，此处要声明异常
     * @param bidPrice
     * @throws AuctionException
     */
    public void bid(String bidPrice) throws AuctionException{
        double d = 0.0;
        try {
            d = Double.parseDouble(bidPrice);
        }catch (Exception e){
            //打印异常跟踪栈信息
            e.printStackTrace();
            //再次抛出异常
            //throw new AuctionException("竞拍价必须是数值，不能包含其他字符！");
            //异常链：原始异常记录下来
            throw new AuctionException(e);
        }
        if (initPrice > d){
            throw new AuctionException("竞拍价比起拍价低，不允许竞拍！");
        }

    }

    public static void main(String[] args) {
        AuctionTest ts = new AuctionTest();
        try{
            ts.bid("gg");
        }catch (AuctionException ae){
            //捕捉异常并处理
            System.out.println(ae.getMessage());
        }
    }
}
