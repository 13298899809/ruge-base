package com.ruge.test.springMVC.报表.poi.excel.xls_2003;

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
 * @Description: 演示excel对其
 * @date 2018/5/14 8:50
 */
public class demo04_align_xls_2003 {
    @Test
    public void test_xls_2003(){
        /**
         * 创建excel 2003的工作簿
         */
        Workbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        /**
         * 创建sheet页面
         */
        Sheet sheet1 = wb.createSheet("手动创建的第一个sheet页面");
        /**
         * 创建单元格样式
         */
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss"));
        /**
         * 设置对齐方式
         * 设置边框
         * 设置底部边框颜色
         */
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.RED.getIndex());
        /**
         * 创建一行并在其中放置一些单元格。行基于0。
         */
        Row row = sheet1.createRow(0);
        /**
         * 行高
         */
        row.setHeightInPoints(30);
        /**
         * 创建一个单元格 并给第一个单元格赋值(方式一)
         */
        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);
        /**
         * 创建一个单元格 并给第一个单元格赋值(方式二)
         */
        row.createCell(1).setCellValue("逆光");
        Cell cell1 = row.createCell(2);
        cell1.setCellValue(Calendar.getInstance());
        cell1.setCellStyle(cellStyle);
        try  (OutputStream fileOut = new FileOutputStream("F:/excel2003.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
