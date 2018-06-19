package com.abt.java.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by huangweiqi on 13/05/2018.
 */
public class DoSemaphore {

    public static void main(String[] args) {
        System.out.println("Math.random() * 10000 = "+Math.random() * 10000);
        ExecutorService exec = Executors.newCachedThreadPool(); // 线程池
        final Semaphore semaphore = new Semaphore(5); // 只能5个线程同时访问
        for (int index = 0; index < 20; index++) { // 模拟20个客户端访问
            final int num = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire(); // 获取许可
                        System.out.println("Accessing: " + num);
                        Thread.sleep((long) (Math.random() * 10000));
                        semaphore.release(); // 访问完后，释放
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown(); // 退出线程池
    }
}
