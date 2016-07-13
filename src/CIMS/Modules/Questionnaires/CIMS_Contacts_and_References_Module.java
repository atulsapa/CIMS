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

public class CIMS_Contacts_and_References_Module {
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
	 
		public CIMS_Contacts_and_References_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Contacts_and_References_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 0, ColumnCounter);
			String Contacts_and_ReferencesScenerio=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 2, ColumnCounter);
			String Contacts_and_ReferencesTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 3, ColumnCounter);		
			String Contacts_and_ReferencesPageURL=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 4, ColumnCounter);
			String Contacts_and_ReferencesID=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 5, ColumnCounter);
			
			String Title=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 6, ColumnCounter);
			String Firstname=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 7, ColumnCounter);
			String Middlename=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 8, ColumnCounter);
			String Lastname=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 9, ColumnCounter);
			String DateOfBirth=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 10, ColumnCounter);
			String Gender=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 11, ColumnCounter);
			String Nationality=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 12, ColumnCounter);
			String ImmigrationStatus=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 13, ColumnCounter);
			String NationalNumberId=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 14, ColumnCounter);
			String OrganizationName=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 15, ColumnCounter);
			String HowIndividualKnowYouWork=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 16, ColumnCounter);
			String experienceyear=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 17, ColumnCounter);
			String WhyLeadExpert=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 18, ColumnCounter);
			String HasIndividualWorkWithYouradio=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 19, ColumnCounter);
			String HowExpertKnowYourWork=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 10, ColumnCounter);
			String HaveContactReferenceradio=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 21, ColumnCounter);
			String country=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 22, ColumnCounter);
			String StreetAddress1=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 23, ColumnCounter);
			String StreetAddress2=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 24, ColumnCounter);
			String AptSteFlr=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 25, ColumnCounter);
			String locality=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 26, ColumnCounter);
			String StateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 27, ColumnCounter);
			String postal_code=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 28, ColumnCounter);
			String Emailprimaryradio=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 29, ColumnCounter);
			String Email=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 30, ColumnCounter);
			String Phonenumberprimaryradio=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 31, ColumnCounter);
			String PhoneNumberType=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 32, ColumnCounter);
			String PhoneCountryCode=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 33, ColumnCounter);
			String PhoneNumber=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 34, ColumnCounter);
			String PhoneExtension=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 35, ColumnCounter);
			String Addresslookup=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 36, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Contacts_and_References", 37, ColumnCounter);
			
			String addreslookupxpath=".//*[@class='panel-body-main']//*[@class='question-group-address']//*[@name]";
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group'][xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']/./div/h4/..//*[@class='control-group']//*[@id]";
			
			String Contacts_and_References_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
			String Contacts_and_ReferencesCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

			String Referenceemail=".//*[@id='grp-email']//*[@name]";
			
			String Referencephonenumberfieldxpath=".//*[@id='grp-phone']//td[xx]//*[@name]";
			String Referencephonenumbercounterxpath=".//*[@id='grp-phone']//td//*[@name]";
			
			String Firstnamexpath=".//*[@class='control-group field-group-inline']//*[@class='field'][1]//*[@id]";
			String Middlenamexpath=".//*[@class='control-group field-group-inline']//*[@class='field'][2]//*[@id]";
			String Lastnamexpath=".//*[@class='form-horizontal']/*[@class='controls']//*[@id]";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			String QuestionarieName="Contacts and References";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);

			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Contacts_and_ReferencesScenerio;
			 description=Contacts_and_ReferencesTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
			
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Contacts_and_ReferencesURLwithID=Contacts_and_ReferencesPageURL+Contacts_and_ReferencesID;
					 utilfunc.NavigatetoURL(Contacts_and_ReferencesURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String AddbuttonXpath="//*[@class='btn']";
					 try {
						utilfunc.MakeElement(AddbuttonXpath).click();
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {
						
					}
					 
					 
					 String FirstNameXPath	=	".//*[@id='FirstName']";
					 
					 try {
						utilfunc.MakeElement(FirstNameXPath).sendKeys(Firstname);
					} catch (Exception e1) {

					}
					 
					 String LastNameXPath	=	".//*[@id='LastName']";
							 
					 try {
						utilfunc.MakeElement(LastNameXPath).sendKeys(Lastname);
					} catch (Exception e1) {

					}
					 
					 int ObjCount=utilfunc.GetObjectCount(Contacts_and_ReferencesCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Contacts_and_References_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);

							 if(AttributeName.equals("Title")){							
							     try {
							    	 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Title);
								} catch (Exception e) {
									
								}

							     /*utilfunc.MakeElement(Firstnamexpath).sendKeys(Firstname);
							     utilfunc.MakeElement(Middlenamexpath).sendKeys(Middlename);
							     utilfunc.MakeElement(Lastnamexpath).sendKeys(Lastname);*/
							     
					        	}	
							 else if(AttributeName.equals("DateOfBirth")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(DateOfBirth);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Gender")){
								 if(Gender.equalsIgnoreCase("Male")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath+"//.[@value='MALE']").click();
								} catch (Exception e) {
									
								}
					        	}else{
					        		try {
					        			Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[@value='FEMALE']").click();
									} catch (Exception e) {
										
									}
					        	}
							 }
							 else if(AttributeName.equals("NationalityCountryCode")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Nationality);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("ImmigrationStatus")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationStatus);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("NationalNumberId")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(NationalNumberId);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("OrganizationName")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(OrganizationName);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("HowIndividualKnowYouWork")){
								 String xpath1=NewXpath+"[1]";
								 String xpath2=NewXpath+"[2]";
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(xpath1, HowIndividualKnowYouWork);
								} catch (Exception e) {
									
								}
								 try {
									utilfunc.MakeElement(xpath2).sendKeys(HowIndividualKnowYouWork);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("ExperienceYears")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(experienceyear);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("WhyLeadExpert")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(WhyLeadExpert);
								} catch (Exception e) {

								}
					        	}
							 else if(AttributeName.equals("HasIndividualWorkWithYou")){
								 if(HasIndividualWorkWithYouradio.equals("Yes")){
									 String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									} catch (Exception e) {
										
									}
					        	}else if(HasIndividualWorkWithYouradio.equals("No")){
					        		String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									} catch (Exception e) {
										
									}
					        	}
							 }
							 else if(AttributeName.equals("HowExpertKnowYourWork")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(HowExpertKnowYourWork);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("HaveContactReference")){							
								if(HaveContactReferenceradio.equals("Yes")){
									 String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									} catch (Exception e) {
										
									}
								}else if(HaveContactReferenceradio.equals("No")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									} catch (Exception e) {
										
									}
								}
					        	}
							 else if(AttributeName.equals("country")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, country);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("route")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StreetAddress1);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("StreetAddress2")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StreetAddress2);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("UnitType")){	
								 String xpath1=NewXpath+"[1]";
								 String xpath2=NewXpath+"[2]";
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(xpath1, AptSteFlr);
								} catch (Exception e) {
									
								}
								 try {
									utilfunc.MakeElement(xpath2).sendKeys(AptSteFlr);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("locality")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(locality);
								} catch (Exception e) {
								}
					        	}
							 else if(AttributeName.equals("administrative_area_level_1")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StateProvinceRegion);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("postal_code")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(postal_code);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Email")){
								 
								 String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
								 	if(AttributeNameemail.equals("Email")){
								 		try {
											utilfunc.MakeElement(Referenceemail).sendKeys(Email);
										} catch (Exception e) {
											
										}
								 		} 
								 	
								 	if(Emailprimaryradio.equals("Yes")){
										 try {
											 Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[contains(@id,'primary-email')]").click();
										} catch (Exception e) {
											
										}
										 }
					        	}
							 else if(AttributeName.equals("fld-primary-phone")){	
								 int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
								 	
								 	for(int count2=1; count2<=ObjCount2; count2++){
								 		String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
								 		try{
								 			String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
											System.out.println("Attribute name "+count2+"is : "+AttributeName2);
											
											if(AttributeName2.contains("PhoneNumberType1")){	
												try {
													utilfunc.Selectdropdownvaluebyvalue(NewXpath3, PhoneNumberType);
												} catch (Exception e) {
													
												}
											 }
											else if(AttributeName2.contains("PhoneCountryCode")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneCountryCode);
												} catch (Exception e) {
													
												}
											 }
											else if(AttributeName2.contains("PhoneNumber")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneNumber);
												} catch (Exception e) {
													
												}
											 }
											else if(AttributeName2.contains("PhoneExtension")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneExtension);
												} catch (Exception e) {
													
												}
											 }
																			 			
								 		}catch(Exception e){
								 			System.out.println("Exception is "+e);
								 		}
								 	}
								 	
								 	if(Phonenumberprimaryradio.equals("Yes")){
										 try {
											 Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='1']").click();
										} catch (Exception e) {
											
										}
										 }
					        	}
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////NAME//////////////////////////////////////////////////////////
					 try{
						 utilfunc.MakeElement(Firstnamexpath).sendKeys(Firstname);
						 try{
					     utilfunc.MakeElement(Middlenamexpath).sendKeys(Middlename);
						 }catch(Exception e){
						 }
					     utilfunc.MakeElement(Lastnamexpath).sendKeys(Lastname);
					 }catch(Exception e){
						 
					 }
					 //////////////////////////////////////address lookup////////////////////////////////
					 try{
						 String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
						 if(AttributeName.contains("autocomplete")){			
							 try {
								utilfunc.MakeElement(addreslookupxpath).sendKeys(Addresslookup);
							} catch (Exception e) {
								
							}
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
					 
					 /*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
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
					 /*String Contacts_and_ReferencesURLwithID=Contacts_and_ReferencesPageURL+Contacts_and_ReferencesID;
					 utilfunc.NavigatetoURL(Contacts_and_ReferencesURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					 try {
						utilfunc.MakeElement(EditbuttonXpath).click();
					} catch (Exception e1) {
						
					}
					 
					 int ObjCount=utilfunc.GetObjectCount(Contacts_and_ReferencesCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Contacts_and_References_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("Title")){							
							     try {
							    	 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Title);
								} catch (Exception e) {
									
								}
							     
							     /*utilfunc.MakeElement(Firstnamexpath).sendKeys(Firstname);
							     utilfunc.MakeElement(Middlenamexpath).sendKeys(Middlename);
							     utilfunc.MakeElement(Lastnamexpath).sendKeys(Lastname);*/
							     
					        	}	
							 else if(AttributeName.equals("DateOfBirth")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(DateOfBirth);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Gender")){
								 if(Gender.equalsIgnoreCase("Male")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath+"//.[@value='MALE']").click();
								} catch (Exception e) {
									
								}
					        	}else{
					        		try {
					        			Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath+"//.[@value='FEMALE']").click();
									} catch (Exception e) {
										
									}
					        	}
							 }
							 else if(AttributeName.equals("NationalityCountryCode")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Nationality);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("ImmigrationStatus")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(ImmigrationStatus);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("NationalNumberId")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(NationalNumberId);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("OrganizationName")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(OrganizationName);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("HowIndividualKnowYouWork")){
								 String xpath1=NewXpath+"[1]";
								 String xpath2=NewXpath+"[2]";
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(xpath1, HowIndividualKnowYouWork);
								} catch (Exception e) {
									
								}
								 try {
									utilfunc.MakeElement(xpath2).sendKeys(HowIndividualKnowYouWork);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("ExperienceYears")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(experienceyear);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("WhyLeadExpert")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(WhyLeadExpert);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("HasIndividualWorkWithYou")){
								 if(HasIndividualWorkWithYouradio.equals("Yes")){
									 String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									} catch (Exception e) {
										
									}
					        	}else if(HasIndividualWorkWithYouradio.equals("No")){
					        		String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									} catch (Exception e) {
										
									}
					        	}
							 }
							 else if(AttributeName.equals("HowExpertKnowYourWork")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(HowExpertKnowYourWork);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("HaveContactReference")){							
								if(HaveContactReferenceradio.equals("Yes")){
									 String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									} catch (Exception e) {
										
									}
								}else if(HaveContactReferenceradio.equals("No")){
									String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
									try {
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath1).click();
									} catch (Exception e) {
										
									}
								}
					        	}
							 else if(AttributeName.equals("country")){							
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, country);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("route")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StreetAddress1);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("StreetAddress2")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StreetAddress2);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("UnitType")){	
								 String xpath1=NewXpath+"[1]";
								 String xpath2=NewXpath+"[2]";
								 try {
									 Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebyvalue(xpath1, AptSteFlr);
								} catch (Exception e) {
									
								}
								 try {
									utilfunc.MakeElement(xpath2).sendKeys(AptSteFlr);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("locality")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(locality);
								} catch (Exception e) {
								}
					        	}
							 else if(AttributeName.equals("administrative_area_level_1")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(StateProvinceRegion);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("postal_code")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(postal_code);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Email")){
								 
								 String AttributeNameemail=utilfunc.MakeElement(Referenceemail).getAttribute("name");
								 	if(AttributeNameemail.equals("Email")){
								 		try {
											utilfunc.MakeElement(Referenceemail).sendKeys(Email);
										} catch (Exception e) {
											
										}
								 		} 
								 	
								 	if(Emailprimaryradio.equals("Yes")){
										 try {
											 Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[contains(@id,'primary-email')]").click();
										} catch (Exception e) {
											
										}
										 }
					        	}
							 else if(AttributeName.equals("fld-primary-phone")){	
								 int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
								 	
								 	for(int count2=1; count2<=ObjCount2; count2++){
								 		String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
								 		try{
								 			String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
											System.out.println("Attribute name "+count2+"is : "+AttributeName2);
											
											if(AttributeName2.contains("PhoneNumberType1")){	
												try {
													utilfunc.Selectdropdownvaluebyvalue(NewXpath3, PhoneNumberType);
												} catch (Exception e) {
													
												}
											 }
											else if(AttributeName2.contains("PhoneCountryCode")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneCountryCode);
												} catch (Exception e) {
													
												}
											 }
											else if(AttributeName2.contains("PhoneNumber")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneNumber);
												} catch (Exception e) {
													
												}
											 }
											else if(AttributeName2.contains("PhoneExtension")){
											 	try {
													utilfunc.MakeElement(NewXpath3).sendKeys(PhoneExtension);
												} catch (Exception e) {
													
												}
											 }
																			 			
								 		}catch(Exception e){
								 			System.out.println("Exception is "+e);
								 		}
								 	}
								 	
								 	if(Phonenumberprimaryradio.equals("Yes")){
										 try {
											 Thread.sleep(1000);
											utilfunc.MakeElement(NewXpath+"//.[@value='1']").click();
										} catch (Exception e) {
											
										}
										 }
					        	}
							 
						 }catch(Exception e){
							 
						 }
					 }
					 //////////////////////NAME//////////////////////////////////////////////////////////
					 try{
						 utilfunc.MakeElement(Firstnamexpath).sendKeys(Firstname);
						 try{
					     utilfunc.MakeElement(Middlenamexpath).sendKeys(Middlename);
						 }catch(Exception e){
						 }
					     utilfunc.MakeElement(Lastnamexpath).sendKeys(Lastname);
					 }catch(Exception e){
						 
					 }
					 //////////////////////////////////////address lookup////////////////////////////////
					 try{
						 String AttributeName=utilfunc.MakeElement(addreslookupxpath).getAttribute("name");
						 if(AttributeName.contains("autocomplete")){			
							 try {
								utilfunc.MakeElement(addreslookupxpath).sendKeys(Addresslookup);
							} catch (Exception e) {
								
							}
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
					 
					 /*String SaveButtonXpath=".//*[@id='btnSave']";
					 utilfunc.MakeElement(SaveButtonXpath).click();*/
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
					 utilfunc.ErrorMessage="";
					 utilfunc.ErrorMessage1="";							
					 utilfunc.ErrorMessage4="";
					 utilfunc.ErrorMessage5="";
					 utilfunc.ErrorMessage2="No Records Found to Edit";
					 Flag=false;
					 utilfunc.TakeScreenshot();

				 }
				 
				 
			 }else if(mode.equals(ACTION2)){
				 try{
					 /*String Contacts_and_ReferencesURLwithID=Contacts_and_ReferencesPageURL+Contacts_and_ReferencesID;
					 utilfunc.NavigatetoURL(Contacts_and_ReferencesURLwithID);*/
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
					} catch (Exception e) {
						
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
