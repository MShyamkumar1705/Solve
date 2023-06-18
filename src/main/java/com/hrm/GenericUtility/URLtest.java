package com.hrm.GenericUtility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class URLtest {

	@Test
	public void test() throws MalformedURLException {
		Reporter.log("Test1 - class1" +Thread.currentThread().getId(), true);
		URL url = new URL("http://192.168.172.1:4444/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		WebDriver driver=new RemoteWebDriver(url, cap);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/");
	}
}
