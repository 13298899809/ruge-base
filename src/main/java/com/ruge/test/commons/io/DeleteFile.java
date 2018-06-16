package com.ruge.test.commons.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 爱丽丝、如歌  创建于 2018/6/15 19:27
 * 说明:  删除文件
 */
public class DeleteFile {
    /**
     * 文件的删除
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        File file = new File("d:/aaa.txt");
        if (!file.exists()) {
            file.createNewFile();
            FileUtils.deleteDirectory(file);
        }
    }

    /**
     * 文件夹的删除
     */
    @Test
    public void test2() throws IOException {
        FileUtils.deleteDirectory(new File("d:/test"));
    }
    @Test
    public void test3() throws IOException {
        File file = new File( ("D:\\workspace\\j2ee\\mycommon\\src\\com\\commons\\io\\abcd.txt") );
        FileUtils.forceDelete(file);
    }

}
