package CIMS;


import java.awt.AWTException;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import listner.ErrorUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.WinUser.FLASHWINFO;
import com.sun.rmi.rmid.ExecPermission;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.Click;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


//import util.Email;
import util.RunMode;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Modules.LeftNavigation.*;
import CIMS.Reports.*;

@SuppressWarnings("deprecation")
public class CIMS_Left_Navigation {

	private String 										sysDate;
	private WebDriver 									webdriver;		
	private UtilFunction 								utilfunc;		
	private CIMS_Login 									obj_CIMS_Login;
	private dashboard 									obj_Report_Dashboard;

	//
	private CIMS_LeftNavigation_InitiateAProject obj_CIMS_LeftNavigation_InitiateAProject;
	private CIMS_LeftNavigation_EmployeeSearch obj_CIMS_LeftNavigation_EmployeeSearch;
	private CIMS_LeftNavigation_ProjectSearch obj_CIMS_LeftNavigation_ProjectSearch;
	private CIMS_LeftNavigation_MyProfile obj_CIMS_LeftNavigation_MyProfile;
	private CIMS_LeftNavigation_ImmigrationStatus obj_CIMS_LeftNavigation_ImmigrationStatus;
	private CIMS_LeftNavigation_PriorityDates obj_CIMS_LeftNavigation_PriorityDates;
	private CIMS_LeftNavigation_Messages obj_CIMS_LeftNavigation_Messages;
	private CIMS_LeftNavigation_News obj_CIMS_LeftNavigation_News;
	private CIMS_LeftNavigation_Company obj_CIMS_LeftNavigation_Company;
	private CIMS_LeftNavigation_NewQuery obj_CIMS_LeftNavigation_NewQuery;
	private CIMS_LeftNavigation_QueryHistory obj_CIMS_LeftNavigation_QueryHistory;
	private CIMS_LeftNavigation_VisaAudit obj_CIMS_LeftNavigation_VisaAudit;
	private CIMS_LeftNavigation_TravelHistory obj_CIMS_LeftNavigation_TravelHistory;
	private CIMS_LeftNavigation_DocumentGeneration obj_CIMS_LeftNavigation_DocumentGeneration;
	private CIMS_LeftNavigation_TemplateGeneration obj_CIMS_LeftNavigation_TemplateGeneration;
	private CIMS_LeftNavigation_PurchaseOrderLists obj_CIMS_LeftNavigation_PurchaseOrderLists;
	private CIMS_LeftNavigation_BulkInitiationHistory obj_CIMS_LeftNavigation_BulkInitiationHistory;
	private CIMS_LeftNavigation_CaseManagementAdmin obj_CIMS_LeftNavigation_CaseManagementAdmin;
	private CIMS_LeftNavigation_DocumentTypeAdmin obj_CIMS_LeftNavigation_DocumentTypeAdmin;
	private CIMS_LeftNavigation_EmailSnippetAdmin obj_CIMS_LeftNavigation_EmailSnippetAdmin;
	private CIMS_LeftNavigation_GlobalReferenceList obj_CIMS_LeftNavigation_GlobalReferenceList;
	private CIMS_LeftNavigation_GovernmentPriorityDates obj_CIMS_LeftNavigation_GovernmentPriorityDates;
	private CIMS_LeftNavigation_NewsAdmin obj_CIMS_LeftNavigation_NewsAdmin;
	private CIMS_LeftNavigation_NotificationAdmin obj_CIMS_LeftNavigation_NotificationAdmin;
	private CIMS_LeftNavigation_PolicyDisclaimer obj_CIMS_LeftNavigation_PolicyDisclaimer;
	private CIMS_LeftNavigation_QuestionnaireAdmin obj_CIMS_LeftNavigation_QuestionnaireAdmin;
	private CIMS_LeftNavigation_ReportAdmin obj_CIMS_LeftNavigation_ReportAdmin;
	private CIMS_LeftNavigation_ResourcesAdmin obj_CIMS_LeftNavigation_ResourcesAdmin;
	private CIMS_LeftNavigation_PermissionAdmin obj_CIMS_LeftNavigation_PermissionAdmin;
	private CIMS_LeftNavigation_RoleAdmin obj_CIMS_LeftNavigation_RoleAdmin;
	private CIMS_LeftNavigation_ServiceCodeCategoryAdmin obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin;
	private CIMS_LeftNavigation_ServiceCodeClassificationAdmin obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin;
	private CIMS_LeftNavigation_SurveySearch obj_CIMS_LeftNavigation_SurveySearch;
	private CIMS_LeftNavigation_CountryandVisa obj_CIMS_LeftNavigation_CountryandVisa;
	private CIMS_LeftNavigation_CountryGroup obj_CIMS_LeftNavigation_CountryGroup;
	private CIMS_LeftNavigation_GenericPurposes obj_CIMS_LeftNavigation_GenericPurposes;
	private CIMS_LeftNavigation_CompanyDocument obj_CIMS_LeftNavigation_CompanyDocument;





	//file name that takes dynamically in all modules.
	public static String ExcelFileName="Test Left Navigation Data.xls";
	public static String suiteName		=	"Left Navigation";
	public String sheetName="URLANDNAME";
	public static String os=System.getProperty("os.name");
	public static String osbit=System.getProperty("sun.arch.data.model");
	public static String moduleName="";
	public static String Employee_namecheck=null;
	public static String questionarie_name1="";
	public static String timer;
	private String columnNameRM="RUNMODE";
	private String columnNameAction="ACTION";


	//timer
	StopWatch pageLoad = new StopWatch();

	//Initiate the class Before TEST method
	@BeforeClass

