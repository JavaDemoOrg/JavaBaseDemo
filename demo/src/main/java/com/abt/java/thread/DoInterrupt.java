package com.abt.java.thread;

import java.io.IOException;

/**
 * @描述： @
 * @作者： @黄卫旗
 * @创建时间： @2018/5/15
 */
public class DoInterrupt {

    public static void main(String[] args) throws IOException {
        DoInterrupt test = new DoInterrupt();
        SleepThread thread = test.new SleepThread();
        thread.start();
        try {
            System.out.println("MainThread --> 进入睡眠状态");
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SleepThread --> 主动中断");
        thread.interrupt();
    }

    class SleepThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("SleepThread --> 进入睡眠状态");
                Thread.currentThread().sleep(10000);
                System.out.println("SleepThread --> 睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println("SleepThread --> 得到中断异常");
            }
            System.out.println("SleepThread --> run方法执行完毕");
        }
    }

}
