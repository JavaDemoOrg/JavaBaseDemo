package com.abt.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangweiqi on 14/05/2018.
 */
public class DoLock {

    public static void main(String[] args) {
        SellTicket st = new SellTicket(); // 创建3个线程对象
        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");
        t1.start(); // 启动线程
        t2.start();
        t3.start();
    }

    static class SellTicket implements Runnable {
        private int ticket = 100;
        private Lock lock = new ReentrantLock();
        public void run() {
            while (true) {
                lock.lock();
                if (ticket > 10) { // 剩下10张不卖
                    try {
                        Thread.sleep(300); // 模拟售票
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + " 正在出售第" + (--ticket) + "张票");
                    lock.unlock();
                    try {
                        Thread.sleep((long) (Math.random() * 5000)); // 模拟售票间隙
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
