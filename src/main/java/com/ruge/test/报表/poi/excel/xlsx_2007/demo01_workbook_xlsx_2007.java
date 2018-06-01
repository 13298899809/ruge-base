package com.ruge.test.报表.poi.excel.xlsx_2007;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 爱丽丝、如歌
 * @Description: 创建工作簿
 * @date 2018/5/14 8:48
 */
public class demo01_workbook_xlsx_2007 {
    @Test
    public void test_xlsx_2007(){
        /**
         * 创建excel 2007工作簿
         */
        Workbook wb = new XSSFWorkbook();
        try (OutputStream fileOut = new FileOutputStream("f:/excel2007.xlsx")) {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
