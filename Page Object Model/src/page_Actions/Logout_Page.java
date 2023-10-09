package page_Actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout_Page {
	//logout
		//define repository for logout
		@FindBy(id = "welcome")
		WebElement objwelcome;
		@FindBy (xpath = "//a[normalize-space()='Logout']")
		WebElement objlogout;
	//method for logout
		public void adminlogout ()
		{
			objwelcome.click();
			objlogout.click();
		}
	}

