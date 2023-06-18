package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.iPathContent;

public class WriteDtainExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=58355126069&hvpone=&hvptwo=&hvadid=486458706470&hvpos=&hvnetw=g&hvrand=13577342175681627551&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062009&hvtargid=kwd-10573980&hydadcr=14453_2154373");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 14"+Keys.ENTER);
		 List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for (int i = 0; i<list.size(); i++) {
			String text = list.get(i).getText();
			System.out.println(text+ " ");
			FileInputStream fis=new FileInputStream("./src/test/resources/HRM.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			int rowNum = sh.getLastRowNum()+1;
			short cellNum = sh.getRow(0).getLastCellNum();
			Cell cell=sh.getRow(rowNum).getCell(0);
			Object[][] obj = new Object [rowNum][cellNum];
			for (int j =1; j <rowNum; j++) {
				
			sh.getRow(1).getCell(0).setCellValue(text);
			FileOutputStream fos=new FileOutputStream("./src/test/resources/HRM.xlsx");
			wb.write(fos);
			wb.close();
		}
			}
		driver.close();
	}
}
