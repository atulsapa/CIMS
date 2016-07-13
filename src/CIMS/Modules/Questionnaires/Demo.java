package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class Demo
{
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	private Robot Robot;
	//Veriables-------------
	
	//Project_Initiation_login()	 
	//Methods Xpaths	
	private static String RegisterLinkXpath="//*[@id='dnn_dnnUser_enhancedRegisterLink']";
	
	private static String UsernameXpath="//*[@id='dnn_ctr_Register_userForm_Username_Username_TextBox']";
	private static String PasswordXpath="//*[@id='dnn_ctr_Register_userForm_Password_Password_TextBox']";
	private static String PasswordConfirmXpath="//*[@id='dnn_ctr_Register_userForm_PasswordConfirm_PasswordConfirm_TextBox']";
	private static String DisplayNameXpath="//*[@id='dnn_ctr_Register_userForm_DisplayName_DisplayName_TextBox']";
	private static String EmailXpath="//*[@id='dnn_ctr_Register_userForm_Email_Email_TextBox']";
	private static String RegisterXpath="//*[@id='dnn_ctr_Register_registerButton']";
	
	
	 
	
	private static String SuccessmessageXpath="//*[@id='dnn_ctr_ctl00_lblMessage']/strong";
	 //Excel sheet Data collection
	private static String Username=UtilFunction.getCellData("Test Data.xls", "Credentials", 2, 1);
	private static String Password=UtilFunction.getCellData("Test Data.xls", "Credentials", 3, 1);
	private static String ConfirmPassword=UtilFunction.getCellData("Test Data.xls", "Credentials", 4, 1);
	private static String DisplayName=UtilFunction.getCellData("Test Data.xls", "Credentials", 5, 1);
	private static String Email=UtilFunction.getCellData("Test Data.xls", "Credentials", 6, 1);
	
	//Welcome_Page()
		 
	//Methods Xpaths	
	//private static String WelcomeTextXpath="//*[@class='span10']/div[1]/table/tbody/tr/td[1]";
	private static String WelcomeTextXpath="//*[@id='main-container']/div/div[1]/table/tbody/tr/td[1]/div";
	private static String InitiateProjectButtonXpath="//*[@class='btn btn-primary']";

	
	 //Constructor----------
	 
		public Demo(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		
		
		//Functions--------------
	/**
	 * Verify that User is able to logged in successfully 
	 * 	
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	 public void Demo_POC() throws AWTException, InterruptedException
	 	{	
		
		 Reporter.log("DEMO Project Statstics Report");		 
		 Reporter.log("---------------------------------------------------------------------------------------");
		 Reporter.log("");	
		 Reporter.log("-------------------------------Registration Page Verification----------------------------");
		 try{
		 utilfunc.findElementByXpath(RegisterLinkXpath);
		 utilfunc.MakeElement(RegisterLinkXpath).click();
		 Thread.sleep(3000);
		 
		 Reporter.log("User is successfully clicked on the Register link Successfully");
		 			
		 utilfunc.MakeElement(UsernameXpath).sendKeys(Username);
		 utilfunc.MakeElement(PasswordXpath).sendKeys(Password);
		 utilfunc.MakeElement(PasswordConfirmXpath).sendKeys(ConfirmPassword);
		 utilfunc.MakeElement(DisplayNameXpath).sendKeys(DisplayName);
		 utilfunc.MakeElement(EmailXpath).sendKeys(Email);
		 
		 utilfunc.MakeElement(RegisterXpath).click();
		 Thread.sleep(5000);
		 
		 String ErroUsernameXpath="//*[@id='dnn_ctr_Register_userForm_Username_Username_Required']";
		 String ErroPasswordXpath="//*[@id='dnn_ctr_Register_userForm_Password_Password_Required']";
		 String ErroPasswordConfirmXpath="//*[@id='dnn_ctr_Register_userForm_PasswordConfirm_PasswordConfirm_Required']";
		 String ErroDisplayNameXpath="//*[@id='dnn_ctr_Register_userForm_DisplayName_DisplayName_Required']";
		 String ErroEmailXpath="//*[@id='dnn_ctr_Register_userForm_Email_Email_Required']";
		 
		
			String UsernameError=utilfunc.MakeElement(ErroUsernameXpath).getAttribute("style");
			String PasswordError=utilfunc.MakeElement(ErroPasswordXpath).getAttribute("style");
			String PasswordConfirmError=utilfunc.MakeElement(ErroPasswordConfirmXpath).getAttribute("style");
			String DisplayNameError=utilfunc.MakeElement(ErroDisplayNameXpath).getAttribute("style");
			String EmailError=utilfunc.MakeElement(ErroEmailXpath).getAttribute("style");
			
			if(UsernameError.equalsIgnoreCase("display: inline;")||
					PasswordError.equalsIgnoreCase("display: inline;")||
					PasswordConfirmError.equalsIgnoreCase("display: inline;")||
					DisplayNameError.equalsIgnoreCase("display: inline;")) {
				
				 Reporter.log("Error Occured");
				 UsernameError=utilfunc.MakeElement(ErroUsernameXpath).getText();
				 PasswordError=utilfunc.MakeElement(ErroPasswordXpath).getText();
				 PasswordConfirmError=utilfunc.MakeElement(ErroPasswordConfirmXpath).getText();
				 DisplayNameError=utilfunc.MakeElement(ErroDisplayNameXpath).getText();
				 EmailError=utilfunc.MakeElement(ErroEmailXpath).getText();
				 Reporter.log("Error is ---");
				 Reporter.log(UsernameError);
				 Reporter.log(PasswordError);
				 Reporter.log(PasswordConfirmError);
				 Reporter.log(DisplayNameError);
				 Reporter.log(EmailError);
			}
			else {
				Reporter.log("No Error Message is displayed");	
			}
			Thread.sleep(5000);
			String Successmessage=utilfunc.MakeElement(SuccessmessageXpath).getText();
			Reporter.log("");
			Reporter.log("Success Message is ---"+Successmessage);	
			Reporter.log("");
		 Reporter.log("User is successfully Registered");
		 Reporter.log("---------------------------------------------------------------------------------------");
		 }
		 catch(Exception e){
			 Reporter.log("");
			 Reporter.log("Register verfication Failed due to an error");
			 Reporter.log("------------------------------------------------------------------------------------");
			 TakeScreenshot();
		 }
	   }
     
	 
	
	//Take a Screen shot
	public void TakeScreenshot(){
		utilfunc.takeScreenShot(System.getProperty("user.dir")+"/test-output/Error Screenshot/errorSceenshot"+UtilFunction.currentDateTime()+".jpg");
	}
	 
}