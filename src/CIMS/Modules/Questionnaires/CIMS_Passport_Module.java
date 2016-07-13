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
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import CIMS.CIMS_MainProject;

import util.UtilFunction;

public class CIMS_Passport_Module
{
	
	
	private static final String Counter = null;
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	//Veriables-------------
	
	 public static String ErrorMessage="";
	 public static String ErrorMessage1="";
	 public static String ErrorMessage2="";
	 public static String ErrorMessage4="";
	 public static String URLwithID="";
	 //public static String ErrorMessage3[]=new String [100];
	 
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	 
	
	
	 //Constructor----------
	 
		public CIMS_Passport_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		
		
		//Functions--------------
	/**
	 * Verify that User is able to landed on the Project Initiation Page
	 * 	
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	 public boolean PassportPage(int ColumnCounter, String mode) throws AWTException, InterruptedException
	 	{	
		
		//Passport Page	
		 
		//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Passport", 0, ColumnCounter);
			String PassportScenerio=UtilFunction.getCellData("Test Data.xls", "Passport", 2, ColumnCounter);
			String PassportTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Passport", 3, ColumnCounter);		
			String PassportPageURL=UtilFunction.getCellData("Test Data.xls", "Passport", 4, ColumnCounter);
			String PassportID=UtilFunction.getCellData("Test Data.xls", "Passport", 5, ColumnCounter);	
			
			String PassportCountry=UtilFunction.getCellData("Test Data.xls", "Passport", 6, ColumnCounter);
			String PassportPassportNumber=UtilFunction.getCellData("Test Data.xls", "Passport", 7, ColumnCounter);
			String PassportIssuedDate=UtilFunction.getCellData("Test Data.xls", "Passport", 8, ColumnCounter);
			String PassportExpirationDate=UtilFunction.getCellData("Test Data.xls", "Passport", 9, ColumnCounter);
			String PassportIssuedatCountry=UtilFunction.getCellData("Test Data.xls", "Passport", 10, ColumnCounter);
			String PassportIssuedStateProvince=UtilFunction.getCellData("Test Data.xls", "Passport", 11, ColumnCounter);
			
			String PassportIssuedatCity=UtilFunction.getCellData("Test Data.xls", "Passport", 12, ColumnCounter);
			String Passportbooknumber=UtilFunction.getCellData("Test Data.xls", "Passport", 13, ColumnCounter);
			String InventoryControlNumber=UtilFunction.getCellData("Test Data.xls", "Passport", 14, ColumnCounter);
			
			String Passporttype=UtilFunction.getCellData("Test Data.xls", "Passport", 15, ColumnCounter);
			String PassportLocationofPassport=UtilFunction.getCellData("Test Data.xls", "Passport", 16, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Passport", 17, ColumnCounter);
			String Fileupload=UtilFunction.getCellData("Test Data.xls", "Passport", 18, ColumnCounter);
			//Custom Field  
			String showbuttonxpath=".//*[@id='btnShowDocUpload']";
			String uploadbuttonxpath=".//*[@id='DocUploadModal']//*[@class='modal-body']//button";
			String fileuploadpath="";
			if(CIMS_MainProject.os.contains("Linux")){
				fileuploadpath=System.getProperty("user.dir")+"/testuploadsheet.xlsx";
			}else if(CIMS_MainProject.os.contains("Windows")){
				fileuploadpath="c:\\JavaWorkspace\\testuploadsheet.xlsx";			
			}
			String fileuploadbutton=".//*[@id='btnUploadDocuments']";
			
			//Methods Xpath
			String PassportFiledXpath=".//*[@class='control-group'][xx]//*[@id]";
			String PassportcounterXpath=".//*[@class='control-group']//*[@id]";
			
			String additionalinfocounterxpath=".//div/h4/..//*[@class='control-group']//*[@id]";
			String additionalinfofieldxpath=".//div/h4/..//*[@class='control-group'][xx]//*[@id]";
		 
			/////////////////////////////////URL FETCH///////////////////////////////////
				 
		 String QuestionarieName="Passport";
		 //String URLwithID=UtilFunction.geturl(QuestionarieName);
		 URLwithID=utilfunc.geturldirect(QuestionarieName);
			
		 boolean Flag =false;
		 testcaseid=TestcaseID;
		 scenerio=PassportScenerio;
		 description=PassportTestcaseDescription;
		 String ACTION="New";
		 String ACTION1="Edit";
		 String ACTION2="Delete";
		 
		 if(URLwithID.equals("")){
			 utilfunc.closesidebar();
			 Flag=false; 
			 }else{
			  
			
		 
		 if(mode.equals(ACTION)){
			 try{
				 /*String PassportURLwithID=PassportPageURL+PassportID;
				 
				 utilfunc.NavigatetoURL(PassportURLwithID);*/
			
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 String AddbuttonXpath="//*[@class='btn']";
				 utilfunc.MakeElement(AddbuttonXpath).click();
				 				 
				 
				 int ObjCount=utilfunc.GetObjectCount(PassportcounterXpath);
				 
