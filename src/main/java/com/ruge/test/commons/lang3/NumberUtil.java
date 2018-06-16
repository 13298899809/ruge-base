package com.ruge.test.commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * 爱丽丝、如歌  创建于 2018/6/13 20:08
 * 说明:  数值工具类
 */
public class NumberUtil {
    @Test
    public void test1(){
        System.out.println("字符串转为数字，不能转的为0");
        System.out.println(NumberUtils.toInt("35"));
        System.out.println("从数组中选出最大值.");
        System.out.println(NumberUtils.max(new int[] { 1, 2, 3, 4 }));
        System.out.println("判断字符串是否全是整数.");
        System.out.println(NumberUtils.isDigits("123.1"));
        System.out.println("判断字符串是否是有效数字.");
        System.out.println(NumberUtils.isNumber("0123.1"));
    }
}
