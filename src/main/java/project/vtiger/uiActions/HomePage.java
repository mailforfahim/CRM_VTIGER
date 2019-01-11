package project.vtiger.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	@FindBy(xpath="//input[@name='user_name']")
	WebElement username;

	@FindBy(xpath="//input[@name='user_password']")
	WebElement userpassword;

	@FindBy(xpath="//input[@name='Login']")
	WebElement submitButton;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signout;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginApplication(String uname, String paswd) throws Exception {
		username.clear();
		username.sendKeys(uname);
		userpassword.clear();
		userpassword.sendKeys(paswd);
		submitButton.click();
	}
	
	public void logout() {
		try {
			signout.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
