package com.ruge.test.多线程.demo03_线程的比较;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 13:38
 * 说明:
 */
public class Thread线程卖票未同步 extends Thread {
    /**
     * 一共有100张火车票
     */
    private int count = 100;

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println(Thread.currentThread().getName()+"卖了一张票,剩余 "+count+" 张");
        }
    }

    public static void main(String[] args) {
        /**
         * 创建三个线程  模拟窗口卖票
         */
        Thread线程卖票未同步 t1 = new Thread线程卖票未同步();
        Thread线程卖票未同步 t2 = new Thread线程卖票未同步();
        Thread线程卖票未同步 t3 = new Thread线程卖票未同步();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
