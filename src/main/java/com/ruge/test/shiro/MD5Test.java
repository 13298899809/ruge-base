package com.ruge.test.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * 爱丽丝、如歌  创建于 2018/5/25 13:28
 * 说明:  TODO
 */
public class MD5Test {
    @Test
    public void testMD5() {
        String password = "123";
        /**
         * 加密 md5
         */
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println("加密 md5:"+md5Hash);
        /**
         * 加密 md5 + 盐
         */
        Md5Hash md5Hash1 = new Md5Hash(password, "张三");
        System.out.println("加密 md5 + 盐:"+md5Hash1);
        /**
         * 加密 md5 + 盐 + 散列排序
         */
        Md5Hash md5Hash2 = new Md5Hash(password, "zhang", 9527);
        System.out.println("加密 md5 + 盐 + 散列排序:"+md5Hash2);


    }
}
