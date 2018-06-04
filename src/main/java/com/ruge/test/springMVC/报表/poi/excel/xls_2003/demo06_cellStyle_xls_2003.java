package com.ruge.test.springMVC.报表.poi.excel.xls_2003;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;

/**
 * @author 爱丽丝、如歌
 * @Description: 单元格样式操作
 * @date 2018/5/14 8:50
 */
public class demo06_cellStyle_xls_2003 {
    @Test
    public void test_xls_2003() {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        /**
         * 设置行宽
         */
        sheet.setColumnWidth(0, 5000);
        Row row = sheet.createRow(0);
        /**
         * 设置列高
         */
        row.setHeightInPoints(30);
        /**
         * first row 起始行数
         * last row 终止行数
         * first column 起始列数
         * last column 终止列数
         */
      //  CellRangeAddress cellRangeAddress = new CellRangeAddress(0, (short) 6, 0, (short) 6);
       // sheet.addMergedRegion(cellRangeAddress);
        /**
         * 字体
         */
        Font font = wb.createFont();
        createCell(wb, row,0, HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM,"谁在悬崖沏一壶茶1",font);
        createCell(wb, row, 1, HorizontalAlignment.CENTER_SELECTION, VerticalAlignment.BOTTOM,"谁在悬崖沏一壶茶2",font);
        createCell(wb, row, 2, HorizontalAlignment.FILL, VerticalAlignment.CENTER,"谁在悬崖沏一壶茶3",font);
        createCell(wb, row, 3, HorizontalAlignment.GENERAL, VerticalAlignment.CENTER,"谁在悬崖沏一壶茶4",font);
        createCell(wb, row, 4, HorizontalAlignment.JUSTIFY, VerticalAlignment.JUSTIFY,"谁在悬崖沏一壶茶5",font);
        createCell(wb, row, 5, HorizontalAlignment.LEFT, VerticalAlignment.TOP,"谁在悬崖沏一壶茶6",font);
        createCell(wb, row, 6, HorizontalAlignment.RIGHT, VerticalAlignment.TOP,"谁在悬崖沏一壶茶7",font);

        try (OutputStream fileOut = new FileOutputStream("f:/workbook.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建一个单元格 并指定对齐方式
     * @param wb  工作簿
     * @param row 行
     * @param column 列
     * @param halign
     * @param valign
     * @param value
     */
    private static void createCell(Workbook wb, Row row, int column, HorizontalAlignment halign, VerticalAlignment valign,String value,Font font) {
        /**
         * 创建单元格
         */
        Cell cell = row.createCell(column);
        /**
         * 为单元格赋值
         */
        cell.setCellValue(value);
        /**
         * 创建单元格的样式
         */
        CellStyle cellStyle = wb.createCellStyle();
        /**
         * 水平方向对齐样式
         */
        cellStyle.setAlignment(halign);
        /**
         * 垂直方向对齐样式
         */
        cellStyle.setVerticalAlignment(valign);
        /**
         * 背景色
         * setFillForegroundColor 背景色
         * setFillForegroundColor 前景色
         */
        cellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        /**
         * 设置自动换行
         */
        cellStyle.setWrapText(true);
        /**
         * 字体设置
         * setFontHeightInPoints 高度
         * setFontName 字体名称
         * setItalic 斜体
         * setStrikeout 中间的划线
         */
        font.setFontHeightInPoints((short)24);
        font.setFontName("Courier New");
        font.setItalic(true);
        font.setStrikeout(true);
        cellStyle.setFont(font);
        /**
         * 为单元格赋样式
         */
        cell.setCellStyle(cellStyle);
    }
}
