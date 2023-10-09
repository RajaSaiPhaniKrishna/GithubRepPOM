package config;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page_Actions.Login_Page;
import page_Actions.Logout_Page;


public class Apputil {
public static WebDriver driver;
@BeforeTest
public void setup() throws Throwable
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Login_Page login = PageFactory.initElements(driver, Login_Page.class);
login.adminlogin("Admin", "Qedge123!@#");
}
@AfterTest
public void teardown()
{
Logout_Page logout = PageFactory.initElements(driver, Logout_Page.class);
logout.adminlogout();
driver.close();
}
}
