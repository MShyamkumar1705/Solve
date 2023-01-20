package com.hrm.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation extends HRMHeadBaseClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"-----> Testscript execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"----> Passed");
		Reporter.log(methodName+"----->Testscript execution successful");
		
	}

	public void onTestFailure(ITestResult result) {
		String failedScript = result.getMethod().getMethodName();
		String screenShot=failedScript+new JavaUtility().getSystemDateAndTime();
		EventFiringWebDriver edriver=new EventFiringWebDriver(HRMHeadBaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File path = new File("./Screenshot/"+screenShot+".png");
		String filepath = path.getAbsolutePath();
		try {
			FileUtils.copyFile(src, path);
		}
		catch (IOException e) {
e.printStackTrace(); 
}
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("--TestScript Execution failed--");
   }

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"-- Skipped");
		Reporter.log("--TestScript Execution skipped--");
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("HRM Report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser","chrome");
		report.setSystemInfo("Os", "windows");
		report.setSystemInfo("Base-URL", "https://localhost:8888");
		report.setSystemInfo("Report Name", "Shyam");
		
		
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
