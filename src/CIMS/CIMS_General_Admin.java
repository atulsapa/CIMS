package CIMS;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

import listner.ErrorUtil;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.RunMode;
import util.UtilFunction;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Modules.Company.CIMS_Company_Functions;
import CIMS.Modules.GeneralAdmin.CIMS_Document_Type_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Email_Snippet_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Global_Reference_List;
import CIMS.Modules.GeneralAdmin.CIMS_Government_Priority_Dates;
import CIMS.Modules.GeneralAdmin.CIMS_News_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Notification_Administration;
import CIMS.Modules.GeneralAdmin.CIMS_Permission_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Policy_Disclaimer;
import CIMS.Modules.GeneralAdmin.CIMS_Questionnaire_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Questionnaire_Admin_Edit_Custom_Label;
import CIMS.Modules.GeneralAdmin.CIMS_Questionnaire_Admin_Edit_Document_Checklist;
import CIMS.Modules.GeneralAdmin.CIMS_Report_Administration;
import CIMS.Modules.GeneralAdmin.CIMS_Resource_Type;
import CIMS.Modules.GeneralAdmin.CIMS_Resources_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Role_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Service_Code_Category_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Service_Code_Classification_Admin;
import CIMS.Modules.GeneralAdmin.CIMS_Survey_Search;
import CIMS.Reports.dashboard;


public class CIMS_General_Admin {


	
	private String sysDate;
	private WebDriver webdriver;		
	private UtilFunction utilfunc;		
	private CIMS_Login obj_CIMS_Login;
	private dashboard obj_Report_Dashboard;
	
	private CIMS_Document_Type_Admin obj_CIMS_Document_Type_Admin;
	private CIMS_Email_Snippet_Admin obj_CIMS_Email_Snippet_Admin;
	private CIMS_Global_Reference_List obj_CIMS_Global_Reference_List;
	private CIMS_Notification_Administration obj_CIMS_Notification_Administration;
	
	private CIMS_News_Admin obj_CIMS_News_Admin;
	
	private CIMS_Permission_Admin obj_CIMS_Permission_Admin;
	
	private CIMS_Report_Administration obj_CIMS_Report_Administration;
	
	private CIMS_Service_Code_Category_Admin obj_CIMS_Service_Code_Category_Admin;
	
	private CIMS_Service_Code_Classification_Admin obj_CIMS_Service_Code_Classification_Admin;
	private CIMS_Role_Admin obj_CIMS_Role_Admin;
	private CIMS_Resource_Type obj_CIMS_Resource_Type;
	
	private CIMS_Resources_Admin obj_CIMS_Resources_Admin;
	
	private CIMS_Policy_Disclaimer obj_CIMS_Policy_Disclaimer;
	
	private CIMS_Government_Priority_Dates obj_CIMS_Government_Priority_Dates;
	private CIMS_Questionnaire_Admin obj_CIMS_Questionnaire_Admin;
	
	
	
	
	private CIMS_Questionnaire_Admin_Edit_Custom_Label obj_CIMS_Questionnaire_Admin_Edit_Custom_Label;
	private CIMS_Questionnaire_Admin_Edit_Document_Checklist obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist;
	private CIMS_Survey_Search obj_CIMS_Survey_Search;
	
    //file name that takes dynamically in all modules.
    public static String ExcelFileName="Test General Admin Data.xls";
    public static String suiteName	=	"General Admin";
    public static String os=System.getProperty("os.name");
    public static String osbit=System.getProperty("sun.arch.data.model");
    public static String moduleName="";
    public static String Employee_namecheck=null;
    public static String companyName=null;
    public static String timer;
    private String columnNameRM="RUNMODE";
	private String columnNameAction="ACTION";

    
	//timer
    StopWatch pageLoad = new StopWatch();


 

	//Initiate the class Before TEST method
	@BeforeClass
		public void isSkipped(){

		if(RunMode.isSkip(ExcelFileName,this.getClass().getName())){
				Reporter.log("");
				Reporter.log(this.getClass().getName()+" Test is Skipped Intentionally.");
				Reporter.log("");
				Reporter.log("This Test will be Skipped as Run Mode is set 'No' in the Test Data Excel Sheet.");
				throw new SkipException("Test will be Skiped as Run Mode is Set to 'N' in Test Data xls File.");
			}
			else {		
//				System.out.println(this.getClass().getName());
				setDriver(UtilFunction.getBrowser(this.getClass().getName(),this.ExcelFileName));
				setSysDate(UtilFunction.currentDateTime());				
				setUtilfunc(new UtilFunction(this.getDriver()));	
				setobj_CIMS_Login(new CIMS_Login(webdriver, utilfunc));
				
				setobj_CIMS_Document_Type_Admin(new CIMS_Document_Type_Admin(webdriver, utilfunc));
				setobj_CIMS_Email_Snippet_Admin(new CIMS_Email_Snippet_Admin(webdriver, utilfunc));
				setobj_CIMS_Global_Reference_List(new CIMS_Global_Reference_List(webdriver, utilfunc));
				setobj_CIMS_Notification_Administration(new CIMS_Notification_Administration(webdriver, utilfunc));
				setobj_CIMS_News_Admin(new CIMS_News_Admin(webdriver, utilfunc));
				setobj_CIMS_Permission_Admin(new CIMS_Permission_Admin(webdriver, utilfunc));
				setobj_CIMS_Report_Administration(new CIMS_Report_Administration(webdriver, utilfunc));
				setobj_CIMS_Service_Code_Category_Admin(new CIMS_Service_Code_Category_Admin(webdriver, utilfunc));
				setobj_CIMS_Service_Code_Classification_Admin(new CIMS_Service_Code_Classification_Admin(webdriver, utilfunc));
				setobj_CIMS_Role_Admin(new CIMS_Role_Admin(webdriver, utilfunc));
				setobj_CIMS_Resource_Type(new CIMS_Resource_Type(webdriver, utilfunc));
				setobj_CIMS_Resources_Admin(new CIMS_Resources_Admin(webdriver, utilfunc));
				setobj_CIMS_Policy_Disclaimer(new CIMS_Policy_Disclaimer(webdriver, utilfunc));
				setobj_CIMS_Government_Priority_Dates(new CIMS_Government_Priority_Dates(webdriver, utilfunc));
				setobj_CIMS_Questionnaire_Admin(new CIMS_Questionnaire_Admin(webdriver, utilfunc));
				
				setobj_CIMS_Questionnaire_Admin_Edit_Custom_Label(new CIMS_Questionnaire_Admin_Edit_Custom_Label(webdriver, utilfunc));
				setobj_CIMS_Questionnaire_Admin_Edit_Document_Checklist(new CIMS_Questionnaire_Admin_Edit_Document_Checklist(webdriver, utilfunc));
				setobj_CIMS_Survey_Search(new CIMS_Survey_Search(webdriver, utilfunc));


				
				setobj_dashboard((new dashboard()));
				
				
				
				
				
				
				
				
				
				if(UtilFunction.Actualbrw.equals("IE")){
					webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					
				}else if(UtilFunction.Actualbrw.equals("CHROME")){
					webdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					
				}else{
				webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
				}
				Reporter.log("");
				Reporter.log("***************************Opening the Application*********************************");

				boolean StartApplicationFlag = utilfunc.startApplication(ExcelFileName);
					if(!StartApplicationFlag){
						Reporter.log("User is not able to Open the application");
					}
					else {
						Reporter.log("Opened the Application URL Successfully");
						}
					}
				}
			

	
	@AfterMethod
	public void closeBrowser() {
		Reporter.log("Closing Opened Browser");
		boolean CloaseBrowserFlag = utilfunc.closeWebDriver();		
		if(!CloaseBrowserFlag){
			Reporter.log("User is not able to close the application");
		}
		else {
			Reporter.log("Closed the application.");
		}
		
	}
			
	

