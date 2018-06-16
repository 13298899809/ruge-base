package com.ruge.test.springMVC.报表.poi.excel.xls_2003;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-30  19:38
 * 描述 ：动态生成的表头
 */
public class demo07_动态表头_合并单元格_背景色_导出文件 {
    @Test
    public void test1(){
        String [] titleText  = {"姓名","性别","年龄","电话号"};
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        /**
         * 创建表头样式
         * 设置背景颜色
         * 橙色“前景”，前景是填充前景而不是字体颜色。
         */
     //   CellStyle cellStyleTitle = wb.createCellStyle();
    //    cellStyleTitle.setFillForegroundColor(new XSSFColor(new java.awt.Color(128, 0, 128)));
     //   cellStyleTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFCellStyle cellStyleTitle = wb.createCellStyle();
        cellStyleTitle.setFillForegroundColor(new XSSFColor(new java.awt.Color(197, 217, 241)));
        cellStyleTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        /**
         * 合并单元格
         */
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3 ));
        /**
         * 标题
         */
        Row row_title = sheet.createRow(0);
        Cell cell_title = row_title.createCell(0);
        cell_title.setCellValue("demo07_动态表头_合并单元格_背景色_导出文件");
        cell_title.setCellStyle(cellStyleTitle);
        /**
         * 第一列表头
         */
        Row row = sheet.createRow(1);
        List<Person> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            String name = "张"+i;
            String age = "1"+i;
            String sex = "男";
            String phone = "1329889980"+i;
           list.add(new Person(name,age,sex,phone));
        }
        for (int i = 1; i <titleText.length ; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(titleText[i]);
        }
        for (int i = 2; i <5 ; i++) {
            row = sheet.createRow(i);
            Cell cell0 = row.createCell(0);
            Cell cell1 = row.createCell(1);
            Cell cell2 = row.createCell(2);
            Cell cell3 = row.createCell(3);
            cell0.setCellValue(list.get(i).getName());
            cell1.setCellValue(list.get(i).getAge());
            cell2.setCellValue(list.get(i).getSex());
            cell3.setCellValue(list.get(i).getPhone());
        }
        try  (OutputStream fileOut = new FileOutputStream("F:/excel2003.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