	public void isSkipped()
	{

		if(RunMode.isSkip(ExcelFileName,this.getClass().getName())){
			System.out.println("");
			System.out.println(this.getClass().getName()+" Test is Skipped Intentionally.");
			System.out.println("");
			System.out.println("This Test will be Skipped as Run Mode is set 'No' in the Test Data Excel Sheet.");
			throw new SkipException("Test will be Skiped as Run Mode is Set to 'N' in Test Data xls File.");
		}
		else {	

			//  				System.out.println("browser:  "+UtilFunction.getBrowser(this.getClass().getName()));
			setDriver(UtilFunction.getBrowser(this.getClass().getName(),this.ExcelFileName));
			setSysDate(UtilFunction.currentDateTime());				
			setUtilfunc(new UtilFunction(this.getDriver()));	
			setobj_CIMS_Login(new CIMS_Login(webdriver, utilfunc));

			setobj_CIMS_LeftNavigation_InitiateAProject(new CIMS_LeftNavigation_InitiateAProject (webdriver,utilfunc));
			setobj_CIMS_LeftNavigation_EmployeeSearch(new CIMS_LeftNavigation_EmployeeSearch(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_ProjectSearch(new CIMS_LeftNavigation_ProjectSearch(webdriver, utilfunc));  				
			setobj_CIMS_LeftNavigation_MyProfile(new CIMS_LeftNavigation_MyProfile (webdriver,utilfunc));
			setobj_CIMS_LeftNavigation_ImmigrationStatus(new CIMS_LeftNavigation_ImmigrationStatus (webdriver,utilfunc));
			setobj_CIMS_LeftNavigation_PriorityDates(new CIMS_LeftNavigation_PriorityDates(webdriver,utilfunc));
			setobj_CIMS_LeftNavigation_Messages(new CIMS_LeftNavigation_Messages(webdriver,utilfunc));
			setobj_CIMS_LeftNavigation_News(new CIMS_LeftNavigation_News(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_Company(new CIMS_LeftNavigation_Company(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_NewQuery(new CIMS_LeftNavigation_NewQuery(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_QueryHistory(new CIMS_LeftNavigation_QueryHistory(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_VisaAudit(new CIMS_LeftNavigation_VisaAudit(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_TravelHistory(new CIMS_LeftNavigation_TravelHistory(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_DocumentGeneration(new CIMS_LeftNavigation_DocumentGeneration(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_TemplateGeneration(new CIMS_LeftNavigation_TemplateGeneration(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_PurchaseOrderLists(new CIMS_LeftNavigation_PurchaseOrderLists(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_BulkInitiationHistory(new CIMS_LeftNavigation_BulkInitiationHistory(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_CaseManagementAdmin(new CIMS_LeftNavigation_CaseManagementAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_DocumentTypeAdmin(new CIMS_LeftNavigation_DocumentTypeAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_EmailSnippetAdmin(new CIMS_LeftNavigation_EmailSnippetAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_GlobalReferenceList(new CIMS_LeftNavigation_GlobalReferenceList(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_GovernmentPriorityDates(new CIMS_LeftNavigation_GovernmentPriorityDates(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_NewsAdmin(new CIMS_LeftNavigation_NewsAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_NotificationAdmin(new CIMS_LeftNavigation_NotificationAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_PolicyDisclaimer(new CIMS_LeftNavigation_PolicyDisclaimer(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_QuestionnaireAdmin(new CIMS_LeftNavigation_QuestionnaireAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_ReportAdmin(new CIMS_LeftNavigation_ReportAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_ResourcesAdmin(new CIMS_LeftNavigation_ResourcesAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_PermissionAdmin(new CIMS_LeftNavigation_PermissionAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_RoleAdmin(new CIMS_LeftNavigation_RoleAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin(new CIMS_LeftNavigation_ServiceCodeCategoryAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin(new CIMS_LeftNavigation_ServiceCodeClassificationAdmin(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_SurveySearch(new CIMS_LeftNavigation_SurveySearch(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_CountryandVisa(new CIMS_LeftNavigation_CountryandVisa(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_CountryGroup(new CIMS_LeftNavigation_CountryGroup(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_GenericPurposes(new CIMS_LeftNavigation_GenericPurposes(webdriver, utilfunc));
			setobj_CIMS_LeftNavigation_CompanyDocument(new CIMS_LeftNavigation_CompanyDocument(webdriver, utilfunc));

			setobj_dashboard((new dashboard()));




			if(UtilFunction.Actualbrw.equals("IE")){
				webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			}else if(UtilFunction.Actualbrw.equals("CHROME")){
				webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			}else{
				webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			}
			System.out.println("");
			System.out.println("***************************Opening the Application*********************************");

			boolean StartApplicationFlag = utilfunc.startApplication(ExcelFileName);
			if(!StartApplicationFlag){
				System.out.println("User is not able to Open the application");
			}
			else {
				System.out.println("Opened the Application URL Successfully");
			}
		}
	}


	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("Closing Opened Browser");
		boolean CloaseBrowserFlag = utilfunc.closeWebDriver();		
		if(!CloaseBrowserFlag){
			System.out.println("User is not able to close the application");
		}
		else {
			System.out.println("Closed the application.");
		}

	}


	//Our Test start from here.

	@Test
	public void CIMSLeftNavigation() throws InterruptedException, IOException, AWTException 
	{

		try {

			// Project  Login	
			obj_CIMS_Login.Project_login(ExcelFileName);

			//Welcome page
			obj_CIMS_Login.Welcome_Page();


			//privacy disclaimer check
			try{

				String check=".//*[@id='chkConfirm']";
				String Agreebutton=".//*[@id='btnNext']";

				utilfunc.MakeElement(check).click();                               
				utilfunc.MakeElement(Agreebutton).click();

			}catch(Exception e){
				System.out.println("Privacy policy Disclaimer is not Exist on the Page");
			}

			// let us zoom out 2-3 times of current screen so that slider icon is never missed out while switching any module

			utilfunc.zoomOut(5);

			//Getting employee Name
			try{
				utilfunc.MakeElement("//*[@id='user-profile']").click();
				Employee_namecheck				=	utilfunc.MakeElement(".//*[@id='user-name']").getText();
				Thread.sleep(400);
				utilfunc.MakeElement("//*[@id='user-profile']").click();
				System.out.println(Employee_namecheck);
			}catch(Exception e){
				System.out.println("Unable to find Employee name and using username instead");	
			}


			//now start our code for left navigation

			//initialize variables that will be used...
			String fileName							=	ExcelFileName;
			long startTime							=	0;
			boolean Page_flag						=	false;
			boolean ModuleFoundOrNot_flag			=	false;
			String status							=	"";
			String ModuleName						=	"";
			String ActionName						=	"";
			long startTotalTime						=	0;
			String TotalTime						=	"";

			//Lokesh add these lines for get count of +ve and -ve test cases.
			int PositiveScenarioCounter				=	0;
			int NegativeScenarioCounter				=	0;
			int ModuleCounter						=	0;
			int TotalTestCaseCounter				=	0;
			int passTestCaseCounter					=	0;
			int failTestCaseCounter					=	0;
			int NotAssignedModuleCounter			=	0;
			ArrayList NumberOfNotAssignModule = new ArrayList();
			//let us choose Left Navigation from excel with Run mode Yes 
			String 	LeftNavigation					=		"Left Navigation";	//"Left Navigation" is the sheet name in "Test Left Navigation Data.xls" file.
			int RowCount							=		UtilFunction.usedRowCount(fileName, LeftNavigation);
			int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, LeftNavigation, columnNameRM);
			int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, LeftNavigation, columnNameAction);
			int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, LeftNavigation, "Suite Name");


			try{

				//loop for check is module yes in  "Left Navigation" sheet or not(FIRST LOOP)
				startTotalTime = System.currentTimeMillis();
				for(int modCounter = 1;modCounter<RowCount;modCounter++)
				{
					Thread.sleep(1000);
					try
					{
						boolean passCounter				=	false;
						boolean failCounter				=	false;
						boolean negativePassCounter		=	false;
						boolean notAssignedCounter		=	false;
						//Here we are checking for yes or no for current module
						if(UtilFunction.getCellData(fileName, LeftNavigation, columnNumber_RUNMODE, modCounter).equals("Y"))
						{
							ModuleCounter=ModuleCounter+1;
							ModuleName="";ActionName="";
							utilfunc.ErrorMessage1="";
							utilfunc.ErrorMessage2="";
							utilfunc.ErrorMessage4="";
							utilfunc.ErrorMessage5="";
							utilfunc.globalerrormessage="";
							// now pick the name of regression suite, action, etc that is set to run mode Y
							ModuleName				=		UtilFunction.getCellData(fileName, LeftNavigation, columnNumber_SuiteName, modCounter);

							ActionName				=		UtilFunction.getCellData(fileName, LeftNavigation, columnNumber_ACTION, modCounter);
							System.out.println("Sheet selected to pull data is: -"	+ ModuleName	+	"- and with Action: "	+	ActionName+".");

							// now check module run modes with Y.. and call module objects..
							String sheetName					=	ModuleName;
							int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
							int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameRM);
							int Scenariocol	=	UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");




							//loop for check how many test case are Yes or NO for individual module sheet (SECOND LOOP)
							for(int count=1; count<rowCount; count++)
							{

								Thread.sleep(1000);
								try{
									//Here we are checking for yes or no for current module and current test case number    						
									if(UtilFunction.getCellData(fileName, sheetName, columnNumber_suiteNm_RUNMODE, count).equals("Y"))
									{
										String Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

										if(Scenariotext.equals("Positive") || Scenariotext.contains("sitive") || Scenariotext.contains("Pos")){
											PositiveScenarioCounter++;
										}else if(Scenariotext.equals("Negative") || Scenariotext.contains("gative") || Scenariotext.contains("gavtive") ){
											NegativeScenarioCounter++;
										}
										TotalTestCaseCounter=TotalTestCaseCounter+1;
										utilfunc.ErrorMessage1="";
										utilfunc.ErrorMessage2="";
										utilfunc.ErrorMessage4="";
										utilfunc.ErrorMessage5="";
										utilfunc.globalerrormessage="";

										String CheckMenuVisiableorNot=".//*[contains(@class,'menuOpen')]";
										int counterforCheckMenuVisiableorNot=utilfunc.GetObjectCount(CheckMenuVisiableorNot);
										//System.out.println("---x---x---x");
										Thread.sleep(3000);
										if(counterforCheckMenuVisiableorNot>0)
										{
											//click again and hide the menu
											System.out.println("click again and hide the menu");
											utilfunc.MakeElement("//a[text()='Menu']").click();
										}
										else{
											System.out.println("Menu already hide no need to hide it again");
										}
										//System.out.println("---x---x---x");
										Thread.sleep(3000);

										System.out.println("\n\n=== ==== ==== === === ==== === \nModule: "+ModuleName);
										if(ModuleName.equals("Initiate a Project"))
										{
											try{
												utilfunc.MakeElement("//a[text()='Menu']").click();
												// check if current browser is IE8 then click link for IE8 only
												System.out.println("check if current browser is IE then click link for IE only");

												String InitiationLink		=		"//*[contains(@id,'divSidebaris')]";
												//					    					String InitiateLinkXPath	=		"SinglepageInitiation"; // this is used to get the link of enabled(display: none is missing) link
												for(int w=1;w<=utilfunc.GetObjectCount(InitiationLink);w++){

													String InitiateLinkXPath	=	InitiationLink+"["+w+"]";
													Boolean	styleAttrPresent	=		utilfunc.isAttributePresent(utilfunc.MakeElement(InitiateLinkXPath), "style");

													if(styleAttrPresent==false){
														System.out.println("style tag not present.."+utilfunc.MakeElement(InitiateLinkXPath).getText());
														// clicking on initiation page.. let us save the id to identify if we need to call old initiation page
														String IdentifyIE			=		utilfunc.MakeElement(InitiateLinkXPath).getAttribute("id");
														System.out.println("ie-: "+IdentifyIE);
														Thread.sleep(2000);
														utilfunc.MakeElement(InitiateLinkXPath).click();
														ModuleFoundOrNot_flag	=	true;
														break;
													}

												}



											}catch(Exception error){utilfunc.MakeElement("//a[text()='Menu']").click();}
										}else{
											//System.out.println("Menu search start...");

											//check Module Name if =Service Code Classification Adm so we have to change
											if(ModuleName.equalsIgnoreCase("Service Code Classification Adm"))
											{
												ModuleName="Service Code Classification Admin";
											}

											ModuleFoundOrNot_flag=utilfunc.goToMenuSubItems(ModuleName);


											// rest Module name to "Service Code Classification Adm"
											if(ModuleName.equalsIgnoreCase("Service Code Classification Admin"))
											{ModuleName="Service Code Classification Adm";}

											//System.out.println("Menu search ends...");
										}
										//wait for some time till page load 
										Thread.sleep(4000);



										if(ModuleFoundOrNot_flag==true)
										{
											//wait if module found 
											Thread.sleep(2000);
											UtilFunction.ErrorMessage1="";
											UtilFunction.ErrorMessage2="";
											UtilFunction.ErrorMessage4="";
											UtilFunction.ErrorMessage5="";
											UtilFunction.globalerrormessage="";

											try{
												//Initiate a Project
												if(ModuleName.equals("Initiate a Project")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_InitiateAProject.InitiateAProject(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;

															if(UtilFunction.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_InitiateAProject.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_InitiateAProject.scenerio, ActionName, obj_CIMS_LeftNavigation_InitiateAProject.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_InitiateAProject.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_InitiateAProject.scenerio, ActionName, obj_CIMS_LeftNavigation_InitiateAProject.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_InitiateAProject.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_InitiateAProject.scenerio,ActionName,obj_CIMS_LeftNavigation_InitiateAProject.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_InitiateAProject.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_InitiateAProject.scenerio,ActionName,obj_CIMS_LeftNavigation_InitiateAProject.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;

															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_InitiateAProject.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_InitiateAProject.scenerio,ActionName, obj_CIMS_LeftNavigation_InitiateAProject.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a negative fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_InitiateAProject.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_InitiateAProject.scenerio, ActionName, obj_CIMS_LeftNavigation_InitiateAProject.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}


														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Project Search
												else if(ModuleName.equals("Project Search")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_ProjectSearch.ProjectSearch(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;

															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_ProjectSearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ProjectSearch.scenerio, ActionName, obj_CIMS_LeftNavigation_ProjectSearch.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ProjectSearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ProjectSearch.scenerio, ActionName, obj_CIMS_LeftNavigation_ProjectSearch.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_ProjectSearch.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ProjectSearch.scenerio,ActionName,obj_CIMS_LeftNavigation_ProjectSearch.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ProjectSearch.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ProjectSearch.scenerio,ActionName,obj_CIMS_LeftNavigation_ProjectSearch.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;

															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_ProjectSearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ProjectSearch.scenerio,ActionName, obj_CIMS_LeftNavigation_ProjectSearch.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ProjectSearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ProjectSearch.scenerio, ActionName, obj_CIMS_LeftNavigation_ProjectSearch.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Employee Search
												else if(ModuleName.equals("Employee Search")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_EmployeeSearch.EmployeeSearch(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;

															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_EmployeeSearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_EmployeeSearch.scenerio, ActionName, obj_CIMS_LeftNavigation_EmployeeSearch.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_EmployeeSearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_EmployeeSearch.scenerio, ActionName, obj_CIMS_LeftNavigation_EmployeeSearch.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_EmployeeSearch.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_EmployeeSearch.scenerio,ActionName,obj_CIMS_LeftNavigation_EmployeeSearch.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_EmployeeSearch.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_EmployeeSearch.scenerio,ActionName,obj_CIMS_LeftNavigation_EmployeeSearch.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_EmployeeSearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_EmployeeSearch.scenerio,ActionName, obj_CIMS_LeftNavigation_EmployeeSearch.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_EmployeeSearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_EmployeeSearch.scenerio, ActionName, obj_CIMS_LeftNavigation_EmployeeSearch.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//My Profile
												else if(ModuleName.equals("My Profile")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_MyProfile.MyProfile(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;

															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_MyProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_MyProfile.scenerio, ActionName, obj_CIMS_LeftNavigation_MyProfile.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_MyProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_MyProfile.scenerio, ActionName, obj_CIMS_LeftNavigation_MyProfile.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_MyProfile.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_MyProfile.scenerio,ActionName,obj_CIMS_LeftNavigation_MyProfile.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_MyProfile.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_MyProfile.scenerio,ActionName,obj_CIMS_LeftNavigation_MyProfile.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}



														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_MyProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_MyProfile.scenerio,ActionName, obj_CIMS_LeftNavigation_MyProfile.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_MyProfile.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_MyProfile.scenerio, ActionName, obj_CIMS_LeftNavigation_MyProfile.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Immigration Status
												else if(ModuleName.equals("Immigration Status")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_ImmigrationStatus.ImmigrationStatus(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_ImmigrationStatus.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ImmigrationStatus.scenerio, ActionName, obj_CIMS_LeftNavigation_ImmigrationStatus.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ImmigrationStatus.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ImmigrationStatus.scenerio, ActionName, obj_CIMS_LeftNavigation_ImmigrationStatus.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_ImmigrationStatus.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ImmigrationStatus.scenerio,ActionName,obj_CIMS_LeftNavigation_ImmigrationStatus.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ImmigrationStatus.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ImmigrationStatus.scenerio,ActionName,obj_CIMS_LeftNavigation_ImmigrationStatus.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}	
															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_ImmigrationStatus.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ImmigrationStatus.scenerio,ActionName, obj_CIMS_LeftNavigation_ImmigrationStatus.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);


															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ImmigrationStatus.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ImmigrationStatus.scenerio, ActionName, obj_CIMS_LeftNavigation_ImmigrationStatus.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Priority Dates
												else if(ModuleName.equals("Priority Dates")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_PriorityDates.PriorityDates(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_PriorityDates.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PriorityDates.scenerio, ActionName, obj_CIMS_LeftNavigation_PriorityDates.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PriorityDates.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PriorityDates.scenerio, ActionName, obj_CIMS_LeftNavigation_PriorityDates.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_PriorityDates.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_PriorityDates.scenerio,ActionName,obj_CIMS_LeftNavigation_PriorityDates.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PriorityDates.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_PriorityDates.scenerio,ActionName,obj_CIMS_LeftNavigation_PriorityDates.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_PriorityDates.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PriorityDates.scenerio,ActionName, obj_CIMS_LeftNavigation_PriorityDates.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PriorityDates.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PriorityDates.scenerio, ActionName, obj_CIMS_LeftNavigation_PriorityDates.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Messages
												else if(ModuleName.equals("Messages")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_Messages.Messages(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS"; passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_Messages.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_Messages.scenerio, ActionName, obj_CIMS_LeftNavigation_Messages.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_Messages.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_Messages.scenerio, ActionName, obj_CIMS_LeftNavigation_Messages.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_Messages.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_Messages.scenerio,ActionName,obj_CIMS_LeftNavigation_Messages.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_Messages.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_Messages.scenerio,ActionName,obj_CIMS_LeftNavigation_Messages.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_Messages.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_Messages.scenerio,ActionName, obj_CIMS_LeftNavigation_Messages.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_Messages.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_Messages.scenerio, ActionName, obj_CIMS_LeftNavigation_Messages.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}


														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//News
												else if(ModuleName.equals("News")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_News.News(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_News.scenerio, ActionName, obj_CIMS_LeftNavigation_News.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_News.scenerio, ActionName, obj_CIMS_LeftNavigation_News.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_News.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_News.scenerio,ActionName,obj_CIMS_LeftNavigation_News.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_News.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_News.scenerio,ActionName,obj_CIMS_LeftNavigation_News.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_News.scenerio,ActionName, obj_CIMS_LeftNavigation_News.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_News.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_News.scenerio, ActionName, obj_CIMS_LeftNavigation_News.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Company
												else if(ModuleName.equals("Company")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_Company.Company(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_Company.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_Company.scenerio, ActionName, obj_CIMS_LeftNavigation_Company.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_Company.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_Company.scenerio, ActionName, obj_CIMS_LeftNavigation_Company.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}	
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_Company.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_Company.scenerio,ActionName,obj_CIMS_LeftNavigation_Company.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_Company.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_Company.scenerio,ActionName,obj_CIMS_LeftNavigation_Company.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_Company.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_Company.scenerio,ActionName, obj_CIMS_LeftNavigation_Company.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_Company.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_Company.scenerio, ActionName, obj_CIMS_LeftNavigation_Company.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//New Query
												else if(ModuleName.equals("New Query")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_NewQuery.NewQuery(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NewQuery.scenerio, ActionName, obj_CIMS_LeftNavigation_NewQuery.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NewQuery.scenerio, ActionName, obj_CIMS_LeftNavigation_NewQuery.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_NewQuery.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_NewQuery.scenerio,ActionName,obj_CIMS_LeftNavigation_NewQuery.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NewQuery.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_NewQuery.scenerio,ActionName,obj_CIMS_LeftNavigation_NewQuery.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NewQuery.scenerio,ActionName, obj_CIMS_LeftNavigation_NewQuery.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NewQuery.scenerio, ActionName, obj_CIMS_LeftNavigation_NewQuery.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Query History
												else if(ModuleName.equals("Query History")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_QueryHistory.QueryHistory(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_QueryHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_QueryHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_QueryHistory.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_QueryHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_QueryHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_QueryHistory.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}	
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_QueryHistory.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_QueryHistory.scenerio,ActionName,obj_CIMS_LeftNavigation_QueryHistory.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_QueryHistory.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_QueryHistory.scenerio,ActionName,obj_CIMS_LeftNavigation_QueryHistory.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_QueryHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_QueryHistory.scenerio,ActionName, obj_CIMS_LeftNavigation_QueryHistory.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_QueryHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_QueryHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_QueryHistory.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}


														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Visa Audit
												else if(ModuleName.equals("Visa Audit")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_VisaAudit.VisaAudit(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_VisaAudit.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_VisaAudit.scenerio, ActionName, obj_CIMS_LeftNavigation_VisaAudit.testcasedescription, status);
															// now write it in a pass file..
															if(passCounter==false){
																try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																passCounter=true;
															}
															try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_VisaAudit.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_VisaAudit.scenerio, ActionName, obj_CIMS_LeftNavigation_VisaAudit.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_VisaAudit.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_VisaAudit.scenerio,ActionName,obj_CIMS_LeftNavigation_VisaAudit.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_VisaAudit.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_VisaAudit.scenerio,ActionName,obj_CIMS_LeftNavigation_VisaAudit.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_VisaAudit.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_VisaAudit.scenerio,ActionName, obj_CIMS_LeftNavigation_VisaAudit.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_VisaAudit.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_VisaAudit.scenerio, ActionName, obj_CIMS_LeftNavigation_VisaAudit.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Travel History
												else if(ModuleName.equals("Travel History")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_TravelHistory.TravelHistory(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_TravelHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_TravelHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_TravelHistory.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_TravelHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_TravelHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_TravelHistory.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_TravelHistory.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_TravelHistory.scenerio,ActionName,obj_CIMS_LeftNavigation_TravelHistory.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_TravelHistory.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_TravelHistory.scenerio,ActionName,obj_CIMS_LeftNavigation_TravelHistory.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_TravelHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_TravelHistory.scenerio,ActionName, obj_CIMS_LeftNavigation_TravelHistory.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_TravelHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_TravelHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_TravelHistory.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}


														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Document Generation
												else if(ModuleName.equals("Document Generation")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_DocumentGeneration.DocumentGeneration(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_DocumentGeneration.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_DocumentGeneration.scenerio, ActionName, obj_CIMS_LeftNavigation_DocumentGeneration.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_DocumentGeneration.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_DocumentGeneration.scenerio, ActionName, obj_CIMS_LeftNavigation_DocumentGeneration.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_DocumentGeneration.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_DocumentGeneration.scenerio,ActionName,obj_CIMS_LeftNavigation_DocumentGeneration.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_DocumentGeneration.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_DocumentGeneration.scenerio,ActionName,obj_CIMS_LeftNavigation_DocumentGeneration.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}


														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_DocumentGeneration.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_DocumentGeneration.scenerio,ActionName, obj_CIMS_LeftNavigation_DocumentGeneration.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_DocumentGeneration.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_DocumentGeneration.scenerio, ActionName, obj_CIMS_LeftNavigation_DocumentGeneration.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Template Generation
												else if(ModuleName.equals("Template Generation")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_TemplateGeneration.TemplateGeneration(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_TemplateGeneration.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_TemplateGeneration.scenerio, ActionName, obj_CIMS_LeftNavigation_TemplateGeneration.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_TemplateGeneration.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_TemplateGeneration.scenerio, ActionName, obj_CIMS_LeftNavigation_TemplateGeneration.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_TemplateGeneration.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_TemplateGeneration.scenerio,ActionName,obj_CIMS_LeftNavigation_TemplateGeneration.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_TemplateGeneration.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_TemplateGeneration.scenerio,ActionName,obj_CIMS_LeftNavigation_TemplateGeneration.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}


															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_TemplateGeneration.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_TemplateGeneration.scenerio,ActionName, obj_CIMS_LeftNavigation_TemplateGeneration.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_TemplateGeneration.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_TemplateGeneration.scenerio, ActionName, obj_CIMS_LeftNavigation_TemplateGeneration.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Purchase Order Lists
												else if(ModuleName.equals("Purchase Order Lists")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_PurchaseOrderLists.PurchaseOrderLists(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_PurchaseOrderLists.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PurchaseOrderLists.scenerio, ActionName, obj_CIMS_LeftNavigation_PurchaseOrderLists.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PurchaseOrderLists.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PurchaseOrderLists.scenerio, ActionName, obj_CIMS_LeftNavigation_PurchaseOrderLists.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}


															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_PurchaseOrderLists.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_PurchaseOrderLists.scenerio,ActionName,obj_CIMS_LeftNavigation_PurchaseOrderLists.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PurchaseOrderLists.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_PurchaseOrderLists.scenerio,ActionName,obj_CIMS_LeftNavigation_PurchaseOrderLists.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}



															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_PurchaseOrderLists.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PurchaseOrderLists.scenerio,ActionName, obj_CIMS_LeftNavigation_PurchaseOrderLists.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PurchaseOrderLists.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PurchaseOrderLists.scenerio, ActionName, obj_CIMS_LeftNavigation_PurchaseOrderLists.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Bulk Initiation History
												else if(ModuleName.equals("Bulk Initiation History")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_BulkInitiationHistory.BulkInitiationHistory(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_BulkInitiationHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_BulkInitiationHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_BulkInitiationHistory.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_BulkInitiationHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_BulkInitiationHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_BulkInitiationHistory.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_BulkInitiationHistory.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_BulkInitiationHistory.scenerio,ActionName,obj_CIMS_LeftNavigation_BulkInitiationHistory.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_BulkInitiationHistory.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_BulkInitiationHistory.scenerio,ActionName,obj_CIMS_LeftNavigation_BulkInitiationHistory.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_BulkInitiationHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_BulkInitiationHistory.scenerio,ActionName, obj_CIMS_LeftNavigation_BulkInitiationHistory.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_BulkInitiationHistory.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_BulkInitiationHistory.scenerio, ActionName, obj_CIMS_LeftNavigation_BulkInitiationHistory.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Case Management Admin
												else if(ModuleName.equals("Case Management Admin")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_CaseManagementAdmin.CaseManagementAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_CaseManagementAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CaseManagementAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_CaseManagementAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CaseManagementAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CaseManagementAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_CaseManagementAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_CaseManagementAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_CaseManagementAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_CaseManagementAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CaseManagementAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_CaseManagementAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_CaseManagementAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_CaseManagementAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CaseManagementAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_CaseManagementAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CaseManagementAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CaseManagementAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_CaseManagementAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Document Type Admin    
												else if(ModuleName.equals("Document Type Admin")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_DocumentTypeAdmin.DocumentTypeAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_DocumentTypeAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_DocumentTypeAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}

															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_DocumentTypeAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_DocumentTypeAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_DocumentTypeAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_DocumentTypeAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_DocumentTypeAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Email Snippet Admin  
												else if(ModuleName.equals("Email Snippet Admin")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_EmailSnippetAdmin.EmailSnippetAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_EmailSnippetAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_EmailSnippetAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_EmailSnippetAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_EmailSnippetAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}

															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_EmailSnippetAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_EmailSnippetAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_EmailSnippetAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Global Reference List   
												else if(ModuleName.equals("Global Reference List")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_GlobalReferenceList.GlobalReferenceList(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_GlobalReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GlobalReferenceList.scenerio, ActionName, obj_CIMS_LeftNavigation_GlobalReferenceList.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GlobalReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GlobalReferenceList.scenerio, ActionName, obj_CIMS_LeftNavigation_GlobalReferenceList.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_GlobalReferenceList.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_GlobalReferenceList.scenerio,ActionName,obj_CIMS_LeftNavigation_GlobalReferenceList.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GlobalReferenceList.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_GlobalReferenceList.scenerio,ActionName,obj_CIMS_LeftNavigation_GlobalReferenceList.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_GlobalReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GlobalReferenceList.scenerio,ActionName, obj_CIMS_LeftNavigation_GlobalReferenceList.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GlobalReferenceList.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GlobalReferenceList.scenerio, ActionName, obj_CIMS_LeftNavigation_GlobalReferenceList.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Government Priority Dates 
												else if(ModuleName.equals("Government Priority Dates")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_GovernmentPriorityDates.GovernmentPriorityDates(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GovernmentPriorityDates.scenerio, ActionName, obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GovernmentPriorityDates.scenerio, ActionName, obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_GovernmentPriorityDates.scenerio,ActionName,obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_GovernmentPriorityDates.scenerio,ActionName,obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}

														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GovernmentPriorityDates.scenerio,ActionName, obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GovernmentPriorityDates.scenerio, ActionName, obj_CIMS_LeftNavigation_GovernmentPriorityDates.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//News Admin
												else if(ModuleName.equals("News Admin")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_NewsAdmin.NewsAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_NewsAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NewsAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_NewsAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NewsAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NewsAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_NewsAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_NewsAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_NewsAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_NewsAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NewsAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_NewsAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_NewsAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_NewsAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NewsAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_NewsAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NewsAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NewsAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_NewsAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Notification Admin 
												else if(ModuleName.equals("Notification Admin")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_NotificationAdmin.NotificationAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_NotificationAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NotificationAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_NotificationAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NotificationAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NotificationAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_NotificationAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_NotificationAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_NotificationAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_NotificationAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NotificationAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_NotificationAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_NotificationAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_NotificationAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NotificationAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_NotificationAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_NotificationAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_NotificationAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_NotificationAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}

														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Policy Disclaimer 
												else if(ModuleName.equals("Policy Disclaimer")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_PolicyDisclaimer.PolicyDisclaimer(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_PolicyDisclaimer.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PolicyDisclaimer.scenerio, ActionName, obj_CIMS_LeftNavigation_PolicyDisclaimer.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PolicyDisclaimer.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PolicyDisclaimer.scenerio, ActionName, obj_CIMS_LeftNavigation_PolicyDisclaimer.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_PolicyDisclaimer.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_PolicyDisclaimer.scenerio,ActionName,obj_CIMS_LeftNavigation_PolicyDisclaimer.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PolicyDisclaimer.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_PolicyDisclaimer.scenerio,ActionName,obj_CIMS_LeftNavigation_PolicyDisclaimer.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_PolicyDisclaimer.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PolicyDisclaimer.scenerio,ActionName, obj_CIMS_LeftNavigation_PolicyDisclaimer.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PolicyDisclaimer.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PolicyDisclaimer.scenerio, ActionName, obj_CIMS_LeftNavigation_PolicyDisclaimer.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Questionnaire Admin 
												else if(ModuleName.equals("Questionnaire Admin")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_QuestionnaireAdmin.QuestionnaireAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_QuestionnaireAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_QuestionnaireAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_QuestionnaireAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_QuestionnaireAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_QuestionnaireAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_QuestionnaireAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_QuestionnaireAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Report Admin 
												else if(ModuleName.equals("Report Admin")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_ReportAdmin.ReportAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_ReportAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ReportAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ReportAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ReportAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ReportAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ReportAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_ReportAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ReportAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_ReportAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ReportAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ReportAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_ReportAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_ReportAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ReportAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_ReportAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ReportAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ReportAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ReportAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Resources Admin
												else if(ModuleName.equals("Resources Admin")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_ResourcesAdmin.ResourcesAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_ResourcesAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ResourcesAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ResourcesAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ResourcesAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ResourcesAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ResourcesAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_ResourcesAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ResourcesAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_ResourcesAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ResourcesAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ResourcesAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_ResourcesAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_ResourcesAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ResourcesAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_ResourcesAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ResourcesAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ResourcesAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ResourcesAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Permission Admin PermissionAdmin
												else if(ModuleName.equals("Permission Admin")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_PermissionAdmin.PermissionAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_PermissionAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PermissionAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_PermissionAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PermissionAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PermissionAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_PermissionAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_PermissionAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_PermissionAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_PermissionAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PermissionAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_PermissionAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_PermissionAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_PermissionAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PermissionAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_PermissionAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_PermissionAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_PermissionAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_PermissionAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Role Admin 
												else if(ModuleName.equals("Role Admin")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_RoleAdmin.RoleAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_RoleAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_RoleAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_RoleAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_RoleAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_RoleAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_RoleAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_RoleAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_RoleAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_RoleAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_RoleAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_RoleAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_RoleAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_RoleAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_RoleAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_RoleAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_RoleAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_RoleAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_RoleAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Service Code Category Admin   
												else if(ModuleName.equals("Service Code Category Admin")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.ServiceCodeCategoryAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Service Code Classification Admin    
												else if(ModuleName.equals("Service Code Classification Adm")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.ServiceCodeClassificationAdmin(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.scenerio,ActionName,obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.scenerio,ActionName, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.scenerio, ActionName, obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Survey Search
												else if(ModuleName.equals("Survey Search")){
													startTime = System.currentTimeMillis();
													try{

														Page_flag	=	obj_CIMS_LeftNavigation_SurveySearch.SurveySearch(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_SurveySearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_SurveySearch.scenerio, ActionName, obj_CIMS_LeftNavigation_SurveySearch.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_SurveySearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_SurveySearch.scenerio, ActionName, obj_CIMS_LeftNavigation_SurveySearch.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_SurveySearch.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_SurveySearch.scenerio,ActionName,obj_CIMS_LeftNavigation_SurveySearch.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_SurveySearch.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_SurveySearch.scenerio,ActionName,obj_CIMS_LeftNavigation_SurveySearch.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_SurveySearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_SurveySearch.scenerio,ActionName, obj_CIMS_LeftNavigation_SurveySearch.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_SurveySearch.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_SurveySearch.scenerio, ActionName, obj_CIMS_LeftNavigation_SurveySearch.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Country & Visa   
												else if(ModuleName.equals("Country & Visa")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_CountryandVisa.CountryandVisa(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_CountryandVisa.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CountryandVisa.scenerio, ActionName, obj_CIMS_LeftNavigation_CountryandVisa.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CountryandVisa.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CountryandVisa.scenerio, ActionName, obj_CIMS_LeftNavigation_CountryandVisa.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_CountryandVisa.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_CountryandVisa.scenerio,ActionName,obj_CIMS_LeftNavigation_CountryandVisa.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CountryandVisa.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_CountryandVisa.scenerio,ActionName,obj_CIMS_LeftNavigation_CountryandVisa.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_CountryandVisa.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CountryandVisa.scenerio,ActionName, obj_CIMS_LeftNavigation_CountryandVisa.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CountryandVisa.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CountryandVisa.scenerio, ActionName, obj_CIMS_LeftNavigation_CountryandVisa.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Country Group  
												else if(ModuleName.equals("Country Group")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_CountryGroup.CountryGroup(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_CountryGroup.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CountryGroup.scenerio, ActionName, obj_CIMS_LeftNavigation_CountryGroup.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CountryGroup.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CountryGroup.scenerio, ActionName, obj_CIMS_LeftNavigation_CountryGroup.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_CountryGroup.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_CountryGroup.scenerio,ActionName,obj_CIMS_LeftNavigation_CountryGroup.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CountryGroup.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_CountryGroup.scenerio,ActionName,obj_CIMS_LeftNavigation_CountryGroup.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_CountryGroup.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CountryGroup.scenerio,ActionName, obj_CIMS_LeftNavigation_CountryGroup.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CountryGroup.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CountryGroup.scenerio, ActionName, obj_CIMS_LeftNavigation_CountryGroup.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Generic Purpose  
												else if(ModuleName.equals("Generic Purpose")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_GenericPurposes.GenericPurposes(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";  passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_GenericPurposes.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GenericPurposes.scenerio, ActionName, obj_CIMS_LeftNavigation_GenericPurposes.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GenericPurposes.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GenericPurposes.scenerio, ActionName, obj_CIMS_LeftNavigation_GenericPurposes.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_GenericPurposes.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_GenericPurposes.scenerio,ActionName,obj_CIMS_LeftNavigation_GenericPurposes.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GenericPurposes.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_GenericPurposes.scenerio,ActionName,obj_CIMS_LeftNavigation_GenericPurposes.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_GenericPurposes.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GenericPurposes.scenerio,ActionName, obj_CIMS_LeftNavigation_GenericPurposes.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_GenericPurposes.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_GenericPurposes.scenerio, ActionName, obj_CIMS_LeftNavigation_GenericPurposes.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}	
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
												//Comapny Document  
												else if(ModuleName.equals("Company Document")){
													startTime = System.currentTimeMillis();
													try{
														Page_flag	=	obj_CIMS_LeftNavigation_CompanyDocument.CompanyDocument(fileName,sheetName,count,ActionName);
														timer = utilfunc.getTimeTakenByModule(startTime);
														utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
														if (Page_flag)
														{
															status="PASS";  passTestCaseCounter++;
															if(utilfunc.globalerrormessage.equals(""))
															{
																utilfunc.TestngReportPass(obj_CIMS_LeftNavigation_CompanyDocument.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CompanyDocument.scenerio, ActionName, obj_CIMS_LeftNavigation_CompanyDocument.testcasedescription, status);
																// now write it in a pass file..
																if(passCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Pass");} catch (Exception e) {}
																	passCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardPassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CompanyDocument.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CompanyDocument.scenerio, ActionName, obj_CIMS_LeftNavigation_CompanyDocument.testcasedescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+ModuleName);}
															}
															else
															{
																utilfunc.TestngReportNegativePassTestcase(obj_CIMS_LeftNavigation_CompanyDocument.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_CompanyDocument.scenerio,ActionName,obj_CIMS_LeftNavigation_CompanyDocument.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
																// now write it in a negative pass dashboard file..
																if(negativePassCounter==false){
																	try {	obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Negative Pass");} catch (Exception e) {}
																	negativePassCounter=true;
																}
																try {obj_Report_Dashboard.writeDashBoardNegativePassReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CompanyDocument.testcaseid, utilfunc.Actualbrw,obj_CIMS_LeftNavigation_CompanyDocument.scenerio,ActionName,obj_CIMS_LeftNavigation_CompanyDocument.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
																catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+ModuleName);}
															}
														}
														else
														{
															status="FAIL";failTestCaseCounter++;
															utilfunc.TestngReportFail1(obj_CIMS_LeftNavigation_CompanyDocument.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CompanyDocument.scenerio,ActionName, obj_CIMS_LeftNavigation_CompanyDocument.testcasedescription, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
															// now write it in a fail dashboard file..
															if(failCounter==false){
																obj_Report_Dashboard.writeReportHeader(LeftNavigation, sheetName,"Fail");
																failCounter	= true;
															}
															try {obj_Report_Dashboard.writeDashBoardFailReport(LeftNavigation, Employee_namecheck, obj_CIMS_LeftNavigation_CompanyDocument.testcaseid, utilfunc.Actualbrw, obj_CIMS_LeftNavigation_CompanyDocument.scenerio, ActionName, obj_CIMS_LeftNavigation_CompanyDocument.testcasedescription, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+ModuleName);}	
														}
														if(!utilfunc.ErrorMessage4.contains("permission to access")){webdriver.navigate().back();}
													}catch(Exception e){
														ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
														System.out.println("Script Failed");
														utilfunc.assertion();			
														utilfunc.TakeScreenshot();
													}
												}
											}catch(Exception error){}
										}//if(ModuleFoundOrNot_flag==true) ends here
										else
										{
											try{
												Thread.sleep(3000);
												timer = utilfunc.getTimeTakenByModule(startTime);
												status="PASS";
												String Errormessage="";
												String NotAssignTestCaseID="";
												String NotAssignScenerio="";
												String NotAssignTestCaseDescription="";
												int columnNumber_TCID;
												int columnNumber_Scenario;
												int columnNumber_TestCaseDescription;

												utilfunc.updateModuleDataForReportGeneration(ModuleName, Employee_namecheck, timer);
												Errormessage=""+ModuleName+" is not assigned to "+Employee_namecheck+" User";
												System.out.println(Errormessage);

												columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
												columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
												columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

												NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, columnNumber_TCID, count);
												NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, columnNumber_Scenario, count);
												NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, columnNumber_TestCaseDescription, count);

												utilfunc.TestngReportFail(NotAssignTestCaseID, utilfunc.Actualbrw, NotAssignScenerio,ActionName,NotAssignTestCaseDescription,status,Errormessage);

												NumberOfNotAssignModule.add(ModuleName);

												if(notAssignedCounter==false){
													obj_Report_Dashboard.writeReportHeader(LeftNavigation, ModuleName,"Not Assigned");
													notAssignedCounter=true;

													NotAssignedModuleCounter++;
												}
												try {obj_Report_Dashboard.writeDashBoardNotAssignedReport(LeftNavigation, Employee_namecheck, NotAssignTestCaseID, utilfunc.Actualbrw, NotAssignScenerio, ActionName, NotAssignTestCaseDescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard not assigned report for : "+ModuleName);}

											}catch(Exception error){}
										}
									}
								}catch(Exception error){}
							}
						}
					}catch(Exception error){}
				}

				LinkedHashSet<String> lhs = new LinkedHashSet<String>();
				lhs.addAll(NumberOfNotAssignModule);
				NumberOfNotAssignModule.clear();
				NumberOfNotAssignModule.addAll(lhs);
				NotAssignedModuleCounter=NumberOfNotAssignModule.size();

				System.out.println("========\n========\n========");
				System.out.println("PositiveScenarioCounter : "+PositiveScenarioCounter);
				System.out.println("NegativeScenarioCounter : "+NegativeScenarioCounter);
				System.out.println("ModuleCounter : "+ModuleCounter);
				System.out.println("TotalTestCaseCounter : "+TotalTestCaseCounter);
				System.out.println("passTestCaseCounter : "+passTestCaseCounter);
				System.out.println("failTestCaseCounter : "+failTestCaseCounter);
				System.out.println("NotAssignedModuleCounter : "+NotAssignedModuleCounter);
				System.out.println("========\n========\n========");

				// adding dashboard code here..
				String PositiveScenarioCount="";
				String NegativeScenarioCount="";
				String ModuleCount="";
				String TotalTestCaseCount="";
				String FinalPositiveCount="";
				String FinalNegativeCount="";
				String NotAssignedModuleCount="";


				try{	PositiveScenarioCount			=	Integer.toString(PositiveScenarioCounter);	}catch(Exception error){}
				try{	NegativeScenarioCount			=	Integer.toString(NegativeScenarioCounter);	}catch(Exception error){}
				try{	ModuleCount						=	Integer.toString(ModuleCounter);			}catch(Exception error){}
				try{	TotalTestCaseCount				=	Integer.toString(TotalTestCaseCounter);		}catch(Exception error){}
				try{	FinalPositiveCount				=	Integer.toString(passTestCaseCounter);		}catch(Exception error){}
				try{	FinalNegativeCount				=	Integer.toString(failTestCaseCounter);		}catch(Exception error){}
				try{	NotAssignedModuleCount			=	Integer.toString(NotAssignedModuleCounter);	}catch(Exception error){}

				//utilfunc.TestngDashBoardReport("Left Navigation",ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,FinalPositiveCount,FinalNegativeCount,NotAssignedModuleCount);
				// before generating final report let us check the time taken by the script..
				TotalTime = utilfunc.getTimeTakenByModule(startTotalTime);
				try{
					obj_Report_Dashboard.generateReportForSuite(LeftNavigation,ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,
							FinalPositiveCount,FinalNegativeCount,TotalTime,NotAssignedModuleCount);
				}catch(Exception e){
					System.out.println("unable to call & generate dashboard report..");
				}
			}catch(Exception error){}


		}catch(Exception e){}

	}


	// Below Methods are getters and setters for Test Parameters.	

	public String getSysDate() {
		return sysDate;
	}
	public WebDriver getDriver() {
		return webdriver;
	}
	public void setDriver(String browser) {
		this.webdriver = UtilFunction.getDriver(browser);
	}
	public void setSysDate(String sysdate) {
		this.sysDate = sysdate ;
	}
	public UtilFunction getUtilfunc() {
		return utilfunc;
	}

	public void setUtilfunc(UtilFunction utilfunc) {
		this.utilfunc = utilfunc;
	}



	//Below method is used for click on "menu" and get the text of next item
	public void leftnav()
	{
		String Menu_xpath=".//*[@id='nav-parent']//*[contains(@class,'gn-icon-menu') and contains(text(),'Menu')]";

		//click on the top "Menu" so we can get count of items and the menu text in it.
		try{
			utilfunc.MakeElement(Menu_xpath).click();

		}catch(Exception error){}
	} 


	public void setobj_CIMS_Login(CIMS_Login setobj_CIMS_Login) {
		this.obj_CIMS_Login = setobj_CIMS_Login;
	}

	//Initiate A Project
	public void setobj_CIMS_LeftNavigation_InitiateAProject(CIMS_LeftNavigation_InitiateAProject setobj_CIMS_LeftNavigation_InitiateAProject) {
		this.obj_CIMS_LeftNavigation_InitiateAProject	=	setobj_CIMS_LeftNavigation_InitiateAProject;

	}
	//ProjectSearch
	public void setobj_CIMS_LeftNavigation_ProjectSearch(CIMS_LeftNavigation_ProjectSearch setobj_CIMS_LeftNavigation_ProjectSearch) {
		this.obj_CIMS_LeftNavigation_ProjectSearch	=	setobj_CIMS_LeftNavigation_ProjectSearch;

	}		
	//Employee Search
	public void setobj_CIMS_LeftNavigation_EmployeeSearch(CIMS_LeftNavigation_EmployeeSearch setobj_CIMS_LeftNavigation_EmployeeSearch) {
		this.obj_CIMS_LeftNavigation_EmployeeSearch	=	setobj_CIMS_LeftNavigation_EmployeeSearch;

	}
	//MyProfile
	public void setobj_CIMS_LeftNavigation_MyProfile(CIMS_LeftNavigation_MyProfile setobj_CIMS_LeftNavigation_MyProfile) {
		this.obj_CIMS_LeftNavigation_MyProfile	=	setobj_CIMS_LeftNavigation_MyProfile;

	}		
	//Immigration Status
	public void setobj_CIMS_LeftNavigation_ImmigrationStatus(CIMS_LeftNavigation_ImmigrationStatus setobj_CIMS_LeftNavigation_ImmigrationStatus) {
		this.obj_CIMS_LeftNavigation_ImmigrationStatus	=	setobj_CIMS_LeftNavigation_ImmigrationStatus;

	}
	//Immigration Status
	public void setobj_CIMS_LeftNavigation_PriorityDates(CIMS_LeftNavigation_PriorityDates setobj_CIMS_LeftNavigation_PriorityDates) {
		this.obj_CIMS_LeftNavigation_PriorityDates	=	setobj_CIMS_LeftNavigation_PriorityDates;
	}
	//Messages
	public void setobj_CIMS_LeftNavigation_Messages(CIMS_LeftNavigation_Messages setobj_CIMS_LeftNavigation_Messages) {
		this.obj_CIMS_LeftNavigation_Messages	=	setobj_CIMS_LeftNavigation_Messages;
	}
	//News
	public void setobj_CIMS_LeftNavigation_News(CIMS_LeftNavigation_News setobj_CIMS_LeftNavigation_News) {
		this.obj_CIMS_LeftNavigation_News	=	setobj_CIMS_LeftNavigation_News;
	}
	//Company
	public void setobj_CIMS_LeftNavigation_Company(CIMS_LeftNavigation_Company setobj_CIMS_LeftNavigation_Company) {
		this.obj_CIMS_LeftNavigation_Company	=	setobj_CIMS_LeftNavigation_Company;
	}
	//New Query
	public void setobj_CIMS_LeftNavigation_NewQuery(CIMS_LeftNavigation_NewQuery setobj_CIMS_LeftNavigation_NewQuery) {
		this.obj_CIMS_LeftNavigation_NewQuery	=	setobj_CIMS_LeftNavigation_NewQuery;
	}
	//Query History
	public void setobj_CIMS_LeftNavigation_QueryHistory(CIMS_LeftNavigation_QueryHistory setobj_CIMS_LeftNavigation_QueryHistory) {
		this.obj_CIMS_LeftNavigation_QueryHistory	=	setobj_CIMS_LeftNavigation_QueryHistory;
	}
	//Visa Audit
	public void setobj_CIMS_LeftNavigation_VisaAudit(CIMS_LeftNavigation_VisaAudit setobj_CIMS_LeftNavigation_VisaAudit) {
		this.obj_CIMS_LeftNavigation_VisaAudit	=	setobj_CIMS_LeftNavigation_VisaAudit;
	}		
	//Travel History
	public void setobj_CIMS_LeftNavigation_TravelHistory(CIMS_LeftNavigation_TravelHistory setobj_CIMS_LeftNavigation_TravelHistory) {
		this.obj_CIMS_LeftNavigation_TravelHistory	=	setobj_CIMS_LeftNavigation_TravelHistory;
	}		
	//Document Generation
	public void setobj_CIMS_LeftNavigation_DocumentGeneration(CIMS_LeftNavigation_DocumentGeneration setobj_CIMS_LeftNavigation_DocumentGeneration) {
		this.obj_CIMS_LeftNavigation_DocumentGeneration	=	setobj_CIMS_LeftNavigation_DocumentGeneration;
	}
	//Template Generation
	public void setobj_CIMS_LeftNavigation_TemplateGeneration(CIMS_LeftNavigation_TemplateGeneration setobj_CIMS_LeftNavigation_TemplateGeneration) {
		this.obj_CIMS_LeftNavigation_TemplateGeneration	=	setobj_CIMS_LeftNavigation_TemplateGeneration;
	}
	//Purchase Order Lists
	public void setobj_CIMS_LeftNavigation_PurchaseOrderLists(CIMS_LeftNavigation_PurchaseOrderLists setobj_CIMS_LeftNavigation_PurchaseOrderLists) {
		this.obj_CIMS_LeftNavigation_PurchaseOrderLists	=	setobj_CIMS_LeftNavigation_PurchaseOrderLists;
	}
	//Bulk Initiation History
	public void setobj_CIMS_LeftNavigation_BulkInitiationHistory(CIMS_LeftNavigation_BulkInitiationHistory setobj_CIMS_LeftNavigation_BulkInitiationHistory) {
		this.obj_CIMS_LeftNavigation_BulkInitiationHistory	=	setobj_CIMS_LeftNavigation_BulkInitiationHistory;
	}
	//Case Management Admin
	public void setobj_CIMS_LeftNavigation_CaseManagementAdmin(CIMS_LeftNavigation_CaseManagementAdmin setobj_CIMS_LeftNavigation_CaseManagementAdmin) {
		this.obj_CIMS_LeftNavigation_CaseManagementAdmin	=	setobj_CIMS_LeftNavigation_CaseManagementAdmin;
	}
	//Document Type Admin
	public void setobj_CIMS_LeftNavigation_DocumentTypeAdmin(CIMS_LeftNavigation_DocumentTypeAdmin setobj_CIMS_LeftNavigation_DocumentTypeAdmin) {
		this.obj_CIMS_LeftNavigation_DocumentTypeAdmin	=	setobj_CIMS_LeftNavigation_DocumentTypeAdmin;
	}
	//EmailSnippetAdmin
	public void setobj_CIMS_LeftNavigation_EmailSnippetAdmin(CIMS_LeftNavigation_EmailSnippetAdmin setobj_CIMS_LeftNavigation_EmailSnippetAdmin) {
		this.obj_CIMS_LeftNavigation_EmailSnippetAdmin	=	setobj_CIMS_LeftNavigation_EmailSnippetAdmin;
	}
	//Global Reference List  
	public void setobj_CIMS_LeftNavigation_GlobalReferenceList(CIMS_LeftNavigation_GlobalReferenceList setobj_CIMS_LeftNavigation_GlobalReferenceList) {
		this.obj_CIMS_LeftNavigation_GlobalReferenceList	=	setobj_CIMS_LeftNavigation_GlobalReferenceList;
	}
	//GovernmentPriorityDates
	public void setobj_CIMS_LeftNavigation_GovernmentPriorityDates(CIMS_LeftNavigation_GovernmentPriorityDates setobj_CIMS_LeftNavigation_GovernmentPriorityDates) {
		this.obj_CIMS_LeftNavigation_GovernmentPriorityDates	=	setobj_CIMS_LeftNavigation_GovernmentPriorityDates;
	}
	//News Admin
	public void setobj_CIMS_LeftNavigation_NewsAdmin(CIMS_LeftNavigation_NewsAdmin setobj_CIMS_LeftNavigation_NewsAdmin) {
		this.obj_CIMS_LeftNavigation_NewsAdmin	=	setobj_CIMS_LeftNavigation_NewsAdmin;
	}
	//Notification Admin
	public void setobj_CIMS_LeftNavigation_NotificationAdmin(CIMS_LeftNavigation_NotificationAdmin setobj_CIMS_LeftNavigation_NotificationAdmin) {
		this.obj_CIMS_LeftNavigation_NotificationAdmin	=	setobj_CIMS_LeftNavigation_NotificationAdmin;
	}
	//Policy Disclaimer
	public void setobj_CIMS_LeftNavigation_PolicyDisclaimer(CIMS_LeftNavigation_PolicyDisclaimer setobj_CIMS_LeftNavigation_PolicyDisclaimer) {
		this.obj_CIMS_LeftNavigation_PolicyDisclaimer	=	setobj_CIMS_LeftNavigation_PolicyDisclaimer;
	}
	//Questionnaire Admin
	public void setobj_CIMS_LeftNavigation_QuestionnaireAdmin(CIMS_LeftNavigation_QuestionnaireAdmin setobj_CIMS_LeftNavigation_QuestionnaireAdmin) {
		this.obj_CIMS_LeftNavigation_QuestionnaireAdmin	=	setobj_CIMS_LeftNavigation_QuestionnaireAdmin;
	}
	//Report Admin
	public void setobj_CIMS_LeftNavigation_ReportAdmin(CIMS_LeftNavigation_ReportAdmin setobj_CIMS_LeftNavigation_ReportAdmin) {
		this.obj_CIMS_LeftNavigation_ReportAdmin	=	setobj_CIMS_LeftNavigation_ReportAdmin;
	}
	//Resources Admin
	public void setobj_CIMS_LeftNavigation_ResourcesAdmin(CIMS_LeftNavigation_ResourcesAdmin setobj_CIMS_LeftNavigation_ResourcesAdmin) {
		this.obj_CIMS_LeftNavigation_ResourcesAdmin	=	setobj_CIMS_LeftNavigation_ResourcesAdmin;
	}
	//Permission Admin
	public void setobj_CIMS_LeftNavigation_PermissionAdmin(CIMS_LeftNavigation_PermissionAdmin setobj_CIMS_LeftNavigation_PermissionAdmin) {
		this.obj_CIMS_LeftNavigation_PermissionAdmin	=	setobj_CIMS_LeftNavigation_PermissionAdmin;
	}
	//Role Admin
	public void setobj_CIMS_LeftNavigation_RoleAdmin(CIMS_LeftNavigation_RoleAdmin setobj_CIMS_LeftNavigation_RoleAdmin) {
		this.obj_CIMS_LeftNavigation_RoleAdmin	=	setobj_CIMS_LeftNavigation_RoleAdmin;
	}
	//Service Code Category Admin
	public void setobj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin(CIMS_LeftNavigation_ServiceCodeCategoryAdmin setobj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin) {
		this.obj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin	=	setobj_CIMS_LeftNavigation_ServiceCodeCategoryAdmin;
	}
	//ServiceCodeClassificationAdmin
	public void setobj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin(CIMS_LeftNavigation_ServiceCodeClassificationAdmin setobj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin) {
		this.obj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin	=	setobj_CIMS_LeftNavigation_ServiceCodeClassificationAdmin;
	}
	//SurveySearch
	public void setobj_CIMS_LeftNavigation_SurveySearch(CIMS_LeftNavigation_SurveySearch setobj_CIMS_LeftNavigation_SurveySearch) {
		this.obj_CIMS_LeftNavigation_SurveySearch	=	setobj_CIMS_LeftNavigation_SurveySearch;
	}
	//CountryandVisa
	public void setobj_CIMS_LeftNavigation_CountryandVisa(CIMS_LeftNavigation_CountryandVisa setobj_CIMS_LeftNavigation_CountryandVisa) {
		this.obj_CIMS_LeftNavigation_CountryandVisa	=	setobj_CIMS_LeftNavigation_CountryandVisa;
	}
	//CountryGroup
	public void setobj_CIMS_LeftNavigation_CountryGroup(CIMS_LeftNavigation_CountryGroup setobj_CIMS_LeftNavigation_CountryGroup) {
		this.obj_CIMS_LeftNavigation_CountryGroup	=	setobj_CIMS_LeftNavigation_CountryGroup;
	}
	//GenericPurposes
	public void setobj_CIMS_LeftNavigation_GenericPurposes(CIMS_LeftNavigation_GenericPurposes setobj_CIMS_LeftNavigation_GenericPurposes) {
		this.obj_CIMS_LeftNavigation_GenericPurposes	=	setobj_CIMS_LeftNavigation_GenericPurposes;
	}
	//CompanyDocument
	public void setobj_CIMS_LeftNavigation_CompanyDocument(CIMS_LeftNavigation_CompanyDocument setobj_CIMS_LeftNavigation_CompanyDocument) {
		this.obj_CIMS_LeftNavigation_CompanyDocument	=	setobj_CIMS_LeftNavigation_CompanyDocument;
	}
	// dashboard report
	public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
		this.obj_Report_Dashboard = setobj_Report_Dashboard;
	}
}
