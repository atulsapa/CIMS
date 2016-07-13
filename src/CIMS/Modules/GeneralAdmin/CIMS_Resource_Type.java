package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Resource_Type {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Resource_Type(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Resource_Type(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String ServiceName                                  =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String Description                                  =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				//String for Add ResourcesType
				String ResourcesTypeBtnXpath= ".//a[contains(@class,'btn') and contains(text(),'Resources Type')]";
				String AddNewResourcesTypeBtnXpath  =".//a[contains(@class,'btn') and contains(text(),'Add New Resource')]";
				String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name and not(@name='star')]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
				
				//String for Edit ResourcesType
				
				String EditResourcesTypeFirstRecordXpath=".//*[contains(@class,'rec-container')]//tbody//tr[1]//td[3]//*[contains(@class,'edit')]";
				
				
				//String for Delete ResourcesType
				
				String DeleteResourcesTypeFirstRecordXpath=".//*[contains(@class,'rec-container')]//tbody//tr[1]//td[3]//*[contains(@class,'trash')]";
				
				try {
					utilfunc.MakeElement(ResourcesTypeBtnXpath).click();
				} catch (Exception e2) {
					System.out.println("===Unable to click on the Resources Type button===");
				}
				
				
				if(mode.equals("New")){
					
					try {
						utilfunc.MakeElement(AddNewResourcesTypeBtnXpath).click();
					} catch (Exception e) {
						System.out.println("===Unable to click on the Add new Resources Type button===");
					}
					try{
						int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
						
						for(int i=1; i<=resultCount; i++){							
	                        Thread.sleep(3000);
							
							String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
							String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
							System.out.println("Attribute Name is" + " " + AttributeName);
							System.out.println("New Xpath is:" + " "+ NewXpath);
							
							if(AttributeName.equals("ServiceName")){
									
								    utilfunc.MakeElement(NewXpath).clear();
									try {
										utilfunc.MakeElement(NewXpath).sendKeys(ServiceName);
									} catch (Exception e) {}
									
									
								    }else if(AttributeName.equals("Description")){
										
									    utilfunc.MakeElement(NewXpath).clear();
										try {
											utilfunc.MakeElement(NewXpath).sendKeys(Description);
										} catch (Exception e) {}
										
										
									}else{
					                	   System.out.println("Please select all the mandatory fields..");
					                   }
						
						
						}
						
					}catch(Exception e){
						
						Flag	=	false;
						System.out.println("Unable to insert data into "+sheetName+" form");
					}
					
				}
				
				if(mode.equals("Edit")){
					
					try {
						utilfunc.MakeElement(EditResourcesTypeFirstRecordXpath).click();
					} catch (Exception e) {
						System.out.println("==Unable to click on the Edit button==");
					}
					
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					
					try {
						for(int i=1; i<=resultCount; i++){							
						    Thread.sleep(3000);
							
							String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
							String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
							System.out.println("Attribute Name is" + " " + AttributeName);
							System.out.println("New Xpath is:" + " "+ NewXpath);
							
//							if(AttributeName.equals("ServiceName")){
//									
//								    utilfunc.MakeElement(NewXpath).clear();
//									try {
//										utilfunc.MakeElement(NewXpath).sendKeys(ServiceName);
//									} catch (Exception e) {}
//									}
//									
								   if(AttributeName.equals("Description")){
										
									    utilfunc.MakeElement(NewXpath).clear();
										try {
											utilfunc.MakeElement(NewXpath).sendKeys(Description);
										} catch (Exception e) {}
										
										
									}else{
						            	   System.out.println("Please select all the mandatory fields..");
						               }
						
						
						}
					} catch (Exception e) {
						System.out.println("==Error message is showing==");
					}
					
					
					
					
				}
				
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}catch(Exception e){}
				try {
					String updateBtnXpath=".//a[contains(@class,'btn') and text()='Update']";
					utilfunc.MakeElement(updateBtnXpath).click();
				} catch (Exception e1) {}
				
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
					 }else if(error_flag.equals("Error! Duplicate entry.")){
						 Flag=false;
						 webdriver.navigate().back();
						 utilfunc.TakeScreenshot();
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
					
					 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
	            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
	            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
	            		  
	            		Flag=false;
	  					return Flag;
	            	   }else{
		            		   utilfunc.scrollToTop();
	   					System.out.println("Record founded. we are going to delete it.");
					
					try {
						Thread.sleep(2000);
						utilfunc.MakeElement(DeleteResourcesTypeFirstRecordXpath).click();
						Thread.sleep(500);
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
						
						
					} catch (Exception e) {
						System.out.println("===Error\n"+e+"\n===");
						
					}
					
	            }
				}
           	
			}
	return 	Flag;	
	}

}
