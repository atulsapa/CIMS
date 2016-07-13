package CIMS;


import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CIMS.Modules.Questionnaires.CIMS_Login;
import util.Email;
import util.RunMode;
import util.UtilFunction;


	public class CIMSEmail

	{
		private String 										sysDate;
		private WebDriver 									webdriver;		
		private UtilFunction 								utilfunc;		
		private Email 										obj_Email;		
	
		//Initiate the class Before TEST method
		@BeforeClass		
		public void isSkipped(){							
			setDriver(UtilFunction.getBrowser("FIREFOX","Test Data.xls"));
			setSysDate(UtilFunction.currentDateTime());				
			setUtilfunc(new UtilFunction(this.getDriver()));
			setobj_Email(new Email(webdriver, utilfunc));
		}

		@AfterMethod
		public void closeBrowser() {
			Reporter.log("Closing Opened Browser");
			boolean CloaseBrowserFlag = utilfunc.closeWebDriver();		
			if(!CloaseBrowserFlag){
				Reporter.log("User is not able to close the application");
			}
			else {
				Reporter.log("Closed the application.");
			}
			
		}		
	
	// Our Test start from here.
	@Test()	
	public void CIMSMain() throws Exception {

		obj_Email.SendMailtoUser();	
		System.out.println("Email Sent");
		}
		
		
	
	// Below Methods are getters and setters for Test Parameters.	


	public String getSysDate() {
		return sysDate;
	}
	
	public WebDriver getDriver() {
		return webdriver;
	}
	
	public void setDriver(String browser) {
		this.webdriver = UtilFunction.getDriver(browser);
	}
	
	public void setSysDate(String sysdate) {
		this.sysDate = sysdate ;
	}
	
	public UtilFunction getUtilfunc() {
		return utilfunc;
	}

	
	public void setUtilfunc(UtilFunction utilfunc) {
		this.utilfunc = utilfunc;
	}
	
	public void setobj_Email(Email setobj_Email) {
		this.obj_Email = setobj_Email;
	}
			
				
	}

