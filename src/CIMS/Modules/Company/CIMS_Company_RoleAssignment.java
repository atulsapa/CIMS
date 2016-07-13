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



public class CIMS_Company_RoleAssignment {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	
	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";
	
	public CIMS_Company_RoleAssignment(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean RoleAssignment(String filename, String sheetName,int ColumnCounter,String mode) throws AWTException, InterruptedException{
		
		System.out.println("User is on Role Assignment module");
		boolean Flag	=	false;
		
//		/RoleAssignment/Detail
		
		//RoleId
		
		
		//*[@id='btnSearchName'] search name utton to search contact name
		//*[@id='btnSearch']
		
		//sCompanyRoleType
		//sCompany
		//FirstName
		//LastName
		//Email
		//id-Username
		
		// result div 
		//*[@id='table_getname']//*
		
		//*[@id='table_getname']/tbody/tr[1]/td[5]/a
		
		//assignlevel
		//id-isPrimary
		
		//excel data sheet collection..
				String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String CompanyName									=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);
				String Role											=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String sCompanyRoleType								=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String sCompany										=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String FirstName									=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);
				String LastName										=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String Email										=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String Username										=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				String assignlevel									=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String isPrimary									=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String BusinessUnit									=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String Entity										=			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);
				String Country										=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);
				String CountryGroup									=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);
				String ContactPerson								=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
				String ExpectedErrorMessage							=			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);

				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;

				if(TestcaseRunMode.equals("Y")){

//					if(mode.equals("Delete")){
//						
//						System.out.println("User is deleting role assignment module");
//						
//
//					}else{

						if(mode.equals("New")){
							Thread.sleep(1000);

							System.out.println("entering add mode for role assignment module");

							String AddNewBtnXpath	=	"//a[contains(@class,'btn') and contains(text(),'Add New')]";
							try {
								Thread.sleep(1500);
								utilfunc.waitForAnElementToLoad(AddNewBtnXpath, true);
								utilfunc.MakeElement(AddNewBtnXpath).click();
							} catch (Exception e) {
								
							}
							
							System.out.println("User is now about to add new roles");
							Thread.sleep(3000);

						}else if(mode.equals("Edit") || mode.equals("Delete")){
							Thread.sleep(1000);

							System.out.println("User has entered "+mode+" mode");
							String RoleListCounterXPath		=	".//*[@id='tablelist']/tbody/tr";
							String RoleListXPath			=	".//*[@id='tablelist']/tbody/tr[rr]";
//							String RoleListRoleXPath	=	".//*[@id='tablelist']/tbody/tr[rr]/td[2]";
//							String RoleListContactNameXPath	=	".//*[@id='tablelist']/tbody/tr[rr]/td[3]";
							
							int rCount	=	utilfunc.GetObjectCount(RoleListCounterXPath);
							for(int a=1;a<=rCount;a++){
								
								Thread.sleep(2000);

								String NewXPath						=	RoleListXPath.replace("rr", Integer.toString(a));
								String RoleListRole					=	utilfunc.MakeElement(NewXPath+"/td[2]").getText();
								String RoleListContactName			=	utilfunc.MakeElement(NewXPath+"/td[3]").getText();
								String RoleListBussinessUnit		=	utilfunc.MakeElement(NewXPath+"/td[4]").getText();
								String RoleListEntity				=	utilfunc.MakeElement(NewXPath+"/td[5]").getText();
								String RoleListCountry				=	utilfunc.MakeElement(NewXPath+"/td[6]").getText();
								String RoleListCountryGroup			=	utilfunc.MakeElement(NewXPath+"/td[7]").getText();
								String ContactName					=	LastName+", "+FirstName;

								if(Role.equalsIgnoreCase(RoleListRole) &&  RoleListContactName.equalsIgnoreCase(ContactName)
										&& RoleListBussinessUnit.equalsIgnoreCase(BusinessUnit) && RoleListEntity.equalsIgnoreCase(Entity)
										&& RoleListCountry.equalsIgnoreCase(Country) && RoleListCountryGroup.equalsIgnoreCase(CountryGroup)
										){

									if(mode.equals("Edit")){
										Thread.sleep(1500);

										System.out.println("Record found in the list, now let us open the same for edit");
										String RoleListEditXPath	=	NewXPath+"/td[8]/a";
										try{
											Thread.sleep(1500);
											utilfunc.MakeElement(RoleListEditXPath).click();
											break;
										}catch(Exception e){
											System.out.println("editing record as per");
										}
									}else if(mode.equals("Delete")){
										Thread.sleep(1500);
										
										System.out.println("Record found in the list, now let us delete the record");
										String RoleListDeleteXPath	=	NewXPath+"/td[9]/a";
										
										try{
											utilfunc.MakeElement(RoleListDeleteXPath).click();
											utilfunc.isAlertPresent();
											System.out.println("record deleted succesfully!");
											Flag=true;
											return Flag;
										}catch(Exception s){
											Flag	=	false;
											System.out.println("unable to delete record successfully!");
										}
										return Flag;
										
									}
								}
							}
						}
						
						try{
								String RoleXPath										=	"//*[@name='RoleId']";
								String SearchContactButton								=	".//*[@id='btnSearchName' and contains(text(),'Search Contact')]";
								String sCompanyRoleTypeXPath								=	".//*[@name='sCompanyRoleType']";
								String sCompanyXPath								=	".//*[@name='sCompany']";
								String FirstNameXPath								=	".//*[@name='FirstName']";
								String LastNameXPath								=	".//*[@name='LastName']";
								String EmailXPath								=	".//*[@name='Email']";
								String UsernameXPath								=	"//*[@id='Username']";
								
								String SearchBtnXPath								=	"//a[contains(@class,'btn') and text()='Search']";
								String SearchResultXPath							=	".//*[@id='table_getname']/tbody/tr";

								String assignlevelXPath									=	"//*[@name='assignlevel']";
								String isPrimaryXPath									=	"//*[@id='isPrimary']";
								String XPathPrefix										=	"//*[@name='";
								String XPathSufixTrue									=	"' and @value='True']";
								String XPathSufixFalse									=	"' and @value='False']";
								String XPathSufix										=	"']";

									
									utilfunc.Selectdropdownvaluebytext(RoleXPath, Role);
									System.out.println("now let us search for contact name from database");
									try{
										Thread.sleep(1500);
									utilfunc.MakeElement(SearchContactButton).click();
									System.out.println("let us wait for popup to open first");}catch(Exception error){}
									Thread.sleep(2500);
									try{
										if(sCompanyRoleType!=null){
											utilfunc.Selectdropdownvaluebytext(sCompanyRoleTypeXPath, sCompanyRoleType);
										}
										if(sCompany!=null){
											utilfunc.Selectdropdownvaluebytext(sCompanyXPath, sCompany);
										}
										utilfunc.MakeElement(FirstNameXPath).clear();
										utilfunc.MakeElement(FirstNameXPath).sendKeys(FirstName);
										utilfunc.MakeElement(LastNameXPath).clear();
										utilfunc.MakeElement(LastNameXPath).sendKeys(LastName);
										utilfunc.MakeElement(EmailXPath).clear();
										utilfunc.MakeElement(EmailXPath).sendKeys(Email);
										utilfunc.MakeElement(UsernameXPath).clear();
										utilfunc.MakeElement(UsernameXPath).sendKeys(Username);
										try{
										utilfunc.MakeElement(SearchBtnXPath).click();}catch(Exception e){}
										System.out.println("Let us wait for user list to populate");
										Thread.sleep(3500);
										try{
											int resultCount			=	utilfunc.GetObjectCount(SearchResultXPath);
											for(int r=1;r<=resultCount;r++){
												Thread.sleep(1500);
												
												String ResultFirstNameXPath	=	SearchResultXPath+"["+r+"]/td[1]";
												String ResultEmailXPath	=	SearchResultXPath+"["+r+"]/td[1]";
												String ResultFirstName	=	utilfunc.MakeElement(ResultFirstNameXPath).getText();
												String ResultEmail	=	utilfunc.MakeElement(ResultEmailXPath).getText();
												if(ResultFirstName.equals(FirstName) || ResultEmail.equals(Email)){
													System.out.println("record found!");
													try {
														String AssignBtnXPath	=	"//*[@id='table_getname']/tbody/tr["+r+"]/td[5]/a";
														utilfunc.MakeElement(AssignBtnXPath).click();
														break;
													} catch (Exception e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}else{
													//click on first record if no record match...
													try {
														String AssignBtnXPath	=	"//*[@id='table_getname']/tbody/tr["+r+"]/td[5]/a";
														utilfunc.MakeElement(AssignBtnXPath).click();
														break;
													} catch (Exception e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												}
											}
										}catch(Exception e){
											System.out.println("Unable to find and assign user");
										}
									}catch(Exception e){
										System.out.println("unable to search user");
									}
									try{
									if(isPrimary.equals("Yes")){
										Thread.sleep(2000);
										utilfunc.enableOrDisableCheckbox(isPrimaryXPath, true);
									}else{
										utilfunc.enableOrDisableCheckbox(isPrimaryXPath, false);
									}}catch(Exception Error){}
									
									Flag	=	true;
							}catch(Exception e){
								Flag	=	false;
								System.out.println("Unable to add communication protocal");
							}
					 
						if(Flag=true){
							try{
								Thread.sleep(2000);
								 // save button after saving all data..
								String saveBtn	=	".//a[contains(@class,'btn') and text()='Save']";
					        	utilfunc.MakeElement(saveBtn).click();
							}
							catch(Exception e){}
							try{
								System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario succeed ");
								String error_flag=utilfunc.ErrorMessagehandlerExperiment();
//								ExpectedErrorMessage=ExpectedErrorMessage.trim();
//								System.out.println("==="+ExpectedErrorMessage+"===");
//								System.out.println("==="+error_flag+"===");
								
								 if (error_flag.equals(ExpectedErrorMessage)){
									 Flag=true;
									 utilfunc.ErrorMessage1=ExpectedErrorMessage;
									 utilfunc.globalerrormessage=ExpectedErrorMessage;									 
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
					}
//				}	
				/**
				 * scroll to top in order to catch the company slider icon
				 */
				utilfunc.scrollToTop();
		return Flag;
	}
}
