package com.ruge.test.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * 爱丽丝、如歌  创建于 2018/6/13 20:06
 * 说明:  序列化工具类
 */
public class SerializationUtil {
    @Test
    public void test1(){
        System.out.println("*SerializationUtils**");
        Date date = new Date();
        //序列化成一个字节数组
        byte[] bytes = SerializationUtils.serialize(date);
        System.out.println(ArrayUtils.toString(bytes));
        System.out.println(date);
        //反序列化成对象
        Date reDate = (Date) SerializationUtils.deserialize(bytes);
        System.out.println(reDate);
        //值相等
        System.out.println(ObjectUtils.equals(date, reDate));
        //但不是同一个对象
        System.out.println(date == reDate);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream(new File("d:/test.txt"));
            fis = new FileInputStream(new File("d:/test.txt"));
            //将对象序列化后写到文件中
            SerializationUtils.serialize(date, fos);
            //从文件中读出对象
            Date reDate2 = (Date) SerializationUtils.deserialize(fis);
            System.out.println(date.equals(reDate2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
