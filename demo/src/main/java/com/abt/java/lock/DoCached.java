package com.abt.java.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by huangweiqi on 13/05/2018.
 */
public class DoCached {

    public static void main(String[] args) {
        final Cached ca = new Cached();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " " + ca.getS("key"));
                    System.out.println(threadName + " " + ca.cacheMap.entrySet());
                }
            }).start();
        }
    }

    /** 多线程实现缓存 */
    private static class Cached {
        volatile Map<String, String> cacheMap = new HashMap<String, String>();  // 加volatile关键字保证可见性。
        ReadWriteLock rwLock = new ReentrantReadWriteLock(); // 这个读写锁要定义在方法外面，使得每一个线程用的是同一个读写锁。
        public String getS(String key) { //如果定义在方法内部，就是跟方法栈有关的读写锁。这样可能不是同一个锁。
            rwLock.readLock().lock();
            String value = null;
            try {
                value = cacheMap.get(key);
                if (cacheMap.get(key) == null) { // 这里要重新获得key对应的value值
                    rwLock.readLock().unlock();
                    rwLock.writeLock().lock();
                    try {
                        if (cacheMap.get(key) == null) { // 这里也是
                            value = "(value is "+Thread.currentThread().getName()+")";
                            cacheMap.put(key, value);
                            System.out.println(Thread.currentThread().getName() + " put the value ::: " + value);
                        }
                    } finally {
                        rwLock.readLock().lock();       // 将锁降级，这里跟下一句的顺序不能反。
                        rwLock.writeLock().unlock();    // 关于这里的顺序问题，请查阅post中的说明。
                    }
                }
            } finally {
                rwLock.readLock().unlock();
            }
            return cacheMap.get(key);
        }
    }
}
