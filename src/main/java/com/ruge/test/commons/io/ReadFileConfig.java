package com.ruge.test.commons.io;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 爱丽丝、如歌  创建于 2018/6/15 19:28
 * 说明:  读取文件配置
 */
public class ReadFileConfig {
    /**
     * 读取文件夹的大小
     */
    @Test
    public void testSizeOfDirectory() {
        File file = new File("d:");
        long size = FileUtils.sizeOfDirectory(file);
        System.out.println(size);
    }

    /**
     * 读取文件大小
     */
    @Test
    public void testFileSize() {
        File file = new File("D:\\9C4JPR0QO0.txt");
        long size = FileUtils.sizeOf(file);
        System.out.println(size);
    }

    /**
     * 获取磁盘空余空间
     */
    @Test
    public void testFreeSpace() throws IOException {
        // 以字节为单位
        System.out.println(FileSystemUtils.freeSpace("c:\\") / 1024 / 1024 / 1024);
        System.out.println(FileSystemUtils.freeSpace("d:\\") / 1024 / 1024 / 1024);
        // 以k为单位
        System.out.println(FileSystemUtils.freeSpaceKb("e:\\") / 1024 / 1024);
        System.out.println(FileSystemUtils.freeSpaceKb("f:\\") / 1024 / 1024);
    }
}
