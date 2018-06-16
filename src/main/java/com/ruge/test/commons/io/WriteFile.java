package com.ruge.test.commons.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/15 19:30
 * 说明:  TODO
 */
public class WriteFile {
    /**
     * 文件的写入
     */
    @Test
    public void test1() throws IOException {
        FileUtils.write(new File("d:/aaa.txt"), "commons-io工具类", "UTF-8", false);
    }

    /**
     * 追缴方式写入原文件
     */
    public void test2() throws IOException {
        FileUtils.writeStringToFile(new File("d:/aaa.txt"), "作者：爱丽丝、如歌", "UTF-8", true);
    }

    /**
     * 写入多行
     */
    @Test
    public void test3() throws IOException {
        List<String> lines = new ArrayList<String>();
        lines.add("第一行");
        lines.add("第二行");
        FileUtils.writeLines(new File("d:/aaa.txt"), lines, true);
    }
}
