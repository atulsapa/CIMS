package CIMS.Modules.Company;
//**//
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;

import util.UtilFunction;



public class CIMS_Company_Company_Settings {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	
	public CIMS_Company_Company_Settings(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Settings(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		
		System.out.println("User is on "+sheetName+" module");
		boolean Flag	=	false;
		

		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String SurveyEnabled								=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String LinkValidDays							    =			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String ReminderDays									=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String EscalateHR									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String CountBeforeEscalate							=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String EEDefDocumentVisibility						=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String ERDefDocumentVisibility						=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String NPDefDocumentVisibility						=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String GCPOneResult									=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				
				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;

				if(TestcaseRunMode.equals("Y")){
					System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
					if(mode.equals("Delete")){
						System.out.println("User is deleting "+sheetName+" module");
						utilfunc.ErrorMessage1="Can not perform "+mode+" operation on "+sheetName+"  module.";
						Flag= true;
						utilfunc.globalerrormessage="User is not having permission for perform this operation for this module.";
						return Flag;
					}else{
				
						try{
							
							String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
							String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
							int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
							
							for(int i=1;i<=resultCount;i++){
								String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
								String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
								System.out.println(AttributeName);
								if(AttributeName.equals("SurveyEnabled")){
									
									if(SurveyEnabled.equals("Yes")){
										utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
									}else{
										utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
									}
								}
								else if(AttributeName.equals("LinkValidDays")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(LinkValidDays);
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								else if(AttributeName.equals("EscalateHR")){
									
									if(EscalateHR.equals("Yes")){
										utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
										System.out.println("Radio Button selected: Yes");
									}else{
										utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
										System.out.println("Radio Button selected: No");
									}
									}
								else if(AttributeName.equals("CountBeforeEscalate")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(CountBeforeEscalate);
								}
								else if(AttributeName.equals("EEDefDocumentVisibility")){
										utilfunc.MakeElement(NewXpath).click();
										Thread.sleep(1000);
										utilfunc.Selectdropdownvaluebytext(NewXpath, EEDefDocumentVisibility);
										Thread.sleep(1000);
										utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
										System.out.println("Value has been selected for (EEDefDocumentVisibility)");
								}
								else if(AttributeName.equals("ERDefDocumentVisibility")){
									utilfunc.MakeElement(NewXpath).click();
									Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebytext(NewXpath, ERDefDocumentVisibility);
									Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
									System.out.println("Value has been selected for (ERDefDocumentVisibility)");
								}
								else if(AttributeName.equals("NPDefDocumentVisibility")){
									utilfunc.MakeElement(NewXpath).click();
									Thread.sleep(1000);
									utilfunc.Selectdropdownvaluebytext(NewXpath, NPDefDocumentVisibility);
									Thread.sleep(1000);
									utilfunc.MakeElement(NewXpath).sendKeys(Keys.ENTER);
									System.out.println("Value has been selected for (NPDefDocumentVisibility)");
								}
								else if(AttributeName.equals("GCPOneResult")){
									
									if(GCPOneResult.equals("Yes")){
										utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
										System.out.println("Radio button (GCP One Result) has been seleced");
										
									}
									else{
										utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
										System.out.println("Radio button (GCP Multiple Results ) has been seleced");
									}
								
									}
								else{
									System.out.println("Please fill all the mandatory fields.");
								}
							}
							
							//String FormFieldXpath		=	"//*[@id='form1']//*[@class='control-group'][xx]//*[@name]";
							//String FormFieldsCounterXpath		=	"//*[@id='form1']//*[@class='control-group']";
							//int resultCount			=	utilfunc.GetObjectCount(FormFieldsCounterXpath);
							
							/*for(int i=1;i<=resultCount;i++){
								String NewXpath	=	FormFieldXpath.replace("xx",Integer.toString(i));
								String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
								if(AttributeName.equals("SurveyEnabled")){
									
									if(SurveyEnabled.equals("Yes")){
										utilfunc.MakeElement(NewXpath+"//.[@value='True']").click();
									}else{
										utilfunc.MakeElement(NewXpath+"//.[@value='False']").click();
									}
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								else if(AttributeName.equals("ReminderDays")){
									utilfunc.MakeElement(NewXpath).sendKeys(ReminderDays);
								}
								
							}*/
							
							
							
							
																
							
							
							
							
							
					}catch(Exception e){
								Flag	=	false;
								System.out.println("Unable to add communication protocal");
							}
					//}

							 try{
								 // save button after saving all data..
								String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
			    	        	utilfunc.MakeElement(saveBtn).click();
								System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
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
								Flag	=	false;
								System.out.println("Data is not saved because all fields are not set in the form.");
							}
	
				}	/**
				 * scroll to top in order to catch the company slider icon
				 */
				utilfunc.scrollToTop();
		
	}
				return Flag;
	}
}

