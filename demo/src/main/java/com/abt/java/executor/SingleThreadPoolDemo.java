package com.abt.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huangweiqi on 28/04/2018.
 * 总结：
 * 线程中只有一个线程在执行
 * 适用于有明确执行顺序但是不影响主线程的任务，压入池中的任务会按照队列顺序执行。
 * 使用无界的LinkedBlockingQueue，要综合考虑生成与消费能力，生成过剩，可能导致堆内存溢出。
 */
public class SingleThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for(int i = 0 ; i < 50 ; i++){
            pool.submit(new ThreadRunner((i + 1)));
        }
        pool.shutdown();
    }
}
