package com.abt.java.synchronize;

/**
 * @描述： @DoSyncThread
 * @作者： @黄卫旗
 * @创建时间： @2018/5/14
 */
public class DoSyncThread {

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread-1");
        Thread thread2 = new Thread(syncThread, "SyncThread-2");
        thread1.start();
        thread2.start();

        /*Thread thread1 = new Thread(new SyncThread(), "SyncThread-1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread-2");
        thread1.start();
        thread2.start();*/
    }

    /**
     * 同步线程
     */
    static class SyncThread implements Runnable {
        private static int count;

        public SyncThread() {
            count = 0;
        }

        public  void run() {
            synchronized(this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": " + (count++));
                        Thread.sleep(100); // 特意添加的间隙
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
