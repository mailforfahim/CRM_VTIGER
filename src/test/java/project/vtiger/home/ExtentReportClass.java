package project.vtiger.home;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportClass {
	
	ExtentHtmlReporter extentHtmlReport;
	ExtentReports extentReport;
	ExtentTest logger;
	
	@Test
	public void startTest() {
		
		extentHtmlReport = new ExtentHtmlReporter("D:\\WorkSpaceProject\\vtiger\\test-output\\extent.html");
		
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(extentHtmlReport);
		
		logger = extentReport.createTest("LoginTest");
		
		logger.log(Status.INFO, "Login To Vtiger CRM");
		
		logger.log(Status.PASS, "Login Test Pass");
		
		extentReport.flush();
		
		ExtentTest logger2 = extentReport.createTest("LoginTest 1");

		logger2.log(Status.FAIL, "Login Test Pass");
		
		extentReport.flush();
		
		ExtentTest logger3 = extentReport.createTest("LoginTest 2");
		
		logger3.log(Status.SKIP, "Registration");
		
		extentReport.flush();
		
	}

}
