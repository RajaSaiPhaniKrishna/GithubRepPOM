package page_Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Login_Page {
	//define repository for login
	@FindBy(xpath = "//input[@name='txtUsername']")
WebElement objuser;
	@FindBy (xpath = "//input[@name='txtPassword']")
	WebElement objpass;
	@FindBy (xpath = "//input[@name='Submit']")
	WebElement objlogin;
//write method for login
	public void adminlogin(String user, String pass)
	{
		objuser.sendKeys(user);
		objpass.sendKeys(pass);
		objlogin.click();
		}
}


