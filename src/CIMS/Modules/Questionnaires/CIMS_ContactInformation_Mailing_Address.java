package CIMS.Modules.Questionnaires;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_ContactInformation_Mailing_Address {
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
	 public CIMS_ContactInformation_Mailing_Address(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
	 public boolean ContactInformation_Mailing_Address(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
		 String TestcaseID=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 0, ColumnCounter);
		   
			String Contact_InformationScenerio=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 2, ColumnCounter);
			String Contact_InformationTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 3, ColumnCounter);		
			String Contact_InformationPageURL=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 4, ColumnCounter);
			String Contact_InformationID=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 5, ColumnCounter);
			
			String Contact_Information=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 6, ColumnCounter);
			String Contact_InformationCountry=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 7, ColumnCounter);
			String Contact_InformationAddressLookup=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 8, ColumnCounter);
			String Contact_InformationStreetAddress1=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 9, ColumnCounter);
			String Contact_InformationStreetAddress2=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 10, ColumnCounter);
			String Contact_InformationAptSteFlr=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 11, ColumnCounter);
			String Contact_InformationCityTownLocality=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 12, ColumnCounter);
			String Contact_InformationStateProvinceRegion=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 13, ColumnCounter);
			String Contact_InformationPostalCode=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 14, ColumnCounter);
			
			
//			String Contact_InformationEmail=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 15, ColumnCounter);
//			
//			String Contact_InformationIsphonenumberisprimary=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 16, ColumnCounter);
//			String Contact_InformationPhoneType=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 17, ColumnCounter);
//			String Contact_InformationPhoneCountrycode=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 18, ColumnCounter);
//			String Contact_InformationPhoneNumber=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 19, ColumnCounter);
//			String Contact_InformationPhoneExt=UtilFunction.getCellData("Test Data.xls", "Contact_Information", 20, ColumnCounter);
			String Contact_InformationSavedaddress=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 21, ColumnCounter);
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "ContactInformationMailingAddres", 22, ColumnCounter);
			
			String Contact_Information_attributeFiledXpath=".//*[@class='control-group'][xx]//*[@id]";
			String Contact_InformationCounterXpath=".//*[@class='control-group']//*[@id]";
			
			String countryxpath=".//*[@id='country']";
			
//			String ResidenceAddressxpath=".//*[@id='divResidence']//*[@class='icon-pencil icon-block']";
			String MailingAddressxpath=".//*[@class='form-horizontal']/div[2]//*[@class='control-group']//*[@class='btn']";
//			String PermanentAddressinHomeCountryxpath=".//*[@id='divPermanet']//*[@class='icon-pencil icon-block']";
//			String EmailAddressxpath=".//*[@id='divEmail']//*[@class='icon-pencil icon-block']";
//			String PhoneNumberxpath=".//*[@id='divPhone']//*[@class='icon-pencil icon-block']";
			
			String addresslookupxpath=".//*[@class='question-group-address']//*[@id]";
			String Emailxpath=".//*[@class='fld-email']";
			
			String phonenumberenterxpath=".//*[@class='control-group']//*[@id]";
			
			String Referencephonenumberfieldxpath=".//*[@id='grp-phone']//td[xx]//*[@name]";
			String Referencephonenumbercounterxpath=".//*[@id='grp-phone']//td//*[@name]";

			/////////////////////////////////URL FETCH///////////////////////////////////
			String QuestionarieName="Contact Info";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			try {
				Thread.sleep(1000);
				URLwithID=utilfunc.geturldirect(QuestionarieName);
				
				
				
				
			} catch (Exception e1) {}			
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
					 if(mode.equals(ACTION)||mode.equals(ACTION1)){
						 try{
						 utilfunc.NavigatetoURL(URLwithID);
						 
						 utilfunc.ServerErrorHandler();
						 

						 try {
							 Thread.sleep(1000);
							utilfunc.MakeElement(MailingAddressxpath).click();
						} catch (Exception e1) {}
						 
						 int ObjCount=utilfunc.GetObjectCount(Contact_InformationCounterXpath);
						 
						 for(int count=1; count<=ObjCount; count++)
						 {
							 String NewXpath=Contact_Information_attributeFiledXpath.replace("xx", Integer.toString(count));
							 try{
								 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
								 System.out.println("Attribute name "+count+"is ............: "+AttributeName);
								 
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
									utilfunc.mouseaction();
								} catch (Exception e) {
									
								}
								}
							}
							catch(Exception f){}
							///////////////////////
							
							/////////////////////Additional info handle///////////////////////////////
							try {
								Thread.sleep(3000);
								utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
								Thread.sleep(3000);
							} catch (Exception e) {}
							
						
						 
					 
					 try {
						 Thread.sleep(1000);
						utilfunc.savebutton();
					} catch (Exception e) {	}
				        
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
					 }}catch(Exception e){
						 
						 utilfunc.NavigatetoURL(URLwithID);
					 }
						 }
					 
						 
				 
					 if(mode.equals(ACTION2)){
						 
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
									
									boolean error_flagA=utilfunc.ErrorMessagehandler();
									 if (error_flagA){
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
				 
		  }
		 return Flag;
	 	}

}
