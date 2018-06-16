package com.ruge.test.commons.lang3;

import org.apache.commons.lang3.CharSetUtils;
import org.junit.Test;

/**
 * 爱丽丝、如歌  创建于 2018/6/13 19:53
 * 说明:  字符集工具类
 */
public class CharSetUtil {
    @Test
    public void test() {
        System.out.println("**CharSetUtilsDemo**");
        System.out.println("计算字符串中包含某字符数.");
        System.out.println(CharSetUtils.count("The quick brown fox jumps over the lazy dog.",
                "aeiou"));
        System.out.println("删除字符串中某字符.");
        System.out.println(CharSetUtils.delete("The quick brown fox jumps over the lazy dog.",
                "aeiou"));
        System.out.println("保留字符串中某字符.");
        System.out.println(CharSetUtils.keep("The quick brown fox jumps over the lazy dog.",
                "aeiou"));
        System.out.println("合并重复的字符.");
        System.out.println(CharSetUtils.squeeze("a bbbbbb c dd", "b d"));
    }
}
