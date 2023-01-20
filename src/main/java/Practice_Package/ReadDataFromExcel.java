package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

	FileInputStream fis=new FileInputStream("./src/test/resources/TestYantra.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String sh = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	String sh1 = wb.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
	
	System.out.println(sh+" "+sh1);
	}

}
