package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Service_Code_Classification_Admin {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Service_Code_Classification_Admin(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Service_Code_Classification_Admin(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String CountryCode                                  =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String CategoryId                                   =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String ClassificationCode                           =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String ClassificationDescription                    =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String DisplaySequence                              =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String TriggerDateRange                             =           UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String IsGCP                                        =           UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String DocumentRequirement                          =           UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			
			
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			
			if(TestcaseRunMode.equals("Y")){
				
				String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name and not(@name='star')]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
				String DocRequirmentXpath     = "//*[@id='form1']//*[@class='control-group'][8]//*[@id='DocumentTypeId']";
				String AddDocRequirmentXpath                 ="//*[@id='form1']//*[@class='control-group'][8]//*[contains(@class,'btn') and contains(text(),'Add')]";
				
				
				if(mode.equals("New")){
					
					try{
						String AddNewService_Code_ClassificationXpath	=	".//a[contains(@class,'btn') and contains(text(),'Create New Classification')]";
						utilfunc.MakeElement(AddNewService_Code_ClassificationXpath).click();
						System.out.println("======Click on the Create New Service_Code_Classification ======");
					}catch(Exception e){
						System.out.println("unable to click on Add New Service_Code_Classification button");
					}
					try{
						int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
						
						for(int i=1; i<=resultCount; i++){							
	                        Thread.sleep(3000);
							
							String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
							String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
							System.out.println("Attribute Name is" + " " + AttributeName);
							System.out.println("New Xpath is:" + " "+ NewXpath);
							
							if(AttributeName.equals("CountryCode")){
								    
								Thread.sleep(800);
								try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
								} catch (Exception e) {
									System.out.println("Unable to select the value");
								}
							}else if(AttributeName.equals("CategoryId")){
								
								Thread.sleep(800);
								try {
									utilfunc.Selectdropdownvaluebytext(NewXpath, CategoryId);
								} catch (Exception e) {
									System.out.println("Unable to select the value");
								}
							}else if(AttributeName.equals("ClassificationCode")){
								utilfunc.MakeElement(NewXpath).clear();
								Thread.sleep(800);
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(ClassificationCode);
								} catch (Exception e) {
									System.out.println("Unable to enter the value");
								}
							}else if(AttributeName.equals("ClassificationDescription")){
								
								utilfunc.MakeElement(NewXpath).clear();
								Thread.sleep(800);
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(ClassificationDescription);
								} catch (Exception e) {
									System.out.println("Unable to enter the value");
								}
							}else if(AttributeName.equals("DisplaySequence")){
								utilfunc.MakeElement(NewXpath).clear();
								Thread.sleep(800);
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(DisplaySequence);
								} catch (Exception e) {
									System.out.println("Unable to enter the value");
								}
							}else if(AttributeName.equals("TriggerDateRange")){
								utilfunc.MakeElement(NewXpath).clear();
								Thread.sleep(800);
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(TriggerDateRange);
								} catch (Exception e) {
									System.out.println("Unable to enter the value");
								}
							}else if(AttributeName.equals("IsGCP")){
							try{
								if(IsGCP.equalsIgnoreCase("Yes")){
									utilfunc.enableOrDisableCheckbox(NewXpath, true);
								}else{
									utilfunc.enableOrDisableCheckbox(NewXpath, false);
								}
								
							 }catch(Exception Error){}
							 }else{
								 System.out.println("please select the mandatory fields.");
							 }
					
					 }
						try {
							Thread.sleep(800);
							utilfunc.Selectdropdownvaluebytext(DocRequirmentXpath, DocumentRequirement);
						} catch (Exception e) {
							System.out.println("Unable to select the value");
						}
						Thread.sleep(1500);
						try {
							utilfunc.MakeElement(AddDocRequirmentXpath).click();
						} catch (Exception e) {
							System.out.println("Unable to clicked on the add button");
						}
					
					}catch(Exception e){
						
						Flag	=	false;
						System.out.println("Unable to insert data into "+sheetName+" form");
					}
					
					
				}
				if(mode.equals("Edit")){
					
					String SearchClassificationCodeXpath="//*[@class='form-horizontal']//tbody//tr[1]//*[contains(@class,'span3') and (@id='ClassificationCode')]";
					String SearchBtnXpath=".//*[@id='btnSearch']";
					String FirstRecordXpath=".//*[@id='form1']//*[contains(@class,'rec-container')]//tbody//tr[1]//td[6]//*[contains(@class,'edit')]";
					
					
					
					try {
						utilfunc.MakeElement(SearchClassificationCodeXpath).sendKeys(ClassificationCode);
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
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute Name is" + " " + AttributeName);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						
						if(AttributeName.equals("CountryCode")){
							    
							Thread.sleep(800);
							try {
								utilfunc.Selectdropdownvaluebytext(NewXpath, CountryCode);
							} catch (Exception e) {
								System.out.println("Unable to select the value");
							}
						}else if(AttributeName.equals("CategoryId")){
							
							Thread.sleep(800);
							try {
								utilfunc.Selectdropdownvaluebytext(NewXpath, CategoryId);
							} catch (Exception e) {
								System.out.println("Unable to select the value");
							}
						}else if(AttributeName.equals("ClassificationCode")){
							utilfunc.MakeElement(NewXpath).clear();
							Thread.sleep(800);
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(ClassificationCode);
							} catch (Exception e) {
								System.out.println("Unable to enter the value");
							}
						}else if(AttributeName.equals("ClassificationDescription")){
							
							utilfunc.MakeElement(NewXpath).clear();
							Thread.sleep(800);
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(ClassificationDescription);
							} catch (Exception e) {
								System.out.println("Unable to enter the value");
							}
						}else if(AttributeName.equals("DisplaySequence")){
							utilfunc.MakeElement(NewXpath).clear();
							Thread.sleep(800);
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(DisplaySequence);
							} catch (Exception e) {
								System.out.println("Unable to enter the value");
							}
						}else if(AttributeName.equals("TriggerDateRange")){
							utilfunc.MakeElement(NewXpath).clear();
							Thread.sleep(800);
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(TriggerDateRange);
							} catch (Exception e) {
								System.out.println("Unable to enter the value");
							}
						}else if(AttributeName.equals("IsGCP")){
						try{
							if(IsGCP.equalsIgnoreCase("Yes")){
								utilfunc.enableOrDisableCheckbox(NewXpath, true);
							}else{
								utilfunc.enableOrDisableCheckbox(NewXpath, false);
							}
							
						 }catch(Exception Error){}
						 }else{
							 System.out.println("please select the mandatory fields.");
						 }
				
				 }
					try {
						Thread.sleep(800);
						utilfunc.Selectdropdownvaluebytext(DocRequirmentXpath, DocumentRequirement);
					} catch (Exception e) {
						System.out.println("Unable to select the value");
					}
					Thread.sleep(1500);
					try {
						utilfunc.MakeElement(AddDocRequirmentXpath).click();
					} catch (Exception e) {
						System.out.println("Unable to clicked on the add button");
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
					String error_flag=utilfunc.PoclassificationErrorMessageHandler();
					ExpectedErrorMessage=ExpectedErrorMessage.trim();
					System.out.println("==="+ExpectedErrorMessage+"===");
					System.out.println("==="+error_flag+"===+SSSS");
					
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
					 }else if(error_flag.equals("Duplicate! This Classification Code already exist.")){
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
				
				if(mode.equals("Delete")){
					

					String SearchClassificationCodeXpath="//*[@class='form-horizontal']//tbody//tr[1]//*[contains(@class,'span3') and (@id='ClassificationCode')]";
					String SearchBtnXpath=".//*[@id='btnSearch']";
					
					try {
						utilfunc.MakeElement(SearchClassificationCodeXpath).sendKeys(ClassificationCode);
					} catch (Exception e) {}
					
					try {
						utilfunc.MakeElement(SearchBtnXpath).click();
					} catch (Exception e) {}
					
								
                  	
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
	   							error_flag=utilfunc.PoclassificationErrorMessageHandler();}
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
	   						}
	   						
	   						else{
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
