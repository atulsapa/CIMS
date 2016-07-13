package CIMS.Modules.WebAccess;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_WebAccessModule {
	
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

//	 public CIMS_WebAccessModule(WebDriver driver,UtilFunction utilfunc) {
//	    	  
//	    }
//

		public CIMS_WebAccessModule(WebDriver driver,UtilFunction utilfunc) {
			

			this.webdriver =driver;
			this.utilfunc=utilfunc;
		
	}


		public boolean WebAccessEnable(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module..");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String EnableLogin							        =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String SendUserRegEmail							    =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String loginMethod							        =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String Email							            =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			
			
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				String FormFieldCounterXpath="//*[@id='form1']//*[contains(@class,'control-group')]";
				String FormFieldXpath="//*[@id='form1']//*[contains(@class,'control-group')][xx]//*[@name and not(@type='hidden')]";
				String NewXpath;
				String AttributeName;
				
				if(mode.equals("New")|| mode.equals("Edit")){
					
					
					String WebAccessEditlink=".//*[@id='rnav-principal-info']//tbody//tr[1]//td[2]//a[text()='Edit']";
					
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(WebAccessEditlink).click();
					} catch (Exception e1) {
						System.out
								.println("Unable to click on the link");
					}

					
					try {
						int resultcount = utilfunc.GetObjectCount(FormFieldCounterXpath);
						
						for(int i=1;i<=resultcount; i++){
							
						       try {
								Thread.sleep(3000);
								
								NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
								AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
								System.out.println("Attribute Name is" + " " + AttributeName);
								System.out.println("New Xpath is:" + " "+ NewXpath);
								
								if(AttributeName.equals("EnableLogin")){
									
									if(EnableLogin.equals("Yes")){

										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
											Thread.sleep(1000);
										} catch (Exception e) {
										   System.out.println("Unable to click on the radio button yes");
										}
									}else{
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
											Thread.sleep(1000);
										} catch (Exception e) {
											System.out.println("Unable to click on the radio button no");
										}
									}
									
									
								}else if(AttributeName.equals("SendUserRegEmail")){

									
									if(SendUserRegEmail.equals("Yes")){

										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
											Thread.sleep(1000);
										} catch (Exception e) {
										   System.out.println("Unable to click on the radio button yes");
										}
									}else{
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
											Thread.sleep(1000);
										} catch (Exception e) {
											System.out.println("Unable to click on the radio button no");
										}
									}
									
									
								
									
								}else if(AttributeName.equals("loginMethod")){


									
									if(loginMethod.equals("Yes")){

										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='Internal']").click();
											Thread.sleep(1000);
										} catch (Exception e) {
										   System.out.println("Unable to click on the radio button yes");
										}
									}else{
										try {
											Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='SSO']").click();
											Thread.sleep(1000);
										} catch (Exception e) {
											System.out.println("Unable to click on the radio button no");
										}
									}
									
									
								}else if(AttributeName.equals("Email")){
									
									try {
										utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Email);
									} catch (Exception e) {
										
									}
									
									
								}
								else{
									System.out.println("Unable to find the field");
								}
								
								
								
							} catch (Exception e) {
								System.out.println("Field not found");
							}
							
						}
					} catch (Exception e) {
						Flag	=	false;
						System.out.println("Unable to insert data into "+sheetName+" form");
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
				}catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved because all fields are not set in the form.");
				}
			
				
				
				
			}
     return Flag;
    }


		 
}
