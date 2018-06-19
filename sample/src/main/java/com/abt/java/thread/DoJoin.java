package com.abt.java.thread;

import java.io.IOException;

/**
 * @描述： @DoJoin
 * @作者： @黄卫旗
 * @创建时间： @2018/5/15
 */
public class DoJoin {

    public static void main(String[] args) throws IOException {
        System.out.println("进入线程" + Thread.currentThread().getName());
        DoJoin test = new DoJoin();
        SleepThread thread = test.new SleepThread();
        thread.start();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "等待");
            thread.join();
            System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class SleepThread extends Thread {
        @Override
        public void run() {
            System.out.println("进入线程" + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
        }
    }

}
