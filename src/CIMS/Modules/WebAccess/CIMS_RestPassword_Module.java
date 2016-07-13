package CIMS.Modules.WebAccess;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_RestPassword_Module {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_RestPassword_Module(WebDriver driver,UtilFunction utilfunc) {
	    	  
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    }


		public boolean Resetpassword(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module....");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String Password							        =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String ConfirmPassword							        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name and not(@name='star')]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
				
				
				if(mode.equals("New")||mode.equals("Edit")){
					
					String ResetPasswordlink=".//*[@id='rnav-principal-info']/tbody/tr[2]/td[2]//a[text()='Reset']";
					
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(ResetPasswordlink).click();
					} catch (Exception e1) {
						System.out
								.println("Unable to click on the link");
					}
					
					
					
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					for(int i=1;i<=resultCount;i++){
						
                       Thread.sleep(3000);
						
						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute Name is" + " " + AttributeName);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						
						if(AttributeName.contentEquals("Password1")){
							
							utilfunc.MakeElement(NewXpath).clear();
							utilfunc.MakeElement(NewXpath).sendKeys(Password);
							
						}else if(AttributeName.contentEquals("Password2")){
							
							utilfunc.MakeElement(NewXpath).clear();
							utilfunc.MakeElement(NewXpath).sendKeys(ConfirmPassword);
							
							
							
						}else{
							System.out.println("Field not found.");
						}
						
						
					}
					
					
					
				}
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn')]//.[contains(text(),'Save')]";
		        	utilfunc.MakeElement(saveBtn).click();
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
