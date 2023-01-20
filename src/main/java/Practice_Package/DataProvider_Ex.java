package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Ex {
	
	@Test(dataProvider = "data")
	public void travel(String src,String dst,int price) {
		System.out.println("from"+src+"---->"+"to"+dst+ price);
	}

	@DataProvider
	public Object[][] data() {
		Object[][] objarr= new Object[3][3];
		objarr[0][0]="Andaman";
		objarr[0][1]="Nicobar";
		objarr[0][2]=80000;
		
		objarr[1][0]="Andaman";
		objarr[1][1]="Nicobar";
		objarr[1][2]=8000;
		
		objarr[2][0]="Port Blair";
		objarr[2][1]="Havelock";
		objarr[2][2]=1000;
		
		return objarr;
		
	}
}
