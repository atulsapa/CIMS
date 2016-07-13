package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Permission_Admin {
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	 public CIMS_Permission_Admin(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		}
	 

	      public boolean Permission_Admin(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String xAppName							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String searchCompanyName							        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String xRoleId							    =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String xPermissionId							            =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String xPermissionLevel							    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			
			String xFriendlyId							                =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String xDescriptionId							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			

			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				if(mode.equals("Delete")){
					return false;
				}
				
				if(mode.equalsIgnoreCase("New")){
					

					
					try{
						String AddNewPermission_AdminXpath	=	".//a[contains(@class,'btn') and contains(text(),'Add New')]";
						utilfunc.MakeElement(AddNewPermission_AdminXpath).click();
						System.out.println("======Click on the Add Add New Permission Admin ======");
					}catch(Exception e){
						System.out.println("unable to click on add new button");
					}
					
					try{
					String FormFieldXpath		=	"//*[@id='form_modal']//*[@class='control-group'][xx]//*[@name and not(@name='star')]";
					String FormFieldsCounterXpath		=	"//*[@id='form_modal']//*[@class='control-group']";
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					for(int i=1; i<=resultCount; i++){
						Thread.sleep(3000);
						
						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute Name is" + " " + AttributeName);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						
						if(AttributeName.equals("xAppName")){
							
							try {
								Thread.sleep(1000);
								utilfunc.Selectdropdownvaluebytext(NewXpath, xAppName);
							
							} catch (Exception e) {
								System.out.println("===Unable to select the value from xAppName ===");
							}
							
							
						}else if (AttributeName.equals("searchCompanyName")){
							    utilfunc.MakeElement(NewXpath).clear();
							try {
								Thread.sleep(1000);
								utilfunc.MakeElement(NewXpath).sendKeys(searchCompanyName);
								Thread.sleep(1500);
								utilfunc.selectFirstResultFromAutoSuggestion(searchCompanyName);
								
							} catch (Exception e) {
								System.out.println("===Unable to enter the value in searchCompanyName ===");
							}
							}else if (AttributeName.equals("xRoleId")){
								
								try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, xRoleId);
								} catch (Exception e) {
									
									System.out.println("===Unable to select the value===");
								}
								
								
							}else if (AttributeName.equals("xPermissionId")){
								
								try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, xPermissionId);
								} catch (Exception e) {
									
									System.out.println("===Unable to select the value===");
								}
								
								
							}else if (AttributeName.equals("xPermissionLevel")){
								
								try{
									if(xPermissionLevel.equalsIgnoreCase("Read only"))
									{
										try {
											utilfunc.MakeElement(NewXpath+"//.[@value=1]").click();
										} catch (Exception e) {
											
										}
									}
									else if(xPermissionLevel.equalsIgnoreCase(" Read & Write "))
									{
										try {
											utilfunc.MakeElement(NewXpath+"//.[@value='2']").click();
										} catch (Exception e) {
											
										}
									}else{
										try {
											utilfunc.MakeElement(NewXpath+"//.[@value='3']").click();
										} catch (Exception e) {
											
										}
									}
								}catch(Exception errror){}
								
							}else if (AttributeName.equals("xFriendlyId")){
								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(xFriendlyId);
									
								} catch (Exception e) {
									
									System.out.println("===Unable to entered the value===");
								}
								
								
							}else if (AttributeName.equals("xDescriptionId")){
								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(xDescriptionId);
									
								} catch (Exception e) {
									
									System.out.println("===Unable to entered the value===");
								}
								
								
							}else{
								System.out.println("===Please select the mandatory fields.===");
							}
					
					}
					}catch(Exception e){
						Flag	=	false;
						System.out.println("Unable to insert data into "+sheetName+" form");
						
					}
				
				}
				
				if(mode.equals("Edit")){
					
					String ApplicationXapth=".//*[@class='tblRP']//*[@id='AppName']";
					String SearchXpath=".//*[contains(@class,'btn') and contains(text(),'Search')]";
					String PrivilageXpath="//*[@id='form_modal']//*[@class='control-group'][5]//*[@name and not(@name='star')]";
					
					String FirstRecordXpath="//*[@id='form']//tbody//tr[1]//td[1]//a[1]";
					
					try {
						utilfunc.Selectdropdownvaluebytext(ApplicationXapth,xAppName);
					} catch (Exception e) {
						
					}
					
					try {
						utilfunc.MakeElement(SearchXpath).click();
					} catch (Exception e) {
						

					}
					
					try {
						utilfunc.MakeElement(FirstRecordXpath).click();
					} catch (Exception e1) {
						
					}
					
					
					
					if (PrivilageXpath.equals("xPermissionLevel")){
						
						try{
							if(xPermissionLevel.equalsIgnoreCase("None")){
								
								utilfunc.MakeElement(PrivilageXpath+"//.[@value=0]").click();
								
							}
							
							
						else if(xPermissionLevel.equalsIgnoreCase("Read only"))
							{
								try {
									utilfunc.MakeElement(PrivilageXpath+"//.[@value=1]").click();
								} catch (Exception e) {
									
								}
							}
							else if(xPermissionLevel.equalsIgnoreCase("Read & Write"))
							{
								try {
									utilfunc.MakeElement(PrivilageXpath+"//.[@value='2']").click();
								} catch (Exception e) {
									
								}
							}else {
								try {
									utilfunc.MakeElement(PrivilageXpath+"//.[@value='3']").click();
								} catch (Exception e) {
									
								}
							}
						}catch(Exception errror){}
						
					}
					
					
				}
				
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}
				catch(Exception e){}
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.PermissionErrorMessagehandlerExperiment();
		//			ExpectedErrorMessage=ExpectedErrorMessage.trim();
					System.out.println("==="+ExpectedErrorMessage+"====");
					System.out.println("==="+error_flag+"===");
					
					String closeBtnXpath=".//*[contains(@class,'close') and text()='×']";
					
					 if (error_flag.equals(ExpectedErrorMessage)){
						 Flag=true;
						 utilfunc.TakeScreenshot();
						 try {
							 Thread.sleep(3000);
							utilfunc.MakeElement(closeBtnXpath).click();
							Thread.sleep(3000);
						} catch (Exception e) {
						System.out.println("Unable to click on the link");
						}
					 }else if (error_flag.equals("")){
						 Flag=true;
					 }else if (error_flag.contains("Success!")){
						 Flag=true;
					 }else if(error_flag.equals("Server Error in '/' Application.")){
						 Flag=false;
						 webdriver.navigate().back();
					 }else if(error_flag.contains("Error! These Permission and Role are duplicated.")){
						 
						 Flag=false;
						 utilfunc.TakeScreenshot();
						 try {
							 Thread.sleep(3000);
							utilfunc.MakeElement(closeBtnXpath).click();
							Thread.sleep(3000);
						} catch (Exception e) {
						System.out.println("Unable to click on the link");
						}
						 
					
						 
						// webdriver.navigate().back();
						 
					 }
					 
					 else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
						 try {
							 Thread.sleep(3000);
							utilfunc.MakeElement(closeBtnXpath).click();
							Thread.sleep(3000);
						} catch (Exception e) {
						System.out.println("Unable to click on the link");
						}
					 }
				}catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved because all fields are not set in the form.");
				}
				
				
			}
			
			return Flag;
	      }

}
