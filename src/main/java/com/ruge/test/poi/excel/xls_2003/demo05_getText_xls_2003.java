package com.ruge.test.poi.excel.xls_2003;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 爱丽丝、如歌
 * @Description: 批量处理行和列的样式
 * @date 2018/5/14 8:50
 */
public class demo05_getText_xls_2003 {
    @Test
    public void test_xls_2003() {
        try {
            InputStream inp = new FileInputStream("f:/excel2003.xls");
            HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
            /**
             * 获取第一个sheet页面
             */
            HSSFSheet sheetAt = wb.getSheetAt(0);
            /**
             * 第一种遍历方式
             */
            ExcelExtractor extractor = new ExcelExtractor(wb);
            extractor.setFormulasNotResults(true);
            extractor.setIncludeSheetNames(false);
            String text = extractor.getText();
           // System.out.println(text);
            /**
             * 第二种遍历方式
             */
            if (sheetAt != null) {
                /**
                 * 遍历所有的sheet页
                 */
                for (Sheet sheet : wb) {
                  //  System.out.println(sheet.getSheetName());
                    /**
                     * 遍历所有的行
                     */
                    for (Row row : sheet) {
                     //   System.out.println();
                        /**
                         * 遍历所有的单元格
                         */
                        for (Cell cell : row) {
                 //           System.out.print(cell);
                        }
                    }
                }
            } else {
                return;
            }
            /**
             * 第三种遍历方式
             * sheetAt.getLastRowNum() 遍历所有的行
             * row.getLastCellNum()    遍历列
             */
            if (sheetAt != null) {
                for (int i = 0; i < sheetAt.getLastRowNum(); i++) {
                    HSSFRow row = sheetAt.getRow(i);
                    if (row == null) {
                        continue;
                    }
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        HSSFCell c = row.getCell(j);
                        if (c == null) {
                            continue;
                        }
                      //  System.out.println(getValue(c));
                    }
                }
            } else {
                return;
            }
            /**
             * 第四种遍历
             */
            DataFormatter formatter = new DataFormatter();
            for (Row row : sheetAt) {
                for (Cell cell : row) {
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    System.out.print(cellRef.formatAsString());
                    System.out.print(" - ");
                    String text2 = formatter.formatCellValue(cell);
                   System.out.print("第四种遍历:" + text2);
                }
            }
            wb.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(HSSFCell cell) {
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:return String.valueOf(cell.getStringCellValue());
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return String.valueOf(cell.getDateCellValue());
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case HSSFCell.CELL_TYPE_BOOLEAN:return String.valueOf(cell.getBooleanCellValue());
            case HSSFCell.CELL_TYPE_FORMULA:return String.valueOf(cell.getCellFormula());
            case HSSFCell.CELL_TYPE_BLANK:return "222";
            default:return null;
        }
    }
}
