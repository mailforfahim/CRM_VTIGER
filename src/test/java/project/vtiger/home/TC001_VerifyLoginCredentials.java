package project.vtiger.home;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import project.vtiger.testbase.TestBase;
import project.vtiger.uiActions.HomePage;

public class TC001_VerifyLoginCredentials extends TestBase {
	
	HomePage homepage;

	@BeforeTest
	public void setUp() throws Exception {
		init();
	}

	@DataProvider(name="testdata")
	public String[][] getTestData() throws Exception {
		String[][] data = getData("Logindata", "VtigerData.xlsx");
		return data;
	}

	@Test(dataProvider="testdata")
	public void verifyLogin(String uname, String paswd) throws Exception {
		System.out.println("==================verifylogin start========================");
		homepage = new HomePage(driver);
		homepage.loginApplication(uname, paswd);
		homepage.logout();
		System.out.println("==================verifylogin end========================");
	}

/*	@AfterClass
	public void BrowserClose() {

	}*/


}
