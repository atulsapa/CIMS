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

import javax.swing.text.StyledEditorKit.BoldAction;

import listner.ErrorUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;

import util.UtilFunction;



public class CIMS_Company_Subscribed_Services {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";

	public CIMS_Company_Subscribed_Services(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Add_Subscribed_Services(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{

		System.out.println("User is on Subscribed services module");
		boolean Flag	=	false;

		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CaseManagement								=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String Cobalt										=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String DocumentGeneration							=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String Resources									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String FrequentlyAskQuestions						=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String GlobalCheck									=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String VisaForTravelerInitiation					=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String Initiation									=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String InitiationServiceModule						=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String ShowNews										=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String ShowPolicies									=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				String ProjectDetail								=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
				String ProjectSummary								=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
				String ProjectSummaryFeatures						=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
				String Roster										=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
				String SecureMessage								=			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
				String TopRecentPopup								=			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
				String TwoFactorsAuthentication						=			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
				
				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;
				
				if(TestcaseRunMode.equals("Y")){
					System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
					Thread.sleep(1000);
					// pull data from 
					String SubscribedService_attributeFiledXpath=".//*[@id='company-subscribed-service']/tbody/tr[xx]//*[@name]";
					String SubscribedServiceCounterXpath=".//*[@id='company-subscribed-service']/tbody/tr";

					int ObjCount=utilfunc.GetObjectCount(SubscribedServiceCounterXpath);

					if(mode.equalsIgnoreCase("Delete")){
						System.out.println("User is deleting "+sheetName+" module");
						utilfunc.ErrorMessage1="Can not perform "+mode+" operation on "+sheetName+"  module.";
						Flag= true;
						utilfunc.globalerrormessage="User is not having permission for perform this operation for this module.";
						return Flag;				
						}
					if(mode.equalsIgnoreCase("Edit")){

//						System.out.println("Let us clear all subscribed service form data before updating the new one");
//						for(int count=1; count<=ObjCount; count++)
//						 {
//							try{
//								Thread.sleep(800);
//								String NewXpath=SubscribedService_attributeFiledXpath.replace("xx", Integer.toString(count));
//								System.out.println("data cleared for "+count+" element");
//								
//							}catch(Exception d){
//								System.out.println("Some error oddured while clearing field data");
//							}
//						 }
					}	
					// now adding the data

						 for(int count=1; count<=ObjCount; count++)
						 {
							try{

								Thread.sleep(800);
								String NewXpath					=	SubscribedService_attributeFiledXpath.replace("xx", Integer.toString(count));
								String AttributeName			=	utilfunc.MakeElement(NewXpath).getAttribute("name");

								System.out.println("Attribute: " + AttributeName.toString());

								if(AttributeName.equals("CaseManagement")){
									if(CaseManagement.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath,true);
									}
									else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("Cims")){
									if(Cobalt.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath,true);
									}
									else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}

								else if(AttributeName.equals("DocGen")){
									if(DocumentGeneration.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath,true);
									}
									else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("FAQ")){
									if(Resources.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath,true);

									}
									else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
									try{
										Thread.sleep(500);
										utilfunc.getCheckboxFromInnerHtmlAndEnable(FrequentlyAskQuestions, "//*[@id='company-subscribed-service']/tbody/tr["+count+"]/td[2]", "//input[contains(@id,'FAQ.') and contains(@name,'FAQ.')]");
									}catch(Exception e){
										System.out.println("unable to work on "+ AttributeName +" inner HTML ");
									}
								}
								else if(AttributeName.equalsIgnoreCase("GlobalCheck")){
									// some issue with code it is redirecting to 
									if(GlobalCheck.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
									try{
										Thread.sleep(500);
										utilfunc.getCheckboxFromInnerHtmlAndEnable(VisaForTravelerInitiation, "//*[@id='company-subscribed-service']/tbody/tr["+count+"]/td[2]", "//input[contains(@id,'GlobalCheck.') and contains(@name,'GlobalCheck.')]");
									}catch(Exception e){
										System.out.println("unable to work on "+ AttributeName +" inner HTML ");
									}
									// scroll to bottom so that 
									utilfunc.scrollToBottom();
								}
								else if(AttributeName.equals("Initiation")){
									if(Initiation.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
									try{
										Thread.sleep(500);
										utilfunc.getCheckboxFromInnerHtmlAndEnable(InitiationServiceModule, "//*[@id='company-subscribed-service']/tbody/tr["+count+"]/td[2]", "//input[contains(@id,'Initiation.') and contains(@name,'Initiation.')]");
									}catch(Exception e){
										System.out.println("unable to work on "+ AttributeName +" inner HTML ");
									}
								}
								else if(AttributeName.equals("News")){
									if(ShowNews.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("Policies")){
									if(ShowPolicies.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("ProjectDetail")){
									if(ProjectDetail.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("ProjectSummary")){
									if(ProjectSummary.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("ProjectSummary")){

									if(ProjectSummaryFeatures.equalsIgnoreCase("Status and Documents")){
										utilfunc.MakeElement("//input[@id='ProjectSummary.StatusDoc']").click();
									}
									else if(ProjectSummaryFeatures.equalsIgnoreCase("VisaBase Projects")){
										utilfunc.MakeElement("//input[@id='ProjectSummary.VisaBaseProject']").click();
									}
								}
								else if(AttributeName.equals("Roster")){
									if(Roster.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("SecureMessage")){
									if(SecureMessage.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("TopRecentPopup")){
									if(TopRecentPopup.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
								else if(AttributeName.equals("TwoFactorAuth")){
									if(TwoFactorsAuthentication.equals("Yes")){
										utilfunc.enableOrDisableCheckbox(NewXpath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(NewXpath, false);
									}
								}
							}catch(Exception e){
								Flag	=	false;
								
							}
						 }
//					}
//					else if(mode.equals("Edit")){
//						
//					}

					 try{
						 // save button after saving all data..
						String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
	    	        	utilfunc.MakeElement(saveBtn).click();

	    	        	String error_flag=utilfunc.ErrorMessagehandlerExperiment();
						 if (error_flag.equals(ExpectedErrorMessage)){
							 Flag=true;
							 utilfunc.TakeScreenshot();
						 }else if (error_flag.equals("")){
							 Flag=true;
						 }else if (error_flag.contains("Success!")){
							 Flag=true;
						 }else if(error_flag.equals("Server Error in '/' Application.")){
							 Flag=false;utilfunc.TakeScreenshot();
							 webdriver.navigate().back();
						 }else{
							 Flag=false;
							 utilfunc.TakeScreenshot();
						 }
						 System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
					}catch(Exception e){
						Flag	=	false;utilfunc.TakeScreenshot();
						System.out.println("Data is not saved because all fields are not set in the form.");
						System.out.println("Unable to insert data into Company's General Info form");
					}
				}
				
				
				/**
				 * scroll to top in order to catch the company slider icon
				 */
				utilfunc.scrollToTop();

		return Flag;
	}
	
	
}
