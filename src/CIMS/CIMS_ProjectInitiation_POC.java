package CIMS;


import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.WebDriver;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CIMS.Modules.Questionnaires.Project_Initiation;
import util.RunMode;
import util.UtilFunction;


	public class CIMS_ProjectInitiation_POC

	{
		private String sysDate;
		private WebDriver webdriver;		
		private UtilFunction utilfunc;		
		private Project_Initiation obj_Project_Initiation;

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
			setobj_Project_Initiation(new Project_Initiation(webdriver, utilfunc));
			
			webdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
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
	public void ProjectInitiation_POC() throws InterruptedException, IOException, AWTException {
			
		try {
			
			
		// Project Initiate Login	
		obj_Project_Initiation.Project_Initiation_login();
		
		//Project Initiate page
		obj_Project_Initiation.Welcome_Page();
		
		//Project Initiate page
		obj_Project_Initiation.Project_Initiation_Page();
		
		//Project_Initiation_Step1_Page
		boolean FlagStep1=obj_Project_Initiation.Project_Initiation_Step1_Page();
		if(!FlagStep1){
			System.out.println("Step 1 Script Failed due to an Exception");	
			
		}
		else{
			System.out.println("Successfully Executed- Step 1 for Project Initation");
			
		}
		
		//Project_Initiation_Step2_Page
		boolean FlagStep2=obj_Project_Initiation.Project_Initiation_Step2_Page();
		if(!FlagStep2){
			System.out.println("Step 2 Script Failed due to an Exception");
			
		}
		else{
			System.out.println("Successfully Executed- Step 2 for Project Initation");
		}
		
		//Project_Initiation_Step3_Page
		boolean FlagStep3=obj_Project_Initiation.Project_Initiation_Step3_Page();
		if(!FlagStep3){
			System.out.println("Step 3 Script Failed due to an Exception");
			
		}
		else{
			System.out.println("Successfully Executed- Step 3 for Project Initation");
		}
		
		//Project_Initiation_Step4_Page
		boolean FlagStep4=obj_Project_Initiation.Project_Initiation_Step4_Page();
		if(!FlagStep4){
			System.out.println("Step 4 Script Failed due to an Exception");	
			
		}
		else{
			System.out.println("Successfully Executed- Step 4 for Project Initation");
		}
		
		//Project_Initiation_Step5_Page
		boolean FlagStep5=obj_Project_Initiation.Project_Initiation_Step5_Page();
		if(!FlagStep5){
			System.out.println("Script Failed due to an Exception");
			
		}
		else{
			System.out.println("Successfully Executed- Step 5 for Project Initation");
		}
		
		//Project_Initiation_Step6_Page
		boolean FlagStep6=obj_Project_Initiation.Project_Initiation_Step6_Page();
		if(!FlagStep6){
			System.out.println("Script Failed due to an Exception");			
		}
		else{
			System.out.println("Successfully Executed- Step 6 for Project Initation");
		}
		
		}catch(Exception e){
			ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
			System.out.println("Script Failed");
			utilfunc.assertion();
		
		obj_Project_Initiation.TakeScreenshot();
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
			
			public void setobj_Project_Initiation(Project_Initiation setobj_Project_Initiation) {
				this.obj_Project_Initiation = setobj_Project_Initiation;
			}			
				
	}

