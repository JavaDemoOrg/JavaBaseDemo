package com.abt.java.synchronize;

/**
 * @描述： @DoLockObject
 * @作者： @黄卫旗
 * @创建时间： @2018/5/14
 */
public class DoLockObject {

    public static void main(String[] args) {
        Account account = new Account("AI", 10000.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        final int THREAD_NUM = 5;
        Thread threads[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i ++) {
            threads[i] = new Thread(accountOperator, "Thread-" + i);
            threads[i].start();
        }
    }

    /**
     * 银行账户类
     */
    static class Account {
        String name;
        float amount;

        public Account(String name, float amount) {
            this.name = name;
            this.amount = amount;
        }

        public void deposit(float amt) { // 存钱
            amount += amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void withdraw(float amt) { // 取钱
            amount -= amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public float getBalance() {
            return amount;
        }
    }

    /**
     * 账户操作类
     */
    static class AccountOperator implements Runnable {
        private Account account;

        public AccountOperator(Account account) {
            this.account = account;
        }

        public void run() {
            synchronized (account) {
                account.deposit(5500);
                account.withdraw(500);
                System.out.println(Thread.currentThread().getName() + " : " + account.getBalance());
            }
        }
    }

    class Lock implements Runnable {
        private byte[] lock = new byte[0];  // 特殊的instance变量

        public void method() {
            synchronized(lock) {
                System.out.println("sync()");
            }
        }

        public void run() {
            System.out.println("run()");
        }
    }

}
