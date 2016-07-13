package CIMS.Modules.Company;
//**//
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;

import util.UtilFunction;


public class CIMS_Company_General_Info {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	public static String testcaseid="";
	public static String scenerio="";
	public static String description="";
	
	public CIMS_Company_General_Info(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Add_General_Info(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		System.out.println("adding data to general info form");
		boolean Flag	=	false;
		
		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String CompanyCode									=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String CompanyNumber								=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String LogoImage									=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String EmailDomain									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String WebsiteUrl									=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String CSSpath										=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String StockTicker									=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String SharepointLink								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String TypeofBusiness								=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String JobLookupFunction							=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String LoginMethod									=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				String HomePageDashboard							=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
				String CompanyLogoText								=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
				
				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;

				if(TestcaseRunMode.equals("Y")){
					System.out.println("\n=== === ===\t"+sheetName+"\n=== === ===");
					
					if(mode.equals("Delete")){

						System.out.println("User is deleting "+sheetName+" module");
						utilfunc.ErrorMessage1="User is not having permission for perform "+mode+" operation for "+sheetName+" module.";
						Flag= true;
						utilfunc.globalerrormessage="User is not having permission for perform this operation for this module.";
						return Flag;
					
					}
					
					// pull data from 
					String GeneralInfo_attributeFiledXpath="//*[@class='form-horizontal']//*[@class='control-group'][xx]//*[@name]";
					String GeneralInfoCounterXpath="//*[@class='form-horizontal']//*[@class='control-group']//*[@class='controls']";
					
					int ObjCount=utilfunc.GetObjectCount(GeneralInfoCounterXpath);

					// adding data for extra three form fields which are not covered using xpath..
					String	CompanyCodeXpath		=		"//input[@name='CompanyCode']";
					String	CompanyNumberXpath		=		"//input[@name='CompanyNumber']";
					String	LogoDataXpath			=		"//input[@name='LogoData']";
					
					String	AddMoreDomainLinkXpath		=		"//a[text()='Add More' and @class='lbl-add' and contains(@href,'AddNewEmailDomain')]";

					//if(mode.equals("Edit")){
					
						System.out.println("Let us clear all form data before updating the new one");
						
						String	EmailDomainXpath		=		"//input[contains(@id,'DomainName_')]"; // get list of added domain
						String	DeleteMoreDomainLinkXpath		=		"//a[contains(@href,'DeleteEmailDomain')]";
						//let us clear all domain added and delete extra
						int domainCount	=	utilfunc.GetObjectCount(EmailDomainXpath);
						
						utilfunc.MakeElement("//input[contains(@id,'DomainName_0')]").clear();
						if(domainCount>1)
						{
						for(int dc=0; dc<domainCount;dc++){
							Thread.sleep(450);
							utilfunc.MakeElement("//input[contains(@id,'DomainName_1')]").clear();
							if(dc>0){
								try{
								//delete additional email domain textboxes too..
								utilfunc.MakeElement(DeleteMoreDomainLinkXpath).click();
								// alert window is prompt need to code for press okay and then proceed ..
								Thread.sleep(450);
								utilfunc.isAlertPresent();
								}catch(Exception error){}
							}
						}
						}
						utilfunc.MakeElement("//input[contains(@id,'DomainName_0')]").clear();
						
						utilfunc.MakeElement(CompanyCodeXpath).clear();
						utilfunc.MakeElement(CompanyNumberXpath).clear();
//						utilfunc.MakeElement(Company).clear(); // logo
//						for(int count=1; count<=ObjCount; count++)
//						 {
//							try{
//								String NewXpath=GeneralInfo_attributeFiledXpath.replace("xx", Integer.toString(count));
//								utilfunc.MakeElement(NewXpath).clear();
//							}catch(Exception d){
//								System.out.println("Some error oddured while clearing field data");
//							}
//						 }
				//	}
						utilfunc.MakeElement(CompanyCodeXpath).sendKeys(CompanyCode);
						utilfunc.MakeElement(CompanyNumberXpath).sendKeys(CompanyNumber);
						utilfunc.MakeElement(LogoDataXpath).click();
						utilfunc.uploadfile(LogoImage); //MakeElement(LogoDataXpath).sendKeys(LogoImage);
				try{
					Alert alert = webdriver.switchTo().alert();
					   // if present dismiss the alert,
					alert.accept();
					   alert.dismiss();
				}catch(Exception e){
					System.out.println("no alert found!");
				}
	
						 for(int count=1; count<=ObjCount; count++)
						 {
							try{
								String NewXpath			=	GeneralInfo_attributeFiledXpath.replace("xx", Integer.toString(count));
								String AttributeName	=	utilfunc.MakeElement(NewXpath).getAttribute("name");
	
								if(AttributeName.equals("tbEmailDomain")){
	
									// get list of email domains
									String[] EmailDomains	=	EmailDomain.split(",");
									System.out.println("number of email domains: "+EmailDomains.length);
	
									if(EmailDomains.length>1){
										int c=0;
										for(String ed : EmailDomains){
											System.out.println(ed);
		//									utilfunc.MakeElement(NewXpath).sendKeys(ed);
											if(c!=0){
												//input[@name='LogoData']
												System.out.println("make sure add more is click to add new domain");
												utilfunc.MakeElement(AddMoreDomainLinkXpath).click();
											}
											System.out.println("and now set the value of domain in the textbox opened");
											utilfunc.MakeElement("//input[contains(@id,'DomainName_"+c+"')]").clear();
											utilfunc.MakeElement("//input[contains(@id,'DomainName_"+c+"')]").sendKeys(ed);
											c++;
										}
									}else{
										System.out.println("add value of email domain in the field");
										utilfunc.MakeElement("//input[contains(@id,'DomainName_0')]").sendKeys(EmailDomains);
									}
	//								utilfunc.MakeElement(NewXpath).sendKeys(AttributeName);
								}
								else if(AttributeName.equals("WebsiteUrl")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(WebsiteUrl);
								}
								else if(AttributeName.equals("CustomCSS")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(CSSpath);
									utilfunc.scrollToBottom();
								}
								else if(AttributeName.equals("StockTicker")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(StockTicker);
								}
								else if(AttributeName.equals("TypeOfBusiness")){
									utilfunc.Selectdropdownvaluebytext(NewXpath, "Select");
									utilfunc.Selectdropdownvaluebytext(NewXpath, TypeofBusiness);
								}
								else if(AttributeName.equals("JobLookupFunction")){
									utilfunc.Selectdropdownvaluebytext(NewXpath, "Select");
									utilfunc.Selectdropdownvaluebytext(NewXpath, JobLookupFunction);
								}
								else if(AttributeName.equals("LoginMethod")){
									utilfunc.Selectdropdownvaluebytext(NewXpath, "Select");
									utilfunc.Selectdropdownvaluebytext(NewXpath, LoginMethod);
								}
								else if(AttributeName.equals("HomePageDashboard")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(HomePageDashboard);
								}
								else if(AttributeName.equals("CompanyLogoText")){
									utilfunc.MakeElement(NewXpath).clear();
									utilfunc.MakeElement(NewXpath).sendKeys(CompanyLogoText);
								}
	//							 System.out.println(AttributeName);
	//							 utilfunc.MakeElement(NewXpath).sendKeys(AttributeName);
	
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Unable to insert data into Company's General Info form");
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
	    	        	System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
						String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//						ExpectedErrorMessage=ExpectedErrorMessage.trim();
						System.out.println("---"+ExpectedErrorMessage+"---");
						System.out.println("---"+error_flag+"---");
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
				}
				
				/**
				 * scroll to top in order to catch the company slider icon
				 */
				utilfunc.scrollToTop();
		return Flag;
	}
}
