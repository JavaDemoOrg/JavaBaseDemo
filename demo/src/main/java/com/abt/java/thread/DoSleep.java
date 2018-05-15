package com.abt.java.thread;

import java.io.IOException;

/**
 * @描述： @DoSleep
 * @作者： @黄卫旗
 * @创建时间： @2018/5/15
 */
public class DoSleep {

    private Object object = new Object();

    public static void main(String[] args) throws IOException {
        DoSleep test = new DoSleep();
        SleepThread thread1 = test.new SleepThread();
        SleepThread thread2 = test.new SleepThread();
        thread1.start();
        thread2.start();
    }

    class SleepThread extends Thread {
        @Override
        public void run() {
            synchronized(object) {
                try {
                    System.out.println(Thread.currentThread().getName()+" --> 进入睡眠状态");
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" --> 睡眠结束");
            }
        }
    }

    public void count(int num) throws ThreadException {
        if (num < 0) {
            throw new ThreadException();
        }
    }

    class ThreadException extends Exception {

    }

}
