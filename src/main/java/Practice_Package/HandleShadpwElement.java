package Practice_Package;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleShadpwElement {

	public static void main(String[] args) {

	WebDriver driver=new ChromeDriver();
	driver.get("chrome://downloads/");
	//JavascriptExecutor js=(JavascriptExecutor) driver;
	//WebElement el = (WebElement)js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('#searchInput')");
	//el.sendKeys("Hakuna Matataaa....");
	JavascriptExecutor js=(JavascriptExecutor) driver;
	WebElement el = (WebElement)js.executeScript("document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('#searchInput').value='fhghhhhhhhhhhhhhhhhhhhhhhhhhhh'");
	//el.sendKeys("Hakuna Matataaa....");
	}

}
