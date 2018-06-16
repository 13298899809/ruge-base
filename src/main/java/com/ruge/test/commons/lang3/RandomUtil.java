package com.ruge.test.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * 爱丽丝、如歌  创建于 2018/6/13 20:09
 * 说明:  随机字符串工具类
 */
public class RandomUtil {
    @Test
    public void randomStringUtilsDemo() {
        System.out.println("**RandomStringUtilsDemo**");
        System.out.println("生成指定长度的随机字符串");
        System.out.println(RandomStringUtils.random(500));
        System.out.println("在指定字符串中生成长度为n的随机字符串.");
        System.out.println(RandomStringUtils.random(5, "abcdefghijk"));
        System.out.println("指定从字符或数字中生成随机字符串(验证码可以用).");
        System.out.println(RandomStringUtils.random(5, true, false));
        System.out.println(RandomStringUtils.random(5, false, true));
        System.out.println(RandomStringUtils.random(5, true, true));
    }
}
