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

public class CIMS_Employer_Processing_Module {
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
	 
		public CIMS_Employer_Processing_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Employer_Processing_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 0, ColumnCounter);
			String Employer_ProcessingScenerio=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 2, ColumnCounter);
			String Employer_ProcessingTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 3, ColumnCounter);		
			String Employer_ProcessingPageURL=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 4, ColumnCounter);
			String Employer_ProcessingID=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 5, ColumnCounter);
			
			String Employer_Processingemployeeid=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 6, ColumnCounter);
			String PurchaseOrderNumber=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 7, ColumnCounter);
			String PremiumProcessingradio=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 8, ColumnCounter);
			String ReplacedPersonradio=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 9, ColumnCounter);
			
			String Nameofreplacedperson=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 10, ColumnCounter);
			String Visatype=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 11, ColumnCounter);
			String Visadateofissue=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 12, ColumnCounter);
			String Visaplaceofissue=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 13, ColumnCounter);
			String Exportcomplianceradio=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 14, ColumnCounter);
			String ExportLicenseRequiredradio=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 15, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Employer_Processing", 16, ColumnCounter);
			
			String addditionalinfoxpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@id]";
			
			String Employer_Processing_idxpath=".//*[@class='form-horizontal']//*[@class='control-group'][1]//*[@id]";
			
			String Employer_Processing_fieldxpath=".//*[@class='form-horizontal']/div//*[@class='control-group'][xx]//*[@id]";
			String Employer_ProcessingCounterXpath=".//*[@class='form-horizontal']/div//*[@class='control-group']//*[@id]";

			String Replacepersionradioxpath=".//*[@class='form-horizontal']/div//*[@class='control-group'][4]//*[@class='controls']/div[xx]//*[@class='radio inline'][1]/input";
			String Replacepersionradiocounterxpath=".//*[@class='form-horizontal']/div//*[@class='control-group'][4]//*[@class='controls']/div//*[@class='radio inline'][1]/input";
			String replacepersonattributexpath=".//*[@class='form-horizontal']/div//*[@class='control-group'][4]//*[@class='controls']/div[xx]//*[@class='radio inline']";
			
			String Replacepersionfieldxpath=".//*[@id='ReplacedPerson']//*[@class='control-group'][xx]//*[@id]";
			String Replacepersioncounterxpath=".//*[@id='ReplacedPerson']//*[@class='control-group']//*[@id]";
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Employer Processing";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Employer_ProcessingScenerio;
			 description=Employer_ProcessingTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Employer_ProcessingURLwithID=Employer_ProcessingPageURL+Employer_ProcessingID;
					 utilfunc.NavigatetoURL(Employer_ProcessingURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 try{
						 utilfunc.MakeElement(Employer_Processing_idxpath).clear();
					 utilfunc.MakeElement(Employer_Processing_idxpath).sendKeys(Employer_Processingemployeeid);
					 }catch(Exception e){
						 
					 }
					 int ObjCount=utilfunc.GetObjectCount(Employer_ProcessingCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Employer_Processing_fieldxpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("PurchaseOrderNumber")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(PurchaseOrderNumber);
					        	}	
							 else if(AttributeName.equals("BillingReference")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(PurchaseOrderNumber);
					        	}
							 else if(AttributeName.equals("PremiumProcessing")){	
								 if(PremiumProcessingradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 else if(AttributeName.equals("ExportComplianceCheckCompleted")){	
								 if(Exportcomplianceradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 else if(AttributeName.equals("ExportLicenseRequired")){
								 
								 if(ExportLicenseRequiredradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 
													 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 
					 //replace person radio
					 int ObjCount1=utilfunc.GetObjectCount(Replacepersionradiocounterxpath);
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 //replacepersonattributexpath
						 String NewXpath=Replacepersionradioxpath.replace("xx", Integer.toString(count));
						 String NewXpath1=replacepersonattributexpath.replace("xx", Integer.toString(count));
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath1).getText();
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals(ReplacedPersonradio)){
								 utilfunc.MakeElement(NewXpath).click();
					        	}	
						 }catch(Exception e){
							 
						 }
					 }
					 
					//replace person field
					 int ObjCount2=utilfunc.GetObjectCount(Replacepersioncounterxpath);
					 for(int count=1; count<=ObjCount2; count++)
					 {
						 String NewXpath=Replacepersionfieldxpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("ReplacedPerson_FullName")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Nameofreplacedperson);
					        	}
							 else if(AttributeName.equals("ReplacedPerson_VisaType")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Visatype);
					        	}
							 else if(AttributeName.equals("ReplacedPerson_VisaIssuedDate")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Visadateofissue);
					        	}
							 else if(AttributeName.equals("ReplacedPerson_VisaIssuedLocation")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Visaplaceofissue);
					        	}
							 
							 
							 
						 }catch(Exception e){
							 
						 }
						 
					 }
					 
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					 
					 utilfunc.savebutton();
					 
					 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
					 }else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
					 
				 }catch(Exception e){
					 
				 }
				 
				 
			 }else if(mode.equals(ACTION1)){
				 try{
					 /*String Employer_ProcessingURLwithID=Employer_ProcessingPageURL+Employer_ProcessingID;
					 utilfunc.NavigatetoURL(Employer_ProcessingURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 try{
					 utilfunc.MakeElement(Employer_Processing_idxpath).clear();
					 utilfunc.MakeElement(Employer_Processing_idxpath).sendKeys(Employer_Processingemployeeid);
					 }catch(Exception e){
						 
					 }
					 int ObjCount=utilfunc.GetObjectCount(Employer_ProcessingCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Employer_Processing_fieldxpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("PurchaseOrderNumber")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(PurchaseOrderNumber);
					        	}	
							 else if(AttributeName.equals("BillingReference")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(PurchaseOrderNumber);
					        	}
							 else if(AttributeName.equals("PremiumProcessing")){	
								 if(PremiumProcessingradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 else if(AttributeName.equals("ExportComplianceCheckCompleted")){	
								 if(Exportcomplianceradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 else if(AttributeName.equals("ExportLicenseRequired")){
								 
								 if(ExportLicenseRequiredradio.equals("Yes")){
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][1]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}else{
										String NewXpath1=NewXpath.replace("//*[@id]", "//*[@class='radio inline'][2]/input");
										System.out.println(NewXpath1);
										utilfunc.MakeElement(NewXpath1).click();
									}
					        	}
							 
													 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 
					 //replace person radio
					 int ObjCount1=utilfunc.GetObjectCount(Replacepersionradiocounterxpath);
					 for(int count=1; count<=ObjCount1; count++)
					 {
						 String NewXpath=Replacepersionradioxpath.replace("xx", Integer.toString(count));
						 try{
							 if(ReplacedPersonradio.equals("Yes")){
								 utilfunc.MakeElement(NewXpath).click();
					        	}	
							 else if(ReplacedPersonradio.equals("No, there is an increase in staff.")){
								 utilfunc.MakeElement(NewXpath).click();
					        	}	
							 else if(ReplacedPersonradio.equals("No, there is a continuation of existing employment in the United States")){
								 utilfunc.MakeElement(NewXpath).click();
					        	}
						 }catch(Exception e){
							 
						 }
					 }
					 
					//replace person field
					 int ObjCount2=utilfunc.GetObjectCount(Replacepersioncounterxpath);
					 for(int count=1; count<=ObjCount2; count++)
					 {
						 String NewXpath=Replacepersionfieldxpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("ReplacedPerson_FullName")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Nameofreplacedperson);
					        	}
							 else if(AttributeName.equals("ReplacedPerson_VisaType")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Visatype);
					        	}
							 else if(AttributeName.equals("ReplacedPerson_VisaIssuedDate")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Visadateofissue);
					        	}
							 else if(AttributeName.equals("ReplacedPerson_VisaIssuedLocation")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Visaplaceofissue);
					        	}
							 
							 
							 
						 }catch(Exception e){
							 
						 }
						 
					 }
					 
					 //////////////////////Additional info handle///////////////////////////////
					 utilfunc.dynamic_data(addditionalinfocounterxpath, addditionalinfoxpath);
					 
					 utilfunc.savebutton();
					 
					 String error_flag=utilfunc.ErrorMessagehandlerExperiment();
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
					 }else{
						 Flag=false;
						 utilfunc.TakeScreenshot();
					 }
					 
				 }catch(Exception e){
					 
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
						utilfunc.MakeElement(deletexpath).click();
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
							utilfunc.ErrorMessage2="Delete option is not Implimented in Employer Processing Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
				
				 }///////////url ckeck end 
			 
			
			 return Flag;
	 	}

}
