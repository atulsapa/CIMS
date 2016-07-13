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

public class CIMS_Contact_Information_Module {
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	 public static String Deletecheck="";
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String URLwithID="";
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 
	 	
	 //Constructor----------
	 
		public CIMS_Contact_Information_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Contact_Information_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 0, ColumnCounter);
			String Contact_InformationScenerio=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 2, ColumnCounter);
			String Contact_InformationTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 3, ColumnCounter);		
			String Contact_InformationPageURL=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 4, ColumnCounter);
			String Contact_InformationID=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 5, ColumnCounter);
			
			String Contact_Information=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 6, ColumnCounter);
			String Contact_InformationCountry=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 7, ColumnCounter);
			String Contact_InformationAddressLookup=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 8, ColumnCounter);
			String Contact_InformationStreetAddress1=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 9, ColumnCounter);
			String Contact_InformationStreetAddress2=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 10, ColumnCounter);
			String Contact_InformationAptSteFlr=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 11, ColumnCounter);
			String Contact_InformationCityTownLocality=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 12, ColumnCounter);
			String Contact_InformationStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 13, ColumnCounter);
			String Contact_InformationPostalCode=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 14, ColumnCounter);
			
			
			String Contact_InformationEmail=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 15, ColumnCounter);
			
			String Contact_InformationIsphonenumberisprimary=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 16, ColumnCounter);
			String Contact_InformationPhoneType=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 17, ColumnCounter);
			String Contact_InformationPhoneCountrycode=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 18, ColumnCounter);
			String Contact_InformationPhoneNumber=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 19, ColumnCounter);
			String Contact_InformationPhoneExt=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 20, ColumnCounter);
			String Contact_InformationSavedaddress=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 21, ColumnCounter);
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 22, ColumnCounter);
			
			String Contact_Information_attributeFiledXpath=".//*[@class='control-group'][xx]//*[@id]";
			String Contact_InformationCounterXpath=".//*[@class='control-group']//*[@id]";
			
			String countryxpath=".//*[@id='country']";
			
			String ResidenceAddressxpath=".//*[@id='divResidence']//*[@class='icon-pencil icon-block']";
			String MailingAddressxpath=".//*[@class='form-horizontal']/div[2]//*[@class='control-group']//*[@class='btn']";
			String PermanentAddressinHomeCountryxpath=".//*[@class='form-horizontal']/div[3]//*[@class='control-group']//*[@class='btn']";
			String EmailAddressxpath=".//*[@class='form-horizontal']/div[4]//*[@class='control-group']//*[@class='btn']";
			String PhoneNumberxpath=".//*[@class='form-horizontal']/div[6]//*[@class='control-group']//*[@class='btn']";
			
			String addresslookupxpath=".//*[@class='question-group-address']//*[@id]";
			String Emailxpath=".//*[@class='fld-email']";
			
			String phonenumberenterxpath=".//*[@class='control-group']//*[@id]";
			
			String Referencephonenumberfieldxpath=".//*[@id='grp-phone']//td[xx]//*[@name]";
			String Referencephonenumbercounterxpath=".//*[@id='grp-phone']//td//*[@name]";

			/////////////////////////////////URL FETCH///////////////////////////////////
			String QuestionarieName="Contact Info";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Contact_InformationScenerio;
			 description=Contact_InformationTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Contact_InformationURLwithID=Contact_InformationPageURL+Contact_InformationID;
					 utilfunc.NavigatetoURL(Contact_InformationURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 Thread.sleep(1000);
					 
					 utilfunc.ServerErrorHandler();
					 Thread.sleep(1000);
					 if(Contact_Information.equals("Residence Address")){
						 utilfunc.MakeElement(ResidenceAddressxpath).click();
						 webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
						 
						 int ObjCount=utilfunc.GetObjectCount(Contact_InformationCounterXpath);
						 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 String NewXpath=Contact_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 if(AttributeName.equals("SavedAddressId")){
									 if(Contact_InformationCountry.equals("0")){
										 try {
											utilfunc.Selectdropdownvaluebyindex(NewXpath, 0);
										} catch (Exception e) {
											
										}
									 }else{
										 try {
											utilfunc.Selectdropdownvaluebyvalue(NewXpath, Contact_InformationSavedaddress);
										} catch (Exception e) {
											
										}
									 }
									 
									 try {
										utilfunc.Selectdropdownvaluebyvalue(countryxpath, Contact_InformationCountry);
									} catch (Exception e) {
										}
									 
						        	}	
								 else if(AttributeName.equals("country")){
									 try {
										utilfunc.Selectdropdownvaluebyvalue(countryxpath, Contact_InformationCountry);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("route")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress1);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("StreetAddress2")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress2);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("UnitType")){							
									 String Newpath=NewXpath+"[1]";
									 	try {
											utilfunc.Selectdropdownvaluebyvalue(Newpath, Contact_InformationAptSteFlr);
										} catch (Exception e) {
											
										}
									 	String Newpath1=NewXpath+"[2]";
									 	try {
											utilfunc.MakeElement(Newpath1).clear();
											utilfunc.MakeElement(Newpath1).sendKeys(Contact_InformationAptSteFlr);
										} catch (Exception e) {
											
										}
						        	}
								 else if(AttributeName.equals("locality")){	
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationCityTownLocality);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("administrative_area_level_1")){	
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStateProvinceRegion);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("postal_code")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationPostalCode);
									} catch (Exception e) {
										
									}
						        	}
								 
								 
							 }catch(Exception e){
								 
							 }
						 }
						 	//////Address Lookup 
							try{
								String AttributeName1=utilfunc.MakeElement(addresslookupxpath).getAttribute("name");
								if(AttributeName1.contains("form2_autocomplete")){			
								try {
									utilfunc.MakeElement(addresslookupxpath).sendKeys(Contact_InformationAddressLookup);
								} catch (Exception e) {
									
								}
								try {
									utilfunc.mouseaction();
								} catch (Exception e) {
									
								}
								}
							}
							catch(Exception f){}
							///////////////////////
							
							//////////////////////Additional info handle///////////////////////////////
							 try {
								utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
							} catch (Exception e) {
								
							}
							
							/*String SaveButtonXpath=".//*[@id='btnSave']";
							 utilfunc.MakeElement(SaveButtonXpath).click();*/
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
							
							
						 
					 }
