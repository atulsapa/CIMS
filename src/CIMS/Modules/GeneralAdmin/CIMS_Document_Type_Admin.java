package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Document_Type_Admin {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	 public CIMS_Document_Type_Admin(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		}
	 

	      public boolean Document_Type(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

			boolean Flag	=	false;
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String DocumentCategoryId							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String CountryCode							        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String DocumentTypeName							    =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String FormName							            =			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String TriggerDateRange							    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String Note							                =			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			

			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				
				if(mode.equalsIgnoreCase("Delete")){
					System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
	      			System.out.println("search ....");
	      			String SearchCountryXpath=".//*[contains(@id,'country') and (@class='span3')]";
                  	String SearchDocTpyeXpath=".//*[contains(@id,'dname') and (@class='span3')]";
                  	String SearchBtn=".//*[contains(@class,'btn') and contains(text(),'Search')]";
	            	  try {
						Thread.sleep(1000);
						  utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, CountryCode);
					} catch (Exception e1) {
						
					}
	            	  Thread.sleep(500);
	            	  utilfunc.MakeElement(SearchDocTpyeXpath).clear();
	            	  utilfunc.MakeElement(SearchDocTpyeXpath).sendKeys(DocumentTypeName);
	            	  Thread.sleep(1000);
	            	  try {
						utilfunc.MakeElement(SearchBtn).click();
					 }catch (Exception e1) {}
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
       						ExpectedErrorMessage=ExpectedErrorMessage.trim();
       						System.out.println("==="+ExpectedErrorMessage+"===");
       						System.out.println("==="+error_flag+"===");
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

				
				
				
				if(mode.equalsIgnoreCase("New")){
					
					try{
						String AddNewDocType	=	".//a[contains(@class,'btn') and contains(text(),'Add Document Type')]";
						utilfunc.MakeElement(AddNewDocType).click();
						System.out.println("======Click on the Add Document Type ======");
					}catch(Exception e){
						System.out.println("unable to click on add new button");
					}
					
					try{
					String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
					String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					for(int i=1; i<=resultCount; i++){
						Thread.sleep(3000);
						
						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute Name is" + " " + AttributeName);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						
						if(AttributeName.equals("DocumentCategoryId")){
							
							try {
								Thread.sleep(1000);
								utilfunc.Selectdropdownvaluebytext(NewXpath, DocumentCategoryId);
								System.out.println(AttributeName+" has been selected");
							} catch (Exception e) {
								System.out.println("===Unable to select the value from DocumentCategoryId ===");
							}
							
							
						}else if (AttributeName.equals("CountryCode")){
							
							try {
								Thread.sleep(1000);
								utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
								
								System.out.println(AttributeName+" has been selected");
							} catch (Exception e) {
								System.out.println("===Unable to select the value from Country ===");
							}
							}else if (AttributeName.equals("DocumentTypeName")){
								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(DocumentTypeName);
									System.out.println(AttributeName+" has been entred");
								} catch (Exception e) {
									
									System.out.println("===Unable to entered the value===");
								}
								
								
							}else if (AttributeName.equals("FormName")){
								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(FormName);
									System.out.println(AttributeName+" has been entred");
								} catch (Exception e) {
									
									System.out.println("===Unable to entered the value===");
								}
								
								
							}else if (AttributeName.equals("TriggerDateRange")){
								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(TriggerDateRange);
									System.out.println(AttributeName+" has been entred");
								} catch (Exception e) {
									
									System.out.println("===Unable to entered the value===");
								}
								
								
							}else if (AttributeName.equals("Note")){
								
								try {
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(Note);
									System.out.println(AttributeName+" has been entred");
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
				//Code start here for edit document type
				if(mode.equalsIgnoreCase("Edit")){
	            	try{
	            	System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
	      			System.out.println("search ....");
	      			String SearchCountryXpath=".//*[contains(@id,'country') and (@class='span3')]";
                  	String SearchDocTpyeXpath=".//*[contains(@id,'dname') and (@class='span3')]";
                  	String SearchBtn=".//*[contains(@class,'btn') and contains(text(),'Search')]";
	            	  try {
						Thread.sleep(1000);
						  utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, CountryCode);
					} catch (Exception e1) {
						
					}
	            	  Thread.sleep(500);
	            	  utilfunc.MakeElement(SearchDocTpyeXpath).clear();
	            	  utilfunc.MakeElement(SearchDocTpyeXpath).sendKeys(DocumentTypeName);
	            	  Thread.sleep(3000);
	            	  try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e1) {}
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
	            	      Thread.sleep(3000);
	            	      
	  					  String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
	  					  String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
	  					  int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
	  					
	  					      for(int i=1; i<=resultCount; i++){
	  							Thread.sleep(3000);
	  							
	  							String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
	  							String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
	  							System.out.println("Attribute Name is" + " " + AttributeName);
	  							System.out.println("New Xpath is:" + " "+ NewXpath);
	  							
	  							if(AttributeName.equals("DocumentCategoryId")){
	  								
	  								try {
	  									Thread.sleep(1000);
	  									utilfunc.Selectdropdownvaluebytext(NewXpath, DocumentCategoryId);
	  									System.out.println(AttributeName+" has been selected");
	  								} catch (Exception e) {
	  									System.out.println("===Unable to select the value from DocumentCategoryId ===");
	  								}
	  								
	  								
	  							}else if (AttributeName.equals("CountryCode")){
	  								
	  								try {
	  									Thread.sleep(1000);
	  									utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
	  									
	  									System.out.println(AttributeName+" has been selected");
	  								} catch (Exception e) {
	  									System.out.println("===Unable to select the value from Country ===");
	  								}
	  								}else if (AttributeName.equals("DocumentTypeName")){
	  									
	  									try {
	  										utilfunc.MakeElement(NewXpath).clear();
	  										utilfunc.MakeElement(NewXpath).sendKeys(DocumentTypeName);
	  										System.out.println(AttributeName+" has been entred");
	  									} catch (Exception e) {
	  										
	  										System.out.println("===Unable to entered the value===");
	  									}
	  									
	  									
	  								}else if (AttributeName.equals("FormName")){
	  									
	  									try {
	  										utilfunc.MakeElement(NewXpath).clear();
	  										utilfunc.MakeElement(NewXpath).sendKeys(FormName);
	  										System.out.println(AttributeName+" has been entred");
	  									} catch (Exception e) {
	  										
	  										System.out.println("===Unable to entered the value===");
	  									}
	  									
	  									
	  								}else if (AttributeName.equals("TriggerDateRange")){
	  									
	  									try {
	  										utilfunc.MakeElement(NewXpath).clear();
	  										utilfunc.MakeElement(NewXpath).sendKeys(TriggerDateRange);
	  										System.out.println(AttributeName+" has been entred");
	  									} catch (Exception e) {
	  										
	  										System.out.println("===Unable to entered the value===");
	  									}
	  									
	  									
	  								}else if (AttributeName.equals("Note")){
	  									
	  									try {
	  										utilfunc.MakeElement(NewXpath).clear();
	  										utilfunc.MakeElement(NewXpath).sendKeys(Note);
	  										System.out.println(AttributeName+" has been entred");
	  									} catch (Exception e) {
	  										
	  										System.out.println("===Unable to entered the value===");
	  									}
	  									
	  									
	  								}else{
	  									System.out.println("===Please select the mandatory fields.===");
	  								}
	  							
	  							
	  							
	  							
	  						}
	  				
	            	      
	            	
	            	
	            		   
	            		  
	            		  
	            	  }
	            	  
	            	  }catch(Exception e){
	            		  System.out.println("==Error in search data==");
	            		  }
	            	  
	              }
				
				//Code end here for edit document type
                  				
			
			
			try{
				 // save button after saving all data..
				String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	        	utilfunc.MakeElement(saveBtn).click();
			}
			catch(Exception e){}
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
				 }else{
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
