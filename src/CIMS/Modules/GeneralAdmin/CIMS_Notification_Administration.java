package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Notification_Administration {
	
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 public CIMS_Notification_Administration(WebDriver driver,UtilFunction utilfunc) {
	    	  
	    			this.webdriver =driver;
	    			this.utilfunc=utilfunc;
	    }


		public boolean Notification_Administration(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.....");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String xNotificationCode							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String xDescription						        	=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String xNotificationCategory					    =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String xOptionChoice							    =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
		
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){

				String AddNewNotification_AdministrationXpath	=	".//a[contains(@class,'btn') and contains(text(),'Add New')]";
				String FormFieldXpath		=	"//*[@id='form_modal']//*[@class='control-group'][xx]//*[@id]";
				String FormFieldsCounterXpath		=	"//*[@id='form_modal']//*[@class='control-group']";
				
				if(mode.equals("New")){
                      try{
						
						utilfunc.MakeElement(AddNewNotification_AdministrationXpath).click();
						System.out.println("======Click on the Add Reference List Type ======");
					}catch(Exception e){
						System.out.println("unable to click on add new button");
					}
					try{
						int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
    					
    					for(int i=1; i<=resultCount; i++){
    						Thread.sleep(3000);
    						
    						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
    						String Attributeid	=	utilfunc.MakeElement(NewXpath).getAttribute("id");
    						System.out.println("Attribute Name is" + " " + Attributeid);
    						System.out.println("New Xpath is:" + " "+ NewXpath);
    						
    						if(Attributeid.equals("xNotificationCode")){
    							
    							try {
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(xNotificationCode);
								} catch (Exception e) {
									System.out.println("Unable to enter the value");
								}
    							
    						}else if(Attributeid.equals("xDescription")){
    							try {
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(xDescription);
								} catch (Exception e) {
									System.out.println("Unable to enter the value");
								}	
    						}
    						else if(Attributeid.equals("xNotificationCategory")){
    							Thread.sleep(1000);
    							try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, xNotificationCategory);
								} catch (Exception e) {
									System.out.println("Unable to enter the value");
								}	
    						}
    						else if(Attributeid.equals("xOptionChoice")){
    							Thread.sleep(1000);
    							try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, xOptionChoice);
								} catch (Exception e) {
									System.out.println("Unable to enter the value");
								}	
    						}else{
    							System.out.println("Please select all the mandatory fields");
    						}
    					
    					
    				   }	
					}catch(Exception e){
						
						Flag	=	false;
						System.out.println("Unable to insert data into "+sheetName+" form");
						
					}
					
					
				}
				
				if(mode.equals("Edit")){
					try{
						String SearchNotification_AdministrationXpath=".//*[contains(@id,'NotificationCategory')]";
	                  	String SearchDescriptionXpath="//*[contains(@id,'OptionChoice')]";
	                  	String SearchBtn=".//*[@id='btnSearch']//*[contains(@class,'icon-search')]";
	      
	                  	try {
							utilfunc.Selectdropdownvaluebytext(SearchNotification_AdministrationXpath, xNotificationCategory);
						} catch (Exception e) {
							System.out.println("Unable to select the value");
						}
	                  	
	                  	try {
							utilfunc.Selectdropdownvaluebytext(SearchDescriptionXpath, xOptionChoice);
						} catch (Exception e) {
							System.out.println("Unable to select the value");
						}
						
	                  	try {
							utilfunc.MakeElement(SearchBtn).click();
						} catch (Exception e) {
							System.out.println("Unable to clicked on the search button");
						}
						
	                  	
	                  	 String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
		            	 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
		            	 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
		            		  
		            		Flag=false;
		  					return Flag;
		            	   }else{
		            		   utilfunc.scrollToTop();
		            		   String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//*[contains(@class,'edit')]";
		            		   try{
		            			   Thread.sleep(2000);
		            		   utilfunc.MakeElement(EditIconXpath).click();
		            		  System.out.println("===="+EditIconXpath+"====="+"Clicked on the same");
		            		   }catch(Exception e){
		            			   System.out.println("unable to clicked on edit");
		            		   }
		            		   
		            		   Thread.sleep(1000);
		            		   int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
		            		   
		            		   for(int i=1; i<=resultCount; i++){
		    						Thread.sleep(3000);
		    						
		    						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
		    						String Attributeid	=	utilfunc.MakeElement(NewXpath).getAttribute("id");
		    						System.out.println("Attribute Name is" + " " + Attributeid);
		    						System.out.println("New Xpath is:" + " "+ NewXpath);
		    						
		    						if(Attributeid.equals("xNotificationCode")){
		    							
		    							try {
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(xNotificationCode);
										} catch (Exception e) {
											System.out.println("Unable to enter the value");
										}
		    							
		    						}else if(Attributeid.equals("xDescription")){
		    							try {
											utilfunc.MakeElement(NewXpath).clear();
											utilfunc.MakeElement(NewXpath).sendKeys(xDescription);
										} catch (Exception e) {
											System.out.println("Unable to enter the value");
										}	
		    						}
		    						else if(Attributeid.equals("xNotificationCategory")){
		    							Thread.sleep(1000);
		    							try {
											utilfunc.Selectdropdownvaluebytext(NewXpath, xNotificationCategory);
										} catch (Exception e) {
											System.out.println("Unable to enter the value");
										}	
		    						}
		    						else if(Attributeid.equals("xOptionChoice")){
		    							Thread.sleep(1000);
		    							try {
											utilfunc.Selectdropdownvaluebytext(NewXpath, xOptionChoice);
										} catch (Exception e) {
											System.out.println("Unable to enter the value");
										}	
		    						}else{
		    							System.out.println("Please select all the mandatory fields");
		    						}
		    					
		    					
		    				   }
		            		  	   
		            	   }
						
					}catch(Exception e){
						System.out.println("==Error in search data==");
					}
					
					
					
				}
				
				   Thread.sleep(2000);
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}
				catch(Exception e){}
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.NotificationErrorMessagehandlerExperiment();
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
					 }else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
				}catch(Exception e){
					Flag	=	false;
					System.out.println("Data is not saved because all fields are not set in the form.");
				}
				
				if(mode.equalsIgnoreCase("Delete")){
					String SearchNotification_AdministrationXpath=".//*[contains(@id,'NotificationCategory')]";
                  	String SearchDescriptionXpath="//*[contains(@id,'OptionChoice')]";
                  	String SearchBtn=".//*[@id='btnSearch']//*[contains(@class,'icon-search')]";
      
                  	try {
						utilfunc.Selectdropdownvaluebytext(SearchNotification_AdministrationXpath, xNotificationCategory);
					} catch (Exception e) {
						System.out.println("Unable to select the value");
					}
                  	
                  	try {
						utilfunc.Selectdropdownvaluebytext(SearchDescriptionXpath, xOptionChoice);
					} catch (Exception e) {
						System.out.println("Unable to select the value");
					}
					
                  	try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {
						System.out.println("Unable to clicked on the search button");
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
