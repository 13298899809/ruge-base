package com.ruge.test.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 爱丽丝、如歌  创建于 2018/6/13 19:59
 * 说明:  字符串工具类
 */
public class StringUtil {
    @Test
    public void test1() {
        System.out.println("https://blog.csdn.net/psh18513234633/article/details/79063158");
        System.out.println("commons-lang3工具类学习（三）");
        //StringUtils.isEmpty(String str) 字符串空判断
        System.out.println("==========isEmpty============");
        System.out.println(StringUtils.isEmpty(null));//true
        System.out.println(StringUtils.isEmpty(""));  //true
        System.out.println(StringUtils.isEmpty(" "));//false
        System.out.println(StringUtils.isEmpty("    "));//false
        System.out.println(StringUtils.isEmpty("abc"));//false
        System.out.println(StringUtils.isEmpty(" abc "));//false
    }

    @Test
    public void test2() {
        //StringUtils.isBlank(String str) 判断字符串是否为空和空字符
        System.out.println("==========isBlank============");
        System.out.println(StringUtils.isBlank(null));//true
        System.out.println(StringUtils.isBlank(""));//true
        System.out.println(StringUtils.isBlank(" "));//true
        System.out.println(StringUtils.isBlank("   "));//true
        System.out.println(StringUtils.isBlank("\n\t"));//true
        System.out.println(StringUtils.isBlank("abc"));//false
        System.out.println(StringUtils.isBlank(" abc "));//false
    }

    @Test
    public void test3() {
        //StringUtils.trim(String str) 参数为null则返回null否则去头和尾的空格
        System.out.println("==========trim============");
        System.out.println(StringUtils.trim(null));//null
        System.out.println(StringUtils.trim(""));//""
        System.out.println(StringUtils.trim("   "));//""
        System.out.println(StringUtils.trim("abc"));//"abc"
        System.out.println(StringUtils.trim("   abc   "));//"abc"
        System.out.println(StringUtils.trim("   a b c   "));//"a b c"  
    }

    @Test
    public void test4() {
        System.out.println("==========indexOf============");
        System.out.println(StringUtils.indexOf(null, "a"));//-1
        System.out.println(StringUtils.indexOf("", "a"));//-1
        System.out.println(StringUtils.indexOf("abcda", "a"));//0
        System.out.println(StringUtils.indexOf("abcda", "a", 2));//4
    }

    @Test
    public void test5() {
        System.out.println("abbreviate(String str, int maxWidth) 返回一个指定长度加省略号的字符串，maxWidth必须大于3");
        System.out.println(StringUtils.abbreviate("", 4)); // null
        System.out.println(StringUtils.abbreviate("abcdefg", 6)); //abc...
        System.out.println(StringUtils.abbreviate("abcdefg", 8)); //abcdefg
        System.out.println(StringUtils.abbreviate("abcdefg", 4)); //a...
        //  System.out.println(StringUtils.abbreviate("abcdefg", 3)); //Minimum abbreviation width is 4
        System.out.println(StringUtils.abbreviate("abcdefg", "=", 4)); //abc=
        System.out.println(StringUtils.abbreviateMiddle("abcdef", ".", 4));//ab.f
    }

    @Test
    public void test6() {
        System.out.println("compare(String str1, String str2) 比较两个字符串，返回一个int值");
        System.out.println(StringUtils.compare(null, null)); //0
        System.out.println(StringUtils.compare(null, "a")); //-1
        System.out.println(StringUtils.compare("a", null)); //1
        System.out.println(StringUtils.compare("abc", "abc"));//0
        System.out.println(StringUtils.compare("a", "b")); //-1
        System.out.println(StringUtils.compare("b", "a")); //1
        System.out.println(StringUtils.compare("a", "B")); //31
        System.out.println(StringUtils.compare("ab", "abc")); //-1
    }
    @Test
    public void test7() {
        System.out.println("join(byte[] array, char separator) 将字节数组转换成string，以指定字符分隔");
        String[] str = {"1","2","3","4"};
        System.out.println(StringUtils.join(str, "|"));
        System.out.println(StringUtils.join(str, ";"));
        System.out.println(StringUtils.join(str, "="));
    }

    @Test
    public void test8() {
        System.out.println("replace(String text, String searchString, String replacement) ");
        System.out.println(StringUtils.replace("aba", "a", ""));
        System.out.println(StringUtils.replace("aba", "a", "z"));
    }

    @Test
    public void test9() {
        System.out.println("reverse(String str) 将字符串反转，返回一个string");
        System.out.println(StringUtils.reverse(null));
        System.out.println(StringUtils.reverse(""));
        System.out.println(StringUtils.reverse("bat"));
    }

    @Test
    public void test10() {
        System.out.println("trimToEmpty(String str) 去除字符串空格，null转为empty，返回一个string");
        System.out.println(StringUtils.trimToEmpty(null));
        System.out.println(StringUtils.trimToEmpty(""));
        System.out.println(StringUtils.trimToEmpty("     "));
        System.out.println(StringUtils.trimToEmpty("abc"));
        System.out.println(StringUtils.trimToEmpty("    abc    "));
    }

    @Test
    public void test11() {
        // 删除空格
        System.out.println(StringUtils.deleteWhitespace(" abc d "));
        // 代替字符串中的字符
        System.out.println(StringUtils.replaceChars("abc", 'a', 'b'));
        // 只包含数字
        System.out.println("是否是数字:" + StringUtils.isNumeric("12"));
        // 只包含字母和汉字
        System.out.println(StringUtils.isAlpha("abc#$"));
        // 删除指定的字符
        System.out.println(StringUtils.remove("abc", 'b'));
        // 重复30次
        System.out.println(StringUtils.repeat("=", 30));
    }
}
