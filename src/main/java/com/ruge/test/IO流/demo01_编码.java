package com.ruge.test.IO流;

import org.openxmlformats.schemas.drawingml.x2006.diagram.STOutputShapeType;

import java.io.UnsupportedEncodingException;

/**
 * 爱丽丝、如歌  创建于 2018/6/12 18:31
 * 说明:
 * UTF-8编码中，一个英文字符等于一个字节，一个中文（含繁体）等于三个字节
 * GBK编码中，一个英文等于两个字节，一个中文（含繁体）等于两个字节。
 */
public class demo01_编码 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String string = "ABC如歌";
        System.out.print(new String(string.getBytes(),"GBK")+" ");
        System.out.println();
        System.out.print(new String(string.getBytes(),"UTF-8")+" ");
        System.out.println();
        byte[] gbks = string.getBytes("gbk");
        for (byte gbk : gbks) {
            System.out.print(gbk+" ");
        }
        System.out.println("可以发现 gbk 的英文占用一个字节  中文占用两个字节");
        byte[] bytes = string.getBytes("UTF-8");
        for (byte aByte : bytes) {
            System.out.print(aByte+" ");
        }
        System.out.println("可以发现 utf-8英文占用一个字节  中文占用三个字节");
    }
}
