package com.ruge.test.多线程.demo01_volatile;

/**
 * 爱丽丝、如歌  创建于 2018/6/12 8:45
 * 说明:  volatile关键字
 * run();  只是调用了一个普通方法，并没有启动另一个线程，程序还是会按照顺序执行相应的代码。
 * start();  则表示，重新开启一个线程，不必等待其他线程运行完，只要得到cup就可以运行该线程。
 */
public class TestVolatile implements Runnable {

    private volatile   boolean flag = false;

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;

        System.out.println("flag=" + flag);

    }


    public static void main(String[] args) {

        TestVolatile testVolatile = new TestVolatile();
        new Thread(testVolatile).start();
        /**
         * 由于内存可见性  当多个线程操作共享数据时  彼此不可见
         * 解决方式1 添加同步锁
         *       使用同步锁的缺点: 效率低
         *     while (true) {
         *             synchronized (testVolatile) {
         *                 if (testVolatile.flag) {
         *                     System.out.println("==========================" + testVolatile.flag);
         *                     break;
         *                 }
         *             }
         *         }
         * 解决方式2 volatile 关键字
         *      当多个线程同时操作共享数据时,可以保证内存中数据可见.
         *      private volatile   boolean flag = false;
         *       while (true) {
         *                 if (testVolatile.flag) {
         *                     System.out.println("==========================" + testVolatile.flag);
         *                     break;
         *                 }
         *         }
         *         volatile 缺点
         *                  1 不具备互斥性
         *                  2 不能保证变量的原子性
         */

        while (true) {
                if (testVolatile.flag) {
                    System.out.println("==========================" + testVolatile.flag);
                    break;
                }
        }
        //  testVolatile.run();


    }
}
