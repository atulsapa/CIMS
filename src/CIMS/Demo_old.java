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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CIMS.Modules.Questionnaires.CIMS_Basic_Information_module;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Modules.Questionnaires.Demo;
import CIMS.Modules.Questionnaires.Project_Initiation;
import util.RunMode;
import util.UtilFunction;


	public class  Demo_old

	{
		private String sysDate;
		private WebDriver webdriver;		
		private UtilFunction utilfunc;		
		private Demo obj_Demo;
		
		private String ExcelFileName="Test Data.xls";
		
		//Initiate the class Before TEST method
		@BeforeClass		
		public void isSkipped(){			
		if(RunMode.isSkip(this.ExcelFileName,this.getClass().getName())){
			Reporter.log("");
			Reporter.log(this.getClass().getName()+" Test is Skipped Intentionally.");		
			Reporter.log("");
			Reporter.log("This Test will be Skipped as Run Mode is set 'No' in the Test Data Excel Sheet.");
			throw new SkipException("Test will be Skiped as Run Mode is Set to 'N' in Test Data xls File.");
		}
		else {					
			setDriver(UtilFunction.getBrowser(this.getClass().getName(),this.ExcelFileName));
			setSysDate(UtilFunction.currentDateTime());				
			setUtilfunc(new UtilFunction(this.getDriver()));	
			
			setobj_Demo(new Demo(webdriver, utilfunc));
			
			webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);	
			Reporter.log("");
			Reporter.log("***************************Opening the Application*********************************");
				
			boolean StartApplicationFlag = utilfunc.startApplication(ExcelFileName);
			if(!StartApplicationFlag){
				Reporter.log("User is not able to Open the application");
			}
			else {
				Reporter.log("Opened the Application URL Successfully");
			}
		}
	}
		
		
	// This Method below close the Browser. It will be run after the annotation Test.
	@AfterClass	
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
	public void CIMSMain() throws InterruptedException, IOException, AWTException {
			
		try {
			
			
		// Project  Login	
		obj_Demo.Demo_POC();
		
		
		
		}catch(Exception e){
			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
			System.out.println("Script Failed");
			utilfunc.assertion();
		
			obj_Demo.TakeScreenshot();
		}
		
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
		
			/*public void setDriver(WebDriver driver) {
				this.driver = driver;
			}*/
			
			public void setobj_Demo(Demo setobj_Demo) {
				this.obj_Demo = setobj_Demo;
			}	
				
				
	}

