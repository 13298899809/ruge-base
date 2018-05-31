package com.ruge.test.报表.poi.excel.xls_2003;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 爱丽丝、如歌
 * @Description: 创建单元格
 * @date 2018/5/14 8:50
 */
public class demo03_cells_xls_2003 {
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
        /**
         * 创建一行并在其中放置一些单元格。行基于0。
         */
        Row row = sheet1.createRow(0);
        /**
         * 创建一个单元格 并给第一个单元格赋值(方式一)
         */
        Cell cell = row.createCell(0);
        cell.setCellValue("谁在悬崖沏一壶茶");
        /**
         * 创建一个单元格 并给第一个单元格赋值(方式二)
         */
        row.createCell(1).setCellValue(new Date());
        row.createCell(2).setCellValue(Calendar.getInstance());
        row.createCell(3).setCellValue("a string");
        row.createCell(4).setCellValue(true);
        row.createCell(5).setCellType(CellType.ERROR);
        row.createCell(6).setCellValue(1.1);
        try  (OutputStream fileOut = new FileOutputStream("F:/excel2003.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
