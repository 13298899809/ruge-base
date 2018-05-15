package com.ruge.test.poi.excel.xls_2003;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 爱丽丝、如歌
 * @Description: 创建工作表
 * @date 2018/5/14 8:50
 */
public class demo02_sheet_xls_2003 {
    @Test
    public void test_xls_2003(){
        /**
         * 创建excel 2003的工作簿
         */
        Workbook wb = new HSSFWorkbook();
        /**
         * 创建sheet页面
         */
        Sheet sheet1 = wb.createSheet("手动创建的第一个sheet页面");
        Sheet sheet2 = wb.createSheet("手动创建的第二个sheet页面");
        try  (OutputStream fileOut = new FileOutputStream("F:/excel2003.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
