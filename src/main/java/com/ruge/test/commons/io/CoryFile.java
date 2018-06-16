package com.ruge.test.commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 爱丽丝、如歌  创建于 2018/6/15 19:27
 * 说明:  复制文件
 */
public class CoryFile {
    /**
     * 文件复制 覆盖原文件
     */
    @Test
    public void test1() throws IOException {
        File src = new File("abc.txt");
        File dest = new File("abcd.txt");
            FileUtils.copyFile(src, dest);
    }
    /**
     * 复制文件到文件夹
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        File src = new File("abc.txt");
        File dir = new File("D:\\");
        FileUtils.copyFileToDirectory(src, dir);
    }
    public void test3(){

    }
    /**
     * 复制文件到一个文件夹中
     */
    @Test
    public void testCopyFileToDir() {

        //   FileUtils.copyDirectory();
        //   FileUtils.copyDirectoryToDirectory();
        //   FileUtils.copyFileToDirectory();

        File src = new File("abc.txt");
        File dir = new File("D:\\");
        /**
         * /拷贝文件到某一路径
         */
        try {


            FileUtils.copyFile(new File("d:/aaa.txt"), new File("d:/ccc.txt"));

            //下载方式1
            URL url = new URL("http://www.baidu.com/img/baidu_logo.gif");
            File file = new File("/Users/jjs/Desktop/baidu1.gif");
            FileUtils.copyURLToFile(url, file);

            //下载方式2
            InputStream in = new URL("http://www.baidu.com/img/baidu_logo.gif").openStream();
            byte[] gif = IOUtils.toByteArray(in);
            FileUtils.writeByteArrayToFile(new File("/Users/jjs/Desktop/baidu2.gif"), gif);
            IOUtils.closeQuietly(in);

            //下载方式3
            InputStream in3 = new URL("http://www.baidu.com/img/baidu_logo.gif").openStream();
            byte[] gif3 = IOUtils.toByteArray(in3);
            IOUtils.write(gif3, new FileOutputStream(new File("/Users/jjs/Desktop/baidu3.gif")));
            IOUtils.closeQuietly(in3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

