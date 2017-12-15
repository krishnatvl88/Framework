package com.actitime.genericlib;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

    String filepath ="D:\\corejava\\TaquilaFramework\\TestData\\TestData.xlsx";
    
    public String getExcelData(String sheetName,int rowNum, int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
        FileInputStream fis = new FileInputStream(filepath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet1");
        Row row = sh.getRow(rowNum);
        String data = row.getCell(colNum).getStringCellValue();
        
        return data;     
    }
}