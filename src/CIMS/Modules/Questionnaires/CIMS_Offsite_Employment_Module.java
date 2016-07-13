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

public class CIMS_Offsite_Employment_Module {
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
	 
		public CIMS_Offsite_Employment_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Offsite_Employment_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 0, ColumnCounter);
			String Offsite_EmploymentScenerio=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 2, ColumnCounter);
			String Offsite_EmploymentTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 3, ColumnCounter);		
			String Offsite_EmploymentPageURL=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 4, ColumnCounter);
			String Offsite_EmploymentID=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 5, ColumnCounter);
			
			String Offsite_EmploymentPercentageTimeOffsite=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 6, ColumnCounter);
			String Offsite_EmploymentPercentageTravelRequiredUS=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 7, ColumnCounter);
			String Offsite_EmploymentPercentageTravelRequiredOutsideUS=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 8, ColumnCounter);
			String Offsite_EmploymentEmployeeSupervisionDescription=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 9, ColumnCounter);
			String Offsite_EmploymentAmtTimeSupervisionHours=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 10, ColumnCounter);
			String Offsite_EmploymentAmtTimeSupervisionUnit=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 11, ColumnCounter);
			String Offsite_EmploymentOffsiteReasonsDutiesDescription=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 12, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Offsite_Employment", 13, ColumnCounter);

			
			String addditionalinfoxpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";
			
			String Offsite_Employment_attributeFiledXpath=".//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@id]";
			String Offsite_EmploymentCounterXpath=".//*[@class='form-horizontal']//*[@class='control-group']//*[@id]";

			String Numberofhourscounterxpath=".//*[@class='control-group field-group-inline']//*[@class='field']";
			String Numberofhoursfieldxpath=".//*[@class='control-group field-group-inline']//*[@class='field'][xx]//*[@id]";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Offsite Employment";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			 URLwithID=utilfunc.geturldirect(QuestionarieName);
			
			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Offsite_EmploymentScenerio;
			 description=Offsite_EmploymentTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
			
			 
			 if(mode.equals(ACTION)){
				 try{
					 /*String Offsite_EmploymentURLwithID=Offsite_EmploymentPageURL+Offsite_EmploymentID;
					 utilfunc.NavigatetoURL(Offsite_EmploymentURLwithID);*/
					 			
			
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 Thread.sleep(2000);
					 int ObjCount=utilfunc.GetObjectCount(Offsite_EmploymentCounterXpath);
					 int ObjCount1=utilfunc.GetObjectCount(Numberofhourscounterxpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Offsite_Employment_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("PercentageTimeOffsite")){	
								 utilfunc.MakeElement(NewXpath).clear();
							    utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentPercentageTimeOffsite);
					        	}	
							 else if(AttributeName.equals("PercentageTravelRequiredUS")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Offsite_EmploymentPercentageTravelRequiredUS);
					        	}
							 else if(AttributeName.equals("PercentageTravelRequiredOutsideUS")){
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Offsite_EmploymentPercentageTravelRequiredOutsideUS);
								}
							 else if(AttributeName.equals("EmployeeSupervisionDescription")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentEmployeeSupervisionDescription);
					        	}
							 else if(AttributeName.equals("OffsiteReasonsDutiesDescription")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentOffsiteReasonsDutiesDescription);
					        	}
														 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 ///////////////////////Number of hours///////////////
					 for(int count=ObjCount1; count>=1; count--)
					 {
						 String NewXpath=Numberofhoursfieldxpath.replace("xx", Integer.toString(count));
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("AmtTimeSupervisionUnit")){							
							     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Offsite_EmploymentAmtTimeSupervisionUnit);
					        	}
							 else if(AttributeName.equals("AmtTimeSupervisionHours")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentAmtTimeSupervisionHours);
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
					 /*String Offsite_EmploymentURLwithID=Offsite_EmploymentPageURL+Offsite_EmploymentID;
					 utilfunc.NavigatetoURL(Offsite_EmploymentURLwithID);*/
					 		 
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 int ObjCount=utilfunc.GetObjectCount(Offsite_EmploymentCounterXpath);
					 int ObjCount1=utilfunc.GetObjectCount(Numberofhourscounterxpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Offsite_Employment_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("PercentageTimeOffsite")){	
								 utilfunc.MakeElement(NewXpath).clear();
							    utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentPercentageTimeOffsite);
					        	}	
							 else if(AttributeName.equals("PercentageTravelRequiredUS")){							
								 utilfunc.Selectdropdownvaluebyvalue(NewXpath, Offsite_EmploymentPercentageTravelRequiredUS);
					        	}
							 else if(AttributeName.equals("PercentageTravelRequiredOutsideUS")){
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentPercentageTravelRequiredOutsideUS);
								}
							 else if(AttributeName.equals("EmployeeSupervisionDescription")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentEmployeeSupervisionDescription);
					        	}
							 else if(AttributeName.equals("OffsiteReasonsDutiesDescription")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentOffsiteReasonsDutiesDescription);
					        	}
														 
							 
						 }catch(Exception e){
							 
						 }
					 }
					 ///////////////////////Number of hours///////////////
					 for(int count=ObjCount1; count>=ObjCount1; count--)
					 {
						 String NewXpath=Numberofhoursfieldxpath.replace("xx", Integer.toString(count));
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("AmtTimeSupervisionUnit")){							
							     utilfunc.Selectdropdownvaluebyvalue(NewXpath, Offsite_EmploymentAmtTimeSupervisionUnit);
					        	}
							 else if(AttributeName.equals("AmtTimeSupervisionHours")){	
								 utilfunc.MakeElement(NewXpath).clear();
								 utilfunc.MakeElement(NewXpath).sendKeys(Offsite_EmploymentAmtTimeSupervisionHours);
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
							utilfunc.ErrorMessage2="Delete option is not Implimented in Basic Information Module.";
							utilfunc.TakeScreenshot();
							Flag=false;
					}			
				 
			 }
			
				 
				
				 
				 }///////////url ckeck end
			
			 return Flag;
	 	}

}
