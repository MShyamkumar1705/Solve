package Practice_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class AutomateLiveWorldPopulation {

	public static void main(String[] args) {

		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/search?q=world+live+population&rlz=1C1RXQR_enIN1009IN1009&oq=worl+live+&aqs=chrome.1.69i57j0i10i433i512j0i10i512l8.5989j0j7&sourceid=chrome&ie=UTF-8");
	    driver.findElement(By.xpath("(//h3[.='World Population Clock: 8 Billion People (LIVE, 2023)'])[1]")).click();
	   List<WebElement> liveCount = driver.findElements(By.xpath("//div[@class='maincounter-number']"));
	   for(int i=0;i<liveCount.size();i++)
	   {
		   String text = liveCount.get(i).getText();
		   System.out.println(text);
	   }
	   driver.close();
	
	}

}
