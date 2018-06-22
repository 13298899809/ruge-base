package com.ruge.test.多线程.demo03_线程的比较;

import org.junit.Test;

/**
 * 爱丽丝、如歌  创建于 2018/6/18 13:17
 * 说明:  TODO
 */

public class 线程的两种创建方式 {
    class Thread启动 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread启动");
        }
    }

    class Runnable启动 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable启动");
        }
    }

    @Test
    public void test1() {
        Thread启动 thead启动 = new Thread启动();
        thead启动.start();
    }

    @Test
    public void test2() {
        Runnable启动 runnable启动 = new Runnable启动();
        Thread thread = new Thread(runnable启动);
        thread.start();
    }

    @Test
    public void test3() {
       new Thread(()->{
           System.out.println("lambda thread1 run********");
           System.out.println("lambda thread2 run********");
       }).start();
    }

    @Test
    public void test4() {
        Runnable r1 = () -> {
            System.out.println("Hello Lambda!");
        };
        r1.run();
    }
}
