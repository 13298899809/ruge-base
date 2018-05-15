package com.ruge.test.日志.log4j;

import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-11  22:29
 * 描述 ：
 */
public class TestController {
    private static Logger logger=Logger.getLogger(Test.class); // 获取logger实例
    @Test
    public void testLog() {
        logger.info("输入logger的info信息1");
    }
}