//					 else if(Contact_Information.equals("Mailing Address")){
//						 utilfunc.MakeElement(MailingAddressxpath).click();
//						 
//						 int ObjCount=utilfunc.GetObjectCount(Contact_InformationCounterXpath);
//						 
//						 for(int count=1; count<=ObjCount; count++)
//						 {
//							 String NewXpath=Contact_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
//							 try{
//								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
//								 System.out.println("Attribute name "+count+"is : "+AttributeName);
//								 
//								 if(AttributeName.equals("SavedAddressId")){
//									 if(Contact_InformationCountry.equals("0")){
//										 utilfunc.Selectdropdownvaluebyindex(NewXpath, 0);
//									 }else{
//								     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Contact_InformationSavedaddress);
//									 }
//									 
//									 utilfunc.Selectdropdownvaluebyvalue(countryxpath, Contact_InformationCountry);
//									 
//						        	}	
//								 else if(AttributeName.equals("route")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress1);
//						        	}
//								 else if(AttributeName.equals("StreetAddress2")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress2);
//						        	}
//								 else if(AttributeName.equals("UnitType")){							
//									 String Newpath=NewXpath+"[1]";
//									 	utilfunc.Selectdropdownvaluebyvalue(Newpath, Contact_InformationAptSteFlr);
//									 	String Newpath1=NewXpath+"[2]";
//									 	utilfunc.MakeElement(Newpath1).clear();
//									 	utilfunc.MakeElement(Newpath1).sendKeys(Contact_InformationAptSteFlr);
//						        	}
//								 else if(AttributeName.equals("locality")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationCityTownLocality);
//						        	}
//								 else if(AttributeName.equals("administrative_area_level_1")){		
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStateProvinceRegion);
//						        	}
//								 else if(AttributeName.equals("postal_code")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationPostalCode);
//						        	}
//								 
//								 
//							 }catch(Exception e){
//								 
//							 }
//						 }
//						 	//////Address Lookup 
//							try{
//								String AttributeName1=utilfunc.MakeElement(addresslookupxpath).getAttribute("name");
//								if(AttributeName1.contains("form2_autocomplete")){			
//								utilfunc.MakeElement(addresslookupxpath).sendKeys(Contact_InformationAddressLookup);
//								utilfunc.mouseaction();
//								}
//							}
//							catch(Exception f){}
//							///////////////////////
//							
//							/////////////////////Additional info handle///////////////////////////////
//							utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
//							
//							/*String SaveButtonXpath=".//*[@id='btnSave']";
//							 utilfunc.MakeElement(SaveButtonXpath).click();*/
//							utilfunc.savebutton();
//							   
//							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//							 if (error_flag.equals(ExpectedErrorMessage)){
//								 Flag=true;
//								 utilfunc.TakeScreenshot();
//							 }else if (error_flag.equals("")){
//								 Flag=true;
//							 }else if(error_flag.equals("Server Error in '/' Application.")){
//								 Flag=false;
//								 webdriver.navigate().back();
//							 }else{
//								 Flag=false;
//								 utilfunc.TakeScreenshot();
//							 }
//							
//						 
//					 }
					 
