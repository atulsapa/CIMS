package CIMS.Modules.Regression;

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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import CIMS.CIMS_MainProject;
import CIMS.Modules.Custom.Company_Role;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.org.apache.bcel.internal.classfile.Attribute;
import com.thoughtworks.selenium.Selenium;
import  org.apache.commons.lang3.StringUtils;

import util.UtilFunction;

public class CIMS_Regression_ProcessAndQuestionnaire_contact {
	
	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	
	private Company_Role obj_Company_Role;

	public String testcaseid			=	null;
	public String scenerio				=	null;
	public String description        	=	null;

	public CIMS_Regression_ProcessAndQuestionnaire_contact(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Contact_Assignment(String filename, String sheetName,int ColumnCounter,String mode,String EmployeeName) throws AWTException, InterruptedException
	{
		setobj_Company_Role(new Company_Role(webdriver,utilfunc));
		System.out.println("User is on "+sheetName+" Module...");
		boolean Flag	=	false;
		String error_flag                ="";
		String error_msg                ="";

		String TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
		String TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
		String Scenario										=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
	    String TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
		String SelectStepsBalContact						=			UtilFunction.getCellData(filename, sheetName, 18, ColumnCounter);
		String SelectStepsCompanyContact				    =			UtilFunction.getCellData(filename, sheetName, 19, ColumnCounter);
		String CompanyRoles							        =			UtilFunction.getCellData(filename, sheetName, 20, ColumnCounter);
		String CompanyContacts		                        =			UtilFunction.getCellData(filename, sheetName, 21, ColumnCounter);
		String ProcessingCategory					        =			UtilFunction.getCellData(filename, sheetName, 22, ColumnCounter);
		
		
		String SelectStepsQuestionnaires						=			UtilFunction.getCellData(filename, sheetName, 23, ColumnCounter);
		String SecondaryAssistant						    =			UtilFunction.getCellData(filename, sheetName, 24, ColumnCounter);
		String ExpectedErrorMessage						    =			UtilFunction.getCellData(filename, sheetName, 25, ColumnCounter);
		String status;
		
		
		
		
		
		if(TestcaseRunMode.equals("Y"))
		{
			testcaseid			=	TestcaseID;
			scenerio			=	Scenario;
			description         =   TestCaseDescription;
			
			long startTime 								= 0;
			int count									= 0;	
			String AttributeName						=	"";
			String timer								=	"";
			
			String RoleTypeXPath					=	"//*[@class='balContacts']//*[@name='uRoleType']";
			String AddNewRoleTypeButtonXpath		=	".//*[@id='btnAddNewContact']";
			
			if(SelectStepsBalContact.equalsIgnoreCase("Yes")){

				////TIMER START///////
				startTime = System.currentTimeMillis();

				// code here for third step assignment of company roles, processing, etc 


				if(CompanyRoles!=null){
					try{
						String [] RoleTypes					=	CompanyRoles.split(",");
						
						if(RoleTypes.length>0){
							
							// select role types and add..
							for(int y=0;y<RoleTypes.length;y++){
								
								Thread.sleep(3000);
								try{
									// select role type 
									utilfunc.Selectdropdownvaluebytext(RoleTypeXPath, RoleTypes[y]);

									try{
										//click on add
										utilfunc.MakeElement(AddNewRoleTypeButtonXpath).click();
										Thread.sleep(3000);
									}catch(Exception e){
										System.out.println("unable to click on add button..");
									}
								}catch(Exception e){
									System.out.println("unable to add role type for BAL contacts");
								}
							}
						}
						
					}catch(Exception e){
						
					}

				}
			}



					// now call assign role name module..
					try{


						Thread.sleep(6000);
						
						boolean FlagStep2	=	obj_Company_Role.CompanyRole(filename,sheetName,"balContacts","BAL Contacts",TestcaseID,true);

						Thread.sleep(4000);

						timer = utilfunc.getTimeTakenByModule(startTime);

							 // generate report for step one..
							 utilfunc.updateModuleDataForReportGeneration("BAL Conatact ", EmployeeName, timer);

							 if (FlagStep2)
								{
									status="PASS";
									if(utilfunc.globalerrormessage.equals(""))
									{
										utilfunc.TestngReportPass(testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status);
									}
									else
									{
										utilfunc.TestngReportNegativePassTestcase(testcaseid, utilfunc.Actualbrw,scenerio,mode,description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									}
								}
								else
								{
									status="FAIL";
									utilfunc.TestngReportFail1(testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
								}
							 
							 
							 


//							 if(FlagStep2){
								 // now code for forth form..
									// if Company contacts is set to yes

									if(SelectStepsCompanyContact.equalsIgnoreCase("Yes")){
					
									// code here for forth step assignment of company contacts, 

										// code here for third step assignment of company roles, processing, etc 
										
										RoleTypeXPath					=	"//*[@class='networkContacts']//*[@name='uRoleType']";
										AddNewRoleTypeButtonXpath		=	".//*[@id='btnAddNewNetworkContact']";		

										if(CompanyContacts!=null){
											try{
												String [] Contacts					=	CompanyContacts.split(",");

												if(Contacts.length>0){
													
													// select role types and add..
													for(int y=0;y<Contacts.length;y++){

														Thread.sleep(3000);
														try{
															// select role type 
															utilfunc.Selectdropdownvaluebytext(RoleTypeXPath, Contacts[y]);

															try{
																//click on add
																utilfunc.MakeElement(AddNewRoleTypeButtonXpath).click();
																Thread.sleep(3000);
															}catch(Exception e){
																System.out.println("unable to click on add button..");
															}
														}catch(Exception e){
															System.out.println("unable to add role type for BAL contacts");
														}
													}
												}
												
											}catch(Exception e){
												
											}
											
										}
										
										// now call assign role name module..
										try{


											Thread.sleep(6000);
											////TIMER START///////
											startTime = System.currentTimeMillis();
											Flag	=	obj_Company_Role.CompanyRole(filename,sheetName,"networkContacts","Network Partner Contacts",TestcaseID,true);
											timer = utilfunc.getTimeTakenByModule(startTime);
											// now error handler code for step one..
											try{
												timer = utilfunc.getTimeTakenByModule(startTime);
												// handling error for ng-scope errors
												 
												 // generate report for step one..

												 utilfunc.updateModuleDataForReportGeneration(" Process and Questionnaire - Network Partner Contacts", EmployeeName, timer);

												 if (Flag)
													{
														status="PASS";
														if(utilfunc.globalerrormessage.equals(""))
														{
															utilfunc.TestngReportPass(testcaseid, utilfunc.Actualbrw, scenerio, mode, description, status);
														}
														else
														{
															utilfunc.TestngReportNegativePassTestcase(testcaseid, utilfunc.Actualbrw,scenerio,mode,description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
														}
													}
													else
													{
														status="FAIL";
														utilfunc.TestngReportFail1(testcaseid, utilfunc.Actualbrw, scenerio,mode, description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
													}
												 
												 
												 
											}catch(Exception e){
												System.out.println("some error occured while submitting third form");
											}
											
										}catch(Exception e){
											System.out.println("unable to call company contacts.");
										}

									
									// click on complete or next button..
										//CompletBtnXPath="";
								//	CompletBtnXPath		=	".//*[contains(@id,'ButtonDisplayId')]";//*[contains(@class,'btn') and contains(text(),'Complete')]";
									try{
										Thread.sleep(2500);
										//utilfunc.MakeElement(CompletBtnXPath).click();

									}catch(Exception e){
										System.out.println("unable to click on complete button");
									}
									
									
									}
//							 }
							 
						}catch(Exception e){
							System.out.println("some error occured while submitting third form");
						}
						

						
//					}catch(Exception e){
//						System.out.println("unable to call company role.");
//					}
				
				
				

	
			}
		return Flag;    
}
	public void setobj_Company_Role(Company_Role setobj_Company_Role) {
		this.obj_Company_Role = setobj_Company_Role;
	}
}
