package CIMS.Modules.GeneralAdmin;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_Questionnaire_Admin_Edit_Custom_Label {
	
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.
	/**
	 * @param args
	 */

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 
	
		
	 
	 public CIMS_Questionnaire_Admin_Edit_Custom_Label(WebDriver driver,UtilFunction utilfunc) {
		 {
				this.webdriver =driver;
				this.utilfunc=utilfunc;
		}	
		 
	 }


	public boolean Edit_Custom_Label(String filename, String sheetName,int ColumnCounter,String mode)throws AWTException, InterruptedException {
			boolean Flag	=	false;
	      			
			
			System.out.println("user is on '"+sheetName+"' module....");
			System.out.println("entering "+mode+" mode for "+sheetName+" module.");
			
			String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
			String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
			String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
			String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
			String CountryCode                                  =           UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
			String ModuleId                                     =           UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
			String DataFieldId                                  =           UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
			String DefaultLabel                                 =           UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
			String Label                                        =           UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
			
			String Show                                         =           UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
			String UserType                                     =           UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
			String ParamHelpText                                =           UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
			
			

			String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			
			
			testcaseid=TestcaseID;
			scenerio=Scenario;
			description=TestCaseDescription;
			
			if(TestcaseRunMode.equals("Y")){
				
				String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
				String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
				String NewXpath;
			    String AttributeName;
				
			    String SearchCountryXpath=".//*[contains(@class,'form-h')]//*[@id='NewCountryCode']";
				String SearchBtn=".//*[contains(@id,'btnSearch')]//*[contains(@class,'icon-search')]";
				String EditIconXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//.[contains(@class,'edit')]";
				String EditCustomLabellinkXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[7]//*[contains(@class,'dropdown-menu pull-right')]//li[4]//.[contains(text(),'Edit Custom Labels')]";
				
				
				try {
					utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, CountryCode);
				} catch (Exception e) {}
				
				try {
					utilfunc.MakeElement(SearchBtn).click();
				} catch (Exception e) {}
				
				 try {
					String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
					 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
					
					 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
						  
						Flag=false;
						return Flag;
					   }else{
						   utilfunc.scrollToTop();
						   
						   try {
							   Thread.sleep(1000);
							utilfunc.MakeElement(EditIconXpath).click();
							Thread.sleep(4000);
							utilfunc.MakeElement(EditCustomLabellinkXpath).click();
							Thread.sleep(4000);
						} catch (Exception e) {}
					   }
				} catch (Exception e1) {}   
            		   Thread.sleep(1000);
            	
			    
			    
			    
				if(mode.equals("New")){
					
						   
	            		 String AddNewCustomLabelBtnXpath=".//*[contains(@class,'btn') and (contains(text(),'Add Custom Labe'))]";
	            		   
	            		   try {
	            			   Thread.sleep(500);
							utilfunc.MakeElement(AddNewCustomLabelBtnXpath).click();
						} catch (Exception e) {}
	            		   Thread.sleep(1000);
	            		   int resultcount= utilfunc.GetObjectCount(FormFieldsCounterXpath);
		   				    
		   				    for(int i=1; i<=resultcount; i++){
		   				    	
		   				    	NewXpath = FormFieldXpath.replace("xx", Integer.toString(i));
		   				    	//String AddBtnXpath = AddSectionBtnXpath.replace("pp", Integer.toString(i));
		   				    	
		   				    	AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
		   				    	
		   				    	System.out.println("New Xpath" + " "+ NewXpath);
		   				    	System.out.println("AttributeName"+" " + AttributeName);
		   				    	
		   				    	if(AttributeName.equals("ModuleId")){
		   				    	try {
		   				    			Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath,ModuleId);
									} catch (Exception e) {}
		   				    		
		   				    		
		   				    	}else if(AttributeName.equals("DataFieldId")){
		   				    		
		   				    		try {
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath,DataFieldId);
									} catch (Exception e) {}
		   				    	}else if(AttributeName.equals("DefaultLabel")){
		   				    		
		   				    		try {
										if(DefaultLabel.equals("Yes")){
											Thread.sleep(500);
											
											utilfunc.enableOrDisableCheckbox(NewXpath + "//.[@value='true']", true);
										}else{
											
											utilfunc.enableOrDisableCheckbox(NewXpath + "//.[@value='false']", false);
										}
									} catch (Exception e) {}
		   				    		
		   				    		
		   				    	}else if(AttributeName.equals("Label")){
		   				    		
		   				    		
		   				    		try {
		   				    			utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Label);
									} catch (Exception e) {}
		   				    		
		   				    	}else if(AttributeName.equals("Show")){
		   				    		
		   				    		if(Show.equals("Yes")){
		   				    			
		   				    			utilfunc.enableOrDisableCheckbox(NewXpath + "//.[@value='true']", true);
		   				    		}else{
		   				    			
		   				    			utilfunc.enableOrDisableCheckbox(NewXpath + "//.[@value='false']", false);
		   				    		}
		   				    		
		   				    	}else if(AttributeName.equals("UserType")){
		   				    		
		   				    		try {
										utilfunc.Selectdropdownvaluebytext(NewXpath, UserType);
									} catch (Exception e) {}
		   				    	}else if(AttributeName.equals("ParamHelpText")){
		   				    		
		   				    		utilfunc.MakeElement(NewXpath).clear();
		   				    		try {
										utilfunc.MakeElement(NewXpath).sendKeys(ParamHelpText);
									} catch (Exception e) {}
		   				    	}else{
		   				    		System.out.println("Please fill the mandatory fields.");
		   				    	}
		   				    	}
		   				    }
				if(mode.equals("Edit")){
					String SearchModuleXpath=".//*[contains(@class,'project-sea')]//*[@id='ModuleId']";
					String EditCustomlabelXpath="//*[contains(@class,'table-rec-container')]//tbody//tr[1]//td[5]//.[contains(@class,'edit')]";
					
					try {
						utilfunc.Selectdropdownvaluebytext(SearchModuleXpath,ModuleId);
					} catch (Exception e) {}
					
					try {
						utilfunc.MakeElement(SearchBtn).click();
					} catch (Exception e) {}
					
					 try {
						String NorecordXpath=".//*[@class='table-rec-container']//tbody//tr[1]//td[2]";
						 String RecordNotFound= utilfunc.MakeElement(NorecordXpath).getText();
						
						 if(RecordNotFound.equalsIgnoreCase("No Data Found!")){
							  
							Flag=false;
							return Flag;
						   }else{
							   utilfunc.scrollToTop();
							   
							   try {
								   Thread.sleep(1000);
								utilfunc.MakeElement(EditCustomlabelXpath).click();
								
							} catch (Exception e) {}
						   }
					} catch (Exception e1) {}   
	            		   Thread.sleep(1000);
	            		   
	            		   
	            		   int resultcount= utilfunc.GetObjectCount(FormFieldsCounterXpath);
		   				    
		   				    for(int i=1; i<=resultcount; i++){
		   				    	
		   				    	NewXpath = FormFieldXpath.replace("xx", Integer.toString(i));
		   				    	//String AddBtnXpath = AddSectionBtnXpath.replace("pp", Integer.toString(i));
		   				    	
		   				    	AttributeName = utilfunc.MakeElement(NewXpath).getAttribute("name");
		   				    	
		   				    	System.out.println("New Xpath" + " "+ NewXpath);
		   				    	System.out.println("AttributeName"+" " + AttributeName);
		   				    	
		   				    	if(AttributeName.equals("ModuleId")){
		   				    	try {
		   				    			Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath,ModuleId);
									} catch (Exception e) {}
		   				    		
		   				    		
		   				    	}else if(AttributeName.equals("DataFieldId")){
		   				    		
		   				    		try {
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath,DataFieldId);
									} catch (Exception e) {}
		   				    	}else if(AttributeName.equals("DefaultLabel")){
		   				    		
		   				    		try {
										if(DefaultLabel.equals("Yes")){
											Thread.sleep(500);
											
											utilfunc.enableOrDisableCheckbox(NewXpath + "//.[@value='true']", true);
										}else{
											
											utilfunc.enableOrDisableCheckbox(NewXpath + "//.[@value='false']", false);
										}
									} catch (Exception e) {}
		   				    		
		   				    		
		   				    	}else if(AttributeName.equals("Label")){
		   				    		
		   				    		
		   				    		try {
		   				    			utilfunc.MakeElement(NewXpath).clear();
										utilfunc.MakeElement(NewXpath).sendKeys(Label);
									} catch (Exception e) {}
		   				    		
		   				    	}else if(AttributeName.equals("Show")){
		   				    		
		   				    		if(Show.equals("Yes")){
		   				    			
		   				    			utilfunc.enableOrDisableCheckbox(NewXpath + "//.[@value='true']", true);
		   				    		}else{
		   				    			
		   				    			utilfunc.enableOrDisableCheckbox(NewXpath + "//.[@value='false']", false);
		   				    		}
		   				    		
		   				    	}else if(AttributeName.equals("UserType")){
		   				    		
		   				    		try {
										utilfunc.Selectdropdownvaluebytext(NewXpath, UserType);
									} catch (Exception e) {}
		   				    	}else if(AttributeName.equals("ParamHelpText")){
		   				    		
		   				    		utilfunc.MakeElement(NewXpath).clear();
		   				    		try {
										utilfunc.MakeElement(NewXpath).sendKeys(ParamHelpText);
									} catch (Exception e) {}
		   				    	}else{
		   				    		System.out.println("Please fill the mandatory fields.");
		   				    	}
		   				    	}
		   			
					
					
				}
				
				try{
					 // save button after saving all data..
					String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
				    Thread.sleep(1000);
		        	utilfunc.MakeElement(saveBtn).click();
		        	Thread.sleep(2000);
				}catch(Exception e){}