//					 else if(Contact_Information.equals("Permanent Address in Home Country")){
//						 
//						 utilfunc.MakeElement(PermanentAddressinHomeCountryxpath).click();
//						 
//						 int ObjCount=utilfunc.GetObjectCount(Contact_InformationCounterXpath);
//						 
//						 for(int count=1; count<=ObjCount; count++)
//						 {
//							 String NewXpath=Contact_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
//							 try{
//								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
//								 System.out.println("Attribute name "+count+"is : "+AttributeName);
//								 
//								 if(AttributeName.equals("SavedAddressId")){
//									 if(Contact_InformationCountry.equals("0")){
//										 utilfunc.Selectdropdownvaluebyindex(NewXpath, 0);
//									 }else{
//								     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Contact_InformationSavedaddress);
//									 }
//									 
//									 utilfunc.Selectdropdownvaluebyvalue(countryxpath, Contact_InformationCountry);
//									 
//						        	}	
//								 else if(AttributeName.equals("route")){
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress1);
//						        	}
//								 else if(AttributeName.equals("StreetAddress2")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress2);
//						        	}
//								 else if(AttributeName.equals("UnitType")){							
//									 String Newpath=NewXpath+"[1]";
//									 	utilfunc.Selectdropdownvaluebyvalue(Newpath, Contact_InformationAptSteFlr);
//									 	String Newpath1=NewXpath+"[2]";
//									 	utilfunc.MakeElement(Newpath1).clear();
//									 	utilfunc.MakeElement(Newpath1).sendKeys(Contact_InformationAptSteFlr);
//						        	}
//								 else if(AttributeName.equals("locality")){		
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationCityTownLocality);
//						        	}
//								 else if(AttributeName.equals("administrative_area_level_1")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStateProvinceRegion);
//						        	}
//								 else if(AttributeName.equals("postal_code")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationPostalCode);
//						        	}
//								 
//								 
//							 }catch(Exception e){
//								 
//							 }
//						 }
//						 	//////Address Lookup 
//							try{
//								String AttributeName1=utilfunc.MakeElement(addresslookupxpath).getAttribute("name");
//								if(AttributeName1.contains("form2_autocomplete")){			
//								utilfunc.MakeElement(addresslookupxpath).sendKeys(Contact_InformationAddressLookup);
//								utilfunc.mouseaction();
//								}
//							}
//							catch(Exception f){}
//							///////////////////////
//							
//							/////////////////////Additional info handle///////////////////////////////
//							utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
//									
//							
//							/*String SaveButtonXpath=".//*[@id='btnSave']";
//							 utilfunc.MakeElement(SaveButtonXpath).click();*/
//							utilfunc.savebutton();
//							   
//							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//							 if (error_flag.equals(ExpectedErrorMessage)){
//								 Flag=true;
//								 utilfunc.TakeScreenshot();
//							 }else if (error_flag.equals("")){
//								 Flag=true;
//							 }else if(error_flag.equals("Server Error in '/' Application.")){
//								 Flag=false;
//								 webdriver.navigate().back();
//							 }else{
//								 Flag=false;
//								 utilfunc.TakeScreenshot();
//							 }
//						 
//					 }
//					 else if(Contact_Information.equals("Email Address")){
//						 utilfunc.MakeElement(EmailAddressxpath).click();
//						 
//						 utilfunc.MakeElement(Emailxpath).sendKeys(Contact_InformationEmail);
//						 
//						 /////////////////////Additional info handle///////////////////////////////
//						utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
//									
//						 
//						 String SaveButtonXpath=".//*[@id='btnSave']";
//							utilfunc.MakeElement(SaveButtonXpath).click();
//							 
//							   
//							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//							 if (error_flag.equals(ExpectedErrorMessage)){
//								 Flag=true;
//								 utilfunc.TakeScreenshot();
//							 }else if (error_flag.equals("")){
//								 Flag=true;
//							 }else if(error_flag.equals("Server Error in '/' Application.")){
//								 Flag=false;
//								 webdriver.navigate().back();
//							}else{
//								 Flag=false;
//								 utilfunc.TakeScreenshot();
//							 }
//						 
//						
//					 }
//					 else if(Contact_Information.equals("Phone Number")){
//						 utilfunc.MakeElement(PhoneNumberxpath).click();
//						 						 	
//							int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
//						 	
//						 	for(int count2=1; count2<=ObjCount2; count2++){
//						 		String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
//						 		try{
//						 			String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
//									System.out.println("Attribute name "+count2+"is : "+AttributeName2);
//									
//									if(AttributeName2.contains("PhoneNumberType")){	
//										utilfunc.Selectdropdownvaluebyvalue(NewXpath3, Contact_InformationPhoneType);
//									 }
//									else if(AttributeName2.contains("PhoneCountryCode")){
//										utilfunc.MakeElement(NewXpath3).clear();
//									 	utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneCountrycode);
//									 }
//									else if(AttributeName2.contains("PhoneNumber")){
//										utilfunc.MakeElement(NewXpath3).clear();
//									 	utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneNumber);
//									 }
//									else if(AttributeName2.contains("PhoneExtension")){
//										utilfunc.MakeElement(NewXpath3).clear();
//									 	utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneExt);
//									 }
//																	 			
//						 		}catch(Exception e){
//						 			
//						 		}
//						 	}
//						 	if(Contact_InformationIsphonenumberisprimary.equals("Yes")){
//						 	
//						 	}else{
//						 		utilfunc.MakeElement(phonenumberenterxpath).click();
//								utilfunc.mouseaction();
//						 	}
//						 	
//						 	/////////////////////Additional info handle///////////////////////////////
//							utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
//									
//									
//						 	/*String SaveButtonXpath=".//*[@id='btnSave']";
//							utilfunc.MakeElement(SaveButtonXpath).click();*/
//							utilfunc.savebutton();
//							   
//							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//							 if (error_flag.equals(ExpectedErrorMessage)){
//								 Flag=true;
//								 utilfunc.TakeScreenshot();
//							 }else if (error_flag.equals("")){
//								 Flag=true;
//							 }else if(error_flag.equals("Server Error in '/' Application.")){
//								 Flag=false;
//								 webdriver.navigate().back();
//							}else{
//								 Flag=false;
//								 utilfunc.TakeScreenshot();
//							 }
//						 
//					 }
					 
				 }catch(Exception e){
					 utilfunc.NavigatetoURL(URLwithID);
					 
				 }
				
				 
				 
			 }else if(mode.equals(ACTION1)){
				 try{
					 /*String Contact_InformationURLwithID=Contact_InformationPageURL+Contact_InformationID;
					 utilfunc.NavigatetoURL(Contact_InformationURLwithID);*/
					 
					 utilfunc.NavigatetoURL(URLwithID);
					 Thread.sleep(1000);
					 
					 utilfunc.ServerErrorHandler();
					 Thread.sleep(1000);
					 if(Contact_Information.equals("Residence Address")){
						 utilfunc.MakeElement(ResidenceAddressxpath).click();
						 webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
						 
						 int ObjCount=utilfunc.GetObjectCount(Contact_InformationCounterXpath);
						 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 String NewXpath=Contact_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								 System.out.println("Attribute name "+count+"is : "+AttributeName);
								 
								 if(AttributeName.equals("SavedAddressId")){
									 if(Contact_InformationCountry.equals("0")){
										 try {
											utilfunc.Selectdropdownvaluebyindex(NewXpath, 0);
										} catch (Exception e) {
											
										}
									 }else{
										 try {
											utilfunc.Selectdropdownvaluebyvalue(NewXpath, Contact_InformationSavedaddress);
										} catch (Exception e) {
											
										}
									 }
									 
									 try {
										utilfunc.Selectdropdownvaluebyvalue(countryxpath, Contact_InformationCountry);
									} catch (Exception e) {
										}
									 
						        	}	
								 else if(AttributeName.equals("country")){
									 try {
										utilfunc.Selectdropdownvaluebyvalue(countryxpath, Contact_InformationCountry);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("route")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress1);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("StreetAddress2")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress2);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("UnitType")){							
									 String Newpath=NewXpath+"[1]";
									 	try {
											utilfunc.Selectdropdownvaluebyvalue(Newpath, Contact_InformationAptSteFlr);
										} catch (Exception e) {
											
										}
									 	String Newpath1=NewXpath+"[2]";
									 	try {
											utilfunc.MakeElement(Newpath1).clear();
											utilfunc.MakeElement(Newpath1).sendKeys(Contact_InformationAptSteFlr);
										} catch (Exception e) {
											
										}
						        	}
								 else if(AttributeName.equals("locality")){	
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationCityTownLocality);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("administrative_area_level_1")){	
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStateProvinceRegion);
									} catch (Exception e) {
										
									}
						        	}
								 else if(AttributeName.equals("postal_code")){
									 try {
										utilfunc.MakeElement(NewXpath).clear();
										 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationPostalCode);
									} catch (Exception e) {
										
									}
						        	}
								 
								 
							 }catch(Exception e){
								 
							 }
						 }
						 	//////Address Lookup 
							try{
								String AttributeName1=utilfunc.MakeElement(addresslookupxpath).getAttribute("name");
								if(AttributeName1.contains("form2_autocomplete")){			
								try {
									utilfunc.MakeElement(addresslookupxpath).sendKeys(Contact_InformationAddressLookup);
								} catch (Exception e) {
									
								}
								try {
									utilfunc.mouseaction();
								} catch (Exception e) {
									
								}
								}
							}
							catch(Exception f){}
							///////////////////////
							
							//////////////////////Additional info handle///////////////////////////////
							 try {
								utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
							} catch (Exception e) {
								
							}
							
							/*String SaveButtonXpath=".//*[@id='btnSave']";
							 utilfunc.MakeElement(SaveButtonXpath).click();*/
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
							
							
						 
					 }
