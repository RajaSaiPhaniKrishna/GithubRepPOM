package driver_Factory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.Apputil;
import page_Actions.Add_Employee_Page;
import utilities.Excel_File_Util;

public class Driverfactory extends Apputil {
String inputpath = "./FileInput/DataEngine_framework.xlsx";
String outputpath = "./Fileoutput/empresults.xlsx";
ExtentReports report;
ExtentTest logger;
@Test
public void startTest() throws Throwable
{
	report = new ExtentReports("./Extentreports/AddEmployee.html");
	//cell add  employee pageclass
	Add_Employee_Page emp =  PageFactory.initElements(driver, Add_Employee_Page.class);
Excel_File_Util xl = new Excel_File_Util(inputpath);
int rc = xl.rowcount("Empdata");
Reporter.log("No.of rows are ::"+ rc,true);
for(int i=1;i<=rc;i++)
{
	logger= report.startTest("validate Add Employee");
String fname = xl.getcelldata("Empdata", i, 0);
String mname = xl.getcelldata("Empdata", i, 1);
String lname = xl.getcelldata("Empdata", i, 2);
boolean res = emp.addemployee(fname, mname, lname);
if(res)
{
	xl.setcelldata("Empdata", i, 3, "pass", outputpath);
	logger.log(LogStatus.PASS, "Addemployee success");
}
else
{
	xl.setcelldata("Empdata", i, 3, "fail", outputpath);
	logger.log(LogStatus.FAIL, "AddEmployee fail");
}
}
}
}
