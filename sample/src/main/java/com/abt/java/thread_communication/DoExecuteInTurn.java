package com.abt.java.thread_communication;

/**
 * @描述： @DoExecuteInTurn
 * @作者： @黄卫旗
 * @创建时间： @2018/5/15
 */
public class DoExecuteInTurn {

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        Thread threadA = new Thread(runnable, "ThreadA");
        Thread threadB = new Thread(runnable, "ThreadB");
        threadA.start();
        try {
            threadA.join(); // 关键
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }

    static class PrintRunnable implements Runnable {

        @Override
        public void run() {
            for (int i=0; i<3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName +" --> print:"+ (i+1));
            }
        }
    }
}
