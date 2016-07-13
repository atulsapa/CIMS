package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Service_Code_Category_Admin {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Service_Code_Category_Admin(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Service_Code_Category_Admin(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String CategoryCode                                 =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String CategoryDescription                          =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name and not(@name='star')]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
				
				if(mode.equals("New")){
					
					
					try{
						String AddNewCreate_New_CategoryXpath	=	".//a[contains(@class,'btn') and contains(text(),'Create New Category')]";
						utilfunc.MakeElement(AddNewCreate_New_CategoryXpath).click();
						System.out.println("======Click on the Create New Category ======");
					}catch(Exception e){
						System.out.println("unable to click on Create New Category button");
					}
					
					try{
						
						int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
						
						for(int i=1; i<=resultCount; i++){							
                        Thread.sleep(3000);
						
						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute Name is" + " " + AttributeName);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						
                             if(AttributeName.equals("CategoryCode")){
							
						    utilfunc.MakeElement(NewXpath).clear();
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(CategoryCode);
							} catch (Exception e) {}
							
							
						    }else if(AttributeName.equals("CategoryDescription")){
								
							    utilfunc.MakeElement(NewXpath).clear();
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(CategoryDescription);
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
					
					
					String FirstRecordXpath=".//*[@id='form1']//*[contains(@class,'rec-container')]//tbody//tr[1]//td[3]//*[contains(@class,'edit')]";
					
					try {
						
						utilfunc.MakeElement(FirstRecordXpath).click();
					} catch (Exception e) {
						System.out.println("Unable to click on the Edit link");
					}
					
					
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					for(int i=1; i<=resultCount; i++){							
                    Thread.sleep(3000);
					
					String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
					String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
					System.out.println("Attribute Name is" + " " + AttributeName);
					System.out.println("New Xpath is:" + " "+ NewXpath);
					
                         if(AttributeName.equals("CategoryDescription")){
						
					    utilfunc.MakeElement(NewXpath).clear();
						try {
							utilfunc.MakeElement(NewXpath).sendKeys(CategoryDescription);
						} catch (Exception e) {}
						
						
					    }else{
		                	   System.out.println("Please select all the mandatory fields..");
		                   }
						
						
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
					//ExpectedErrorMessage=ExpectedErrorMessage.trim();
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
					 }else if(error_flag.contains("Duplicate! This Category Code already exist.")){
						 Flag=false;
						 utilfunc.TakeScreenshot();
						 webdriver.navigate().back();
						 
						 
					 }else{
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
