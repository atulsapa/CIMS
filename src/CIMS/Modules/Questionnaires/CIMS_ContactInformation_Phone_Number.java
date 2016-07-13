package CIMS.Modules.Questionnaires;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import util.UtilFunction;

public class CIMS_ContactInformation_Phone_Number {
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
	 public CIMS_ContactInformation_Phone_Number(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
	 public boolean ContactInformation_phone_Number(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
		 String TestcaseID=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 0, ColumnCounter);
		   
			String Contact_InformationScenerio=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 2, ColumnCounter);
			String Contact_InformationTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 3, ColumnCounter);		
			
			String Contact_InformationIsphonenumberisprimary=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 8, ColumnCounter);
			String Contact_InformationPhoneType=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 4, ColumnCounter);
			String Contact_InformationPhoneCountrycode=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 5, ColumnCounter);
			String Contact_InformationPhoneNumber=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 6, ColumnCounter);
			String Contact_InformationPhoneExt=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 7, ColumnCounter);
			
			
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "ContactInformation_Phone", 9, ColumnCounter);
			
			String Contact_Information_attributeFiledXpath=".//*[@class='control-group'][xx]//*[@id]";
			String Contact_InformationCounterXpath=".//*[@class='control-group']//*[@id]";
			
			
			

			String PhoneNumberxpath=".//*[@class='form-horizontal']/div[5]//*[@class='control-group']//*[@class='btn']";

			
			
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
						 
						 try {
							utilfunc.NavigatetoURL(URLwithID);
							 
							 utilfunc.ServerErrorHandler();
							 

							 try {
								 Thread.sleep(1000);
								utilfunc.MakeElement(PhoneNumberxpath).click();
								webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
							} catch (Exception e1) {}
							 
							 
							 
							 int ObjCount2=utilfunc.GetObjectCount(Referencephonenumbercounterxpath);
							 	
							 	for(int count2=1; count2<=ObjCount2; count2++){
							 		String NewXpath3=Referencephonenumberfieldxpath.replace("xx", Integer.toString(count2));
							 		try{
							 			String AttributeName2=utilfunc.MakeElement(NewXpath3).getAttribute("name");
										System.out.println("Attribute name "+count2+"is : "+AttributeName2);
										
										if(AttributeName2.contains("PhoneNumberType")){	
											try {
												
													utilfunc.DeSelectdropdownvalue(NewXpath3);	
													 Thread.sleep(999);
													utilfunc.Selectdropdownvaluebyvalue(NewXpath3, Contact_InformationPhoneType);												
											} catch (Exception e) {
												
											}
										 }
										else if(AttributeName2.contains("PhoneCountryCode")){
											try {
												 utilfunc.MakeElement(NewXpath3).clear();
												 Thread.sleep(300);
												utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneCountrycode);
											} catch (Exception e) {
												
											}
										 }
										else if(AttributeName2.contains("PhoneNumber")){
											try {
												utilfunc.MakeElement(NewXpath3).clear();
												Thread.sleep(300);
												utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneNumber);
											} catch (Exception e) {
												
											}
										 }
										else if(AttributeName2.contains("PhoneExtension")){
											try {
												utilfunc.MakeElement(NewXpath3).clear();
												Thread.sleep(300);
												utilfunc.MakeElement(NewXpath3).sendKeys(Contact_InformationPhoneExt);
											} catch (Exception e) {
												
											}
										 }
																				
									 
									 
								 }catch(Exception e){
									 
								 }
							 }
							 	try{
							 		Thread.sleep(500);
							 	if(Contact_InformationIsphonenumberisprimary.equals("Yes")){
							 		
							 		try {
							 			Thread.sleep(1000);
										utilfunc.MakeElement(phonenumberenterxpath).click();
									} catch (Exception e) {System.out.println("Is primary is not found");}
							 	}
							 	}catch(Exception error){}
							 		
									
							 	
							 	
								try {
									Thread.sleep(1000);
									utilfunc.dynamic_data(Contact_InformationCounterXpath, Contact_Information_attributeFiledXpath);
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
					 }
						} catch (Exception e) {
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
								
								utilfunc.NavigatetoURL(URLwithID);
								
								utilfunc.ServerErrorHandler();
								
								String deletexpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
								utilfunc.MakeElement(deletexpath).click();
								utilfunc.isAlertPresent();
								
								boolean error_flag1=utilfunc.ErrorMessagehandler();
								 if (error_flag1){
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
				 
						 }
		 return Flag;
	 	}




	 	}

