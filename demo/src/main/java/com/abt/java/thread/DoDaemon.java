package com.abt.java.thread;

/**
 * @描述： @DoDaemon
 * @作者： @黄卫旗
 * @创建时间： @2018/5/15
 */
public class DoDaemon {

    public static void main(String[] args) {
        DoDaemon daemon = new DoDaemon();
        SleepThread runnable = daemon.new SleepThread();

        Thread daemonThread = new Thread(runnable, "DaemonThread");
        daemonThread.setDaemon(true); // 设置为守护进程
        daemonThread.start();

        String threadName = daemonThread.getName();
        boolean state = daemonThread.isDaemon();
        System.out.println(threadName + " --> isDaemon=" + state);

        //Thread userThread = new Thread(runnable, "UserThread");
        //userThread.start();
    }

    class SleepThread implements Runnable {
        public void run() {
            while (true) {
                for (int i = 1; i <= 100; i++) {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " --> "+ i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
