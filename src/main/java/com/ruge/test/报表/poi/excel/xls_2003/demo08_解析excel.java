package com.ruge.test.报表.poi.excel.xls_2003;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-30  20:15
 * 描述 ：
 */
public class demo08_解析excel {
    @Test
    public void test() throws IOException {
        Workbook wb = new HSSFWorkbook(FileUtils.openInputStream(new File("F:\\excel2003.xls")));
        /**
         * 读取excel工作页
         * wb.getSheet("sheet0"); 通过工作页名称过去
         * wb.getSheetAt(0); 通过工作页坐标获取
         */
        Sheet sheet = wb.getSheet("sheet0");
        Sheet sheetAt = wb.getSheetAt(0);
        int firstRow = 0;
        int lastRow = sheetAt.getLastRowNum();
        /**
         * 循环读取第 i 行
         */
        for (int i = firstRow; i < lastRow; i++) {
            Row row = sheetAt.getRow(i);
            if (row == null) {
                continue;
            }
            /**
             * 获取该行有多少列
             */
            int lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j++) {
                Cell cell = row.getCell(j);
                String value = cell.getStringCellValue();
                /**
                 * 第一种打印
                 */
                //System.out.println("第"+i+"行，第"+j+"列的值是"+value);
                /**
                 * 第二种打印
                 */
                System.out.print(value+" ");
            }
            /**
             * 第二种打印
             */
            System.out.println();

        }


    }
}
