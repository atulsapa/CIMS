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

public class CIMS_Language_Proficiency_Module {
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
	 
		public CIMS_Language_Proficiency_Module(WebDriver driver,UtilFunction utilfunc) 
		{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
		
		// TODO Auto-generated constructor stub
	 }
		public boolean Language_Proficiency_info(int ColumnCounter,String mode) throws AWTException, InterruptedException
	 	{
			
			//Excel sheet Data collection
			String TestcaseID=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 0, ColumnCounter);
			String Language_ProficiencyScenerio=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 2, ColumnCounter);
			String Language_ProficiencyTestcaseDescription=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 3, ColumnCounter);		
			String Language_ProficiencyPageURL=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 4, ColumnCounter);
			String Language_ProficiencyID=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 5, ColumnCounter);
			
			String Language=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 6, ColumnCounter);
			String Speaking=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 7, ColumnCounter);
			String Reading=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 8, ColumnCounter);
			String Writing=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 9, ColumnCounter);
			String MostFrequentradio=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 10, ColumnCounter);
			String Notes=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 11, ColumnCounter);
			String ExpectedErrorMessage=UtilFunction.getCellData("Test Data.xls", "Language_Proficiency", 12, ColumnCounter);
				
			String addditionalinfoxpath=".//*[@class='form-horizontal']/*[@class='control-group'][xx]//*[@id]";
			String addditionalinfocounterxpath=".//*[@class='form-horizontal']/*[@class='control-group']//*[@id]";
			
			String Language_Proficiency_attributeFiledXpath=".//*[@class='question-group'][2]//*[@class='control-group'][xx]//*[@id]";
			String Language_ProficiencyCounterXpath=".//*[@class='question-group'][2]//*[@class='control-group']//*[@id]";

			String languagexpath=".//*[@class='question-group'][1]//*[@class='control-group']//*[@id]";
			
			/////////////////////////////////URL FETCH///////////////////////////////////
			
			String QuestionarieName="Language Proficiency";
			//String URLwithID=UtilFunction.geturl(QuestionarieName);
			URLwithID=utilfunc.geturldirect(QuestionarieName);

			boolean Flag =false;
			 testcaseid=TestcaseID;
			 scenerio=Language_ProficiencyScenerio;
			 description=Language_ProficiencyTestcaseDescription;
			 
			 String ACTION="New";
			 String ACTION1="Edit";
			 String ACTION2="Delete";
			 
			 if(URLwithID.equals("")){
				 utilfunc.closesidebar();
				 Flag=false; 
				 }else{
				  
				
			 
			 if(mode.equals(ACTION)){
				 try{
					/* String Language_ProficiencyURLwithID=Language_ProficiencyPageURL+Language_ProficiencyID;
					 utilfunc.NavigatetoURL(Language_ProficiencyURLwithID);*/
				
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String AddbuttonXpath="//*[@class='btn']";
					 try {
						utilfunc.MakeElement(AddbuttonXpath).click();
						
						webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					} catch (Exception e1) {
						
					}
					 
					 try {
						utilfunc.MakeElement(languagexpath).sendKeys(Language);
					} catch (Exception e1) {}
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Language_ProficiencyCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Language_Proficiency_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("Speaking")){							
							     try {
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Speaking);
								} catch (Exception e) {
									
								}
					        	}	
							 else if(AttributeName.equals("Reading")){							
								 try {
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Reading);
								} catch (Exception e) {}
					        	}
							 else if(AttributeName.equals("Writing")){							
								 try {
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Writing);
								} catch (Exception e) {}
					        	}
							 else if(AttributeName.equals("MostFrequent")){	
								 if(MostFrequentradio.equals("Yes")){
								 try {
									 Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {}
					        	}
							 }
							 else if(AttributeName.equals("Notes")){							
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Notes);
								} catch (Exception e) {}
					        	}
							
							 
						 }catch(Exception e){
							 
						 }
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
					 /*String Language_ProficiencyURLwithID=Language_ProficiencyPageURL+Language_ProficiencyID;
					 utilfunc.NavigatetoURL(Language_ProficiencyURLwithID);*/
					
					 utilfunc.NavigatetoURL(URLwithID);
					 
					 utilfunc.ServerErrorHandler();
					 
					 String EditbuttonXpath=".//*[@class='table table-item-list']//tr[1]//*[@class='icon-edit']";
					 try {
						utilfunc.MakeElement(EditbuttonXpath).click();
					} catch (Exception e1) {}
					 
					 utilfunc.MakeElement(languagexpath).clear();
					 try {
						utilfunc.MakeElement(languagexpath).sendKeys(Language);
					} catch (Exception e1) {}
					 
					 
					 int ObjCount=utilfunc.GetObjectCount(Language_ProficiencyCounterXpath);
					 
					 for(int count=1; count<=ObjCount; count++)
					 {
						 String NewXpath=Language_Proficiency_attributeFiledXpath.replace("xx", Integer.toString(count));
						 
						 try{
							 String AttributeName=utilfunc.MakeElement(NewXpath).getAttribute("id");
							 System.out.println("Attribute name "+count+"is : "+AttributeName);
							 
							 if(AttributeName.equals("Speaking")){							
							     try {
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Speaking);
								} catch (Exception e) {}
					        	}	
							 else if(AttributeName.equals("Reading")){							
								 try {
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Reading);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("Writing")){							
								 try {
									utilfunc.Selectdropdownvaluebyvalue(NewXpath, Writing);
								} catch (Exception e) {
									
								}
					        	}
							 else if(AttributeName.equals("MostFrequent")){	
								 if(MostFrequentradio.equals("Yes")){
								 try {
									utilfunc.MakeElement(NewXpath).click();
								} catch (Exception e) {
								}
					        	}
							 }
							 else if(AttributeName.equals("Notes")){
								 utilfunc.MakeElement(NewXpath).clear();						
								 try {
									utilfunc.MakeElement(NewXpath).sendKeys(Notes);
								} catch (Exception e) {
									
								}
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
					 /*String Language_ProficiencyURLwithID=Language_ProficiencyPageURL+Language_ProficiencyID;
					 utilfunc.NavigatetoURL(Language_ProficiencyURLwithID);*/
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
