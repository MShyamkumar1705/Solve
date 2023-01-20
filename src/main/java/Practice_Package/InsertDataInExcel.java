package Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream("./src/test/resources/TestYantra.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Sheet1");
Row rw = sh.createRow(4);
Cell cl = rw.createCell(0);
Cell c = rw.createCell(1);

Row rw1 = sh.createRow(5);
Cell cl1 = rw1.createCell(0);
Cell c1 = rw1.createCell(1);

Row rw2 = sh.createRow(6);
Cell cl2 = rw2.createCell(0);
Cell c2 = rw2.createCell(1);
 
cl.setCellValue("Raju");
cl1.setCellValue("sam");
cl2.setCellValue("yuvi");
c.setCellValue("SDET45");
c1.setCellValue("SDET45");
c2.setCellValue("SDET45");



FileOutputStream fos=new FileOutputStream("./src/test/resources/TestYantra.xlsx");
wb.write(fos);

	}

}
