package com.ruge.test.多线程.demo03_线程的比较;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 13:54
 * 说明:  TODO
 */
public class ThreadJDK8线程卖票  extends Thread {
    /**
     * 一共有100张火车票
     */
    static int count = 100;


    public static void main(String[] args) {
    Thread t1 =     new Thread(()->{
            while (count>0){
                count--;
                System.out.println(Thread.currentThread().getName()+"卖出了一张票,还剩"+count);
            }
        });
        Thread t2 =     new Thread(()->{
            while (count>0){
                count--;
                System.out.println(Thread.currentThread().getName()+"卖出了一张票,还剩"+count);
            }
        });
        Thread t3 =     new Thread(()->{
            while (count>0){
                count--;
                System.out.println(Thread.currentThread().getName()+"卖出了一张票,还剩"+count);
            }
        });
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}
