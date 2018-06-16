package com.ruge.test.commons.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 爱丽丝、如歌  创建于 2018/6/15 19:40
 * 说明:  移动文件
 */
public class MoveFile {


    @Test
    public void testMoveFile() throws IOException {
        String basePath = "d:/";
        File srcFile = new File(basePath + "b.txt");
        File destDir = new File(basePath + "move");
        FileUtils.moveToDirectory(srcFile, destDir, true);
    }
}
