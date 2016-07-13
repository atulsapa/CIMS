package CIMS.Modules.WebAccess;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_ForgotPassword {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_ForgotPassword(WebDriver driver,UtilFunction utilfunc) {
	    	  
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    }


		public boolean Forgot_password(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module....");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String Username							            =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				if(mode.equals("New")){
					
					String LogoutXpath =".//*[@id='log-out']/a";
					String UsernameXpath=".//*[@id='txtUsername']";
					String GobuttonXpath=".//*[@id='btnLogin']";
					String FogotPassword=".//*[@id='login-container']/table[2]/tbody/tr/td/table/tbody/tr[4]/td[2]/a[text()='Forgot Password?']";
					String ForgetPasswordPageUsername=".//*[@id='form1']//*[@id='txtUserName']";
					try {
						
						Thread.sleep(1000);
						utilfunc.MakeElement(LogoutXpath).click();
						Thread.sleep(1000);
						
						try {
							utilfunc.MakeElement(UsernameXpath).clear();
							utilfunc.MakeElement(UsernameXpath).sendKeys(Username);
						} catch (Exception e) {
							System.out.println("Not able to entered the user name");
						}
						
						try {
							Thread.sleep(800);
							utilfunc.MakeElement(GobuttonXpath).click();
							Thread.sleep(800);
							
						} catch (Exception e) {System.out.println("Unable to clicked on the Go button");
						}
						
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(FogotPassword).click();
							Thread.sleep(1000);
						} catch (Exception e) {
							System.out.println("Unable to find the link");
						}
						
						try {
							utilfunc.MakeElement(ForgetPasswordPageUsername).clear();
							utilfunc.MakeElement(ForgetPasswordPageUsername).sendKeys(Username);
						} catch (Exception e) {
							System.out.println("unable to entered the name");
						}
					
					} catch (Exception e) {
						System.out.println("Unable to find the logout link");
					}
					
					
				}
				try{
					 // save button after saving all data..
					String submitBtn	=	".//a[contains(@class,'btn')]//.[contains(text(),'Submit')]";
		        	utilfunc.MakeElement(submitBtn).click();
				}
				catch(Exception e){}
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.WebAccessErrorMessageHandler();
				//	ExpectedErrorMessage=ExpectedErrorMessage.trim();
					System.out.println("==="+ExpectedErrorMessage+"===");
					System.out.println("==="+error_flag+"===");
					
					 if (error_flag.equals(ExpectedErrorMessage)){
						 Flag=true;
						 utilfunc.TakeScreenshot();
					 }else if (error_flag.equals("")){
						 Flag=true;
					 }else if (error_flag.contains("Success!")){
						 Flag=true;
					 }else if(error_flag.equals("Server Error in '/' Application.")){
						 Flag=false;
						 webdriver.navigate().back();
					 }else if(error_flag.contains("Error! Password must be different from current passwords.")){
						 Flag=false;
						 utilfunc.TakeScreenshot();
						 webdriver.navigate().back();
						 
					 }
					 
					 else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
				}catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved because all fields are not set in the form.");
				}
				
				
				
			}
return Flag;
}
}
