package com.abt.java.thread_concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @描述： @DoCountDownLatch
 * @作者： @黄卫旗
 * @创建时间： @2018/5/15
 */
public class DoCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);

        for (int i=0; i<2; i++) {
            Thread thread = new Thread(new Player(begin, end));
            thread.start();
        }

        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " --> the race begin!");
            begin.countDown();
            end.await();
            System.out.println(threadName + " --> the race end!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * 选手
 */
class Player implements Runnable {

    private CountDownLatch begin;
    private CountDownLatch end;

    Player(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    public void run() {
        try {
            begin.await();
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " --> arrived!");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
