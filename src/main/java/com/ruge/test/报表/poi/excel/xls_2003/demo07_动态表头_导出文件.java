package com.ruge.test.报表.poi.excel.xls_2003;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
public class demo07_动态表头_导出文件 {
    @Test
    public void test1(){
        String [] titleText  = {"姓名","性别","年龄","电话号"};
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(0);
        List<Person> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            String name = "张"+i;
            String age = "1"+i;
            String sex = "男";
            String phone = "1329889980"+i;
           list.add(new Person(name,age,sex,phone));
        }
        for (int i = 0; i <titleText.length ; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(titleText[i]);
        }
        for (int i = 1; i <5 ; i++) {
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
