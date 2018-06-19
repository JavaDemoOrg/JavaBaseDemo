package com.abt.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huangweiqi on 28/04/2018.
 * 总结：
 * 池中线程数量固定，不会发生变化
 * 使用无界的LinkedBlockingQueue，要综合考虑生成与消费能力，生成过剩，可能导致堆内存溢出。
 * 适用一些很稳定很固定的正规并发线程，多用于服务器
 */
public class DoFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for(int i = 0 ; i < 50 ; i++){
            pool.submit(new ThreadRunner((i + 1)));
        }
        pool.shutdown();
    }
}
