package Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
      import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoAnnotations {

	
	@BeforeClass
	public void openBrowser() {
		System.out.println("*** open the Broswe ***");
	}
	@BeforeMethod
	public void login() {
		System.out.println("--- Login to Application ---");
	}
    @Test
    public void addEmployee() {
    	System.out.println("Employee added");
    }
    @AfterMethod
    public void logout() {
    	System.out.println("--- Logout from the application ---");
    }
    @AfterClass
    public void closeBrowser() {
    	System.out.println("*** Close the Browser ***");
    }
    @Test(priority=1)
    public void addBranch() {
    	System.out.println("Branches is added");
    }
    



}
