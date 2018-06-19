package com.abt.java.lock;

/**
 * @描述： @DoDeadLock
 * @作者： @黄卫旗
 * @创建时间： @2018/5/14
 * @描述：
 * LockA获取objA，LockB获取objB，
 * 但是它们都没有办法再获取另外一个obj，
 * 因为它们都在等待对方先释放锁，这时就是死锁。
 */
public class DoDeadLock {
    public static String objA = "objA";
    public static String objB = "objB";
    public static void main(String[] args) {
        Thread threadA = new Thread(new LockA());
        Thread threadB = new Thread(new LockB());
        threadA.start();
        threadB.start();
    }
}

class LockA implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("LockA running");
            while (true) {
                synchronized(DoDeadLock.objA) {
                    System.out.println("LockA lock objA");
                    Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                    synchronized(DoDeadLock.objB) {
                        System.out.println("LockA lock objB");
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class LockB implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("LockB running");
            while(true) {
                synchronized(DoDeadLock.objB) {
                    System.out.println("LockB lock objB");
                    Thread.sleep(3000);
                    synchronized(DoDeadLock.objA) {
                        System.out.println("LockB lock objA");
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

