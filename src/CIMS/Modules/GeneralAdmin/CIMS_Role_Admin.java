package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Role_Admin {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Role_Admin(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Role_Admin(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String RoleGroup                                 =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String RoleName                          =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String Description                          =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String Elevated                          =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				String FormFieldXpath		=	"//*[@id='form1']//*[@id='panel-body']//tr[xx]//*[@id]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@id='panel-body']//tr";
				//String ElevatedCheckXpath=".//*[@id='form1']//*[@id='Elevated']";
				
				if(mode.equals("New")){
					
					try{
						String AddNewRoleXpath	=	".//a[contains(@class,'btn') and contains(text(),'Add New')]";
						utilfunc.MakeElement(AddNewRoleXpath).click();
						System.out.println("======Click on the Add New ======");
					}catch(Exception e){
						System.out.println("unable to click on Add New button");
					}
				
				try{
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					for(int i=1; i<=resultCount; i++){							
                        Thread.sleep(3000);
						
						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
						String AttributeID	=	utilfunc.MakeElement(NewXpath).getAttribute("id");
						System.out.println("Attribute Name is" + " " + AttributeID);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						
                           if(AttributeID.equals("RoleGroup")){
						   
							try {
								utilfunc.Selectdropdownvaluebytext(NewXpath, RoleGroup);
							} catch (Exception e) {}
							
                           }
							else if(AttributeID.equals("RoleName")){
								
							    utilfunc.MakeElement(NewXpath).clear();
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(RoleName);
								} catch (Exception e) {}
							}else if(AttributeID.equals("Description")){
								
							    utilfunc.MakeElement(NewXpath).clear();
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(Description);
								} catch (Exception e) {}
							}else if(AttributeID.equalsIgnoreCase("Elevated")){
								
								try {
									if(Elevated.equalsIgnoreCase("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								} catch (Exception e) {
									
								}
							}
							
							
							else{
								System.out.println("===Please select all the mandatory fields..===");
							}
					
					}
					
						
					
					
				}catch(Exception e){
					
					Flag	=	false;
					System.out.println("Unable to insert data into "+sheetName+" form");
				}
				}
				
				if(mode.equals("Edit")){
					
						
						String SearchRoleGroupXpath="//*[@class='form-horizontal']//tbody//tr[3]//*[contains(@id,'RoleGroup')]";
						String SearchBtnXpath=".//*[@id='btnSearch']";
						String FirstRecordXpath=".//*[contains(@class,'rec-container')]//tbody//tr[1]//td[6]//*[contains(@class,'edit')]";
						
						
						
						try {
							utilfunc.MakeElement(SearchRoleGroupXpath).sendKeys(RoleGroup);
						} catch (Exception e) {}
						
						try {
							utilfunc.MakeElement(SearchBtnXpath).click();
						} catch(Exception e){
							System.out.println("==Error in search data==");
						}
						
						try {
							utilfunc.MakeElement(FirstRecordXpath).click();
						} catch (Exception e) {}
						

						int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
						
						for(int i=1; i<=resultCount; i++){							
	                        Thread.sleep(3000);
							
							String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
							String AttributeID	=	utilfunc.MakeElement(NewXpath).getAttribute("id");
							System.out.println("Attribute Name is" + " " + AttributeID);
							System.out.println("New Xpath is:" + " "+ NewXpath);
							
	                           if(AttributeID.equals("RoleGroup")){
							   
								try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, RoleGroup);
								} catch (Exception e) {}
								
	                           }
								else if(AttributeID.equals("RoleName")){
									
								    utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(RoleName);
									} catch (Exception e) {}
								}else if(AttributeID.equals("Description")){
									
								    utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(Description);
									} catch (Exception e) {}
								}else if(AttributeID.equalsIgnoreCase("Elevated")){
									
									try {
										if(Elevated.equalsIgnoreCase("Yes")){
											utilfunc.enableOrDisableCheckbox(NewXpath, true);
										}else{
											utilfunc.enableOrDisableCheckbox(NewXpath, false);
										}
									} catch (Exception e) {
										
									}
								}
								
								
								else{
									System.out.println("===Please select all the mandatory fields..===");
								}
						
						}
						
							
						
						
					
					
					
				}
				
				
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}catch(Exception e){}
//				try {
//					String updateBtnXpath=".//a[contains(@class,'btn') and text()='Update']";
//					utilfunc.MakeElement(updateBtnXpath).click();
//				} catch (Exception e1) {}
				
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.PoclassificationErrorMessageHandler();
					ExpectedErrorMessage=ExpectedErrorMessage.trim();
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
					 }else if(error_flag.contains("Error! This role name is already existed.")){
						 Flag= false;
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
				
				if(mode.equals("Delete")){
					Thread.sleep(1000);

					String SearchRoleGroupXpath="//*[@class='form-horizontal']//tbody//tr[3]//*[contains(@id,'RoleGroup')]";
					String SearchBtnXpath=".//*[@id='btnSearch']";
					
					
					
					
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(SearchRoleGroupXpath).sendKeys(RoleGroup);
					} catch (Exception e) {}
					
					try {
						Thread.sleep(1000);
						utilfunc.MakeElement(SearchBtnXpath).click();
					} catch(Exception e){
						System.out.println("==Error in search data==");
					}
					 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
		            		   utilfunc.scrollToTop();
	   					System.out.println("Record founded. we are going to delete it.");
	   					try{
	   						Thread.sleep(2000);
	   						String DeleteBtnXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td//*[@class='icon-trash']";
	   						utilfunc.MakeElement(DeleteBtnXpath).click();
	   						Thread.sleep(300);
	   						Alert alt= webdriver.switchTo().alert();
	   						alt.accept();
	   						System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed.");
	   						String  error_flag="";
	   						try{
	   							error_flag=utilfunc.ErrorMessagehandlerExperiment();}
	   						catch(Exception e){}
	   						Thread.sleep(1000);
	   						System.out.println("error_flag is :"+error_flag);
	   						if (error_flag.equals(ExpectedErrorMessage)){
	   							Flag=true;
	   							utilfunc.TakeScreenshot();
	   						}else if (error_flag.equals("")){
	   							Flag=true;
	   						}else if(error_flag.equals("Server Error in '/' Application.")){
	   							Flag=false;
	   							webdriver.navigate().back();
	   						}else{
	   							Flag=false;
	   							utilfunc.TakeScreenshot();
	   						}
	   					}catch(Exception error){System.out.println("===Error\n"+error+"\n===");}
	   				}
	            		   
	            	   
				
					
				}
			
				

			}
			return Flag;
	}
}