//					 else if(Contact_Information.equals("Mailing Address")){
//						 utilfunc.MakeElement(MailingAddressxpath).click();
//						 
//						 int ObjCount=utilfunc.GetObjectCount(Contact_InformationCounterXpath);
//						 
//						 for(int count=1; count<=ObjCount; count++)
//						 {
//							 String NewXpath=Contact_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
//							 try{
//								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
//								 System.out.println("Attribute name "+count+"is : "+AttributeName);
//								 
//								 if(AttributeName.equals("SavedAddressId")){
//									 if(Contact_InformationCountry.equals("0")){
//										 utilfunc.Selectdropdownvaluebyindex(NewXpath, 0);
//									 }else{
//								     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Contact_InformationSavedaddress);
//									 }
//									 
//									 utilfunc.Selectdropdownvaluebyvalue(countryxpath, Contact_InformationCountry);
//									 
//						        	}	
//								 else if(AttributeName.equals("route")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress1);
//						        	}
//								 else if(AttributeName.equals("StreetAddress2")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress2);
//						        	}
//								 else if(AttributeName.equals("UnitType")){							
//									 String Newpath=NewXpath+"[1]";
//									 	utilfunc.Selectdropdownvaluebyvalue(Newpath, Contact_InformationAptSteFlr);
//									 	String Newpath1=NewXpath+"[2]";
//									 	utilfunc.MakeElement(Newpath1).clear();
//									 	utilfunc.MakeElement(Newpath1).sendKeys(Contact_InformationAptSteFlr);
//						        	}
//								 else if(AttributeName.equals("locality")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationCityTownLocality);
//						        	}
//								 else if(AttributeName.equals("administrative_area_level_1")){		
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStateProvinceRegion);
//						        	}
//								 else if(AttributeName.equals("postal_code")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationPostalCode);
//						        	}
//								 
//								 
//							 }catch(Exception e){
//								 
//							 }
//						 }
//						 	//////Address Lookup 
//							try{
//								String AttributeName1=utilfunc.MakeElement(addresslookupxpath).getAttribute("name");
//								if(AttributeName1.contains("form2_autocomplete")){			
//								utilfunc.MakeElement(addresslookupxpath).sendKeys(Contact_InformationAddressLookup);
//								utilfunc.mouseaction();
//								}
//							}
//							catch(Exception f){}
//							///////////////////////
//							
//							/////////////////////Additional info handle///////////////////////////////
//							utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
//							
//							/*String SaveButtonXpath=".//*[@id='btnSave']";
//							 utilfunc.MakeElement(SaveButtonXpath).click();*/
//							utilfunc.savebutton();
//							   
//							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//							 if (error_flag.equals(ExpectedErrorMessage)){
//								 Flag=true;
//								 utilfunc.TakeScreenshot();
//							 }else if (error_flag.equals("")){
//								 Flag=true;
//							 }else if(error_flag.equals("Server Error in '/' Application.")){
//								 Flag=false;
//								 webdriver.navigate().back();
//							 }else{
//								 Flag=false;
//								 utilfunc.TakeScreenshot();
//							 }
//							
//						 
//					 }
					 
