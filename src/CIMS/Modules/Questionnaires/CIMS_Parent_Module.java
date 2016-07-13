package CIMS.Modules.Questionnaires;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import util.UtilFunction;

public class CIMS_Parent_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	 public static String Deletecheck="";
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String ErrorMessage4="";
	 public static String URLwithID="";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";

	 //Constructor----------
	 
		public CIMS_Parent_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Parent_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Parent", 0, ColumnCounter);
			String ParentScenerio=UtilFunction.getCellData("Test Data.xls", "Parent", 2, ColumnCounter);
			String ParentTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Parent", 3, ColumnCounter);		
			String ParentPageURL=UtilFunction.getCellData("Test Data.xls", "Parent", 4, ColumnCounter);
			String ParentID=UtilFunction.getCellData("Test Data.xls", "Parent", 5, ColumnCounter);
			
			String Parents=UtilFunction.getCellData("Test Data.xls", "Parent", 6, ColumnCounter);
			String ParentFirstname=UtilFunction.getCellData("Test Data.xls", "Parent", 7, ColumnCounter);
			String Parentmiddlename=UtilFunction.getCellData("Test Data.xls", "Parent", 8, ColumnCounter);
			String Parentlastname=UtilFunction.getCellData("Test Data.xls", "Parent", 9, ColumnCounter);
			String ParentMaidenOtherNames=UtilFunction.getCellData("Test Data.xls", "Parent", 10, ColumnCounter);
			String ParentDateofBirth=UtilFunction.getCellData("Test Data.xls", "Parent", 11, ColumnCounter);
			String ParentCountryofBirth=UtilFunction.getCellData("Test Data.xls", "Parent", 12, ColumnCounter);
			String ParentStateProvinceofBirth=UtilFunction.getCellData("Test Data.xls", "Parent", 13, ColumnCounter);
			String ParentCityofBirth=UtilFunction.getCellData("Test Data.xls", "Parent", 14, ColumnCounter);
			String ParentCountryofResidence=UtilFunction.getCellData("Test Data.xls", "Parent", 15, ColumnCounter);
			String ParentStateProvinceofResidence=UtilFunction.getCellData("Test Data.xls", "Parent", 16, ColumnCounter);
			String ParentCityofResidence=UtilFunction.getCellData("Test Data.xls", "Parent", 17, ColumnCounter);
			String ParentCitizenship=UtilFunction.getCellData("Test Data.xls", "Parent", 18, ColumnCounter);
			String ParentDeceased=UtilFunction.getCellData("Test Data.xls", "Parent", 19, ColumnCounter);
			String ParentDateDeceased=UtilFunction.getCellData("Test Data.xls", "Parent", 20, ColumnCounter);
			String ParentOccupation=UtilFunction.getCellData("Test Data.xls", "Parent", 21, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Parent", 22, ColumnCounter);
			
			String Parent_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
			String ParentCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@name]";
			 
			String ParentNamexpath=".//*[@class='control-group field-group-inline']//*[@class='field'][xx]//*[@id]";
			String ParentNamecounterxpath=".//*[@class='control-group field-group-inline']//*[@class='field']//*[@id]";
			String addbuttonxpathforcitizenship=".//*[@id='btnAddCitzenship']";
			 
			String fatherxpath=".//*[@class='question-group'][1]//*[@class='icon-edit']";
			String motherxpath=".//*[@class='question-group'][2]//*[@class='icon-edit']";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Parents";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);

			boolean Flag =false;
			testcaseid=TestcaseID;
			scenerio=ParentScenerio;
			description=ParentTestcaseDescription;
		
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				 
			 if(mode.equals(ACTION)){
				 /*String ParentURLwithID=ParentPageURL+ParentID;
				 utilfunc.NavigatetoURL(ParentURLwithID);*/
			
				 try {
					utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 if(Parents.equals("Father")){
						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(fatherxpath).click();
							webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
						} catch (Exception e) {
						}
					 }else if(Parents.equals("Mother")){
						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(motherxpath).click();
							webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
						} catch (Exception e) {
							
						}
					 }
						 
						 try{
							 int ObjCount=utilfunc.GetObjectCount(ParentNamecounterxpath);
							 int ObjCount1=utilfunc.GetObjectCount(ParentCounterXpath);
							 
							 for(int count=1; count<=ObjCount; count++)
							 {
								 String NewXpath=ParentNamexpath.replace("xx", Integer.toString(count));
								 
								 try{
									 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
									 System.out.println("Attribute name "+count+"is : "+AttributeName);
									 
									 if(AttributeName.equals("FirstName")){		
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(ParentFirstname);
											} catch (Exception e) {
											}
									        utilfunc.mouseaction();
							        	}	
									 else if(AttributeName.equals("MiddleName")){	
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(Parentmiddlename);
											} catch (Exception e) {
												
											}
							        	}
									 else if(AttributeName.equals("LastName")){	
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(Parentlastname);
											} catch (Exception e) {
												
											}
							        	}
									 
								 }catch(Exception e){
									 
								 }
								 
							 }
							 
							 for(int count=1; count<=ObjCount1; count++)
							 {
								 String NewXpath=Parent_attributeFiledXpath.replace("xx", Integer.toString(count));
								 
								 try{
									 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
									 System.out.println("Attribute name "+count+"is : "+AttributeName);
									 
									 if(AttributeName.equals("RelationshipToPrincipal")){							
									        try {
									        	Thread.sleep(1000);
												utilfunc.Selectdropdownvaluebyvalue(NewXpath, Parents);
											} catch (Exception e) {
												
											}
							        	}	
									 else if(AttributeName.equals("MaidenOrOtherNames")){	
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(ParentMaidenOtherNames);
											} catch (Exception e) {
												
											}
							        	}
									 else if(AttributeName.equals("DateOfBirth")){
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(ParentDateofBirth);
											} catch (Exception e) {
											}
							        	}
									 else if(AttributeName.equals("CountryOfBirth")){							
										 try {
											 Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebyvalue(NewXpath, ParentCountryofBirth);
										} catch (Exception e) {
											
										}
							        	}
									 else if(AttributeName.equals("StateOrProvinceOfBirth")){
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(ParentStateProvinceofBirth);
											} catch (Exception e) {
												
											}
							        	}
									 else if(AttributeName.equals("CityOfBirth")){	
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(ParentCityofBirth);
											} catch (Exception e) {
												
											}
							        	}
									 else if(AttributeName.equals("CountryOfResidence")){							
										 try {
											 Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebyvalue(NewXpath, ParentCountryofResidence);
										} catch (Exception e) {
											
										}
							        	}
									 else if(AttributeName.equals("StateOrProvinceOfResidence")){
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(ParentStateProvinceofResidence);
											} catch (Exception e) {
												
											}
							        	}
									 else if(AttributeName.equals("CityOfResidence")){
										 	utilfunc.MakeElement(NewXpath).clear();
									        try {
												utilfunc.MakeElement(NewXpath).sendKeys(ParentCityofResidence);
											} catch (Exception e) {
												
											}
							        	}
									 else if(AttributeName.equals("CountryCode")){							
										 try {
											 Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebyvalue(NewXpath, ParentCitizenship);
										} catch (Exception e) {
											
										}
										 
										 try {
											utilfunc.MakeElement(addbuttonxpathforcitizenship).click();
										} catch (Exception e) {
											
										}
							        	}
									 else if(AttributeName.equals("Deceased")| (AttributeName.equals(""))){
										 
											 if(ParentDeceased.equals("Yes")){
													String NewXpath1=NewXpath.replace("//*[@id]", "//input[contains(@id,'DateDeceased')]");
													try {
														Thread.sleep(1000);
														utilfunc.MakeElement(NewXpath1).click();
													} catch (Exception e1) {
													}
													
													utilfunc.MakeElement(NewXpath).clear();
													try {
														utilfunc.MakeElement(NewXpath).sendKeys(ParentDateDeceased);
													} catch (Exception e) {}
													
												}else{
													String NewXpath1=NewXpath.replace("//*[@id]", "//.[contains(@class,'outside')]//div//.[@class='inside']");
													try {
														Thread.sleep(1000);
														utilfunc.MakeElement(NewXpath1).click();
													} catch (Exception e) {
													}
												}
									 }
									 else if(AttributeName.equals("DateDeceased")| (AttributeName.equals(""))){
										 
										utilfunc.MakeElement(NewXpath).clear();
										 try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentDateDeceased);
										} catch (Exception e) {
											
										}
							        	}else if(AttributeName.equals("Occupation")){
							        		utilfunc.MakeElement(NewXpath).clear();
							        		try {
												utilfunc.MakeElement(NewXpath).sendKeys(ParentOccupation);
												System.out.println("Value has been entered");
											} catch (Exception e) {
												
											}
							        		
							        		
							        	}
									
									 
								 }catch(Exception f){
									 
								 }
							 }
							 ///////////////////////Additional info handled/////////////////////////////
							 try {
								 Thread.sleep(1000);
								utilfunc.dynamic_data(ParentCounterXpath, Parent_attributeFiledXpath);
							} catch (Exception e1) {
								
							}
							 
							 //utilfunc.savebutton();
							 String SaveButtonXpath=".//*[@id='btnSave']";
							 try {
								 Thread.sleep(1000);
								utilfunc.MakeElement(SaveButtonXpath).click();
							} catch (Exception e) {
								
							}
							 
							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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

							 
							 
						 }
						 catch(Exception e){
							 
						 }
				} catch (Exception e) {
					utilfunc.NavigatetoURL(URLwithID);
				}
					 
				 
				 
				 
			 }else if(mode.equals(ACTION1)){
				 /*String ParentURLwithID=ParentPageURL+ParentID;
				 utilfunc.NavigatetoURL(ParentURLwithID);*/
			
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 if(Parents.equals("Father")){
					 try {
						 Thread.sleep(1000);
						utilfunc.MakeElement(fatherxpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e) {
					}
				 }else if(Parents.equals("Mother")){
					 try {
						 Thread.sleep(1000);
						utilfunc.MakeElement(motherxpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e) {
						
					}
				 }
					 
					 try{
						 int ObjCount=utilfunc.GetObjectCount(ParentNamecounterxpath);
						 int ObjCount1=utilfunc.GetObjectCount(ParentCounterXpath);
						 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 String NewXpath=ParentNamexpath.replace("xx", Integer.toString(count));
							 
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 if(AttributeName.equals("FirstName")){		
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentFirstname);
										} catch (Exception e) {
										}
								        utilfunc.mouseaction();
						        	}	
								 else if(AttributeName.equals("MiddleName")){	
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(Parentmiddlename);
										} catch (Exception e) {
											
										}
						        	}
								 else if(AttributeName.equals("LastName")){	
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(Parentlastname);
										} catch (Exception e) {
											
										}
						        	}
								 
							 }catch(Exception e){
								 
							 }
							 
						 }
						 
						 for(int count=1; count<=ObjCount1; count++)
						 {
							 String NewXpath=Parent_attributeFiledXpath.replace("xx", Integer.toString(count));
							 
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 if(AttributeName.equals("RelationshipToPrincipal")){							
								        try {
								        	Thread.sleep(1000);
											utilfunc.Selectdropdownvaluebyvalue(NewXpath, Parents);
										} catch (Exception e) {
											
										}
						        	}	
								 else if(AttributeName.equals("MaidenOrOtherNames")){	
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentMaidenOtherNames);
										} catch (Exception e) {
											
										}
						        	}
								 else if(AttributeName.equals("DateOfBirth")){
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentDateofBirth);
										} catch (Exception e) {
										}
						        	}
								 else if(AttributeName.equals("CountryOfBirth")){							
									 try {
										 Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, ParentCountryofBirth);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("StateOrProvinceOfBirth")){
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentStateProvinceofBirth);
										} catch (Exception e) {
											
										}
						        	}
								 else if(AttributeName.equals("CityOfBirth")){	
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentCityofBirth);
										} catch (Exception e) {
											
										}
						        	}
								 else if(AttributeName.equals("CountryOfResidence")){							
									 try {
										 Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, ParentCountryofResidence);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("StateOrProvinceOfResidence")){
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentStateProvinceofResidence);
										} catch (Exception e) {
											
										}
						        	}
								 else if(AttributeName.equals("CityOfResidence")){
									 	utilfunc.MakeElement(NewXpath).clear();
								        try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentCityofResidence);
										} catch (Exception e) {
											
										}
						        	}
								 else if(AttributeName.equals("CountryCode")){							
									 try {
										 Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebyvalue(NewXpath, ParentCitizenship);
									} catch (Exception e) {
										
									}
									 
									 try {
										utilfunc.MakeElement(addbuttonxpathforcitizenship).click();
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("Deceased")| (AttributeName.equals(""))){
									 
										 if(ParentDeceased.equals("Yes")){
												String NewXpath1=NewXpath.replace("//*[@id]", "//input[contains(@id,'DateDeceased')]");
												try {
													Thread.sleep(1000);
													utilfunc.MakeElement(NewXpath1).click();
												} catch (Exception e1) {
												}
												
												utilfunc.MakeElement(NewXpath).clear();
												try {
													utilfunc.MakeElement(NewXpath).sendKeys(ParentDateDeceased);
												} catch (Exception e) {}
												
											}else{
												String NewXpath1=NewXpath.replace("//*[@id]", "//.[contains(@class,'outside')]//div//.[@class='inside']");
												try {
													Thread.sleep(1000);
													utilfunc.MakeElement(NewXpath1).click();
												} catch (Exception e) {
												}
											}
								 }
								 else if(AttributeName.equals("DateDeceased")| (AttributeName.equals(""))){
									 
									utilfunc.MakeElement(NewXpath).clear();
									 try {
										utilfunc.MakeElement(NewXpath).sendKeys(ParentDateDeceased);
									} catch (Exception e) {
										
									}
						        	}else if(AttributeName.equals("Occupation")){
						        		utilfunc.MakeElement(NewXpath).clear();
						        		try {
											utilfunc.MakeElement(NewXpath).sendKeys(ParentOccupation);
											System.out.println("Value has been entered");
										} catch (Exception e) {
											
										}
						        		
						        		
						        	}
								
								 
							 }catch(Exception f){
								 
							 }
						 }
						 ///////////////////////Additional info handled/////////////////////////////
						 try {
							 Thread.sleep(1000);
							utilfunc.dynamic_data(ParentCounterXpath, Parent_attributeFiledXpath);
						} catch (Exception e1) {
							
						}
						 
						 //utilfunc.savebutton();
						 String SaveButtonXpath=".//*[@id='btnSave']";
						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(SaveButtonXpath).click();
						} catch (Exception e) {
							
						}
		 
						 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
						 
					 }
					 catch(Exception e){
						 
					 }
					 
				 
			 }else if(mode.equals(ACTION2)){
				 
				 try{	
						utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
					 	testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
						
						utilfunc.NavigatetoURL(URLwithID);
						
						utilfunc.ServerErrorHandler();
						
						String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
						try {
							utilfunc.MakeElement(deletexpath).click();
						} catch (Exception e) {
						}
						utilfunc.isAlertPresent();
						
						boolean error_flag=utilfunc.ErrorMessagehandler();
						 if (error_flag){
							 Flag=true;
						 }else{
							 Flag=false;
						 }
						 
						}catch(Exception z){
							utilfunc.ErrorMessage="";
							utilfunc.ErrorMessage1="";							
							utilfunc.ErrorMessage4="";
							utilfunc.ErrorMessage5="";
							Deletecheck="Delete";
							testcaseid="TC001";
							scenerio="Positive";
							description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
							utilfunc.ErrorMessage2="Delete option is not Implimented in Basic Information Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
				 }///////////url ckeck end
			 
			 return Flag;
	 	}

}
