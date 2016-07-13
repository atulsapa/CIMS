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

import org.junit.experimental.categories.Categories;
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



public class CIMS_Company_Notifications {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";


	public CIMS_Company_Notifications(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Notifications(String filename, String sheetName, int ColumnCounter,String mode) throws AWTException, InterruptedException{

		System.out.println("User is on "+sheetName+" module..");
		boolean Flag	=	false;


		//excel data sheet collection..
				String 	TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String 	TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String 	Scenario									=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String 	TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String 	ReceiveGlobalChekNotification				=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);

				String	xNotificationId								=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String	xAvailableForUserChange						=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String	xDefaultNotification						=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String	xRole										=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);

				String	EditxAvailableForUserChange					=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String	EditxDefaultNotification					=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String	EditxRole									=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);
				
				String 	ExpectedErrorMessage						=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
			
				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;

				if(TestcaseRunMode.equals("Y")){
					
					String RadioTrueSufix								=		"//.[@value='True']";
					String RadioFalseSufix								=		"//.[@value='False']";
					
					String RadioOneSufix								=		"//.[@value='1']";
					String RadioZeroSufix								=		"//.[@value='0']";

					try{
						
						if(ReceiveGlobalChekNotification.equalsIgnoreCase("Yes")){
							Thread.sleep(900);
							utilfunc.MakeElement("//*[@name='ReceiveGlobalChekNotification']"+RadioTrueSufix).click();
						}else if(ReceiveGlobalChekNotification.equalsIgnoreCase("No")){
							Thread.sleep(900);
							utilfunc.MakeElement("//*[@name='ReceiveGlobalChekNotification']"+RadioFalseSufix).click();
						}
					try{utilfunc.MakeElement(".//a[contains(@class,'btn') and text()='Save']").click();}catch(Exception error){System.out.println("Unable to click save button for Receive Global Chek Notification.");}
					}catch(Exception Error){}
					
					try{
						//for refresh the page
						webdriver.navigate().refresh();
						Thread.sleep(2000);
					}catch(Exception Error){}
					
					// this is for splitting more than one roles.. doing this on top as it is used in Edit & delete case too
					String[] xRoles	=null;	
							try{
							xRoles=xRole.trim().split(",");
							}catch(Exception error){}
					
					System.out.println("entering "+mode+" mode for "+sheetName+" module");

						if(mode.equals("New")){
							
							try{
								Thread.sleep(1000);
								String AddNewBtnXpath	=	"//*[contains(@class,'btn') and contains(text(),'Add New')]"; 
								try{
									utilfunc.MakeElement(AddNewBtnXpath).click();
									}
								catch(Exception error){}
								System.out.println("User is now about to add new "+sheetName);
							}catch(Exception e){
								System.out.println("User unable to click on add button of module "+sheetName);
							}
							Thread.sleep(1000);
						}else if(mode.equals("Edit") || mode.equals("Delete")){
//
							System.out.println("User has entered "+mode+" mode");


							boolean	EditClicked					=	false;	
							boolean DeleteClicked				=	false;
							
//							//*[@id='dvReport']//*[@class='table-rec-container']//table//tbody//tr[position() mod 2 = 1 and position() > 1]
							String LocationListCounterXPath		=	"//*[contains(@class,'table-item-list')]//tbody//tr";
							String LocationListXPath				=	"//*[contains(@class,'table-item-list')]//tbody//tr[yy]";

							int 	rCount	=	utilfunc.GetObjectCount(LocationListCounterXPath);
							
							for(int r=1;r<=rCount;r++){

								String NewXPath										=	LocationListXPath.replace("yy", Integer.toString(r));
								String CodeList										=	utilfunc.MakeElement(NewXPath+"//td[1]").getText();
								String AvailableForUserChangeList					=	utilfunc.MakeElement(NewXPath+"//td[2]").getText();
								String NotificationList								=	utilfunc.MakeElement(NewXPath+"//td[3]").getText();
								String RoleList										=	utilfunc.MakeElement(NewXPath+"//td[4]").getText();

								System.out.println("role : "+RoleList);
								RoleList	=	RoleList.replaceAll("\n", ", ");

								if(xNotificationId.equals(CodeList) && xAvailableForUserChange.equals(AvailableForUserChangeList) 
									 	&& xDefaultNotification.equals(NotificationList.trim()) && xRole.equals(RoleList)){

										if(mode.equals("Edit")){

											String EditXPath	=	NewXPath+"//td[5]//*[@class='icon-edit']";
											try{
												utilfunc.MakeElement(EditXPath).click();
												EditClicked		=	true;	
												System.out.println("clicked on edit icon");
											}catch(Exception e){
												System.out.println("unable to find edit icon now click on first edit icon from the list");
												
											}
											break;
										}
										if(mode.equals("Delete")){
											String DeleteXPath	=	NewXPath+"//td[5]//*[@class='icon-trash']";
											try{
												utilfunc.MakeElement(DeleteXPath).click();
												utilfunc.isAlertPresent();
												DeleteClicked	=	true;
												System.out.println("clicked on delete icon");
											}catch(Exception e){
												System.out.println("unable to find delete icon, now click on first record for this");
											}
											break;
										}
								}

							}
							/**
							 * in case no record is matched..
							 */
//								if(EditClicked==false || DeleteClicked==false){
									if(EditClicked==false){
										if(mode.equals("Edit")){
											try{
												utilfunc.MakeElement("//*[@id='divList']//tbody//tr[1]//td[5]//*[@class='icon-edit']").click();
											}catch(Exception f){
												System.out.println("no edit reocrd found");
											}
										}
									}
									if(DeleteClicked==false){
										if(mode.equals("Delete")){
											try{
												utilfunc.MakeElement("//*[@id='divList']//tbody//tr[1]//td[5]//*[@class='icon-trash']").click();
												utilfunc.isAlertPresent();
											}catch(Exception f){
												System.out.println("no delete reocrd found");
											}
										}
									}
//								}
							
						}

						if(mode.equals("New")){

							try{
									Thread.sleep(800);
									String InnerFormFieldCounterXPath					=		".//*[@id='dvPopup']//*[@class='control-group']";
									String InnerFormFieldXPath							=		"//*[@id='dvPopup']//*[@class='control-group'][gg]//*[@class='controls']//*[@name]"; 
									

									int innerCount						=		utilfunc.GetObjectCount(InnerFormFieldCounterXPath);
	
									for(int r=1;r<=innerCount;r++){
										
										Thread.sleep(400);

										String NewFieldXPath		=		InnerFormFieldXPath.replace("gg",Integer.toString(r));
										String AttributeName		=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");

										System.out.println(AttributeName);

										if(AttributeName.equals("xNotificationId")){
											utilfunc.MakeElement(NewFieldXPath).sendKeys(xNotificationId);
										}
										else if(AttributeName.equals("xAvailableForUserChange")){
											if(xAvailableForUserChange.equalsIgnoreCase("Yes")){
												utilfunc.MakeElement(NewFieldXPath+RadioOneSufix).click();
											}
											else if(xAvailableForUserChange.equalsIgnoreCase("No")){
												utilfunc.MakeElement(NewFieldXPath+RadioZeroSufix).click();
											}
										}
										else if(AttributeName.equals("xDefaultNotification")){
											if(xDefaultNotification.equalsIgnoreCase("Yes")){
												utilfunc.MakeElement(NewFieldXPath+RadioOneSufix).click();
											}
											else if(xDefaultNotification.equalsIgnoreCase("No")){
												utilfunc.MakeElement(NewFieldXPath+RadioZeroSufix).click();
											}
										}else if(AttributeName.equals("xRole")){
											
												/**
												 * first of all let us find out how many roles we have to add
												 */
											String[]	Roles		=		xRole.split(",");
											
											if(Roles.length >= 1){
												
												for(int f=1;f<=Roles.length;f++){
													Thread.sleep(200);
													utilfunc.Selectdropdownvaluebytext(NewFieldXPath, Roles[f-1].trim());
													// now click add more
													utilfunc.MakeElement(".//*[@id='btnAddRole']").click();
													
												}
												
											}
										}

									}

								}catch(Exception e){
									Flag	=	false;
									System.out.println("Unable to excute "+sheetName);
								}
						}
						
						/**
						 * edit case
						 */

						if(mode.equals("Edit")){

							try{
								Thread.sleep(800);
								String InnerFormFieldCounterXPath					=		".//*[@id='dvPopup']//*[@class='control-group']";
								String InnerFormFieldXPath							=		"//*[@id='dvPopup']//*[@class='control-group'][gg]//*[@class='controls']//*[@name]";

//								String RadioTrueSufix								=		"//.[@value='True']";
//								String RadioFalseSufix								=		"//.[@value='False']";

								int innerCount						=		utilfunc.GetObjectCount(InnerFormFieldCounterXPath);

								for(int r=1;r<=innerCount;r++){

									Thread.sleep(900);

									String NewFieldXPath		=		InnerFormFieldXPath.replace("gg",Integer.toString(r));
									String AttributeName		=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");

									System.out.println(AttributeName);

									if(AttributeName.equals("xNotificationId")){
										continue;
									}
									else if(AttributeName.equals("xAvailableForUserChange")){
										if(EditxAvailableForUserChange.equalsIgnoreCase("Yes")){
											utilfunc.MakeElement(NewFieldXPath+RadioOneSufix).click();
										}
										else if(EditxAvailableForUserChange.equalsIgnoreCase("No")){
											utilfunc.MakeElement(NewFieldXPath+RadioZeroSufix).click();
										}
									}
									else if(AttributeName.equals("xDefaultNotification")){
										if(EditxDefaultNotification.equalsIgnoreCase("Yes")){
											utilfunc.MakeElement(NewFieldXPath+RadioOneSufix).click();
										}
										else if(EditxDefaultNotification.equalsIgnoreCase("No")){
											utilfunc.MakeElement(NewFieldXPath+RadioZeroSufix).click();
										}
									}else if(AttributeName.equals("xRole")){
										
										/**
										 * first of all delete added roles
										 */
										
										String deleteRoleXPath		=		".//*[@id='group_roles']//*[@class='iRow'][1]//*[@class='icon-trash']";

										int gp	=	utilfunc.GetObjectCount("//*[@id='group_roles']//*[@class='icon-trash']");

										for(int g=1;g<=gp;g++){
											Thread.sleep(800);
//											String NewDeleteRoleXPath	=	deleteRoleXPath.replace("rr", Integer.toString(g));
											utilfunc.MakeElement(deleteRoleXPath).click();
											utilfunc.isAlertPresent();
										}
											/**
											 * first of all let us find out how many roles we have to add
											 */
										
										String[]	Roles		=		EditxRole.split(",");
										
										if(Roles.length >= 1){
											
											for(int f=1;f<=Roles.length;f++){
												Thread.sleep(200);
												utilfunc.Selectdropdownvaluebytext(NewFieldXPath, Roles[f-1].trim());
												// now click add more
												utilfunc.MakeElement(".//*[@id='btnAddRole']").click();
												}
											}
										}
									}

							}catch(Exception e){
								Flag	=	false;
								System.out.println("Unable to excute "+sheetName);
							}
						}

							 try{
								 // save button after saving all data..
								String saveBtn	=	".//*[@id='form_modal']//a[contains(@class,'btn') and text()='Save']";
								try{
									Thread.sleep(1000);
			    	        	utilfunc.MakeElement(saveBtn).click(); }
								catch(Exception e){
								System.out.println("Error to click on Save button");	
								}
								//System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed");
								String error_flag=utilfunc.NotificationErrorMessagehandlerExperiment();
								System.out.println("---X---"+error_flag);
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
//					}
//				}		
							 /**
								 * scroll to top in order to catch the company slider icon
								 */
								utilfunc.scrollToTop();
		return Flag;
	}
}