//					 else if(Contact_Information.equals("Permanent Address in Home Country")){
//						 
//						 utilfunc.MakeElement(PermanentAddressinHomeCountryxpath).click();
//						 
//						 int ObjCount=utilfunc.GetObjectCount(Contact_InformationCounterXpath);
//						 
//						 for(int count=1; count<=ObjCount; count++)
//						 {
//							 String NewXpath=Contact_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
//							 try{
//								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
//								 System.out.println("Attribute name "+count+"is : "+AttributeName);
//								 
//								 if(AttributeName.equals("SavedAddressId")){
//									 if(Contact_InformationCountry.equals("0")){
//										 utilfunc.Selectdropdownvaluebyindex(NewXpath, 0);
//									 }else{
//								     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Contact_InformationSavedaddress);
//									 }
//									 
//									 utilfunc.Selectdropdownvaluebyvalue(countryxpath, Contact_InformationCountry);
//									 
//						        	}	
//								 else if(AttributeName.equals("route")){
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress1);
//						        	}
//								 else if(AttributeName.equals("StreetAddress2")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStreetAddress2);
//						        	}
//								 else if(AttributeName.equals("UnitType")){							
//									 String Newpath=NewXpath+"[1]";
//									 	utilfunc.Selectdropdownvaluebyvalue(Newpath, Contact_InformationAptSteFlr);
//									 	String Newpath1=NewXpath+"[2]";
//									 	utilfunc.MakeElement(Newpath1).clear();
//									 	utilfunc.MakeElement(Newpath1).sendKeys(Contact_InformationAptSteFlr);
//						        	}
//								 else if(AttributeName.equals("locality")){		
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationCityTownLocality);
//						        	}
//								 else if(AttributeName.equals("administrative_area_level_1")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationStateProvinceRegion);
//						        	}
//								 else if(AttributeName.equals("postal_code")){	
//									 utilfunc.MakeElement(NewXpath).clear();
//									 utilfunc.MakeElement(NewXpath).sendKeys(Contact_InformationPostalCode);
//						        	}
//								 
//								 
//							 }catch(Exception e){
//								 
//							 }
//						 }
//						 	//////Address Lookup 
//							try{
//								String AttributeName1=utilfunc.MakeElement(addresslookupxpath).getAttribute("name");
//								if(AttributeName1.contains("form2_autocomplete")){			
//								utilfunc.MakeElement(addresslookupxpath).sendKeys(Contact_InformationAddressLookup);
//								utilfunc.mouseaction();
//								}
//							}
//							catch(Exception f){}
//							///////////////////////
//							
//							/////////////////////Additional info handle///////////////////////////////
//							utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
//									
//							
//							/*String SaveButtonXpath=".//*[@id='btnSave']";
//							 utilfunc.MakeElement(SaveButtonXpath).click();*/
//							utilfunc.savebutton();
//							   
//							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//							 if (error_flag.equals(ExpectedErrorMessage)){
//								 Flag=true;
//								 utilfunc.TakeScreenshot();
//							 }else if (error_flag.equals("")){
//								 Flag=true;
//							 }else if(error_flag.equals("Server Error in '/' Application.")){
//								 Flag=false;
//								 webdriver.navigate().back();
//							 }else{
//								 Flag=false;
//								 utilfunc.TakeScreenshot();
//							 }
//						 
//					 }
//					 else if(Contact_Information.equals("Email Address")){
//						 utilfunc.MakeElement(EmailAddressxpath).click();
//						 
//						 utilfunc.MakeElement(Emailxpath).sendKeys(Contact_InformationEmail);
//						 
//						 /////////////////////Additional info handle///////////////////////////////
//						utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
//									
//						 
//						 String SaveButtonXpath=".//*[@id='btnSave']";
//							utilfunc.MakeElement(SaveButtonXpath).click();
//							 
//							   
//							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//							 if (error_flag.equals(ExpectedErrorMessage)){
//								 Flag=true;
//								 utilfunc.TakeScreenshot();
//							 }else if (error_flag.equals("")){
//								 Flag=true;
//							 }else if(error_flag.equals("Server Error in '/' Application.")){
//								 Flag=false;
//								 webdriver.navigate().back();
//							}else{
//								 Flag=false;
//								 utilfunc.TakeScreenshot();
//							 }
//						 
//						
//					 }
//					 else if(Contact_Information.equals("Phone Number")){
//						 utilfunc.MakeElement(PhoneNumberxpath).click();
//						 						 	
//							int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
//						 	
//						 	for(int count2=1; count2<=ObjCount2; count2++){
//						 		String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
//						 		try{
//						 			String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
//									System.out.println("Attribute name "+count2+"is : "+AttributeName2);
//									
//									if(AttributeName2.contains("PhoneNumberType")){	
//										utilfunc.Selectdropdownvaluebyvalue(NewXpath3, Contact_InformationPhoneType);
//									 }
//									else if(AttributeName2.contains("PhoneCountryCode")){
//										utilfunc.MakeElement(NewXpath3).clear();
//									 	utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneCountrycode);
//									 }
//									else if(AttributeName2.contains("PhoneNumber")){
//										utilfunc.MakeElement(NewXpath3).clear();
//									 	utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneNumber);
//									 }
//									else if(AttributeName2.contains("PhoneExtension")){
//										utilfunc.MakeElement(NewXpath3).clear();
//									 	utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneExt);
//									 }
//																	 			
//						 		}catch(Exception e){
//						 			
//						 		}
//						 	}
//						 	if(Contact_InformationIsphonenumberisprimary.equals("Yes")){
//						 	
//						 	}else{
//						 		utilfunc.MakeElement(phonenumberenterxpath).click();
//								utilfunc.mouseaction();
//						 	}
//						 	
//						 	/////////////////////Additional info handle///////////////////////////////
//							utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
//									
//									
//						 	/*String SaveButtonXpath=".//*[@id='btnSave']";
//							utilfunc.MakeElement(SaveButtonXpath).click();*/
//							utilfunc.savebutton();
//							   
//							 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//							 if (error_flag.equals(ExpectedErrorMessage)){
//								 Flag=true;
//								 utilfunc.TakeScreenshot();
//							 }else if (error_flag.equals("")){
//								 Flag=true;
//							 }else if(error_flag.equals("Server Error in '/' Application.")){
//								 Flag=false;
//								 webdriver.navigate().back();
//							}else{
//								 Flag=false;
//								 utilfunc.TakeScreenshot();
//							 }
//						 
//					 }
					 
				 }catch(Exception e){
					 utilfunc.NavigatetoURL(URLwithID);
					 
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
						
						try {
							utilfunc.NavigatetoURL(URLwithID);
							
							utilfunc.ServerErrorHandler();
							
							String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
							try {
								utilfunc.MakeElement(deletexpath).click();
							
							utilfunc.isAlertPresent();
                        } catch (Exception e) {
								
							}
							
							boolean error_flag=utilfunc.ErrorMessagehandler();
							 if (error_flag){
								 Flag=true;
							 }else{
								 Flag=false;
							 }
						} catch (Exception e) {
							utilfunc.NavigatetoURL(URLwithID);
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
