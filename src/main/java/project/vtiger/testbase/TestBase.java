package project.vtiger.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import project.vtiger.excelreader.ExcelReader;

public class TestBase {

	public WebDriver driver;
	Properties prop;
	String browser;
	ExcelReader excelread;

	public void init() throws Exception {
		selectBrowser(getPropertyValue("browsername"));
		getUrl();
	}

	public void selectBrowser(String browser) throws Exception {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}	
	}

	public void getUrl() throws Exception {
		try {
			driver.get(getPropertyValue("url"));
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[][] getData(String sheetname, String excelname) throws Exception {
		String fis = System.getProperty("user.dir") + "/src/main/java/project/vtiger/data/"+excelname;
		try {
			excelread = new ExcelReader(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[][] data = excelread.getDataFromSheet(sheetname, excelname);
		return data;
	}

	public String getPropertyValue(String propertyname) throws Exception {
		InputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/project/vtiger/config/OR.properties");
		prop = new Properties();
		prop.load(fis);
		String strprop = prop.getProperty(propertyname);
		return strprop;
	}

}
