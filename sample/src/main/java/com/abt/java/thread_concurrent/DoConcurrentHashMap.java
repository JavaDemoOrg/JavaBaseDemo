package com.abt.java.thread_concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @描述： @DoConcurrentHashMap
 * @作者： @黄卫旗
 * @创建时间： @2018/5/15
 */
public class DoConcurrentHashMap {

    static final Map<String, AtomicInteger> count = new ConcurrentHashMap<>();
    static final CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] arg) {
        DoConcurrentHashMap map = new DoConcurrentHashMap();
        Runnable runnable = map.new CountRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        try {
            latch.await();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class CountRunnable implements Runnable {
        @Override
        public void run() {
            AtomicInteger oldValue;
            for (int i = 0; i < 5; i++) {
                oldValue = count.get("a");
                if (null == oldValue) {
                    AtomicInteger zeroValue = new AtomicInteger(0);
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " --> putIfAbsent()");
                    oldValue = count.putIfAbsent("a", zeroValue);
                    if (null == oldValue) {
                        oldValue = zeroValue;
                    }
                }
                oldValue.incrementAndGet();
            }
            latch.countDown();
        }
    }

}
