package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("./src/test/resources/TestYantra.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	//Row rw = sh.getRow(0);
	int row = sh.getLastRowNum();
	//short cell = rw.getLastCellNum();
	int c=0; 
	for(int i=1;i<row;i++) {
		String user=wb.getSheet("Sheet1").getRow(i).getCell(i-i).getStringCellValue();
		//System.out.println(user);
	
	//for(int j=0;j<cell;j++) {
		
		String user1=wb.getSheet("Sheet1").getRow(i).getCell(i-c).getStringCellValue();
		System.out.println(user+" "+user1);
		c++;
	}
	
	}

}
//}