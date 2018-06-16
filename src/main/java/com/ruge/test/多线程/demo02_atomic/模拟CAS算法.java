package com.ruge.test.多线程.demo02_atomic;

/**
 * 爱丽丝、如歌  创建于 2018/6/12 11:51
 * 说明:  TODO
 */
public class 模拟CAS算法 {
    private int value;

    /**
     * 获取内存值
     */
    private synchronized int get() {
        return value;
    }

    /**
     * 比较
     */
    private synchronized int compareAndSwap(int expValue, int newValue) {
        int oldValue = value;
        if (oldValue == expValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    private synchronized boolean compareAndSet(int expValue, int newValue) {
        return expValue == compareAndSwap(expValue, newValue);
    }

    public static void main(String[] args) {
        模拟CAS算法 cas = new 模拟CAS算法();
        for (int i = 0; i <10 ; i++) {
            int finalI = i;
            Runnable runnable =() ->{
                int i1 = cas.get();
                boolean b = cas.compareAndSet(i1, (int) Math.random() * 1000);
                System.out.println(b);
            };
            runnable.run();
        }
    }
}
