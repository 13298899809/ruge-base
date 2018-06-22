package com.ruge.test.springMVC.常用注解.JDK自带注解;

/**
 * 爱丽丝、如歌  创建于 2018/6/21 18:25
 * 说明:  TODO
 */
public class 可变长参数 {
    @SafeVarargs
    public static <T> void print(T... t){
        for (T i:t
             ) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        print(1,2,3,"222");
    }
}
