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
        //SleepThread thread = test.new SleepThread();
        //RunningThread thread = test.new RunningThread();
        InterruptableThread thread = test.new InterruptableThread();
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

    class RunningThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                System.out.println(++i+" while循环");
            }
        }
    }

    class InterruptableThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (!isInterrupted() && i<Integer.MAX_VALUE) {
                System.out.println(++i+" while循环");
            }
        }
    }

    /** 通过标志位来中断线程 */
    class FlagThread extends Thread {
        private volatile boolean isStop = false;
        @Override
        public void run() {
            int i = 0;
            while (!isStop) {
                i++;
            }
        }

        public void setStop(boolean stop) {
            this.isStop = stop;
        }
    }

}

