package com.ruge.test.springMVC.报表.poi.excel.xls_2003;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 爱丽丝、如歌
 * @Description: 创建工作簿
 * @date 2018/5/14 8:48
 */
public class demo01_workbook_xls_2003 {
    @Test
    public void test_xls_2003(){
        /**
         * 创建excel 2003的工作簿
         */
        Workbook wb = new HSSFWorkbook();
        try  (OutputStream fileOut = new FileOutputStream("F:/excel2003.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
