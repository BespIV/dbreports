package com.dbreports;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestUtil {
    public static void main(String[] args) {
        Config config = new Config();
        String nameExcel = "example.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        Cell cell;
        Row row;
        XSSFSheet sheet = workbook.createSheet("sheet1");
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("first text");
        cell = row.createCell(1);
        cell.setCellValue("Second text");

        try {
            File file = new File(config.pathApp+config.pathExcel + nameExcel);
            System.out.println(file.getAbsolutePath());
            file.getParentFile().mkdirs();
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            System.out.println("Created file: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
