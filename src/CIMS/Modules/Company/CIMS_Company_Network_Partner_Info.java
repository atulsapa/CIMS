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



public class CIMS_Company_Network_Partner_Info {

	private WebDriver webdriver;	// Will be Provide by Calling Class.	
	private UtilFunction utilfunc;	// Will be Provide by Calling Class.	

	 public static String testcaseid="";
	 public static String scenerio="";
	 public static String description="";


	public CIMS_Company_Network_Partner_Info(WebDriver driver,UtilFunction utilfunc) 
	{
		this.webdriver =driver;
		this.utilfunc=utilfunc;
	}

	public boolean Info(String filename, String sheetName, int ColumnCounter,String mode) throws AWTException, InterruptedException{

		System.out.println("User is on "+sheetName+" module..");
		boolean Flag	=	false;


		//excel data sheet collection..
				String 	TestcaseID									=			UtilFunction.getCellData(filename, sheetName, 0, ColumnCounter);
				String 	TestcaseRunMode								=			UtilFunction.getCellData(filename, sheetName, 1, ColumnCounter);
				String 	Scenario									=			UtilFunction.getCellData(filename, sheetName, 2, ColumnCounter);
				String 	TestCaseDescription							=			UtilFunction.getCellData(filename, sheetName, 3, ColumnCounter);
				String 	PartnerShipStatus							=			UtilFunction.getCellData(filename, sheetName, 4, ColumnCounter);

				String	NetworkPartnerType							=			UtilFunction.getCellData(filename, sheetName, 5, ColumnCounter);
				String	ServiceType									=			UtilFunction.getCellData(filename, sheetName, 6, ColumnCounter);
				String	ExpertiseType								=			UtilFunction.getCellData(filename, sheetName, 7, ColumnCounter);
				String	AssociationAndMembershipType				=			UtilFunction.getCellData(filename, sheetName, 8, ColumnCounter);

				String	CompanyNetworkPartnerRegionTypeList			=			UtilFunction.getCellData(filename, sheetName, 9, ColumnCounter);
				String	Country										=			UtilFunction.getCellData(filename, sheetName, 10, ColumnCounter);
				String	rbnUseOfThirdParty							=			UtilFunction.getCellData(filename, sheetName, 11, ColumnCounter);

				String	ThirdPartyInfo								=			UtilFunction.getCellData(filename, sheetName, 12, ColumnCounter);
				String	ThirdPartyCountriesServed					=			UtilFunction.getCellData(filename, sheetName, 13, ColumnCounter);
				String	ThirdPartyCitiesServed						=			UtilFunction.getCellData(filename, sheetName, 14, ColumnCounter);
				String	BankRoutingInfo						        =			UtilFunction.getCellData(filename, sheetName, 15, ColumnCounter);

				String	searchCompanyName							=			UtilFunction.getCellData(filename, sheetName, 16, ColumnCounter);

				String 	ExpectedErrorMessage						=			UtilFunction.getCellData(filename, sheetName, 17, ColumnCounter);

				testcaseid=TestcaseID;
				scenerio=Scenario;
				description=TestCaseDescription;

				if(TestcaseRunMode.equals("Y")){
					
					if(mode.equals("Delete")){
						System.out.println("User is deleting "+sheetName+" module");
						utilfunc.ErrorMessage1="Can not perform "+mode+" operation on "+sheetName+"  module.";
						Flag= true;
						utilfunc.globalerrormessage="User is not having permission for perform this operation for this module.";
						return Flag;
					}
					
					String RadioTrueSufix								=		"//.[@value='Yes']";
					String RadioFalseSufix								=		"//.[@value='No']";
					
					
					System.out.println("entering "+mode+" mode for "+sheetName+" module");


						if(mode.equals("New") || mode.equals("Edit")){

							try{
									Thread.sleep(1500);
									String InnerFormFieldCounterXPath					=		".//*[@id='panel-body-container']//*[contains(@class,'control-group')]";
									String InnerFormFieldXPath							=		"//*[@id='panel-body-container']//*[contains(@class,'control-group')][yy]//*[@name]"; 
									

									int innerCount						=		utilfunc.GetObjectCount(InnerFormFieldCounterXPath);
	
									for(int r=1;r<=innerCount;r++){
										
										Thread.sleep(1500);

										String NewFieldXPath		=		InnerFormFieldXPath.replace("yy",Integer.toString(r));
										String AttributeName		=		utilfunc.MakeElement(NewFieldXPath).getAttribute("name");

										System.out.println(AttributeName);

										if(AttributeName.equals("PartnerShipStatus")){
											
											
											try {
												Thread.sleep(1500);
												utilfunc.DeSelectdropdownvalue(NewFieldXPath);
												utilfunc.Selectdropdownvaluebytext(NewFieldXPath, PartnerShipStatus);
											} catch (Exception e) {
												System.out.println("Unable to selete the value");
												// TODO Auto-generated catch block
//												e.printStackTrace();
											}
										}
										else if(AttributeName.equals("NetworkPartnerType")){
											try {
												Thread.sleep(1000);
												utilfunc.getCheckboxForNetworkPartnerInfoEnable(NetworkPartnerType, NewFieldXPath.replace("[@name]", "[contains(@class,'controls')]"), "//*[@name='NetworkPartnerType' and @type='checkbox']");
											} catch (Exception e) {
												System.out.println("Unable to get the value");
												// TODO Auto-generated catch block
												//e.printStackTrace();
											}
										}
										
										else if(AttributeName.equals("ServiceType")){
											try {
												Thread.sleep(1000);
												utilfunc.getCheckboxForNetworkPartnerInfoEnable(ServiceType, NewFieldXPath.replace("[@name]", "[contains(@class,'controls')]"), "//*[@name='ServiceType' and @type='checkbox']");
											} catch (Exception e) {
												System.out.println("Unable to get the value");
												// TODO Auto-generated catch block
												//e.printStackTrace();
											}
										}
										else if(AttributeName.equals("ExpertiseType")){
											try {
												Thread.sleep(1000);
												utilfunc.getCheckboxForNetworkPartnerInfoEnable(ExpertiseType, NewFieldXPath.replace("[@name]", "[contains(@class,'controls')]"), "//*[@name='ExpertiseType' and @type='checkbox']");
											} catch (Exception e) {
												System.out.println("Unable to get the value");
												// TODO Auto-generated catch block
												//e.printStackTrace();
											}
										}
										else if(AttributeName.equals("AssociationAndMembershipType")){
											try {
												Thread.sleep(1000);
												utilfunc.getCheckboxForNetworkPartnerInfoEnable(AssociationAndMembershipType, NewFieldXPath.replace("[@name]", "[contains(@class,'controls')]"), "//*[@name='AssociationAndMembershipType' and @type='checkbox']");
											} catch (Exception e) {
												System.out.println("Unable to get the value");
												// TODO Auto-generated catch block
												//e.printStackTrace();
											}
										}
										else if(AttributeName.equals("CompanyNetworkPartnerRegionTypeList")){
											try {
												Thread.sleep(1000);
												utilfunc.getCheckboxFromInnerHtmlAndEnable(CompanyNetworkPartnerRegionTypeList, NewFieldXPath.replace("[@name]", "[contains(@class,'controls')]"), "//*[@name='CompanyNetworkPartnerRegionTypeList' and @type='checkbox']");
											} catch (Exception e) {
												System.out.println("Unable to get the value");
												// TODO Auto-generated catch block
												//e.printStackTrace();
											}
										}
										else if(AttributeName.equals("Country")){
											try {
												Thread.sleep(1000);
												utilfunc.Selectdropdownvaluebytext(NewFieldXPath, Country);
											} catch (Exception e) {
												System.out.println("Unable to select the value");
												// TODO Auto-generated catch block
												//e.printStackTrace();
											}
											try {
												String AddBtnCountry="//*[@class='input-append']//*[contains(@class,'btn') and contains(text(),'Add')]";
												utilfunc.MakeElement(AddBtnCountry).click();
											} catch (Exception e) {
												System.out.println("Country has been added");
												// TODO Auto-generated catch block
//												e.printStackTrace();
											}
										}else if(AttributeName.equals("rbnUseOfThirdParty")){
											
											 try{
										    	 if(rbnUseOfThirdParty.equalsIgnoreCase("Yes")){
										    		 utilfunc.MakeElement(NewFieldXPath+RadioTrueSufix).click();
										    		   Thread.sleep(2000);
										    		    String ThirdPartyInfoXpath="//*[@id='ThirdPartyInfo']";
										    		    utilfunc.MakeElement(ThirdPartyInfoXpath).clear();
														utilfunc.MakeElement(ThirdPartyInfoXpath).sendKeys(ThirdPartyInfo);
														String ThirdPartyCountriesServedXpath="//*[@id='ThirdPartyCountriesServed']";
														utilfunc.MakeElement(ThirdPartyCountriesServedXpath).clear();
														utilfunc.MakeElement(ThirdPartyCountriesServedXpath).sendKeys(ThirdPartyCountriesServed);
														String ThirdPartyCitiesServedXpath="//*[@id='ThirdPartyCitiesServed']";
														utilfunc.MakeElement(ThirdPartyCitiesServedXpath).clear();
														utilfunc.MakeElement(ThirdPartyCitiesServedXpath).sendKeys(ThirdPartyCitiesServed);
														
														
														

										    		 
										    	   }else{
										    		   utilfunc.MakeElement(NewFieldXPath+RadioFalseSufix).click();
										    	   }
											 
											 }catch(Exception Error){
												 
												 System.out.println("User has selet the NO" );
											 }
											
											}else if(AttributeName.equals("BankRoutingInfo")){
									utilfunc.MakeElement(NewFieldXPath).clear();
									utilfunc.MakeElement(NewFieldXPath).sendKeys(BankRoutingInfo);
							}else if(AttributeName.equals("searchCompanyName")){
								try {
									Thread.sleep(1500);
									utilfunc.MakeElement(NewFieldXPath).sendKeys(searchCompanyName);
									Thread.sleep(2000);
									utilfunc.selectFirstResultFromAutoSuggestion(NewFieldXPath);
									Thread.sleep(1500);
								} catch (Exception e) {
									System.out.println("Unable to select the value");
									// TODO Auto-generated catch block
//									e.printStackTrace();
								}
								try {
									String AddBtnsearchCompanyName="//*[@class='input-append']//*[contains(@class,'btn') and contains(text(),'Add')]";
									utilfunc.MakeElement(AddBtnsearchCompanyName).click();
								} catch (Exception e) {
									System.out.println("Company has been added");
									// TODO Auto-generated catch block
//									e.printStackTrace();
								}
						}else{
							System.out.println("Please select the mandatory fields.");
						}


									}

								}catch(Exception e){
									Flag	=	false;
									System.out.println("Unable to excute "+sheetName);
								}
						}
						
						

							 try{
								 // save button after saving all data..
								String saveBtn	=	".//*[@id='form1']//a[contains(@class,'btn') and text()='Save']";
			    	        	utilfunc.MakeElement(saveBtn).click();
								System.out.println("Test case id: "+ TestcaseID + " with  "+Scenario + " scenario executed");
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
