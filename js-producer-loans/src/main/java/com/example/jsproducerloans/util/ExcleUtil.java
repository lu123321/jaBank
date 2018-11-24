package com.example.jsproducerloans.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcleUtil {
    public static String creatExcel(String userid,String[] aa,String[] bb){
        String excelname = "D:\\"+userid+System.currentTimeMillis()+".xls";
        String sheetname = "report";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet a = wb.createSheet(sheetname);
        HSSFCellStyle style = wb.createCellStyle();
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND); //solid 填充
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //文字水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//文字垂直居中
        style.setBorderBottom(BorderStyle.THIN); //底边框加黑
        style.setBorderLeft(BorderStyle.THIN);  //左边框加黑
        style.setBorderRight(BorderStyle.THIN); // 有边框加黑
        style.setBorderTop(BorderStyle.THIN); //上边框加黑
        //为单元格添加背景样式
        for (int i = 0; i < 6; i++) {
            a.setColumnWidth(i,6000);
            //需要6行表格
            Row row =	a.createRow(i);
            row.setHeight((short) ((short) 30*20));
            //创建行
            for (int j = 0; j < 6; j++) {
                //需要6列
                Cell cell = row.createCell(j);
                cell.setCellStyle(style);
            }
        }
        //合并单元格
        //a.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));//合并单元格，cellRangAddress四个参数，第一个起始行，第二终止行，第三个起始列，第四个终止列
        a.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        HSSFRow row = a.getRow(0);
        row.getCell(0).setCellValue("贷款合同信息");
        int cc = 0;
        for(int i= 0;i<aa.length;i++){
            if(i%3 == 0 && i != 0){
                cc++;
                HSSFRow row1 = a.getRow(cc+1);
                row1.getCell(0).setCellValue(aa[i]);
                row1.getCell(1).setCellValue(bb[i]);
            }else{
                HSSFRow row1 = a.getRow(cc+1);
                row1.getCell((i%3)*2).setCellValue(aa[i]);
                row1.getCell(((i%3)*2)+1).setCellValue(bb[i]);
            }
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(excelname);
            wb.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelname;
    }
}
