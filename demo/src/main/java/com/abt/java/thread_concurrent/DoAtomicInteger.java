package com.abt.java.thread_concurrent;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @描述： @DoAtomicInteger TODO
 * @作者： @黄卫旗
 * @创建时间： @2018/5/15
 */
public class DoAtomicInteger {

    final File rootFile = new File("D:\\ISO");
    final File exitFile = new File(""); // 完成标志
    final BlockingQueue<File> queue = new LinkedBlockingQueue<File>(100); // 阻塞队列，能容纳100个文件

    /** AtomicInteger可以在并发情况下达到原子化更新，避免使用了synchronized，性能高。*/
    final AtomicInteger readCount = new AtomicInteger(); // 原子整型，读个数
    final AtomicInteger writeCount = new AtomicInteger(); // 原子整型，写个数

    static long randomTime() {
        return (long) (Math.random() * 1000);
    }

    public static void main(String[] args) {
        DoAtomicInteger doAtomicInteger = new DoAtomicInteger();
        final ExecutorService exec = Executors.newFixedThreadPool(5); // 线程池

        Runnable read = doAtomicInteger.new ReadRunnable(); // 读线程
        exec.submit(read); // submit方法提交一个Runnable任务用于执行，并返回一个表示该任务的Future

        for (int index = 0; index < 4; index++) { // 四个写线程
            Runnable write = doAtomicInteger.new WriteRunnable(index);
            exec.submit(write);
        }
        exec.shutdown();
    }

    class ReadRunnable implements Runnable {
        public void run() {
            scanFile(rootFile);
            scanFile(exitFile);
        }

        public void scanFile(File file) {
            if (file.isDirectory()) {
                File[] files = file.listFiles(new FileFilter() {
                    public boolean accept(File pathname) {
                        return pathname.isDirectory() || pathname.getPath().endsWith(".iso");
                    }
                });
                for (File one : files)
                    scanFile(one);
            } else {
                try {
                    // 原子整型的incrementAndGet方法，以原子方式将当前值加 1，返回更新的值
                    int index = readCount.incrementAndGet();
                    System.out.println("Read0: " + index + " " + file.getPath());
                    // 添加到阻塞队列中
                    queue.put(file);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    class WriteRunnable implements Runnable {

        private String threadName = null;

        public WriteRunnable(int index) {
            threadName = "Write" + index;
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(randomTime());
                    int index = writeCount.incrementAndGet(); // incrementAndGet方法，以原子方式将当前值加1，返回更新的值
                    File file = queue.take(); // 获取并移除此队列的头部，在元素变得可用之前一直等待（如果有必要）。
                    if (file == exitFile) { // 队列已经无对象
                        queue.put(exitFile); // 再次添加"标志"，以让其他线程正常退出
                        break;
                    }
                    System.out.println(threadName + ": " + index + " " + file.getPath());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
