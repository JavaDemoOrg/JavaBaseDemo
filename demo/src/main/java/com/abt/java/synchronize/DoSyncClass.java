package com.abt.java.synchronize;

/**
 * @描述： @DoSyncClass
 * @作者： @黄卫旗
 * @创建时间： @2018/5/14
 */
public class DoSyncClass {

    public static void main(String[] args) {
        SyncMethod syncMethod = new SyncMethod();
        Thread thread1 = new Thread(syncMethod, "SyncMethod-1");
        Thread thread2 = new Thread(new SyncMethod(), "SyncMethod-2");
        thread1.start();
        thread2.start();
    }

    /** 同步线程 */
    static class SyncMethod implements Runnable {
        private static int count;

        public SyncMethod() {
            count = 0;
        }

        public static void method() {
            synchronized(SyncMethod.class) {
                for (int i = 0; i < 5; i ++) {
                    try {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + " : " + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void run() {
            method();
        }
    }

}
