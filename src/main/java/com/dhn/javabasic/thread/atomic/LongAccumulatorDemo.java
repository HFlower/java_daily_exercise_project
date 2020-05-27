package com.dhn.javabasic.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/27 10:51
 */
public class LongAccumulatorDemo {
    public static void main(String[] args) {
        LongAccumulator accumulator = new LongAccumulator((x, y) -> Math.max(x , y),0);
        accumulator.accumulate(1);
        ExecutorService service = Executors.newFixedThreadPool(8);
        IntStream.range(1,10).forEach(i -> service.submit(() -> accumulator.accumulate(i)));
        service.shutdown();
        while (!service.isTerminated()){

        }
        System.out.println(accumulator.getThenReset());
    }
}
