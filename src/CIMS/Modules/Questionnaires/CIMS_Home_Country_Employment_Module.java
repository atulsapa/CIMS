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

public class CIMS_Home_Country_Employment_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String URLwithID="";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 
	
	 //Constructor----------
	 
		public CIMS_Home_Country_Employment_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Home_Country_Employment_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 0, ColumnCounter);
			String Home_Country_EmploymentScenerio=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 2, ColumnCounter);
			String Home_Country_EmploymentTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 3, ColumnCounter);		
			String Home_Country_EmploymentPageURL=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 4, ColumnCounter);
			String Home_Country_EmploymentID=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 5, ColumnCounter);
			
			String HomeCountry=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 6, ColumnCounter);
			String EntityId=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 7, ColumnCounter);
			String HireStartDate=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 8, ColumnCounter);
			String JobDescription=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 9, ColumnCounter);
			String JobTitle=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 10, ColumnCounter);
			String GroupRelationshipType=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 11, ColumnCounter);
			String Salaryamount=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 12, ColumnCounter);
			String Salarycurrency=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 13, ColumnCounter);
			String Salaryper=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 14, ColumnCounter);
			String form1_country=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 15, ColumnCounter);
			String Addresslookup=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 16, ColumnCounter);
			String form1_route=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 17, ColumnCounter);
			String StreetAddress2=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 18, ColumnCounter);
			String AptSteFlr=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 19, ColumnCounter);
			String form1_locality=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 20, ColumnCounter);
			String form1_administrative_area_level_1=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 21, ColumnCounter);
			String form1_postal_code=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 22, ColumnCounter);
			String ddlPrefix=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 23, ColumnCounter);
			String Firstname=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 24, ColumnCounter);
			String Middlename=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 25, ColumnCounter);
			String LastName=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 26, ColumnCounter);
			String CompanyContact_CountJobDescription=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 27, ColumnCounter);
			String form2_country=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 28, ColumnCounter);
			String Addresslookup2=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 29, ColumnCounter);
			String form2_route=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 30, ColumnCounter);
			String CompanyContact_StreetAddress2=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 31, ColumnCounter);
			String AptSteFlr2=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 32, ColumnCounter);
			String form2_locality=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 33, ColumnCounter);
			String form2_administrative_area_level_1=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 34, ColumnCounter);
			String form2_postal_code=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 35, ColumnCounter);
			String Emailsprimaryradio=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 36, ColumnCounter);
			String Email=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 37, ColumnCounter);
			String Phonenumberprimaryradio=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 38, ColumnCounter);
			String PhoneNumberType=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 39, ColumnCounter);
			String PhoneCountryCode=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 40, ColumnCounter);
			String PhoneNumber=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 41, ColumnCounter);
			String PhoneExtension=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 42, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Home_Country_Employment", 43, ColumnCounter);
			
			String addreslookupxpath=".//*[@class='question-group-address'][1]//*[@class='control-group']//*[@name]";
			String addreslookupxpath1=".//*[@class='question-group-address'][2]//*[@class='control-group']//*[@name]";
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";
			
			String Home_Country_Employment_attributeFiledXpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@id]";
			String Home_Country_EmploymentCounterXpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@id]";

			String Referenceemail=".//*[@id='grp-email']//*[@name]";
			
			String Referencephonenumberfieldxpath=".//*[@id='grp-phone']//td[xx]//*[@name]";
			String Referencephonenumbercounterxpath=".//*[@id='grp-phone']//td//*[@name]";
			
			String Salaryamountxpath=".//*[@id='Salary']";
			String Salarycurrencyxpath=".//*[@id='SalaryCurrency']";
			String Salaryperxpath=".//*[@id='PayPeriod']";
			
			String namefieldxpath=".//*[@class='control-group field-group-inline']//*[@class='field'][xx]//*[@id]";
			String namecounterxpath=".//*[@class='control-group field-group-inline']//*[@class='field']//*[@id]";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Home Country Employment";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Home_Country_EmploymentScenerio;
			 description=Home_Country_EmploymentTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Home_Country_EmploymentURLwithID=Home_Country_EmploymentPageURL+Home_Country_EmploymentID;
					 utilfunc.NavigatetoURL(Home_Country_EmploymentURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String AddbuttonXpath="//*[@class='btn']";
					 try {
						 Thread.sleep(1000);
						utilfunc.MakeElement(AddbuttonXpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {System.out.println("Unable to click the add button");}
					 
					 int ObjCount=utilfunc.GetObjectCount(Home_Country_EmploymentCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Home_Country_Employment_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("HomeCountryCode")){							
							     try {
							    	 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, HomeCountry);
								} catch (Exception e) {System.out.println("Unable to select the value");}
					        	}	
							 else if(AttributeName.equals("EntityId")){	
								 Thread.sleep(1000);
								  try {
									  
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, EntityId);
								} catch (Exception e) {System.out.println("Unable to select the value");}
					        	}
							 else if(AttributeName.equals("HireStartDate")){
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(HireStartDate);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
							 }
							 else if(AttributeName.equals("JobDescription")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(JobDescription);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("JobTitle")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(JobTitle);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("GroupRelationshipType")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, GroupRelationshipType);
								} catch (Exception e) {System.out.println("Unable to select the value");}
								 
								 
					        	}
							 else if(AttributeName.equals("form1_country")){	
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, form1_country);
								} catch (Exception e) {System.out.println("Unable to select the value");}
								}
							 else if(AttributeName.equals("form1_route")){
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form1_route);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("StreetAddress2")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StreetAddress2);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("UnitType")){							
								 String xpath1=NewXpath+"[1]";
								 String xpath2=NewXpath+"[2]";
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(xpath1, AptSteFlr);
								} catch (Exception e) {System.out.println("Unable to select the value");}
								 try {
									utilfunc.MakeElement(xpath2).sendKeys(AptSteFlr);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form1_locality")){
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form1_locality);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
							 }
							 else if(AttributeName.equals("form1_administrative_area_level_1")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form1_administrative_area_level_1);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form1_postal_code")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).sendKeys(form1_postal_code);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("ddlPrefix")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, ddlPrefix);
								} catch (Exception e) {System.out.println("Unable to select the value");}
					        	}
							 else if(AttributeName.equals("CompanyContact_CountJobDescription")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(CompanyContact_CountJobDescription);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form2_country")){	
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, form2_country);
								} catch (Exception e) {System.out.println("Unable to select the value");}
							 	}
							 else if(AttributeName.equals("form2_route")){	
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form2_route);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("CompanyContact_StreetAddress2")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(CompanyContact_StreetAddress2);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("CompanyContact_UnitType")){							
								 String xpath1=NewXpath+"[1]";
								 String xpath2=NewXpath+"[2]";
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(xpath1, AptSteFlr2);
								} catch (Exception e) {System.out.println("Unable to select the value");}
								 try {
									utilfunc.MakeElement(xpath2).sendKeys(AptSteFlr2);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form2_locality")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form2_locality);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form2_administrative_area_level_1")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form2_administrative_area_level_1);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form2_postal_code")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form2_postal_code);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("fld-primary-email")){
								 
								 String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
								 	if(AttributeNameemail.equals("Email")){
								 		try {
											utilfunc.MakeElement(Referenceemail).sendKeys(Email);
										} catch (Exception e) {System.out.println("Unable to enter the value");}
								 		} 
								 	
								 	if(Emailsprimaryradio.equals("Yes")){
										 try {
											 Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {System.out.println("Unable to click on the button");}
										 }
					        	}
							 else if(AttributeName.equals("fld-primary-phone")){	
								
								 	
								 	int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
								 	
								 	for(int count2=1; count2<=ObjCount2; count2++){
								 		String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
								 		try{
								 			String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
											System.out.println("Attribute name "+count2+"is : "+AttributeName2);
											
											if(AttributeName2.contains("PhoneNumberType")){	
												try {
													Thread.sleep(1000);
													utilfunc.Selectdropdownvaluebyvalue(NewXpath3, PhoneNumberType);
												} catch (Exception e) {System.out.println("Unable to enter the value");}
											 }
											else if(AttributeName2.contains("PhoneCountryCode")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneCountryCode);
												} catch (Exception e) {System.out.println("Unable to enter the value");}
											 }
											else if(AttributeName2.contains("PhoneNumber")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneNumber);
												} catch (Exception e) {System.out.println("Unable to enter the value");}
											 }
											else if(AttributeName2.contains("PhoneExtension")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneExtension);
												} catch (Exception e) {System.out.println("Unable to enter the value");
												}
											 }
																			 			
								 		}catch(Exception e){
								 			
								 		}
								 	}
								 	
								 	 if(Phonenumberprimaryradio.equals("Yes")){
										 try {
											 Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {System.out.println("Unable to click on the button ");}
										 }
					        	}
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////////////////compensation data////////////////////////////////
					 try{
						 utilfunc.MakeElement(Salaryamountxpath).clear();
						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(Salaryamountxpath).sendKeys(Salaryamount);
						} catch (Exception e) {System.out.println("Unable to enter the value");}
						 
						 try {
							 Thread.sleep(1000);
							utilfunc.Selectdropdownvaluebyvalue(Salarycurrencyxpath, Salarycurrency);
						} catch (Exception e) {System.out.println("Unable to select the value");}
						 
						 try {
							 Thread.sleep(1000);
							utilfunc.Selectdropdownvaluebyvalue(Salaryperxpath, Salaryper);
						} catch (Exception e) {System.out.println("Unable to select the value");}
						 
					 }catch(Exception e){
						 
					 }
					
					 
					 //////////////////////////////////NAME////////////////////////////////////////////
					 int ObjCount1=utilfunc.GetObjectCount(namecounterxpath);
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=namefieldxpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("CompanyContact_FirstName")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Firstname);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}	
							 else if(AttributeName.equals("CompanyContact_MiddleName")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Middlename);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("CompanyContact_LastName")){
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(LastName);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
							 }
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////////////////////address lookup////////////////////////////////
					 try{
						 String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
						 if(AttributeName.contains("form1_autocomplete")){			
							 try {
								utilfunc.MakeElement(addreslookupxpath).sendKeys(Addresslookup);
							} catch (Exception e) {System.out.println("Unable to enter the value");}
							 utilfunc.mouseaction();
						 }
					 }
					 catch(Exception f){
					 }
					 //////////////////////////////////////address lookup////////////////////////////////
					 try{
						 String AttributeName=utilfunc.MakeElement(addreslookupxpath1).getAttribute("name");
						 if(AttributeName.contains("form2_autocomplete")){			
							 try {
								utilfunc.MakeElement(addreslookupxpath1).sendKeys(Addresslookup2);
							} catch (Exception e) {System.out.println("Unable to enter the value");}
							 utilfunc.mouseaction();
						 }
					 }
					 catch(Exception f){
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 try {
						 Thread.sleep(1000);
						utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					} catch (Exception e) {
						
					}
					 
					 try {
						 Thread.sleep(1000);
						utilfunc.savebutton();
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
					 
				 }catch(Exception e){
					 utilfunc.NavigatetoURL(URLwithID);
				 }
				 
				 
			 }else if(mode.equals(ACTION1)){
				 
				 try{
					 
					 /*String Home_Country_EmploymentURLwithID=Home_Country_EmploymentPageURL+Home_Country_EmploymentID;
					 utilfunc.NavigatetoURL(Home_Country_EmploymentURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					 try {
						utilfunc.MakeElement(EditbuttonXpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {System.out.println("Unable to click on the edit icon");}
					 
					 int ObjCount=utilfunc.GetObjectCount(Home_Country_EmploymentCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Home_Country_Employment_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("HomeCountryCode")){							
							     try {
							    	 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, HomeCountry);
								} catch (Exception e) {System.out.println("Unable to select the value");}
					        	}	
							 else if(AttributeName.equals("EntityId")){	
								 Thread.sleep(1000);
								  try {
									  
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, EntityId);
								} catch (Exception e) {System.out.println("Unable to select the value");}
					        	}
							 else if(AttributeName.equals("HireStartDate")){
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(HireStartDate);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
							 }
							 else if(AttributeName.equals("JobDescription")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(JobDescription);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("JobTitle")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(JobTitle);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("GroupRelationshipType")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, GroupRelationshipType);
								} catch (Exception e) {System.out.println("Unable to select the value");}
								 
								 
					        	}
							 else if(AttributeName.equals("form1_country")){	
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, form1_country);
								} catch (Exception e) {System.out.println("Unable to select the value");}
								}
							 else if(AttributeName.equals("form1_route")){
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form1_route);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("StreetAddress2")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StreetAddress2);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("UnitType")){							
								 String xpath1=NewXpath+"[1]";
								 String xpath2=NewXpath+"[2]";
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(xpath1, AptSteFlr);
								} catch (Exception e) {System.out.println("Unable to select the value");}
								 try {
									utilfunc.MakeElement(xpath2).sendKeys(AptSteFlr);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form1_locality")){
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form1_locality);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
							 }
							 else if(AttributeName.equals("form1_administrative_area_level_1")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form1_administrative_area_level_1);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form1_postal_code")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).sendKeys(form1_postal_code);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("ddlPrefix")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, ddlPrefix);
								} catch (Exception e) {System.out.println("Unable to select the value");}
					        	}
							 else if(AttributeName.equals("CompanyContact_CountJobDescription")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(CompanyContact_CountJobDescription);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form2_country")){	
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, form2_country);
								} catch (Exception e) {System.out.println("Unable to select the value");}
							 	}
							 else if(AttributeName.equals("form2_route")){	
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form2_route);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("CompanyContact_StreetAddress2")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(CompanyContact_StreetAddress2);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("CompanyContact_UnitType")){							
								 String xpath1=NewXpath+"[1]";
								 String xpath2=NewXpath+"[2]";
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(xpath1, AptSteFlr2);
								} catch (Exception e) {System.out.println("Unable to select the value");}
								 try {
									utilfunc.MakeElement(xpath2).sendKeys(AptSteFlr2);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form2_locality")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form2_locality);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form2_administrative_area_level_1")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form2_administrative_area_level_1);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("form2_postal_code")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(form2_postal_code);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("fld-primary-email")){
								 
								 String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
								 	if(AttributeNameemail.equals("Email")){
								 		try {
											utilfunc.MakeElement(Referenceemail).sendKeys(Email);
										} catch (Exception e) {System.out.println("Unable to enter the value");}
								 		} 
								 	
								 	if(Emailsprimaryradio.equals("Yes")){
										 try {
											 Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {System.out.println("Unable to click on the button");}
										 }
					        	}
							 else if(AttributeName.equals("fld-primary-phone")){	
								
								 	
								 	int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
								 	
								 	for(int count2=1; count2<=ObjCount2; count2++){
								 		String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
								 		try{
								 			String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
											System.out.println("Attribute name "+count2+"is : "+AttributeName2);
											
											if(AttributeName2.contains("PhoneNumberType")){	
												try {
													Thread.sleep(1000);
													utilfunc.Selectdropdownvaluebyvalue(NewXpath3, PhoneNumberType);
												} catch (Exception e) {System.out.println("Unable to enter the value");}
											 }
											else if(AttributeName2.contains("PhoneCountryCode")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneCountryCode);
												} catch (Exception e) {System.out.println("Unable to enter the value");}
											 }
											else if(AttributeName2.contains("PhoneNumber")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneNumber);
												} catch (Exception e) {System.out.println("Unable to enter the value");}
											 }
											else if(AttributeName2.contains("PhoneExtension")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneExtension);
												} catch (Exception e) {System.out.println("Unable to enter the value");
												}
											 }
																			 			
								 		}catch(Exception e){
								 			
								 		}
								 	}
								 	
								 	 if(Phonenumberprimaryradio.equals("Yes")){
										 try {
											 Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath).click();
										} catch (Exception e) {System.out.println("Unable to click on the button ");}
										 }
					        	}
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////////////////compensation data////////////////////////////////
					 try{
						 utilfunc.MakeElement(Salaryamountxpath).clear();
						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(Salaryamountxpath).sendKeys(Salaryamount);
						} catch (Exception e) {System.out.println("Unable to enter the value");}
						 
						 try {
							 Thread.sleep(1000);
							utilfunc.Selectdropdownvaluebyvalue(Salarycurrencyxpath, Salarycurrency);
						} catch (Exception e) {System.out.println("Unable to select the value");}
						 
						 try {
							 Thread.sleep(1000);
							utilfunc.Selectdropdownvaluebyvalue(Salaryperxpath, Salaryper);
						} catch (Exception e) {System.out.println("Unable to select the value");}
						 
					 }catch(Exception e){
						 
					 }
					
					 
					 //////////////////////////////////NAME////////////////////////////////////////////
					 int ObjCount1=utilfunc.GetObjectCount(namecounterxpath);
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=namefieldxpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("CompanyContact_FirstName")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Firstname);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}	
							 else if(AttributeName.equals("CompanyContact_MiddleName")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Middlename);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
					        	}
							 else if(AttributeName.equals("CompanyContact_LastName")){
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(LastName);
								} catch (Exception e) {System.out.println("Unable to enter the value");}
							 }
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////////////////////address lookup////////////////////////////////
					 try{
						 String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
						 if(AttributeName.contains("form1_autocomplete")){			
							 try {
								utilfunc.MakeElement(addreslookupxpath).sendKeys(Addresslookup);
							} catch (Exception e) {System.out.println("Unable to enter the value");}
							 utilfunc.mouseaction();
						 }
					 }
					 catch(Exception f){
					 }
					 //////////////////////////////////////address lookup////////////////////////////////
					 try{
						 String AttributeName=utilfunc.MakeElement(addreslookupxpath1).getAttribute("name");
						 if(AttributeName.contains("form2_autocomplete")){			
							 try {
								utilfunc.MakeElement(addreslookupxpath1).sendKeys(Addresslookup2);
							} catch (Exception e) {System.out.println("Unable to enter the value");}
							 utilfunc.mouseaction();
						 }
					 }
					 catch(Exception f){
					 }
					 //////////////////////Additional info handle///////////////////////////////
					 try {
						 Thread.sleep(1000);
						utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					} catch (Exception e) {
						
					}
					 
					 try {
						utilfunc.savebutton();
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
					 
				 }catch(Exception e){
					 utilfunc.ErrorMessage="";
					 utilfunc.ErrorMessage1="";							
					 utilfunc.ErrorMessage4="";
					 utilfunc.ErrorMessage5="";
					 utilfunc.ErrorMessage2="No Records Found to Edit";
					 Flag=false;
					 utilfunc.TakeScreenshot();
					 utilfunc.NavigatetoURL(URLwithID);
				 }
				 
				 
			 }else if(mode.equals(ACTION2)){
				 try{
					 /*String Home_Country_EmploymentURLwithID=Home_Country_EmploymentPageURL+Home_Country_EmploymentID;
					 utilfunc.NavigatetoURL(Home_Country_EmploymentURLwithID);*/
					 utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
					 	testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String DeletebuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
					 try {
						utilfunc.MakeElement(DeletebuttonXpath).click();
					} catch (Exception e) {System.out.println("Unable to click on the delete button");
					}
					 
					 Thread.sleep(10000);
					 
					 utilfunc.isAlertPresent();
					 boolean error_flag=utilfunc.ErrorMessagehandler();
					 if (error_flag){
						 Flag=true;
					 }else{
						 Flag=false;
					 }
					 
				 }catch(Exception e){
					 utilfunc.ErrorMessage="";
						utilfunc.ErrorMessage1="";							
						utilfunc.ErrorMessage4="";
						utilfunc.ErrorMessage5="";
						testcaseid="TC001";
						scenerio="Positive";
						description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
					 utilfunc.ErrorMessage2="No Records Found to Delete";
					 Flag=false;
					 utilfunc.TakeScreenshot();
				 }
				 
			 }
				 
				
				 }///////////url ckeck end
			 
			
			 return Flag;
	 	}

}
