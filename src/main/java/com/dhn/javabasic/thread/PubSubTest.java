//package com.dhn.javabasic.thread;
//
//import org.reactivestreams.Publisher;
//import org.reactivestreams.Subscriber;
//import org.reactivestreams.Subscription;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * @description:
// * @author: Dong HuaNan
// * @date: 2020/4/6 20:31
// */
//public class PubSubTest {
//    public static void main(String[] args) {
//        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
//        MySubscriber<String> subscriber = new MySubscriber<>();
//        //注册订阅者
//        publisher.subscribe(subscriber);
//        //发布几个数据项
//        System.out.println("开始发布数据…………");
//        List<String> list = new ArrayList<>();
//        list.add("java");
//        list.add("spring");
//        list.add("Go");
//        list.add("C++");
//        List.of("java","spring","Go","C++").forEach()
//        list.forEach(im -> {
//            //提交数据
//            publisher.submit(im);
//            try{
//                Thread.sleep(500);
//            }catch (Exception e){
//
//            }
//        });
//        System.out.println("发布结束");
//        publisher.close();
//        synchronized ("fkJava"){
//            try {
//                "fkJava".wait();
//            }catch (Exception e){
//
//            }
//        }
//    }
//}
//class MySubscriber<T> implements Subscriber{
//    /**
//     * 发布者和订阅者之间的纽带
//     */
//    private Subscription subscription;
//
//    /**
//     * 订阅时触发该方法
//     * @param subscription
//     */
//    @Override
//    public void onSubscribe(Subscription subscription) {
//        this.subscription = subscription;
//        //开始请求数据
//        subscription.request(1);
//    }
//
//    /**
//     * 接受数据时触发该方法
//     * @param o
//     */
//    @Override
//    public void onNext(Object o) {
//        System.out.println("获取到的数据：" + o);
//        //请求下一条数据
//        subscription.request(1);
//    }
//
//    /**
//     * 订阅出错时触发
//     * @param throwable
//     */
//    @Override
//    public void onError(Throwable throwable) {
//        throwable.printStackTrace();
//        synchronized ("fkJava"){
//            "fkJava".notifyAll();
//        }
//    }
//
//    /**
//     * 订阅结束时触发
//     */
//    @Override
//    public void onComplete() {
//        System.out.println("订阅结束");
//        synchronized ("fkJava"){
//            "fkJava".notifyAll();
//        }
//
//    }
//}
