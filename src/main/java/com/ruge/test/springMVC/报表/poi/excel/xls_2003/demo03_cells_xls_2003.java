package com.ruge.test.springMVC.报表.poi.excel.xls_2003;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
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
        String showType = "1";
        /**
         * 创建sheet页面
         */
        Sheet sheet2 = wb.createSheet("手动创建的第一个sheet页面");

        Row row2 = sheet2.createRow(0);
        Cell cell2 = row2.createCell(0);
        cell2.setCellValue("展示类型");
        row2.createCell(1).setCellValue(showType);

        sheet2.setColumnWidth(1,5000);
        Row row3 = sheet2.createRow(1);
        Cell cell1 =  row3.createCell(0);
        Cell cell3 =  row3.createCell(1);
        cell1.setCellValue("说明");
        cell3.setCellValue("展示类型列：\n 0:表示系统间；\n 1:表示系统批量间\n 默认：0 \n");

        CellStyle cs = wb.createCellStyle();
        cs.setWrapText(true);
        cell3.setCellStyle(cs);

        row3.setHeightInPoints((4*sheet2.getDefaultRowHeightInPoints()));

        sheet2.autoSizeColumn(2);

        try  (OutputStream fileOut = new FileOutputStream("F:/excel2003.xls")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