	@Test
//Our Test start from here.
public void CIMS_GeneralAdmin() throws InterruptedException, IOException, AWTException {


	try {
		/*p = System.getProperty("os.name");
		System.out.println("Operating system is"+p);*/

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
        
        utilfunc.zoomOut(3);
        
        try{
			utilfunc.MakeElement("//*[@id='user-profile']").click();
			Employee_namecheck				=	utilfunc.MakeElement(".//*[@id='user-name']").getText();
			Thread.sleep(400);
			utilfunc.MakeElement("//*[@id='user-profile']").click();
			System.out.println(Employee_namecheck);
		}catch(Exception e){
			System.out.println("Unable to find Employee name and using username instead");	
		}
        
        
        boolean visitSPILink					=	false;
		boolean	openSuite						=	false;
		boolean Page_flag						=	false;
		String fileName							=	ExcelFileName;
		String SuiteName						=	"";
		String status							=	"";
		long startTotalTime					    =	0;
		String MenuLink							=	"";
		String TotalTime						=	"";
		String ActionName						=	"";
		long startTime							=	0;
	
		
		
		
		
		
		//Dharam add these lines for get count of +ve and -ve test cases.
		int PositiveScenarioCounter				=	0;
		int NegativeScenarioCounter				=	0;
		int ModuleCounter						=	0;
		int TotalTestCaseCounter				=	0;
		int passTestCaseCounter					=	0;
		int failTestCaseCounter					=	0;
		int NotAssignedModuleCounter			=	0;
		ArrayList NumberOfNotAssignModule = new ArrayList();

		String 	GeneralAdmin				    =		"General Admin";
		int RowCount							=		UtilFunction.usedRowCount(fileName, GeneralAdmin);
		int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, GeneralAdmin, columnNameRM);
		int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, GeneralAdmin, columnNameAction);
		int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, GeneralAdmin, "Suite Name");

		
	    startTotalTime = System.currentTimeMillis();
       for(int modCounter = 1;modCounter<RowCount;modCounter++){
    	   
    	  
    	   try{
    		   boolean passCounter	=	false;
				boolean failCounter	=	false;
				boolean negativePassCounter=false;
				boolean notAssignedCounter	=	false;
				// check if current suite name is set to runmode Y..
    		   
				if(UtilFunction.getCellData(fileName, GeneralAdmin, columnNumber_RUNMODE, modCounter).equals("Y")){
					
					
					ModuleCounter=ModuleCounter+1;
					SuiteName="";ActionName="";
					// now pick the name of regression suite, action, etc that is set to runmode Y

					SuiteName				=		UtilFunction.getCellData(fileName, GeneralAdmin, columnNumber_SuiteName, modCounter);
					ActionName				=		UtilFunction.getCellData(fileName, GeneralAdmin, columnNumber_ACTION, modCounter);

					System.out.println("Sheet selected to pull data is: "	+ SuiteName	+	" and with Action: "	+	ActionName);
                      
					String sheetName					=	SuiteName;
					int rowCount						=	UtilFunction.usedRowCount(fileName,sheetName);
					int columnNumber_suiteNm_RUNMODE	=	UtilFunction.getColumnWithCellData(fileName, sheetName, columnNameRM);
					int Scenariocol	                    =	UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
               
				
					for(int count=1; count<rowCount; count++)
					{
						
						if(UtilFunction.getCellData(fileName, sheetName, columnNumber_suiteNm_RUNMODE, count).equals("Y")){

							
							String Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);
							
							 if(Scenariotext.equals("Positive") || Scenariotext.contains("sitive") || Scenariotext.contains("Pos")){
								 PositiveScenarioCounter++;
		    					}else if(Scenariotext.equals("Negative") || Scenariotext.contains("gative") || Scenariotext.contains("gavtive") ){
		    						NegativeScenarioCounter++;
		    					}
							TotalTestCaseCounter=TotalTestCaseCounter+1;
							
							
						//S.MakeElement("//a[text()='Menu']").click();

							// click on link & make sure it is clickable if not then it will go to not assigned module..
							String LinkName	=	"";
							if(SuiteName.equals("Resource Type")){
								LinkName	=	"Resources Admin";	
							}else if(SuiteName.equals("Edit Custom Label")||SuiteName.equals("Edit Document Checklist")){
								LinkName	=	"Questionnaire Admin";
							}
							else if(SuiteName.equals("Service Code Classification")){
								LinkName	=	"Service Code Classification Admin";
							}
							
							else{
								LinkName	=	SuiteName;
							}
							
							try {
								Thread.sleep(5000);
									visitSPILink	=	utilfunc.goToMenuSubItems(LinkName);
									Thread.sleep(5000);
							} catch (Exception e1) {
								System.out.println("Unable to clicked on the link");
							}
						if(visitSPILink){

							if(SuiteName.equals("Document Type Admin")){
								
								try{
									startTime = System.currentTimeMillis();
									Page_flag	=	obj_CIMS_Document_Type_Admin.Document_Type(fileName,SuiteName,count,ActionName);
									timer = utilfunc.getTimeTakenByModule(startTime);
									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									if (Page_flag)
									{
										status="PASS";passTestCaseCounter++;
										if(utilfunc.globalerrormessage.equals(""))
										{
											utilfunc.TestngReportPass(obj_CIMS_Document_Type_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Document_Type_Admin.scenerio, ActionName,obj_CIMS_Document_Type_Admin.description, status);
											
											// now write it in a pass file..
											if(passCounter==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
												 passCounter=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Document_Type_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Document_Type_Admin.scenerio, ActionName, obj_CIMS_Document_Type_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

										}
										else
										{
											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Document_Type_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Document_Type_Admin.scenerio,ActionName,obj_CIMS_Document_Type_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											// now write it in a negative pass dashboard file..
											if(negativePassCounter==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
												 negativePassCounter=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Document_Type_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Document_Type_Admin.scenerio,ActionName,obj_CIMS_Document_Type_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

										}
										
										
									}
									else
									{
										status="FAIL";failTestCaseCounter++;
										//													utilfunc.TakeScreenshot();
										utilfunc.TestngReportFail1(obj_CIMS_Document_Type_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Document_Type_Admin.scenerio,ActionName,obj_CIMS_Document_Type_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									
										// now write it in a fail dashboard file..
										if(failCounter==false){
				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
				    						failCounter	= true;
			    						}
										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Document_Type_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Document_Type_Admin.scenerio, ActionName, obj_CIMS_Document_Type_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
									}
								}catch(Exception s){
									System.out.println("some error occured in : "+ SuiteName);
									
								}
							
							}
							
							else if(SuiteName.equals("Email Snippet Admin")){
								

								
								try{
									startTime = System.currentTimeMillis();
									Page_flag	=	obj_CIMS_Email_Snippet_Admin.Email_Snippet_Admin(fileName,SuiteName,count,ActionName);
									timer = utilfunc.getTimeTakenByModule(startTime);
									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									if (Page_flag)
									{
										status="PASS";passTestCaseCounter++;
										if(utilfunc.globalerrormessage.equals(""))
										{
											utilfunc.TestngReportPass(obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Email_Snippet_Admin.scenerio, ActionName,obj_CIMS_Email_Snippet_Admin.description, status);
											
											// now write it in a pass file..
											if(passCounter==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
												 passCounter=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Email_Snippet_Admin.scenerio, ActionName, obj_CIMS_Email_Snippet_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

										}
										else
										{
											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Email_Snippet_Admin.scenerio,ActionName,obj_CIMS_Email_Snippet_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											// now write it in a negative pass dashboard file..
											if(negativePassCounter==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
												 negativePassCounter=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Email_Snippet_Admin.scenerio,ActionName,obj_CIMS_Email_Snippet_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

										}
										
										
									}
									else
									{
										status="FAIL";failTestCaseCounter++;
										//													utilfunc.TakeScreenshot();
										utilfunc.TestngReportFail1(obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Email_Snippet_Admin.scenerio,ActionName,obj_CIMS_Email_Snippet_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									
										// now write it in a fail dashboard file..
										if(failCounter==false){
				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
				    						failCounter	= true;
			    						}
										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Email_Snippet_Admin.scenerio, ActionName, obj_CIMS_Email_Snippet_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
									}
								}catch(Exception s){
									System.out.println("some error occured in : "+ SuiteName);
									
								}
							
							
								
								
								
								
								
								
								
								
								
//								try{
//									startTime = System.currentTimeMillis();
//									Page_flag	=	obj_CIMS_Email_Snippet_Admin.Email_Snippet_Admin(fileName,SuiteName,count,ActionName);
//									timer = utilfunc.getTimeTakenByModule(startTime);
//									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//									if (Page_flag)
//									{
//										status="PASS";passTestCaseCounter++;
//										if(utilfunc.globalerrormessage.equals(""))
//										{
//											utilfunc.TestngReportPass(obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Email_Snippet_Admin.scenerio, ActionName,obj_CIMS_Email_Snippet_Admin.description, status);
//											// now write it in a pass file..
//											if(passCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Pass");} catch (Exception e) {}
//												 passCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Email_Snippet_Admin.scenerio, ActionName, obj_CIMS_Email_Snippet_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										}
//										else
//										{
//											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Email_Snippet_Admin.scenerio,ActionName,obj_CIMS_Email_Snippet_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//											// now write it in a negative pass dashboard file..
//											if(negativePassCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//												 negativePassCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Email_Snippet_Admin.scenerio, ActionName, obj_CIMS_Email_Snippet_Admin.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										}
//										
//										
//									}
//									else
//									{
//										status="FAIL";failTestCaseCounter++;
//										//													utilfunc.TakeScreenshot();
//										utilfunc.TestngReportFail1(obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Email_Snippet_Admin.scenerio,ActionName,obj_CIMS_Email_Snippet_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//										// now write it in a negative fails dashboard file..
//										if(failCounter==false){
//				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Fail");
//				    						failCounter	= true;
//			    						}
//										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Email_Snippet_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Email_Snippet_Admin.scenerio,ActionName, obj_CIMS_Email_Snippet_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//									}
//								}catch(Exception s){
//									System.out.println("some error occured in : "+ SuiteName);
//									
//								}
							
							}
							
							
                             else if(SuiteName.equals("Global Reference List")){
                            	 
                            	 
                            	 

 								
 								try{
 									startTime = System.currentTimeMillis();
 									Page_flag	=	obj_CIMS_Global_Reference_List.Global_Reference_List(fileName,SuiteName,count,ActionName);
 									timer = utilfunc.getTimeTakenByModule(startTime);
 									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
 									if (Page_flag)
 									{
 										status="PASS";passTestCaseCounter++;
 										if(utilfunc.globalerrormessage.equals(""))
 										{
 											utilfunc.TestngReportPass(obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Global_Reference_List.scenerio, ActionName,obj_CIMS_Global_Reference_List.description, status);
 											
 											// now write it in a pass file..
 											if(passCounter==false){
 												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
 												 passCounter=true;
 											 }
 											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Reference_List.scenerio, ActionName, obj_CIMS_Global_Reference_List.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

 										}
 										else
 										{
 											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Global_Reference_List.scenerio,ActionName,obj_CIMS_Global_Reference_List.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
 											// now write it in a negative pass dashboard file..
 											if(negativePassCounter==false){
 												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
 												 negativePassCounter=true;
 											 }
 											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Global_Reference_List.scenerio,ActionName,obj_CIMS_Global_Reference_List.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
 											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

 										}
 										
 										
 									}
 									else
 									{
 										status="FAIL";failTestCaseCounter++;
 										//													utilfunc.TakeScreenshot();
 										utilfunc.TestngReportFail1(obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Global_Reference_List.scenerio,ActionName,obj_CIMS_Global_Reference_List.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
 									
 										// now write it in a fail dashboard file..
 										if(failCounter==false){
 				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
 				    						failCounter	= true;
 			    						}
 										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Reference_List.scenerio, ActionName, obj_CIMS_Global_Reference_List.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
 									}
 								}catch(Exception s){
 									System.out.println("some error occured in : "+ SuiteName);
 									
 								}
 							
 							
						        
                            	 
                            	 
                            	 
                            	 
                            	 
                            	 
                            	 
                            	 
                            	
                            	 
                            	 
                            	 
                            	 
//								try{
//									startTime = System.currentTimeMillis();
//									Page_flag	=	obj_CIMS_Global_Reference_List.Global_Reference_List(fileName,SuiteName,count,ActionName);
//									timer = utilfunc.getTimeTakenByModule(startTime);
//									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//									if (Page_flag)
//									{
//										status="PASS";passTestCaseCounter++;
//										if(utilfunc.globalerrormessage.equals(""))
//										{
//											utilfunc.TestngReportPass(obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Global_Reference_List.scenerio, ActionName,obj_CIMS_Global_Reference_List.description, status);
//										
//											if(passCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Pass");} catch (Exception e) {}
//												 passCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Reference_List.scenerio, ActionName, obj_CIMS_Global_Reference_List.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//											
//											
//										
//										}
//										else
//										{
//											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Global_Reference_List.scenerio,ActionName,obj_CIMS_Global_Reference_List.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//										    
//											
//											// now write it in a negative pass dashboard file..
//											if(negativePassCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//												 negativePassCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Reference_List.scenerio, ActionName, obj_CIMS_Global_Reference_List.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										
//										
//										}	
//									}
//									else
//									{
//										status="FAIL";failTestCaseCounter++;
//										//													utilfunc.TakeScreenshot();
//										utilfunc.TestngReportFail1(obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw,obj_CIMS_Global_Reference_List.scenerio,ActionName,obj_CIMS_Global_Reference_List.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//									
//										if(failCounter==false){
//				    						obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Fail");
//				    						failCounter	= true;
//			    						}
//										try {obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Global_Reference_List.testcaseid, utilfunc.Actualbrw, obj_CIMS_Global_Reference_List.scenerio,ActionName, obj_CIMS_Global_Reference_List.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//									}
//								}catch(Exception s){
//									System.out.println("some error occured in : "+ SuiteName);
//									
//								}
//							
//			
                             }else if(SuiteName.equals("Notification Admin")){
                            	 
                            	 
                            	 

 								
 								try{
 									startTime = System.currentTimeMillis();
 									Page_flag	=	obj_CIMS_Notification_Administration.Notification_Administration(fileName,SuiteName,count,ActionName);
 									timer = utilfunc.getTimeTakenByModule(startTime);
 									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
 									if (Page_flag)
 									{
 										status="PASS";passTestCaseCounter++;
 										if(utilfunc.globalerrormessage.equals(""))
 										{
 											utilfunc.TestngReportPass(obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Notification_Administration.scenerio, ActionName,obj_CIMS_Notification_Administration.description, status);
 											
 											// now write it in a pass file..
 											if(passCounter==false){
 												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
 												 passCounter=true;
 											 }
 											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Notification_Administration.scenerio, ActionName, obj_CIMS_Notification_Administration.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

 										}
 										else
 										{
 											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Notification_Administration.scenerio,ActionName,obj_CIMS_Notification_Administration.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
 											// now write it in a negative pass dashboard file..
 											if(negativePassCounter==false){
 												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
 												 negativePassCounter=true;
 											 }
 											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Notification_Administration.scenerio,ActionName,obj_CIMS_Notification_Administration.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
 											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

 										}
 										
 										
 									}
 									else
 									{
 										status="FAIL";failTestCaseCounter++;
 										//													utilfunc.TakeScreenshot();
 										utilfunc.TestngReportFail1(obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Notification_Administration.scenerio,ActionName,obj_CIMS_Notification_Administration.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
 									
 										// now write it in a fail dashboard file..
 										if(failCounter==false){
 				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
 				    						failCounter	= true;
 			    						}
 										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Notification_Administration.scenerio, ActionName, obj_CIMS_Notification_Administration.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
 									}
 								}catch(Exception s){
 									System.out.println("some error occured in : "+ SuiteName);
 									
 								}
 							
 							
                            	 
                            	 
                            	 
                            	 
								
//								try{
//									startTime = System.currentTimeMillis();
//									Page_flag	=	obj_CIMS_Notification_Administration.Notification_Administration(fileName,SuiteName,count,ActionName);
//									timer = utilfunc.getTimeTakenByModule(startTime);
//									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//									if (Page_flag)
//									{
//										status="PASS";passTestCaseCounter++;
//										if(utilfunc.globalerrormessage.equals(""))
//										{
//											utilfunc.TestngReportPass(obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Notification_Administration.scenerio, ActionName,obj_CIMS_Notification_Administration.description, status);
//											// now write it in a pass dashboard file..
//											if(passCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin,SuiteName,"Pass");} catch (Exception e) {}
//												 passCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Notification_Administration.scenerio, ActionName, obj_CIMS_Notification_Administration.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										}
//										else
//										{
//											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Notification_Administration.scenerio,ActionName,obj_CIMS_Notification_Administration.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//										
//											// now write it in a negative pass dashboard file..
//											if(negativePassCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//												 negativePassCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Notification_Administration.scenerio, ActionName, obj_CIMS_Notification_Administration.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										
//										}
//										
//										
//									}
//									else
//									{
//										status="FAIL";failTestCaseCounter++;
//										//													utilfunc.TakeScreenshot();
//										utilfunc.TestngReportFail1(obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Notification_Administration.scenerio,ActionName,obj_CIMS_Notification_Administration.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//									
//										if(failCounter==false){
//				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin,SuiteName, "Fail");
//				    						failCounter	= true;
//			    						}
//										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Notification_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Notification_Administration.scenerio,ActionName, obj_CIMS_Notification_Administration.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//									}
//								}catch(Exception s){
//									System.out.println("some error occured in : "+ GeneralAdmin);
//									
//									
//								}
							
							}
							
                               else if(SuiteName.equals("News Admin")){
                            	   

   								
   								try{
   									startTime = System.currentTimeMillis();
   									Page_flag	=	obj_CIMS_News_Admin.News_Admin(fileName,SuiteName,count,ActionName);
   									timer = utilfunc.getTimeTakenByModule(startTime);
   									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
   									if (Page_flag)
   									{
   										status="PASS";passTestCaseCounter++;
   										if(utilfunc.globalerrormessage.equals(""))
   										{
   											utilfunc.TestngReportPass(obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_News_Admin.scenerio, ActionName,obj_CIMS_News_Admin.description, status);
   											
   											// now write it in a pass file..
   											if(passCounter==false){
   												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
   												 passCounter=true;
   											 }
   											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_News_Admin.scenerio, ActionName, obj_CIMS_News_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

   										}
   										else
   										{
   											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_News_Admin.scenerio,ActionName,obj_CIMS_News_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
   											// now write it in a negative pass dashboard file..
   											if(negativePassCounter==false){
   												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
   												 negativePassCounter=true;
   											 }
   											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_News_Admin.scenerio,ActionName,obj_CIMS_News_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
   											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

   										}
   										
   										
   									}
   									else
   									{
   										status="FAIL";failTestCaseCounter++;
   										//													utilfunc.TakeScreenshot();
   										utilfunc.TestngReportFail1(obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_News_Admin.scenerio,ActionName,obj_CIMS_News_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
   									
   										// now write it in a fail dashboard file..
   										if(failCounter==false){
   				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
   				    						failCounter	= true;
   			    						}
   										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_News_Admin.scenerio, ActionName, obj_CIMS_News_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
   									}
   								}catch(Exception s){
   									System.out.println("some error occured in : "+ SuiteName);
   									
   								}
   							
   							
                            	   
                            	   
                            	   
                            	   
                            	   
                            	   
                            	   
                            	   
                            	   
//                            	   
//                            	 //  visitSPILink	=	utilfunc.goToMenuSubItems("News Admin");
//                            	   try{
//									Page_flag	=	obj_CIMS_News_Admin.News_Admin(fileName,SuiteName,count,ActionName);
//									timer = utilfunc.getTimeTakenByModule(startTime);
//									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//									if (Page_flag)
//									{
//										status="PASS";passTestCaseCounter++;
//										if(utilfunc.globalerrormessage.equals(""))
//										{
//											utilfunc.TestngReportPass(obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_News_Admin.scenerio, ActionName, obj_CIMS_News_Admin.description, status);
//											if(passCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Pass");} catch (Exception e) {}
//												 passCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_News_Admin.scenerio, ActionName, obj_CIMS_News_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										}
//										else
//										{
//											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_News_Admin.scenerio,ActionName,obj_CIMS_News_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//											// now write it in a negative pass dashboard file..
//											if(negativePassCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//												 negativePassCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_News_Admin.scenerio, ActionName, obj_CIMS_News_Admin.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										
//										}
//										
//										
//									}
//									else
//									{
//										status="FAIL";failTestCaseCounter++;
//										//									utilfunc.TakeScreenshot();
//										utilfunc.TestngReportFail1(obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_News_Admin.scenerio,ActionName, obj_CIMS_News_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//									
//										if(failCounter==false){
//				    						obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Fail");
//				    						failCounter	= true;
//			    						}
//										try {obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_News_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_News_Admin.scenerio,ActionName, obj_CIMS_News_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//									}}
//									catch(Exception s){
//										System.out.println("some error occured in : "+ SuiteName);
//										
//									}
//								
                               }
							
							
							
							
                              else if(SuiteName.equals("Permission Admin")){
                            	  
                            	  
                            	  

  								
  								try{
  									startTime = System.currentTimeMillis();
  									Page_flag	=	obj_CIMS_Permission_Admin.Permission_Admin(fileName,SuiteName,count,ActionName);
  									timer = utilfunc.getTimeTakenByModule(startTime);
  									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
  									if (Page_flag)
  									{
  										status="PASS";passTestCaseCounter++;
  										if(utilfunc.globalerrormessage.equals(""))
  										{
  											utilfunc.TestngReportPass(obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Permission_Admin.scenerio, ActionName,obj_CIMS_Permission_Admin.description, status);
  											
  											// now write it in a pass file..
  											if(passCounter==false){
  												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
  												 passCounter=true;
  											 }
  											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Permission_Admin.scenerio, ActionName, obj_CIMS_Permission_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

  										}
  										else
  										{
  											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Permission_Admin.scenerio,ActionName,obj_CIMS_Permission_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
  											// now write it in a negative pass dashboard file..
  											if(negativePassCounter==false){
  												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
  												 negativePassCounter=true;
  											 }
  											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Permission_Admin.scenerio,ActionName,obj_CIMS_Permission_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
  											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

  										}
  										
  										
  									}
  									else
  									{
  										status="FAIL";failTestCaseCounter++;
  										//													utilfunc.TakeScreenshot();
  										utilfunc.TestngReportFail1(obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Permission_Admin.scenerio,ActionName,obj_CIMS_Permission_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
  									
  										// now write it in a fail dashboard file..
  										if(failCounter==false){
  				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
  				    						failCounter	= true;
  			    						}
  										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Permission_Admin.scenerio, ActionName, obj_CIMS_Permission_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
  									}
  								}catch(Exception s){
  									System.out.println("some error occured in : "+ SuiteName);
  									
  								}
  							
  							
                            	  
//                            	  
//                            	  
//								
//							//	visitSPILink	=	utilfunc.goToMenuSubItems("Permission Admin");
//						
//								try{
//									startTime = System.currentTimeMillis();
//									Page_flag	=	obj_CIMS_Permission_Admin.Permission_Admin(fileName,SuiteName,count,ActionName);
//									timer = utilfunc.getTimeTakenByModule(startTime);
//									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//									if (Page_flag)
//									{
//										status="PASS";passTestCaseCounter++;
//										if(utilfunc.globalerrormessage.equals(""))
//										{
//											utilfunc.TestngReportPass(obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Permission_Admin.scenerio, ActionName,obj_CIMS_Permission_Admin.description, status);
//										
//											if(passCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Pass");} catch (Exception e) {}
//												 passCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Permission_Admin.scenerio, ActionName, obj_CIMS_Permission_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										
//										
//										
//										}
//										else
//										{
//											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Permission_Admin.scenerio,ActionName,obj_CIMS_Permission_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//										   
//											
//											// now write it in a negative pass dashboard file..
//											if(negativePassCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//												 negativePassCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Permission_Admin.scenerio, ActionName, obj_CIMS_Permission_Admin.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										
//										}
//										
//										
//									}
//									else
//									{
//										status="FAIL";failTestCaseCounter++;
//										//													utilfunc.TakeScreenshot();
//										utilfunc.TestngReportFail1(obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Permission_Admin.scenerio,ActionName,obj_CIMS_Permission_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//									
//										if(failCounter==false){
//				    						obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Fail");
//				    						failCounter	= true;
//			    						}
//										try {obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Permission_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Permission_Admin.scenerio,ActionName, obj_CIMS_Permission_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//									}
//								}catch(Exception s){
//									System.out.println("some error occured in : "+ SuiteName);
//									
//								}
//							
							}
							
                              else if(SuiteName.equals("Report Admin")){
                            	  

  								
  								try{
  									startTime = System.currentTimeMillis();
  									Page_flag	=	obj_CIMS_Report_Administration.Report_Administration(fileName,SuiteName,count,ActionName);
  									timer = utilfunc.getTimeTakenByModule(startTime);
  									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
  									if (Page_flag)
  									{
  										status="PASS";passTestCaseCounter++;
  										if(utilfunc.globalerrormessage.equals(""))
  										{
  											utilfunc.TestngReportPass(obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Report_Administration.scenerio, ActionName,obj_CIMS_Report_Administration.description, status);
  											
  											// now write it in a pass file..
  											if(passCounter==false){
  												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
  												 passCounter=true;
  											 }
  											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Report_Administration.scenerio, ActionName, obj_CIMS_Report_Administration.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

  										}
  										else
  										{
  											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Report_Administration.scenerio,ActionName,obj_CIMS_Report_Administration.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
  											// now write it in a negative pass dashboard file..
  											if(negativePassCounter==false){
  												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
  												 negativePassCounter=true;
  											 }
  											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Report_Administration.scenerio,ActionName,obj_CIMS_Report_Administration.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
  											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

  										}
  										
  										
  									}
  									else
  									{
  										status="FAIL";failTestCaseCounter++;
  										//													utilfunc.TakeScreenshot();
  										utilfunc.TestngReportFail1(obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Report_Administration.scenerio,ActionName,obj_CIMS_Report_Administration.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
  									
  										// now write it in a fail dashboard file..
  										if(failCounter==false){
  				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
  				    						failCounter	= true;
  			    						}
  										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Report_Administration.scenerio, ActionName, obj_CIMS_Report_Administration.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
  									}
  								}catch(Exception s){
  									System.out.println("some error occured in : "+ SuiteName);
  									
  								}
  							
  							
                            	  
                            	  
  								
//  								//visitSPILink	=	utilfunc.goToMenuSubItems("Report Admin");
//  						
//  								try{
//  									startTime = System.currentTimeMillis();
//  									Page_flag	=	obj_CIMS_Report_Administration.Report_Administration(fileName,SuiteName,count,ActionName);
//  									timer = utilfunc.getTimeTakenByModule(startTime);
//  									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//  									if (Page_flag)
//  									{
//  										status="PASS";passTestCaseCounter++;
//  										if(utilfunc.globalerrormessage.equals(""))
//  										{
//  											utilfunc.TestngReportPass(obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Report_Administration.scenerio, ActionName,obj_CIMS_Report_Administration.description, status);
//  											if(passCounter==false){
//  												 try {	obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Pass");} catch (Exception e) {}
//  												 passCounter=true;
//  											 }
//  											try {obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Report_Administration.scenerio, ActionName, obj_CIMS_Report_Administration.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//  										
//  										}
//  										else
//  										{
//  											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Report_Administration.scenerio,ActionName,obj_CIMS_Report_Administration.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//  										
//  										// now write it in a negative pass dashboard file..
//											if(negativePassCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//												 negativePassCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Report_Administration.scenerio, ActionName, obj_CIMS_Report_Administration.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//  										}
//  										
//  										
//  									}
//  									else
//  									{
//  										status="FAIL";failTestCaseCounter++;
//  										//													utilfunc.TakeScreenshot();
//  										utilfunc.TestngReportFail1(obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw,obj_CIMS_Report_Administration.scenerio,ActionName,obj_CIMS_Report_Administration.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//  									
//  										if(failCounter==false){
//				    						obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Fail");
//				    						failCounter	= true;
//			    						}
//										try {obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Report_Administration.testcaseid, utilfunc.Actualbrw, obj_CIMS_Report_Administration.scenerio,ActionName, obj_CIMS_Report_Administration.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//  									}
//  								}catch(Exception s){
//  									System.out.println("some error occured in : "+ SuiteName);
//  									
//  									
//  								}
  							
  							}
  						
							

							
                            else if(SuiteName.equals("Service Code Category Admin")){
                            	

								
								try{
									startTime = System.currentTimeMillis();
									Page_flag	=	obj_CIMS_Service_Code_Category_Admin.Service_Code_Category_Admin(fileName,SuiteName,count,ActionName);
									timer = utilfunc.getTimeTakenByModule(startTime);
									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									if (Page_flag)
									{
										status="PASS";passTestCaseCounter++;
										if(utilfunc.globalerrormessage.equals(""))
										{
											utilfunc.TestngReportPass(obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Category_Admin.scenerio, ActionName,obj_CIMS_Service_Code_Category_Admin.description, status);
											
											// now write it in a pass file..
											if(passCounter==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
												 passCounter=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Category_Admin.scenerio, ActionName, obj_CIMS_Service_Code_Category_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

										}
										else
										{
											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Category_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Category_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											// now write it in a negative pass dashboard file..
											if(negativePassCounter==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
												 negativePassCounter=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Category_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Category_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

										}
										
										
									}
									else
									{
										status="FAIL";failTestCaseCounter++;
										//													utilfunc.TakeScreenshot();
										utilfunc.TestngReportFail1(obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Category_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Category_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									
										// now write it in a fail dashboard file..
										if(failCounter==false){
				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
				    						failCounter	= true;
			    						}
										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Category_Admin.scenerio, ActionName, obj_CIMS_Service_Code_Category_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
									}
								}catch(Exception s){
									System.out.println("some error occured in : "+ SuiteName);
									
								}
							
							
                            	
                            	
                            	
                            	
                            	
//  								
//								//visitSPILink	=	utilfunc.goToMenuSubItems("Service Code Category Admin");
//						
//								try{
//									startTime = System.currentTimeMillis();
//									Page_flag	=	obj_CIMS_Service_Code_Category_Admin.Service_Code_Category_Admin(fileName,SuiteName,count,ActionName);
//									timer = utilfunc.getTimeTakenByModule(startTime);
//									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//									if (Page_flag)
//									{
//										status="PASS";passTestCaseCounter++;visitSPILink	=	utilfunc.goToMenuSubItems("Survey Search");
//										if(utilfunc.globalerrormessage.equals(""))
//										{
//											utilfunc.TestngReportPass(obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Category_Admin.scenerio, ActionName,obj_CIMS_Service_Code_Category_Admin.description, status);
//										
//											if(passCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Pass");} catch (Exception e) {}
//												 passCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Category_Admin.scenerio, ActionName, obj_CIMS_Service_Code_Category_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										}
//										else
//										{
//											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Category_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Category_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//											// now write it in a negative pass dashboard file..
//											if(negativePassCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//												 negativePassCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Category_Admin.scenerio, ActionName, obj_CIMS_Service_Code_Category_Admin.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										}
//										
//										
//									}
//									else
//									{
//										status="FAIL";failTestCaseCounter++;
//										//													utilfunc.TakeScreenshot();
//										utilfunc.TestngReportFail1(obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Category_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Category_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//									
//										if(failCounter==false){
//				    						obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Fail");
//				    						failCounter	= true;
//			    						}
//										try {obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Service_Code_Category_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Category_Admin.scenerio,ActionName, obj_CIMS_Service_Code_Category_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//									}
//								}catch(Exception s){
//								
//									System.out.println("some error occured in : "+ SuiteName);
//								}
//							
							}
							
                                else if(SuiteName.equals("Service Code Classification")){
                                	
                                	

    								
    								try{
    									startTime = System.currentTimeMillis();
    									Page_flag	=	obj_CIMS_Service_Code_Classification_Admin.Service_Code_Classification_Admin(fileName,SuiteName,count,ActionName);
    									timer = utilfunc.getTimeTakenByModule(startTime);
    									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
    									if (Page_flag)
    									{
    										status="PASS";passTestCaseCounter++;
    										if(utilfunc.globalerrormessage.equals(""))
    										{
    											utilfunc.TestngReportPass(obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Classification_Admin.scenerio, ActionName,obj_CIMS_Service_Code_Classification_Admin.description, status);
    											
    											// now write it in a pass file..
    											if(passCounter==false){
    												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
    												 passCounter=true;
    											 }
    											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Classification_Admin.scenerio, ActionName, obj_CIMS_Service_Code_Classification_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

    										}
    										else
    										{
    											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Classification_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Classification_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
    											// now write it in a negative pass dashboard file..
    											if(negativePassCounter==false){
    												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
    												 negativePassCounter=true;
    											 }
    											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Classification_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Classification_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
    											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

    										}
    										
    										
    									}
    									else
    									{
    										status="FAIL";failTestCaseCounter++;
    										//													utilfunc.TakeScreenshot();
    										utilfunc.TestngReportFail1(obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Classification_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Classification_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
    									
    										// now write it in a fail dashboard file..
    										if(failCounter==false){
    				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
    				    						failCounter	= true;
    			    						}
    										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Classification_Admin.scenerio, ActionName, obj_CIMS_Service_Code_Classification_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
    									}
    								}catch(Exception s){
    									System.out.println("some error occured in : "+ SuiteName);
    									
    								}
    							
    							
                                	
                                	
//  								
//							//	visitSPILink	=	utilfunc.goToMenuSubItems("Service Code Classification Admin");
//						
//								try{
//									startTime = System.currentTimeMillis();
//									Page_flag	=	obj_CIMS_Service_Code_Classification_Admin.Service_Code_Classification_Admin(fileName,SuiteName,count,ActionName);
//									timer = utilfunc.getTimeTakenByModule(startTime);
//									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//									if (Page_flag)
//									{
//										status="PASS";passTestCaseCounter++;
//										if(utilfunc.globalerrormessage.equals(""))
//										{
//											utilfunc.TestngReportPass(obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Classification_Admin.scenerio, ActionName,obj_CIMS_Service_Code_Classification_Admin.description, status);
//											if(passCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Pass");} catch (Exception e) {}
//												 passCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Classification_Admin.scenerio, ActionName, obj_CIMS_Service_Code_Classification_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										}
//										else
//										{
//											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Classification_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Classification_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//											// now write it in a negative pass dashboard file..
//											if(negativePassCounter==false){
//												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//												 negativePassCounter=true;
//											 }
//											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Classification_Admin.scenerio, ActionName, obj_CIMS_Service_Code_Classification_Admin.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//										
//										
//										}
//										
//										
//									}
//									else
//									{
//										status="FAIL";failTestCaseCounter++;
//										//													utilfunc.TakeScreenshot();
//										utilfunc.TestngReportFail1(obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Service_Code_Classification_Admin.scenerio,ActionName,obj_CIMS_Service_Code_Classification_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//									
//										if(failCounter==false){
//				    						obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Fail");
//				    						failCounter	= true;
//			    						}
//										try {obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Service_Code_Classification_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Service_Code_Classification_Admin.scenerio,ActionName, obj_CIMS_Service_Code_Classification_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//									}
//								}catch(Exception s){
//								
//									System.out.println("some error occured in : "+ SuiteName);
//									ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
//									utilfunc.assertion();			
//									utilfunc.TakeScreenshot();
//									
//								}
//							
							}
                                else if(SuiteName.equals("Role Admin")){
                                	

    								
    								try{
    									startTime = System.currentTimeMillis();
    									Page_flag	=	obj_CIMS_Role_Admin.Role_Admin(fileName,SuiteName,count,ActionName);
    									timer = utilfunc.getTimeTakenByModule(startTime);
    									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
    									if (Page_flag)
    									{
    										status="PASS";passTestCaseCounter++;
    										if(utilfunc.globalerrormessage.equals(""))
    										{
    											utilfunc.TestngReportPass(obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Role_Admin.scenerio, ActionName,obj_CIMS_Role_Admin.description, status);
    											
    											// now write it in a pass file..
    											if(passCounter==false){
    												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
    												 passCounter=true;
    											 }
    											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Role_Admin.scenerio, ActionName, obj_CIMS_Role_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

    										}
    										else
    										{
    											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Role_Admin.scenerio,ActionName,obj_CIMS_Role_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
    											// now write it in a negative pass dashboard file..
    											if(negativePassCounter==false){
    												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
    												 negativePassCounter=true;
    											 }
    											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Role_Admin.scenerio,ActionName,obj_CIMS_Role_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
    											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

    										}
    										
    										
    									}
    									else
    									{
    										status="FAIL";failTestCaseCounter++;
    										//													utilfunc.TakeScreenshot();
    										utilfunc.TestngReportFail1(obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Role_Admin.scenerio,ActionName,obj_CIMS_Role_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
    									
    										// now write it in a fail dashboard file..
    										if(failCounter==false){
    				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
    				    						failCounter	= true;
    			    						}
    										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Role_Admin.scenerio, ActionName, obj_CIMS_Role_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
    									}
    								}catch(Exception s){
    									System.out.println("some error occured in : "+ SuiteName);
    									
    								}
    							
    							
                                	
                                	
                                	
                                	
                                	
                                	
      								
//    							//	visitSPILink	=	utilfunc.goToMenuSubItems("Role Admin");
//    						
//    								try{
//    									startTime = System.currentTimeMillis();
//    									Page_flag	=	obj_CIMS_Role_Admin.Role_Admin(fileName,SuiteName,count,ActionName);
//    									timer = utilfunc.getTimeTakenByModule(startTime);
//    									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
//    									if (Page_flag)
//    									{
//    										status="PASS";passTestCaseCounter++;
//    										if(utilfunc.globalerrormessage.equals(""))
//    										{
//    											utilfunc.TestngReportPass(obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Role_Admin.scenerio, ActionName,obj_CIMS_Role_Admin.description, status);
//    											if(passCounter==false){
//    	   											 try {	obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Pass");} catch (Exception e) {}
//    	   											 passCounter=true;
//    	   										 }
//    	   										try {obj_Report_Dashboard.writeDashBoardPassReport(SuiteName, Employee_namecheck, obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Role_Admin.scenerio, ActionName, obj_CIMS_Role_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//    										
//    										}
//    										else
//    										{
//    											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Role_Admin.scenerio,ActionName,obj_CIMS_Role_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//    										
//    											// now write it in a negative pass dashboard file..
//    											if(negativePassCounter==false){
//    												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Negative Pass");} catch (Exception e) {}
//    												 negativePassCounter=true;
//    											 }
//    											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Role_Admin.scenerio, ActionName, obj_CIMS_Role_Admin.description, status, timer, utilfunc.ErrorMessage2, utilfunc.ErrorMessage1, utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
//    										}
//    										
//    										
//    									}
//    									else
//    									{
//    										status="FAIL";failTestCaseCounter++;
//    										//													utilfunc.TakeScreenshot();
//    										utilfunc.TestngReportFail1(obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Role_Admin.scenerio,ActionName,obj_CIMS_Role_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
//    									
//    										if(failCounter==false){
//    				    						obj_Report_Dashboard.writeReportHeader(SuiteName, sheetName,"Fail");
//    				    						failCounter	= true;
//    			    						}
//    										try {obj_Report_Dashboard.writeDashBoardFailReport(SuiteName, Employee_namecheck, obj_CIMS_Role_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Role_Admin.scenerio,ActionName, obj_CIMS_Role_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
//    									}
//    								}catch(Exception s){
//    								
//    									System.out.println("some error occured in : "+ SuiteName);
//    									ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
//    									utilfunc.assertion();			
//    									utilfunc.TakeScreenshot();
//    									
//    								}
//    							
    							}
							
                                   else if(SuiteName.equals("Resource Type")){
                                	   

       								
       								try{
       									startTime = System.currentTimeMillis();
       									Page_flag	=	obj_CIMS_Resource_Type.Resource_Type(fileName,SuiteName,count,ActionName);
       									timer = utilfunc.getTimeTakenByModule(startTime);
       									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
       									if (Page_flag)
       									{
       										status="PASS";passTestCaseCounter++;
       										if(utilfunc.globalerrormessage.equals(""))
       										{
       											utilfunc.TestngReportPass(obj_CIMS_Resource_Type.testcaseid, utilfunc.Actualbrw,obj_CIMS_Resource_Type.scenerio, ActionName,obj_CIMS_Resource_Type.description, status);
       											
       											// now write it in a pass file..
       											if(passCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
       												 passCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Resource_Type.testcaseid, utilfunc.Actualbrw, obj_CIMS_Resource_Type.scenerio, ActionName, obj_CIMS_Resource_Type.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

       										}
       										else
       										{
       											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Resource_Type.testcaseid, utilfunc.Actualbrw,obj_CIMS_Resource_Type.scenerio,ActionName,obj_CIMS_Resource_Type.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       											// now write it in a negative pass dashboard file..
       											if(negativePassCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
       												 negativePassCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Resource_Type.testcaseid, utilfunc.Actualbrw,obj_CIMS_Resource_Type.scenerio,ActionName,obj_CIMS_Resource_Type.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
       											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

       										}
       										
       										
       									}
       									else
       									{
       										status="FAIL";failTestCaseCounter++;
       										//													utilfunc.TakeScreenshot();
       										utilfunc.TestngReportFail1(obj_CIMS_Resource_Type.testcaseid, utilfunc.Actualbrw,obj_CIMS_Resource_Type.scenerio,ActionName,obj_CIMS_Resource_Type.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       									
       										// now write it in a fail dashboard file..
       										if(failCounter==false){
       				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
       				    						failCounter	= true;
       			    						}
       										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Resource_Type.testcaseid, utilfunc.Actualbrw, obj_CIMS_Resource_Type.scenerio, ActionName, obj_CIMS_Resource_Type.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
       									}
       								}catch(Exception s){
       									System.out.println("some error occured in : "+ SuiteName);
       									
       								}
       												
    							}
							
                                   else if(SuiteName.equals("Resources Admin")){
                                	   

       								
       								try{
       									startTime = System.currentTimeMillis();
       									Page_flag	=	obj_CIMS_Resources_Admin.Resource_Type(fileName,SuiteName,count,ActionName);
       									timer = utilfunc.getTimeTakenByModule(startTime);
       									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
       									if (Page_flag)
       									{
       										status="PASS";passTestCaseCounter++;
       										if(utilfunc.globalerrormessage.equals(""))
       										{
       											utilfunc.TestngReportPass(obj_CIMS_Resources_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Resources_Admin.scenerio, ActionName,obj_CIMS_Resources_Admin.description, status);
       											
       											// now write it in a pass file..
       											if(passCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
       												 passCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Resources_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Resources_Admin.scenerio, ActionName, obj_CIMS_Resources_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

       										}
       										else
       										{
       											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Resources_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Resources_Admin.scenerio,ActionName,obj_CIMS_Resources_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       											// now write it in a negative pass dashboard file..
       											if(negativePassCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
       												 negativePassCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Resources_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Resources_Admin.scenerio,ActionName,obj_CIMS_Resources_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
       											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

       										}
       										
       										
       									}
       									else
       									{
       										status="FAIL";failTestCaseCounter++;
       										//													utilfunc.TakeScreenshot();
       										utilfunc.TestngReportFail1(obj_CIMS_Resources_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Resources_Admin.scenerio,ActionName,obj_CIMS_Resources_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       									
       										// now write it in a fail dashboard file..
       										if(failCounter==false){
       				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
       				    						failCounter	= true;
       			    						}
       										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Resources_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Resources_Admin.scenerio, ActionName, obj_CIMS_Resources_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
       									}
       								}catch(Exception s){
       									System.out.println("some error occured in : "+ SuiteName);
       									
       								}
       						
       							
       							}

                                   else if(SuiteName.equals("Policy Disclaimer")){
                                	   
                                	   

       								
       								try{
       									startTime = System.currentTimeMillis();
       									Page_flag	=	obj_CIMS_Policy_Disclaimer.Policy_Disclaimer(fileName,SuiteName,count,ActionName);
       									timer = utilfunc.getTimeTakenByModule(startTime);
       									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
       									if (Page_flag)
       									{
       										status="PASS";passTestCaseCounter++;
       										if(utilfunc.globalerrormessage.equals(""))
       										{
       											utilfunc.TestngReportPass(obj_CIMS_Policy_Disclaimer.testcaseid, utilfunc.Actualbrw,obj_CIMS_Policy_Disclaimer.scenerio, ActionName,obj_CIMS_Policy_Disclaimer.description, status);
       											
       											// now write it in a pass file..
       											if(passCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
       												 passCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Policy_Disclaimer.testcaseid, utilfunc.Actualbrw, obj_CIMS_Policy_Disclaimer.scenerio, ActionName, obj_CIMS_Policy_Disclaimer.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

       										}
       										else
       										{
       											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Policy_Disclaimer.testcaseid, utilfunc.Actualbrw,obj_CIMS_Policy_Disclaimer.scenerio,ActionName,obj_CIMS_Policy_Disclaimer.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       											// now write it in a negative pass dashboard file..
       											if(negativePassCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
       												 negativePassCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Policy_Disclaimer.testcaseid, utilfunc.Actualbrw,obj_CIMS_Policy_Disclaimer.scenerio,ActionName,obj_CIMS_Policy_Disclaimer.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
       											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

       										}
       										
       										
       									}
       									else
       									{
       										status="FAIL";failTestCaseCounter++;
       										//													utilfunc.TakeScreenshot();
       										utilfunc.TestngReportFail1(obj_CIMS_Policy_Disclaimer.testcaseid, utilfunc.Actualbrw,obj_CIMS_Policy_Disclaimer.scenerio,ActionName,obj_CIMS_Policy_Disclaimer.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       									
       										// now write it in a fail dashboard file..
       										if(failCounter==false){
       				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
       				    						failCounter	= true;
       			    						}
       										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Policy_Disclaimer.testcaseid, utilfunc.Actualbrw, obj_CIMS_Policy_Disclaimer.scenerio, ActionName, obj_CIMS_Policy_Disclaimer.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
       									}
       								}catch(Exception s){
       									System.out.println("some error occured in : "+ SuiteName);
       									
       								}
       							
       							
                                	   
        								
          						
          							
          							}
							
                                   else if(SuiteName.equals("Government Priority Dates")){
                                	   
                                	   

       								
       								try{
       									startTime = System.currentTimeMillis();
       									Page_flag	=	obj_CIMS_Government_Priority_Dates.Government_Priority_Dates(fileName,SuiteName,count,ActionName);
       									timer = utilfunc.getTimeTakenByModule(startTime);
       									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
       									if (Page_flag)
       									{
       										status="PASS";passTestCaseCounter++;
       										if(utilfunc.globalerrormessage.equals(""))
       										{
       											utilfunc.TestngReportPass(obj_CIMS_Government_Priority_Dates.testcaseid, utilfunc.Actualbrw,obj_CIMS_Government_Priority_Dates.scenerio, ActionName,obj_CIMS_Government_Priority_Dates.description, status);
       											
       											// now write it in a pass file..
       											if(passCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
       												 passCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Government_Priority_Dates.testcaseid, utilfunc.Actualbrw, obj_CIMS_Government_Priority_Dates.scenerio, ActionName, obj_CIMS_Government_Priority_Dates.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

       										}
       										else
       										{
       											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Government_Priority_Dates.testcaseid, utilfunc.Actualbrw,obj_CIMS_Government_Priority_Dates.scenerio,ActionName,obj_CIMS_Government_Priority_Dates.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       											// now write it in a negative pass dashboard file..
       											if(negativePassCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
       												 negativePassCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Government_Priority_Dates.testcaseid, utilfunc.Actualbrw,obj_CIMS_Government_Priority_Dates.scenerio,ActionName,obj_CIMS_Government_Priority_Dates.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
       											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

       										}
       										
       										
       									}
       									else
       									{
       										status="FAIL";failTestCaseCounter++;
       										//													utilfunc.TakeScreenshot();
       										utilfunc.TestngReportFail1(obj_CIMS_Government_Priority_Dates.testcaseid, utilfunc.Actualbrw,obj_CIMS_Government_Priority_Dates.scenerio,ActionName,obj_CIMS_Government_Priority_Dates.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       									
       										// now write it in a fail dashboard file..
       										if(failCounter==false){
       				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
       				    						failCounter	= true;
       			    						}
       										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Government_Priority_Dates.testcaseid, utilfunc.Actualbrw, obj_CIMS_Government_Priority_Dates.scenerio, ActionName, obj_CIMS_Government_Priority_Dates.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
       									}
       								}catch(Exception s){
       									System.out.println("some error occured in : "+ SuiteName);
       									
       								}
       								}
							
							
							
                                   else if(SuiteName.equals("Questionnaire Admin")){
                                	   

       								
       								try{
       									startTime = System.currentTimeMillis();
       									Page_flag	=	obj_CIMS_Questionnaire_Admin.Questionnaire_Admin(fileName,SuiteName,count,ActionName);
       									timer = utilfunc.getTimeTakenByModule(startTime);
       									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
       									if (Page_flag)
       									{
       										status="PASS";passTestCaseCounter++;
       										if(utilfunc.globalerrormessage.equals(""))
       										{
       											utilfunc.TestngReportPass(obj_CIMS_Questionnaire_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin.scenerio, ActionName,obj_CIMS_Questionnaire_Admin.description, status);
       											
       											// now write it in a pass file..
       											if(passCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
       												 passCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Questionnaire_Admin.scenerio, ActionName, obj_CIMS_Questionnaire_Admin.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

       										}
       										else
       										{
       											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Questionnaire_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin.scenerio,ActionName,obj_CIMS_Questionnaire_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       											// now write it in a negative pass dashboard file..
       											if(negativePassCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
       												 negativePassCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin.scenerio,ActionName,obj_CIMS_Questionnaire_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
       											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

       										}
       										
       										
       									}
       									else
       									{
       										status="FAIL";failTestCaseCounter++;
       										//													utilfunc.TakeScreenshot();
       										utilfunc.TestngReportFail1(obj_CIMS_Questionnaire_Admin.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin.scenerio,ActionName,obj_CIMS_Questionnaire_Admin.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       									
       										// now write it in a fail dashboard file..
       										if(failCounter==false){
       				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
       				    						failCounter	= true;
       			    						}
       										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin.testcaseid, utilfunc.Actualbrw, obj_CIMS_Questionnaire_Admin.scenerio, ActionName, obj_CIMS_Questionnaire_Admin.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
       									}
       								}catch(Exception s){
       									System.out.println("some error occured in : "+ SuiteName);
       									
       								}
       								}
							
                                   
                                   
							
                                   else if(SuiteName.equals("Edit Custom Label")){
                                	   
                                	   

       								
       								try{
       									startTime = System.currentTimeMillis();
       									Page_flag	=	obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.Edit_Custom_Label(fileName,SuiteName,count,ActionName);
       									timer = utilfunc.getTimeTakenByModule(startTime);
       									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
       									if (Page_flag)
       									{
       										status="PASS";passTestCaseCounter++;
       										if(utilfunc.globalerrormessage.equals(""))
       										{
       											utilfunc.TestngReportPass(obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.scenerio, ActionName,obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.description, status);
       											
       											// now write it in a pass file..
       											if(passCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
       												 passCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.testcaseid, utilfunc.Actualbrw, obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.scenerio, ActionName, obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

       										}
       										else
       										{
       											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.scenerio,ActionName,obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       											// now write it in a negative pass dashboard file..
       											if(negativePassCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
       												 negativePassCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.scenerio,ActionName,obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
       											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

       										}
       										
       										
       									}
       									else
       									{
       										status="FAIL";failTestCaseCounter++;
       										//													utilfunc.TakeScreenshot();
       										utilfunc.TestngReportFail1(obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.scenerio,ActionName,obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       									
       										// now write it in a fail dashboard file..
       										if(failCounter==false){
       				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
       				    						failCounter	= true;
       			    						}
       										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.testcaseid, utilfunc.Actualbrw, obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.scenerio, ActionName, obj_CIMS_Questionnaire_Admin_Edit_Custom_Label.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
       									}
       								}catch(Exception s){
       									System.out.println("some error occured in : "+ SuiteName);
       									
       								}
       							
       							
                                	   
                                	   
        								
          						
          							}
                                   else if(SuiteName.equals("Edit Document Checklist")){
                                	   

       								
       								try{
       									startTime = System.currentTimeMillis();
       									Page_flag	=	obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.Edit_Document_Checklist(fileName,SuiteName,count,ActionName);
       									timer = utilfunc.getTimeTakenByModule(startTime);
       									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
       									if (Page_flag)
       									{
       										status="PASS";passTestCaseCounter++;
       										if(utilfunc.globalerrormessage.equals(""))
       										{
       											utilfunc.TestngReportPass(obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.scenerio, ActionName,obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.description, status);
       											
       											// now write it in a pass file..
       											if(passCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
       												 passCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.testcaseid, utilfunc.Actualbrw, obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.scenerio, ActionName, obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

       										}
       										else
       										{
       											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.scenerio,ActionName,obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       											// now write it in a negative pass dashboard file..
       											if(negativePassCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
       												 negativePassCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.scenerio,ActionName,obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
       											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

       										}
       										
       										
       									}
       									else
       									{
       										status="FAIL";failTestCaseCounter++;
       										//													utilfunc.TakeScreenshot();
       										utilfunc.TestngReportFail1(obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.testcaseid, utilfunc.Actualbrw,obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.scenerio,ActionName,obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       									
       										// now write it in a fail dashboard file..
       										if(failCounter==false){
       				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
       				    						failCounter	= true;
       			    						}
       										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.testcaseid, utilfunc.Actualbrw, obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.scenerio, ActionName, obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
       									}
       								}catch(Exception s){
       									System.out.println("some error occured in : "+ SuiteName);
       									
       								}
       							
        							}
							
							
                                   else if(SuiteName.equals("Survey Search")){
                                	   

       								
       								try{
       									startTime = System.currentTimeMillis();
       									Page_flag	=	obj_CIMS_Survey_Search.Survey_Search(fileName,SuiteName,count,ActionName);
       									timer = utilfunc.getTimeTakenByModule(startTime);
       									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
       									if (Page_flag)
       									{
       										status="PASS";passTestCaseCounter++;
       										if(utilfunc.globalerrormessage.equals(""))
       										{
       											utilfunc.TestngReportPass(obj_CIMS_Survey_Search.testcaseid, utilfunc.Actualbrw,obj_CIMS_Survey_Search.scenerio, ActionName,obj_CIMS_Survey_Search.description, status);
       											
       											// now write it in a pass file..
       											if(passCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Pass");} catch (Exception e) {}
       												 passCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardPassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Survey_Search.testcaseid, utilfunc.Actualbrw, obj_CIMS_Survey_Search.scenerio, ActionName, obj_CIMS_Survey_Search.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

       										}
       										else
       										{
       											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Survey_Search.testcaseid, utilfunc.Actualbrw,obj_CIMS_Survey_Search.scenerio,ActionName,obj_CIMS_Survey_Search.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       											// now write it in a negative pass dashboard file..
       											if(negativePassCounter==false){
       												 try {	obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Negative Pass");} catch (Exception e) {}
       												 negativePassCounter=true;
       											 }
       											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Survey_Search.testcaseid, utilfunc.Actualbrw,obj_CIMS_Survey_Search.scenerio,ActionName,obj_CIMS_Survey_Search.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
       											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

       										}
       										
       										
       									}
       									else
       									{
       										status="FAIL";failTestCaseCounter++;
       										//													utilfunc.TakeScreenshot();
       										utilfunc.TestngReportFail1(obj_CIMS_Survey_Search.testcaseid, utilfunc.Actualbrw,obj_CIMS_Survey_Search.scenerio,ActionName,obj_CIMS_Survey_Search.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
       									
       										// now write it in a fail dashboard file..
       										if(failCounter==false){
       				    						obj_Report_Dashboard.writeReportHeader(GeneralAdmin, sheetName,"Fail");
       				    						failCounter	= true;
       			    						}
       										try {obj_Report_Dashboard.writeDashBoardFailReport(GeneralAdmin, Employee_namecheck, obj_CIMS_Survey_Search.testcaseid, utilfunc.Actualbrw, obj_CIMS_Survey_Search.scenerio, ActionName, obj_CIMS_Survey_Search.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
       									}
       								}catch(Exception s){
       									System.out.println("some error occured in : "+ SuiteName);
       									
       								}
        									
       							}
                           
                                
                             
                              
						}
                                   
                                   
                                   
						                                   
                                   else{
                                	   System.out.println("i m here...");
                                	   try{
                                	   Thread.sleep(3000);
										timer = utilfunc.getTimeTakenByModule(startTime);
										status="PASS";passTestCaseCounter++;  
										//if(notAssignedCounter==false){obj_Report_Dashboard.writeReportHeader(sheetName, SuiteName,"Not Assigned");notAssignedCounter=true;}
  								     	String Errormessage="";
										String NotAssignTestCaseID="";
										String NotAssignScenerio="";
										String NotAssignTestCaseDescription="";
										int columnNumber_TCID;
										int columnNumber_Scenario;
										int columnNumber_TestCaseDescription;

										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
										System.out.println(Errormessage);

										columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
										columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
										columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

										NotAssignTestCaseID						=		UtilFunction.getCellData(fileName, sheetName, columnNumber_TCID, count);
										NotAssignScenerio						=		UtilFunction.getCellData(fileName, sheetName, columnNumber_Scenario, count);
										NotAssignTestCaseDescription			=		UtilFunction.getCellData(fileName, sheetName, columnNumber_TestCaseDescription, count);

										utilfunc.TestngReportFail(NotAssignTestCaseID, utilfunc.Actualbrw, NotAssignScenerio,ActionName,NotAssignTestCaseDescription,status,Errormessage);
										
										NumberOfNotAssignModule.add(SuiteName);
                               	  
										
										if(notAssignedCounter==false){
											 obj_Report_Dashboard.writeReportHeader(GeneralAdmin, SuiteName,"Not Assigned");
											 notAssignedCounter=true;
											 NotAssignedModuleCounter++;
										 }
										try {obj_Report_Dashboard.writeDashBoardNotAssignedReport(GeneralAdmin, Employee_namecheck, NotAssignTestCaseID, utilfunc.Actualbrw, 
												NotAssignScenerio, ActionName, NotAssignTestCaseDescription, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard not assigned report for : "+SuiteName);}


									}catch(Exception error){}

          								
          								
          							}
    						
    					
							
						}

					}
				
				} 
				}         
    	   catch(Exception e){

			}
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
		obj_Report_Dashboard.generateReportForSuite(GeneralAdmin,ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,
				FinalPositiveCount,FinalNegativeCount,TotalTime,NotAssignedModuleCount);
		}catch(Exception e){
			System.out.println("unable to call & generate dashboard report..");
		}



	}
	catch(Exception e){
		ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
		System.out.println("Script Failed!!!");
		utilfunc.assertion();
		utilfunc.TakeScreenshot();
	}

}



// Below Methods are getters and setters for Test Parameters.	

public String getSysDate() {
	return sysDate;
}
public void setobj_CIMS_Login(CIMS_Login setobj_CIMS_Login) {
	this.obj_CIMS_Login = setobj_CIMS_Login;
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

public void setobj_CIMS_Document_Type_Admin(CIMS_Document_Type_Admin setobj_CIMS_Document_Type_Admin) {
	this.obj_CIMS_Document_Type_Admin = setobj_CIMS_Document_Type_Admin;
}


public void setobj_CIMS_Email_Snippet_Admin(CIMS_Email_Snippet_Admin setobj_CIMS_Email_Snippet_Admin) {
	this.obj_CIMS_Email_Snippet_Admin = setobj_CIMS_Email_Snippet_Admin;
}

public void setobj_CIMS_Global_Reference_List(CIMS_Global_Reference_List setobj_CIMS_Global_Reference_List) {
	this.obj_CIMS_Global_Reference_List = setobj_CIMS_Global_Reference_List;
}

public void setobj_CIMS_Notification_Administration(CIMS_Notification_Administration setobj_CIMS_Notification_Administration) {
	this.obj_CIMS_Notification_Administration = setobj_CIMS_Notification_Administration;
}
public void setobj_CIMS_News_Admin(CIMS_News_Admin setobj_CIMS_News_Admin) {
	this.obj_CIMS_News_Admin = setobj_CIMS_News_Admin;
}

public void setobj_CIMS_Permission_Admin(CIMS_Permission_Admin setobj_CIMS_Permission_Admin) {
	this.obj_CIMS_Permission_Admin = setobj_CIMS_Permission_Admin;
}


public void setobj_CIMS_Report_Administration(CIMS_Report_Administration setobj_CIMS_Report_Administration) {
	this.obj_CIMS_Report_Administration = setobj_CIMS_Report_Administration;
}

public void setobj_CIMS_Service_Code_Category_Admin(CIMS_Service_Code_Category_Admin setobj_CIMS_Service_Code_Category_Admin) {
	this.obj_CIMS_Service_Code_Category_Admin = setobj_CIMS_Service_Code_Category_Admin;
}



public void setobj_CIMS_Service_Code_Classification_Admin(CIMS_Service_Code_Classification_Admin setobj_CIMS_Service_Code_Classification_Admin) {
	this.obj_CIMS_Service_Code_Classification_Admin = setobj_CIMS_Service_Code_Classification_Admin;
}

public void setobj_CIMS_Role_Admin(CIMS_Role_Admin setobj_CIMS_Role_Admin) {
	this.obj_CIMS_Role_Admin = setobj_CIMS_Role_Admin;
} 
public void setobj_CIMS_Resource_Type(CIMS_Resource_Type setobj_CIMS_Resource_Type) {
	this.obj_CIMS_Resource_Type = setobj_CIMS_Resource_Type;
} 


public void setobj_CIMS_Resources_Admin(CIMS_Resources_Admin setobj_CIMS_Resources_Admin) {
	this.obj_CIMS_Resources_Admin = setobj_CIMS_Resources_Admin;
}
public void setobj_CIMS_Policy_Disclaimer(CIMS_Policy_Disclaimer setobj_CIMS_Policy_Disclaimer) {
	this.obj_CIMS_Policy_Disclaimer = setobj_CIMS_Policy_Disclaimer;
}
public void setobj_CIMS_Government_Priority_Dates(CIMS_Government_Priority_Dates setobj_CIMS_Government_Priority_Dates) {
	this.obj_CIMS_Government_Priority_Dates = setobj_CIMS_Government_Priority_Dates;
}

public void setobj_CIMS_Questionnaire_Admin(CIMS_Questionnaire_Admin setobj_CIMS_Questionnaire_Admin) {
	this.obj_CIMS_Questionnaire_Admin = setobj_CIMS_Questionnaire_Admin;
}
public void setobj_CIMS_Questionnaire_Admin_Edit_Custom_Label(CIMS_Questionnaire_Admin_Edit_Custom_Label setobj_CIMS_Questionnaire_Admin_Edit_Custom_Label) {
	this.obj_CIMS_Questionnaire_Admin_Edit_Custom_Label = setobj_CIMS_Questionnaire_Admin_Edit_Custom_Label;
}
public void setobj_CIMS_Questionnaire_Admin_Edit_Document_Checklist(CIMS_Questionnaire_Admin_Edit_Document_Checklist setobj_CIMS_Questionnaire_Admin_Edit_Document_Checklist) {
	this.obj_CIMS_Questionnaire_Admin_Edit_Document_Checklist = setobj_CIMS_Questionnaire_Admin_Edit_Document_Checklist;
}
public void setobj_CIMS_Survey_Search(CIMS_Survey_Search setobj_CIMS_Survey_Search) {
	this.obj_CIMS_Survey_Search = setobj_CIMS_Survey_Search;
}










public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
	this.obj_Report_Dashboard = setobj_Report_Dashboard;
}

}		
