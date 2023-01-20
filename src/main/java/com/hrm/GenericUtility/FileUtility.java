package com.hrm.GenericUtility;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUtility {
	
   public void docsUpload(WebDriver driver) throws InterruptedException {
	   File docx=new File(iPathContent.docs);
		String docsPath = docx.getAbsolutePath();
		driver.findElement(By.name("employee_file201")).sendKeys(docsPath);
		Thread.sleep(2000);
		
   }
		
		public void imgUpload(WebDriver driver) {
		File img=new File("./src/test/resources/Screenshot (8).png");
		   String imgPath =img.getAbsolutePath();
		driver.findElement(By.name("employee_image")).sendKeys(imgPath);
		 driver.findElement(By.name("emplo")).click();
		 
   }
}
