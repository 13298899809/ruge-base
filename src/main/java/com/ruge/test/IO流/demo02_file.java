package com.ruge.test.IO流;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/12 19:07
 * 说明:  TODO
 */
public class demo02_file {
    @Test
    public void test1() {
        File file = new File("d:");
        String[] list = file.list();
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("文件遍历结束");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.print(file1 + " ");
        }
        System.out.println("文件路径遍历结束");

        System.out.println();
    }
}
