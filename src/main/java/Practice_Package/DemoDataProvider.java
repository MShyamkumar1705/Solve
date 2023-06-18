package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.GenericUtility.ExcelUtility;

public class DemoDataProvider {
	@Test(dataProvider="demoData")
	public void readData(String from,String to)
	{
	System.out.println(from+"---->"+to);
	}
	
	@DataProvider
	public Object[][] demoData() throws Throwable {
		ExcelUtility rLib=new ExcelUtility();
		Object[][] value = rLib.readMultiplesetOfData("dataprovider");
		return value;
	}

}
