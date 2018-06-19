package com.abt.java.synchronize;

/**
 * @描述： @DoUnSyncThread
 * @作者： @黄卫旗
 * @创建时间： @2018/5/14
 */
public class DoUnSyncThread {

    private static final String threadA = "unSyncThread-A";
    private static final String threadB = "unSyncThread-B";

    public static void main(String[] args) {
        UnSyncThread unsyncThread = new UnSyncThread();
        Thread thread1 = new Thread(unsyncThread, threadA);
        Thread thread2 = new Thread(unsyncThread, threadB);
        thread1.start();
        thread2.start();
    }

    static class UnSyncThread implements Runnable {
        private int count;

        public UnSyncThread() {
            count = 0;
        }

        public void countAdd() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(100);
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": " + (count++));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //非synchronized代码块，未对count进行写操作，所以可以不用synchronized
        public void printCount() {
            for (int i = 0; i < 5; i++) {
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " count = " + count);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            if (threadName.equals(threadA)) {
                countAdd();
            } else if (threadName.equals(threadB)) {
                printCount();
            }
        }
    }

}
