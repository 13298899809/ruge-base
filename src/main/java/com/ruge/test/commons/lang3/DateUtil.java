package com.ruge.test.commons.lang3;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

import java.util.Date;

/**
 * 爱丽丝、如歌  创建于 2018/6/13 20:03
 * 说明:  TODO
 */
public class DateUtil {
    @Test
    public void test1(){
        String pattern = "yyyy-MM-dd";
        //格式化输出
        System.out.println(DateFormatUtils.format(new Date(), pattern));
        // 向后加5天
        Date d1 = DateUtils.addDays(new Date(), 5);
        Date d2 = DateUtils.addMonths(new Date(), 7);
        System.out.println(DateFormatUtils.format(d1, pattern));
        System.out.println(DateFormatUtils.format(d2, pattern));
        // 快速格式化
        FastDateFormat fastDateFormat = FastDateFormat.getDateInstance(FastDateFormat.FULL);
        System.out.println(fastDateFormat.format(new Date()));
    }
}
