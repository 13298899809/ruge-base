package com.ruge.test.多线程.demo03_线程的比较;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 14:07
 * 说明:  TODO
 */
public class Rnnnable方式卖票未同步 implements Runnable {
    /**
     * 一共有100张火车票
     */
    private int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println(Thread.currentThread().getName() + "卖了一张票,剩余 " + count + " 张");
        }
    }

    public static void main(String[] args) {
        /**
         * 创建三个线程  模拟窗口卖票
         */
        Rnnnable方式卖票未同步 rnnnable方式卖票未同步 = new Rnnnable方式卖票未同步();

        Thread thread1 = new Thread(rnnnable方式卖票未同步);
        Thread thread2 = new Thread(rnnnable方式卖票未同步);
        Thread thread3 = new Thread(rnnnable方式卖票未同步);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
