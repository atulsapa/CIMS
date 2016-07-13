package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Report_Administration {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Report_Administration(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }





	public boolean Report_Administration(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module...");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String xReportType							        =			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String xReportName							        =			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String xApplicationName							    =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String xLogixmlLink							        = 	        UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String xStoredProcName							    =			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			String xIsActive							        =		  	UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String xInternalExternal							=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String xCompanySpecificNotes						=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);

			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				if(mode.equals("Delete")){
					return false;
				}
				
				String FormFieldXpath		=	"//*[@id='form_modal']//*[@class='control-group'][xx]//*[@name and not(@name='star')]";
				String FormFieldsCounterXpath		=	"//*[@id='form_modal']//*[@class='control-group']";
				
			
				if(mode.equals("New")){
					
					try{
						String AddNewReport_AdministrationXpath	=	".//a[contains(@class,'btn') and contains(text(),'Add New')]";
						utilfunc.MakeElement(AddNewReport_AdministrationXpath).click();
						System.out.println("======Click on the Add Add New AddNewReport Administration ======");
					}catch(Exception e){
						System.out.println("unable to click on add new button");
					}
					
					try{
//					String FormFieldXpath		=	"//*[@id='form_modal']//*[@class='control-group'][xx]//*[@name and not(@name='star')]";
//					String FormFieldsCounterXpath		=	"//*[@id='form_modal']//*[@class='control-group']";
					int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
					
					for(int i=1; i<=resultCount; i++){
						Thread.sleep(3000);
						
						String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
						String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
						System.out.println("Attribute Name is" + " " + AttributeName);
						System.out.println("New Xpath is:" + " "+ NewXpath);
						
                           if(AttributeName.equals("xReportType")){
							
							try {
								Thread.sleep(1000);
								utilfunc.Selectdropdownvaluebytext(NewXpath, xReportType);
							
							} catch (Exception e) {
								System.out.println("===Unable to select the value from xReportType ===");
							}
							
							
						}else if(AttributeName.equals("xReportName")){
							
						    utilfunc.MakeElement(NewXpath).clear();
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(xReportName);
							} catch (Exception e) {}
							
							
						}else if(AttributeName.equals("xApplicationName")){
							
							try {
								Thread.sleep(1000);
								utilfunc.Selectdropdownvaluebytext(NewXpath, xApplicationName);
							
							} catch (Exception e) {
								System.out.println("===Unable to select the value from xAppName ===");
							}
							
							
						}else if(AttributeName.equals("xLogixmlLink")){
							
							utilfunc.MakeElement(NewXpath).clear();
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(xLogixmlLink);
							} catch (Exception e) {}
	
	
                        }else if(AttributeName.equals("xStoredProcName")){
                        	
                        	utilfunc.MakeElement(NewXpath).clear();
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(xStoredProcName);
							} catch (Exception e) {}
	
	
                      }else if(AttributeName.equals("xIsActive")){
                    	  
                    	  if(xIsActive.equalsIgnoreCase("Yes")){
                    		  
                    		  try {
								utilfunc.MakeElement(NewXpath+ "//.[@value=1]").click();
							} catch (Exception e) {}
                    		  
                          }else{
                        	  try {
								utilfunc.MakeElement(NewXpath+ "//.[@value=2]").click();
							} catch (Exception e) {}
                        }
					
                     }else if(AttributeName.equals("xInternalExternal")){
                    	 
                    	 utilfunc.MakeElement(NewXpath).clear();
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(xInternalExternal);
							} catch (Exception e) {}
	
	
	
                    }else if(AttributeName.equals("xCompanySpecificNotes")){
                    	 utilfunc.MakeElement(NewXpath).clear();
							try {
								utilfunc.MakeElement(NewXpath).sendKeys(xCompanySpecificNotes);
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
					try{
						String ApplicationXapth=".//*[@class='form-horizontal']//*[@id='AppName']";
						String RoleTypeXpath=".//*[@class='form-horizontal']//*[@id='ReportType']";
						String SearchXpath=".//*[contains(@class,'btn') and contains(text(),'Search')]";
						
						String FirstRecordXpath=".//*[@id='form']//*[@id='divList']/tbody/tr[1]/td[1]";
						
						try {
							Thread.sleep(500);
							utilfunc.Selectdropdownvaluebytext(ApplicationXapth, xApplicationName);
						} catch (Exception e) {}
						
						try {
							Thread.sleep(500);
							utilfunc.Selectdropdownvaluebytext(RoleTypeXpath, xReportType);
						} catch (Exception e) {}
						
						try {
							Thread.sleep(500);
							utilfunc.MakeElement(SearchXpath).click();
						} catch (Exception e) {}
						
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
							
	                           if(AttributeName.equals("xReportType")){
								
								try {
									Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebytext(NewXpath, xReportType);
								
								} catch (Exception e) {
									System.out.println("===Unable to select the value from xReportType ===");
								}
								
								
							}else if(AttributeName.equals("xReportName")){
								
							    utilfunc.MakeElement(NewXpath).clear();
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(xReportName);
								} catch (Exception e) {}
								
								
							}else if(AttributeName.equals("xApplicationName")){
								
								try {
									Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebytext(NewXpath, xApplicationName);
								
								} catch (Exception e) {
									System.out.println("===Unable to select the value from xAppName ===");
								}
								
								
							}else if(AttributeName.equals("xLogixmlLink")){
								
								utilfunc.MakeElement(NewXpath).clear();
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(xLogixmlLink);
								} catch (Exception e) {}
		
		
	                        }else if(AttributeName.equals("xStoredProcName")){
	                        	
	                        	utilfunc.MakeElement(NewXpath).clear();
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(xStoredProcName);
								} catch (Exception e) {}
		
		
	                      }else if(AttributeName.equals("xIsActive")){
	                    	  
	                    	  if(xIsActive.equalsIgnoreCase("Yes")){
	                    		  
	                    		  try {
									utilfunc.MakeElement(NewXpath+ "//.[@value=1]").click();
								} catch (Exception e) {}
	                    		  
	                          }else{
	                        	  try {
									utilfunc.MakeElement(NewXpath+ "//.[@value=2]").click();
								} catch (Exception e) {}
	                        }
						
	                     }else if(AttributeName.equals("xInternalExternal")){
	                    	 
	                    	 utilfunc.MakeElement(NewXpath).clear();
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(xInternalExternal);
								} catch (Exception e) {}
		
		
		
	                    }else if(AttributeName.equals("xCompanySpecificNotes")){
	                    	 utilfunc.MakeElement(NewXpath).clear();
								try {
									utilfunc.MakeElement(NewXpath).sendKeys(xCompanySpecificNotes);
								} catch (Exception e) {}
		
		
	                   }else{
	                	   System.out.println("Please select all the mandatory fields..");
	                   }
	                           
							
							
							
							
					}
					
						
						
						
						
					}catch(Exception e){
						System.out.println("==Error in search data==");
					}
					
				}
				
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
		        	utilfunc.MakeElement(saveBtn).click();
				}
				catch(Exception e){}
				
				String closeBtnXpath=".//*[contains(@class,'close') and text()='×']";
				try{
					System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					String error_flag=utilfunc.PermissionErrorMessagehandlerExperiment();
			//		ExpectedErrorMessage=ExpectedErrorMessage.trim();
					System.out.println("==="+ExpectedErrorMessage+"===");
					System.out.println("==="+error_flag+"===");
					
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
						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(closeBtnXpath).click();
							Thread.sleep(1000);
						} catch (Exception e) {
						System.out.println("Unable to click on the link");
						}


					 }
					 else if(error_flag.contains("duplicated")){
						 Flag=false;
						 utilfunc.TakeScreenshot();
						 try {
							 Thread.sleep(3000);
							utilfunc.MakeElement(closeBtnXpath).click();
							Thread.sleep(3000);
						} catch (Exception e) {
						System.out.println("Unable to click on the link");
						}


						 
					 }else{
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
