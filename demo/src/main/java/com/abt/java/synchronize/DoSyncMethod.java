package com.abt.java.synchronize;

/**
 * @描述： @DoSyncMethod
 * @作者： @黄卫旗
 * @创建时间： @2018/5/14
 */
public class DoSyncMethod {

    public static void main(String[] args) {
        SyncMethod syncMethod = new SyncMethod();
        syncMethod.run();

        AutoSync autoSync = new AutoSync();
        Thread threadA = new Thread(autoSync);
        threadA.start();
        Thread threadB = new Thread(autoSync);
        threadB.start();
    }

    static class SyncMethod implements Runnable {
        private int count;

        public /*synchronized*/ SyncMethod() {
            synchronized (this) {
                System.out.println("synchronized可以修饰内部代码块，但不能修饰构造方法");
            }
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 5; i ++) {
                try {
                    Thread.sleep(100);
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " : " + (count++));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** 非同步方法，调用同步父类方法，可实现同步 */
    static class AutoSync extends SyncMethod {
        @Override
        public void run() {
            super.run();
        }
    }

    /** 不能用synchronized修饰接口和接口方法 */
    interface SyncInterface {
        void sync();
    }

}
