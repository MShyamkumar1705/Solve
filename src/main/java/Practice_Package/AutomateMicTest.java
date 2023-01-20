package Practice_Package;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.GenericUtility.WebDriverUtility;

public class AutomateMicTest {

	public static void main(String[] args) throws Throwable {
		ChromeOptions option=new ChromeOptions();
		HashMap<String, Integer>map=new HashMap<String, Integer>();
		HashMap<String, Object> profile=new HashMap<String, Object>();
		HashMap<String, Object> pref=new HashMap<String, Object>();
		map.put("media_stream", 1);
		profile.put("managed_default_content_settings", map);
		pref.put("profile", profile);
		option.setExperimentalOption("prefs", pref);

		
		WebDriver driver=new ChromeDriver(option);
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.maximizeWindow(driver);
		wLib.forPageLoad(driver);
		driver.get("https://www.google.com/search?q=mic+test&oq=mic+te&aqs=chrome.0.69i59j69i57j0i20i263i433i512j0i512l3j69i60l2.1320j0j7&sourceid=chrome&ie=UTF-8");
		driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md']/ancestor::div/descendant::h3[.='Mic Test'])[1]")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("mic-launcher")).click();
		Thread.sleep(5000);
		String actualText = driver.getTitle();
		String expectedText =driver.findElement(By.xpath("//li[@class='notice-done done_testingComplete']")).getText();
		if(actualText.contains(expectedText)) {
			System.out.println("mic test is pass");
		}
		else {
			System.out.println("mic test is fail");
			}
		System.out.println(actualText);
		System.out.println(expectedText);
		
		
		String text = driver.findElement(By.xpath("//li[.='Several microphones were detected. To check the functionality and supported properties of your microphone, select it from the list below and press “Test my mic”. Please note that in order to obtain more accurate results it is recommended to keep enabled only one microphone.']")).getText();
		System.out.println(text);
		WebElement td = driver.findElement(By.xpath("//td[@id='mic-prop_tester_wt_rating']"));
		WebDriverWait wait=new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(td));
		String num = td.getText();
		System.out.println(num);
//		List<WebElement> table = driver.findElements(By.xpath("//table[@class='props-table']"));
//		for(int i=0;i<table.size();i++) {
//			String list = table.get(i).getText();
//			System.out.println(list);
		//}
		
		//driver.close();
	}


}


