package com.ruge.test.多线程.隋唐演义;

/**
 * 爱丽丝、如歌  创建于 2018/6/11 14:39
 * 说明:  军队线程
 */
public class ArmyRunnable implements Runnable {
    /**
     * volatile 保证了线程可以正确的读取其他线程写入的值
     */
    public volatile boolean KeepRunning = true;
    @Override
    public void run() {
        while (KeepRunning) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "进攻对方[" + i + "]");
                /**
                 * 让出处理器时间 下次谁进攻待定
                 */
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "战争结束!");
    }
}
