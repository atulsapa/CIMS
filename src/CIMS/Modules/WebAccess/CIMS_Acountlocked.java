package CIMS.Modules.WebAccess;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Acountlocked {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_Acountlocked(WebDriver driver,UtilFunction utilfunc) {
	    	  
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    }


		public boolean LockedAccount(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module....");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				if(mode.equals("New")){
				
				try {
					String LockedtextXpath =".//*[@id='rnav-principal-header']/table/tbody/tr/td/samp";
					
					String LockedText=	utilfunc.MakeElement(LockedtextXpath).getText();
					System.out.println("locked Text" + LockedText);
					
					if(LockedText.equals("(Locked)")){
						
					      String Accountunlocklink=".//*[@id='rnav-principal-info']//tbody//tr[1]//td[2]//a[text()='Unlock']";
						
						try {
							Thread.sleep(1000);
							utilfunc.MakeElement(Accountunlocklink).click();
						} catch (Exception e1) {
							System.out.println("Unable to click on the link");
						}
						}else{
							System.out.println("User account has alredy been unlocked ");
						
					}
				} catch (Exception e) {
					System.out.println("User account has alredy been unlocked ");
				}
				
				}
				
				System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
				String error_flag=utilfunc.WebAccessErrorMessageHandler();
			//	ExpectedErrorMessage=ExpectedErrorMessage.trim();
				System.out.println("==="+ExpectedErrorMessage+"===");
				System.out.println("==="+error_flag+"===");
				
				 if (error_flag.equals(ExpectedErrorMessage)){
					 Flag=true;
					 utilfunc.TakeScreenshot();
				 }else if (error_flag.contains("")){
					 Flag=true;
				 }else if (error_flag.contains("Success!")){
					 Flag=true;
				 }else if (error_flag.contains("Profile saved")){
					 Flag=true;
				 }
				 else if(error_flag.equals("Server Error in '/' Application.")){
					 Flag=false;
					 webdriver.navigate().back();
				 }else if(error_flag.contains("Error! You cannot create duplicate snippets.")){
					 Flag=false;
					 utilfunc.TakeScreenshot();
					 webdriver.navigate().back();
					 
				 }
				 else{
					 Flag=false;
					 utilfunc.TakeScreenshot();
				 }
			
		
				
				
			}
			return Flag;
			}
		}



