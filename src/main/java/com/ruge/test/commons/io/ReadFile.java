package com.ruge.test.commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/6/15 19:30
 * 说明:  TODO
 */
public class ReadFile {

    /**
     * 文件的读取
     */
    @Test
    public void test1() {
        try {
            System.out.println(FileUtils.readFileToString(new File("d:/aaa.txt"), "UTF-8"));
            System.out.println(FileUtils.readLines(new File("d:/aaa.txt"), "UTF-8")); //返回一个list
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * url的读取
     */
    @Test
    public void read2() throws IOException {
        URL webUrl = new URL("http://www.9dxs.com/1/1071/6473674.html");
        InputStream ins = webUrl.openStream();
        String contents = IOUtils.toString(ins, "GBK");
        System.out.println("contents: " + contents);
    }

    /**
     * 逐行读取文件
     */
    @Test
    public void test3() throws IOException {
        File file = new File("D:\\workspace\\j2ee\\mycommon\\src\\com\\commons\\io\\abc.txt");
        List<String> strings = FileUtils.readLines(file, "UTF-8");
        for (String s : strings
                ) {
            System.out.println(s);
        }
    }
}
