package page_Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Add_Employee_Page {

		WebDriver driver;
		public Add_Employee_Page(WebDriver driver)
		{
			this.driver=driver;
		}
	//define repository
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement Clickpim;
	@FindBy(name = "btnAdd")
	WebElement clickadd;
	@FindBy(name = "firstName")
	WebElement enterfname;
	@FindBy(name = "middleName")
	WebElement entermname;
	@FindBy(name = "lastName")
	WebElement enterlname;
	@FindBy(name = "employeeId")
	WebElement beforeeid;
	@FindBy(id  = "btnSave")
	WebElement clicksave;
	@FindBy(id = "personal_txtEmployeeId")
	WebElement aftereid;
	//method for employee
	public boolean addemployee(String Firstname, String Middlename, String Lastname)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(this.Clickpim).click().perform();
		ac.moveToElement(this.clickadd).click().perform();
		this.enterfname.sendKeys(Firstname);
		this.entermname.sendKeys(Middlename);
	    this.enterlname.sendKeys(Lastname);
	//Capture EID
	String Exp_Eid = this.beforeeid.getAttribute("value");
	ac.moveToElement(this.clicksave).click().perform();
	//capture EID
	String Act_Eid = this.aftereid.getAttribute("value");
	if(Exp_Eid.equals(Act_Eid))
	{
		Reporter.log("Add employee success::::"+Exp_Eid+"   "+Act_Eid);
	return true;
	}
	else
	{
		Reporter.log("Add employee fail::::"+Exp_Eid+"   "+Act_Eid);
	return false;
	}
	}
}