//				try {
//					String updateBtnXpath=".//a[contains(@class,'btn') and text()='Update']";
//					utilfunc.MakeElement(updateBtnXpath).click();
//				} catch (Exception e1) {}
				
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
						 utilfunc.TakeScreenshot();
					 }else if (error_flag.contains("Success!")){
						 Flag=true;
						 utilfunc.TakeScreenshot();
					 }else if(error_flag.equals("Server Error in '/' Application.")){
						 Flag=false;
						 webdriver.navigate().back();
					 }else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
				}catch(Exception e){
					Flag	=	false;
					utilfunc.TakeScreenshot();
					System.out.println("Data is not saved because all fields are not set in the form.");
					
			}
				
				if(mode.equalsIgnoreCase("Delete")){
					System.out.println("========================\nReady to set values in "+sheetName+" in "+mode+" mode.\n========================");
	      			System.out.println("search ....");
	      			String SearchModuleXpath=".//*[contains(@class,'project-sea')]//*[@id='ModuleId']";
                  
                  	
                  	
	            	  try {
						Thread.sleep(1000);
						  utilfunc.Selectdropdownvaluebytext(SearchCountryXpath, CountryCode);
					} catch (Exception e1) {
						
					}
	            	  Thread.sleep(500);
	            	  utilfunc.Selectdropdownvaluebytext(SearchModuleXpath, ModuleId);
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
       						//ExpectedErrorMessage=ExpectedErrorMessage.trim();
       						System.out.println("==="+ExpectedErrorMessage+"===");
       						System.out.println("==="+error_flag+"===");
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
       						}else if(error_flag.contains("Server Error in '/' Application.")){
       							Flag=false;
       							webdriver.navigate().back();
       						}else if(error_flag.contains("Error! Label already exists or hidden.")){
       							Flag=false;
       							utilfunc.TakeScreenshot();
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