				 for(int count=1; count<=ObjCount; count++)
				 {
					 String NewXpath=PassportFiledXpath.replace("xx", Integer.toString(count));
					 
					 try {
						 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
						 System.out.println("Attribute name "+count+"is : "+AttributeName);
						 
						 if(AttributeName.equals("NewCountryCode")){							
						        utilfunc.Selectdropdownvaluebyvalue(NewXpath, PassportCountry);
						       
				        	}	
						 else if(AttributeName.equals("PassportNumber")){							
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportPassportNumber);
				        	}
						 else if(AttributeName.equals("IssuedDate")){							
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportIssuedDate);
				        	}
						 else if(AttributeName.equals("ExpirationDate")){							
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportExpirationDate);
				        	}
						 else if(AttributeName.equals("IssuedCountryCode")){							
							  utilfunc.Selectdropdownvaluebyvalue(NewXpath, PassportIssuedatCountry);
				        	}
						 else if(AttributeName.equals("IssuedStateOrProvince")){							
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportIssuedStateProvince);
				        	}
						 else if(AttributeName.equals("IssuedCity")){							
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportIssuedatCity);
				        	}
						 //////
						 else if(AttributeName.equals("Has2BlankPages")){							
							 utilfunc.MakeElement(NewXpath).click();
				        	}
						 else if(AttributeName.equals("IsEmergencyOrTemp")){							
							 utilfunc.MakeElement(NewXpath).click();
				        	}
						 else if(AttributeName.equals("IsBiometric")){							
							 utilfunc.MakeElement(NewXpath).click();
				        	}
						 else if(AttributeName.equals("IsPrimary")){							
							 utilfunc.MakeElement(NewXpath).click();
				        	}
						 else if(AttributeName.equals("PassportBookNumber")){							
							 utilfunc.MakeElement(NewXpath).sendKeys(Passportbooknumber);
				        	}
						 else if(AttributeName.equals("InventoryControlNumber")){							
							 utilfunc.MakeElement(NewXpath).sendKeys(InventoryControlNumber);
				        	}	 
						 else if(AttributeName.equals("PassportType")){							
							 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Passporttype);
				        	}
						 else if(AttributeName.equals("PassportLocation")){							
							 utilfunc.Selectdropdownvaluebyvalue(NewXpath, PassportLocationofPassport);
				        	}
						 else if(AttributeName.contains("PassportDocumentId")){
							 
							 if(Fileupload.equals("Yes")){
								 utilfunc.MakeElement(showbuttonxpath).click();
									Thread.sleep(2000);
									utilfunc.MakeElement(uploadbuttonxpath).click();
									Thread.sleep(1000);    
						         utilfunc.uploadfile(fileuploadpath);
						         Thread.sleep(5000);
						         utilfunc.MakeElement(fileuploadbutton).click();
							 	}
							}
						 
					 }
					 catch(Exception e){
						
					 }
				 }//for loop ends
				 ////////additional info handled//////////////
				 utilfunc.dynamic_data(additionalinfocounterxpath, additionalinfofieldxpath);
				 
				 /////////////////////////////////////////////
				 utilfunc.savebutton();
			       
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
			
				 
			 }catch(Exception Ex){
			 }
			 
		 }else if(mode.equals(ACTION1)){
			 try{
				 /*String PassportURLwithID=PassportPageURL+PassportID;
				 
				 utilfunc.NavigatetoURL(PassportURLwithID);*/
		
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
				 utilfunc.MakeElement(EditbuttonXpath).click();
				 				 
				 
				 int ObjCount=utilfunc.GetObjectCount(PassportcounterXpath);
				 
				 for(int count=1; count<=ObjCount; count++)
				 {
					 String NewXpath=PassportFiledXpath.replace("xx", Integer.toString(count));
					 
					 try {
						 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
						 System.out.println("Attribute name "+count+"is : "+AttributeName);
						 
						 if(AttributeName.equals("CountryCode")){		
							 if(PassportCountry.equals("")){
								 utilfunc.Selectdropdownvaluebyindex(NewXpath, 0);
							 }else{
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, PassportCountry);
							     //utilfunc.Selectdropdownvaluebyindex(NewXpath, 0); 
							 }						      
				        	}	
						 else if(AttributeName.equals("PassportNumber")){	
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportPassportNumber);
				        	}
						 else if(AttributeName.equals("IssuedDate")){	
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportIssuedDate);
				        	}
						 else if(AttributeName.equals("ExpirationDate")){	
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportExpirationDate);
				        	}
						 else if(AttributeName.equals("IssuedCountryCode")){							
							  utilfunc.Selectdropdownvaluebyvalue(NewXpath, PassportIssuedatCountry);
				        	}
						 else if(AttributeName.equals("IssuedStateOrProvince")){
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportIssuedStateProvince);
				        	}
						 else if(AttributeName.equals("IssuedCity")){	
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(PassportIssuedatCity);
				        	}
						 //////
						 else if(AttributeName.equals("Has2BlankPages")){							
							 utilfunc.MakeElement(NewXpath).click();
				        	}
						 else if(AttributeName.equals("IsEmergencyOrTemp")){							
							 utilfunc.MakeElement(NewXpath).click();
				        	}
						 else if(AttributeName.equals("IsBiometric")){							
							 utilfunc.MakeElement(NewXpath).click();
				        	}
						 else if(AttributeName.equals("IsPrimary")){							
							 utilfunc.MakeElement(NewXpath).click();
				        	}
						 else if(AttributeName.equals("PassportBookNumber")){	
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(Passportbooknumber);
				        	}
						 else if(AttributeName.equals("InventoryControlNumber")){
							 utilfunc.MakeElement(NewXpath).clear();
							 utilfunc.MakeElement(NewXpath).sendKeys(InventoryControlNumber);
				        	}
						 else if(AttributeName.equals("PassportType")){							
							 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Passporttype);
				        	}
						 else if(AttributeName.equals("PassportLocation")){							
							 utilfunc.Selectdropdownvaluebyvalue(NewXpath, PassportLocationofPassport);
				        	}
						 else if(AttributeName.contains("PassportDocumentId")){
							 
							 if(Fileupload.equals("Yes")){
								 utilfunc.MakeElement(showbuttonxpath).click();
									Thread.sleep(2000);
									utilfunc.MakeElement(uploadbuttonxpath).click();
									Thread.sleep(1000);    
						         utilfunc.uploadfile(fileuploadpath);
						         Thread.sleep(5000);
						         utilfunc.MakeElement(fileuploadbutton).click();
							 	}
							}
						 
					 }
					 catch(Exception e){
						
					 }
				 }//for loop ends
				 ////////additional info handled//////////////
				 utilfunc.dynamic_data(additionalinfocounterxpath, additionalinfofieldxpath);
				 
				 /////////////////////////////////////////////
				 utilfunc.savebutton();
			        Thread.sleep(3000);
			        
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
			      		
				 
			 }catch(Exception Ex){
				 utilfunc.ErrorMessage="";
				 utilfunc.ErrorMessage1="";							
				 utilfunc.ErrorMessage4="";
				 utilfunc.ErrorMessage5="";
				 utilfunc.ErrorMessage2="No Records Found to Edit";
				 Flag=false;
				 utilfunc.TakeScreenshot();
			 }
			 
		 }
		 else if(mode.equals(ACTION2)){				 
			 
			 try{
				 /*String PassportURLwithID=PassportPageURL+PassportID;
				 
				 utilfunc.NavigatetoURL(PassportURLwithID);*/
				 utilfunc.ErrorMessage="";
					utilfunc.ErrorMessage1="";							
					utilfunc.ErrorMessage4="";
					utilfunc.ErrorMessage5="";
				 	testcaseid="TC001";
					scenerio="Positive";
					description="Verify that If Click on Delete Button Expected Result-Successfully Deleted";
				
				 utilfunc.NavigatetoURL(URLwithID);
				 
				 utilfunc.ServerErrorHandler();
				 
				 Thread.sleep(10000);
				 String delete=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-trash']";
				 utilfunc.MakeElement(delete).click();
				 
				 Thread.sleep(10000);
				 utilfunc.isAlertPresent();
				 
				   boolean error_flag=utilfunc.ErrorMessagehandler();
					 if (error_flag){
						 Flag=true;
					 }else{
						 Flag=false;
					 }
			 }
				 
			 catch(Exception s){
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

		
	
		