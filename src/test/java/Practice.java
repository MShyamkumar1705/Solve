import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.ReadExcelDataUtility;
import com.hrm.GenericUtility.iPathContent;

public class Practice {

	public static void main(String[] args) throws Throwable {
//WebDriver driver=new ChromeDriver();
		ReadExcelDataUtility eLib=new ReadExcelDataUtility();
		ArrayList<String> al=new ArrayList<String>();
		al.add("employee_companyid");
		al.add("employee_firstname");
		al.add("employee_lastname");
		al.add("employee_middlename");
		al.add("employee_department");
		al.add("employee_branches");
		al.add("employee_position");
		al.add("employee_contact");
		al.add("employee_sss");
		al.add("employee_tin");
		al.add("employee_hdmf_pagibig");
		//al.add("employee_gsis");
		for(int j=0;j<al.size();j++) {
			eLib.setExcelData("Sheet1",0, j,al.get(j));
		}
		//eLib.list(driver,"Sheet1",1);
		
	}

}
/* public void list(WebDriver driver,String key1,String key2,String key3,
			String key4,String key5,String key6,String key7,String key8,
			String key9,String key10,String key11,String key12,String Sheet,int index) throws Throwable {
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
		for(int i=0;i<cell;i++) {
		String value = wb.getSheet(Sheet).getRow(index).getCell(i).getStringCellValue()+jLib.getRandomNumber();
		driver.findElement(By.name(al.get(i))).sendKeys(value);
	}
		
}
	public void sy() {
		System.out.println("Hello");
	}*/
