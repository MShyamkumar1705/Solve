package com.hrm.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Shyam
 *
 */
public class ExcelUtility {
	JavaUtility jLib=new JavaUtility();
	public String readExcelData(String sheetName,int rowNum,int cellNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(iPathContent.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		wb.close();
		return data;
	}
	
	public int rowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(iPathContent.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public short cellCount(String sheetName,int rowNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(iPathContent.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		short cellCount = row.getLastCellNum();
		wb.close();
		return cellCount;
		}
	
	public void setExcelData(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream(iPathContent.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(iPathContent.EXCELPATH);
		wb.write(fos);
		wb.close();
	}
	
	public HashMap<String, String> list(WebDriver driver,String sheetName) throws Throwable, Throwable {
		HashMap<String,String> map=new HashMap<String, String>();
		FileInputStream fis=new FileInputStream(iPathContent.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(0);
		short cellCount = row.getLastCellNum();
		for(int i=0;i<cellCount;i++) {
			String key = wb.getSheet(sheetName).getRow(0).getCell(i).getStringCellValue();
		String value = wb.getSheet(sheetName).getRow(1).getCell(i).getStringCellValue();
	map.put(key, value);
		}
		for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}	
		return map;
	}
	public void list(WebDriver driver,String key1,String key2,String key3,
			String key4,String key5,String key6,String key7,String key8,
			String key9,String key10,String key11,String key12,String key13,String key14,String Sheet,int index) throws Throwable {
		JavaUtility jLib=new JavaUtility();
		FileInputStream fis=new FileInputStream(iPathContent.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(Sheet);
		Row rw=sh.getRow(index);
		short cell = rw.getLastCellNum();
		ArrayList<String> al=new ArrayList<String>();
		al.add(key1);
		al.add(key2);
		al.add(key3);
		al.add(key4);
		al.add(key5);
		al.add(key6);
		al.add(key7);
		al.add(key8);
		al.add(key9);
		al.add(key10);
		al.add(key11);
		al.add(key12);
		al.add(key13);
		al.add(key14);
		for(int i=0;i<cell;i++) {
		String value = wb.getSheet(Sheet).getRow(index).getCell(i).getStringCellValue()+jLib.getRandomNumber();
		driver.findElement(By.name(al.get(i))).sendKeys(value);
	}}
		
		public String AddBranch(String sheetName) throws Throwable {
			FileInputStream fis=new FileInputStream(iPathContent.EXCELPATH);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			String data = sh.getRow(1).getCell(7).getStringCellValue();
			wb.close();
			return data;
			
	}
		
		public Object[][] readMultiplesetOfData(String sheetName) throws Throwable {
			FileInputStream fis=new FileInputStream(iPathContent.EXCELPATH);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int lastrow = sh.getLastRowNum()+1;
			short lastcell = sh.getRow(0).getLastCellNum();
			Object[][] obj = new Object [lastrow][lastcell];
			for(int i=0;i<lastrow;i++) {
				for(int j=0;j<lastcell;j++) {
					obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
					
				}
				}
			return obj;
		}
}



