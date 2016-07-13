package CIMS;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import CIMS.Modules.Advanced.Project_Search;
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
import CIMS.Modules.GlobalCheck.CIMS_GCP_Assement;
import CIMS.Modules.GlobalCheck.CIMS_GCP_project_Initiation;
import CIMS.Modules.Questionnaires.CIMS_Login;
import CIMS.Modules.Regression.CIMS_GCP_NewQuery;
import CIMS.Modules.Regression.CIMS_Regression_Suite_Employee_Profile;
import CIMS.Modules.Regression.CIMS_Travel_History;
import CIMS.Modules.WebAccess.CIMS_Acountlocked;
import CIMS.Modules.WebAccess.CIMS_ForgotPassword;
import CIMS.Modules.WebAccess.CIMS_RestPassword_Module;
import CIMS.Modules.WebAccess.CIMS_WebAccessModule;
import CIMS.Reports.dashboard;

public class CIMS_GlobalCheck_Plus_process {


	
	private String sysDate;
	private WebDriver webdriver;		
	private UtilFunction utilfunc;		
	private CIMS_Login obj_CIMS_Login;
	private dashboard obj_Report_Dashboard;
	
	private CIMS_GCP_NewQuery		obj_CIMS_GCP_NewQuery;
	private CIMS_Travel_History     obj_CIMS_Travel_History;
	
	
	private CIMS_GCP_project_Initiation obj_CIMS_GCP_project_Initiation;
	private CIMS_GCP_Assement obj_CIMS_GCP_Assement;
	
    //file name that takes dynamically in all modules.
    public static String ExcelFileName="Test GlobalCheckplus.xls";
    public static String suiteName	=	"Global Check Plus";
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
				
                setobj_dashboard((new dashboard()));
                setobj_CIMS_GCP_NewQuery(new CIMS_GCP_NewQuery(webdriver, utilfunc));
                setobj_CIMS_Travel_History(new CIMS_Travel_History(webdriver,utilfunc));
                setobj_CIMS_GCP_project_Initiation(new CIMS_GCP_project_Initiation(webdriver,utilfunc));
                setobj_CIMS_GCP_Assement(new CIMS_GCP_Assement(webdriver,utilfunc));
                
                
                
				
				
				
				
				
				
				
				
				
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
public void CIMS_GlobalCheckPlusprocess() throws InterruptedException, IOException, AWTException {


	try {
		/* Project  Login*/	obj_CIMS_Login.Project_login(ExcelFileName);
		/*Welcome page*/	obj_CIMS_Login.Welcome_Page();
		
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
        
        
        boolean visitGCPLink					=	false;
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
	
		boolean passCounter	=	false;
		boolean failCounter	=	false;
		boolean negativePassCounter=false;
		boolean notAssignedCounter	=	false;
		
		
		//for ProcessQuestionnaire Assignment
		int GCP_Newquery_PositiveScenarioCounter	=	0;
		int GCP_Newquery_NegativeScenarioCounter	=	0;
		int GCP_Newquery_TotalTestCaseCounter		=	0;
		int GCP_Newquery_passTestCaseCounter		=	0;
		int GCP_Newquery_failTestCaseCounter		=	0;
		int GCP_Newquery_NotAssignedModuleCounter	=	0;
		int ProcessQuestionnaireAssignment_ModuleCounter			=	1;

		
		//Flags used for GCP New Query Modules
		    boolean GCP_Newquery_NotassignFlag=false;
			boolean GCP_Newquery_PassFlag1=false;
			boolean GCP_Newquery_PassFlag2=false;
			boolean GCP_Newquery_PassFlag3=false;
			//boolean GCP_Newquery_PassFlag4=false;
			boolean GCP_Newquery_FailFlag1=false;
			boolean GCP_Newquery_FailFlag2=false;
			boolean GCP_Newquery_FailFlag3=false;
			//boolean GCP_Newquery_FailFlag4=false;
			boolean GCP_Newquery_NegativePassFlag1=false;
			boolean GCP_Newquery_NegativePassFlag2=false;
			boolean GCP_Newquery_NegativePassFlag3=false;
		//	boolean GCP_Newquery_NegativePassFlag4=false;
			boolean GCP_Newquery_PassFlag1FINALREPORT=false;
			boolean GCP_Newquery_FailFlag1FINALREPORT=false;
		
		
		
		
		//Dharam add these lines for get count of +ve and -ve test cases.
		int PositiveScenarioCounter				=	0;
		int NegativeScenarioCounter				=	0;
		int ModuleCounter						=	0;
		int TotalTestCaseCounter				=	0;
		int passTestCaseCounter					=	0;
		int failTestCaseCounter					=	0;
		int NotAssignedModuleCounter			=	0;
		ArrayList NumberOfNotAssignModule = new ArrayList();

		String 	GlobalCheckPlus				    =		"Global Check Plus";
		int RowCount							=		UtilFunction.usedRowCount(fileName, GlobalCheckPlus);
		int columnNumber_RUNMODE				=		UtilFunction.getColumnWithCellData(fileName, GlobalCheckPlus, columnNameRM);
		int columnNumber_ACTION					=		UtilFunction.getColumnWithCellData(fileName, GlobalCheckPlus, columnNameAction);
		int columnNumber_SuiteName				=		UtilFunction.getColumnWithCellData(fileName, GlobalCheckPlus, "Suite Name");

		
	    startTotalTime = System.currentTimeMillis();
       for(int modCounter = 1;modCounter<RowCount;modCounter++){
    	passCounter	=	false;
   		failCounter	=	false;
   		negativePassCounter=false;
   		notAssignedCounter	=	false;
    	  
    	   try{
    		    
				// check if current suite name is set to runmode Y..
    		   
				if(UtilFunction.getCellData(fileName, GlobalCheckPlus, columnNumber_RUNMODE, modCounter).equals("Y")){
					
					
					ModuleCounter=ModuleCounter+1;
					SuiteName="";ActionName="";
					// now pick the name of regression suite, action, etc that is set to runmode Y

					SuiteName				=		UtilFunction.getCellData(fileName, GlobalCheckPlus, columnNumber_SuiteName, modCounter);
					ActionName				=		UtilFunction.getCellData(fileName, GlobalCheckPlus, columnNumber_ACTION, modCounter);

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
							if(SuiteName.equals("GCP_NewQuery")){
								
								LinkName	=	"New Query";	
							}else{
								LinkName	=	SuiteName;
							}
							
							try {
								Thread.sleep(5000);
									visitGCPLink	=	utilfunc.goToMenuSubItems(LinkName);
									Thread.sleep(5000);
							} catch (Exception e1) {
								System.out.println("Unable to clicked on the link");
							}
						if(visitGCPLink){

							if(SuiteName.equals("GCP_NewQuery")){
								
								
								String GCP_New_Query_Scenariotext	= 	UtilFunction.getCellData(fileName, sheetName, Scenariocol, count);

								if(GCP_New_Query_Scenariotext.equals("Positive") || GCP_New_Query_Scenariotext.contains("sitive") || GCP_New_Query_Scenariotext.contains("Pos")){
									GCP_Newquery_PositiveScenarioCounter++;
								}else if(GCP_New_Query_Scenariotext.equals("Negative") || GCP_New_Query_Scenariotext.contains("gative") || GCP_New_Query_Scenariotext.contains("gavtive") ){
									GCP_Newquery_NegativeScenarioCounter++;
								}
								GCP_Newquery_TotalTestCaseCounter++;
								
								boolean GCP_New_QueryIsAssignOrNot=false;
								GCP_New_QueryIsAssignOrNot=true;
								
								if(GCP_New_QueryIsAssignOrNot==true)
								{
									boolean GCP_New_Query_FlagStep1 = false;
									boolean GCP_New_Query_FlagStep2 = false;
									boolean GCP_New_Query_FlagStep3 = false;
									boolean GCP_New_Query_FlagStep4 = false;

								
								
								try{
									startTime = System.currentTimeMillis();
									GCP_New_Query_FlagStep1	=	obj_CIMS_GCP_NewQuery.GCP_NewQuery_Initiation_Page(fileName,SuiteName,count,ActionName);
									timer = utilfunc.getTimeTakenByModule(startTime);
									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									if (GCP_New_Query_FlagStep1)
									{
										status="PASS";  
										if(utilfunc.globalerrormessage.equals(""))
										{
											utilfunc.TestngReportPass(obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_NewQuery.scenerio, ActionName,obj_CIMS_GCP_NewQuery.description, status);
											
											// now write it in a pass file..
											if(GCP_Newquery_PassFlag1==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName,"Pass");} catch (Exception e) {}
												 GCP_Newquery_PassFlag1=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardPassReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio, ActionName, obj_CIMS_GCP_NewQuery.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

										}
										else
										{
											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_NewQuery.scenerio,ActionName,obj_CIMS_GCP_NewQuery.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											// now write it in a negative pass dashboard file..
											if(GCP_Newquery_NegativePassFlag1==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName,"Negative Pass");} catch (Exception e) {}
												 GCP_Newquery_NegativePassFlag1=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_NewQuery.scenerio,ActionName,obj_CIMS_GCP_NewQuery.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

										}
										
										
									}
									else
									{
										status="FAIL";
										//													utilfunc.TakeScreenshot();
										utilfunc.TestngReportFail1(obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_NewQuery.scenerio,ActionName,obj_CIMS_GCP_NewQuery.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									
										// now write it in a fail dashboard file..
										if(GCP_Newquery_FailFlag1==false){
				    						obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName,"Fail");
				    						GCP_Newquery_FailFlag1	= true;
			    						}
										try {obj_Report_Dashboard.writeDashBoardFailReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio, ActionName, obj_CIMS_GCP_NewQuery.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
									}
								}catch(Exception s){
									System.out.println("some error occured in : "+ SuiteName);
									
								}
								
								
								// Step 2 start from here
								
								try{
									startTime = System.currentTimeMillis();
									GCP_New_Query_FlagStep2	=	obj_CIMS_GCP_project_Initiation.GCP_NewQuery_Initiation_Page(fileName,SuiteName,count,ActionName);
									timer = utilfunc.getTimeTakenByModule(startTime);
									utilfunc.updateModuleDataForReportGeneration(sheetName+" - GCP_Initiation", Employee_namecheck, timer);
									if (GCP_New_Query_FlagStep2)
									{
										status="PASS";
										if(utilfunc.globalerrormessage.equals(""))
										{
											utilfunc.TestngReportPass(obj_CIMS_GCP_project_Initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_project_Initiation.scenerio, ActionName,obj_CIMS_GCP_project_Initiation.description, status);
											
											// now write it in a pass file..
											if(GCP_Newquery_PassFlag2==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName+" - GCP_Initiation","Pass");} catch (Exception e) {}
												 GCP_Newquery_PassFlag2=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardPassReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_project_Initiation.scenerio, ActionName, obj_CIMS_GCP_project_Initiation.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

										}
										else
										{
											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_GCP_project_Initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_project_Initiation.scenerio,ActionName,obj_CIMS_GCP_project_Initiation.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											// now write it in a negative pass dashboard file..
											if(GCP_Newquery_NegativePassFlag2==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName+" - GCP_Initiation","Negative Pass");} catch (Exception e) {}
												 GCP_Newquery_NegativePassFlag2=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_project_Initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_project_Initiation.scenerio,ActionName,obj_CIMS_GCP_project_Initiation.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

										}
										
										
									}
									else
									{
										status="FAIL";
										//													utilfunc.TakeScreenshot();
										utilfunc.TestngReportFail1(obj_CIMS_GCP_project_Initiation.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_project_Initiation.scenerio,ActionName,obj_CIMS_GCP_project_Initiation.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									
										// now write it in a fail dashboard file..
										if(GCP_Newquery_FailFlag2==false){
				    						obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName+" - GCP_Initiation","Fail");
				    						GCP_Newquery_FailFlag2	= true;
			    						}
										try {obj_Report_Dashboard.writeDashBoardFailReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_project_Initiation.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_project_Initiation.scenerio, ActionName, obj_CIMS_GCP_project_Initiation.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
									}
								}catch(Exception s){
									System.out.println("some error occured in : "+ SuiteName);
									
								}
								
								//Step 3- Start From Here
								

								
								try{
									startTime = System.currentTimeMillis();
									GCP_Newquery_PassFlag3	=	obj_CIMS_GCP_Assement.GCP_NewQuery_Initiation_Page(fileName,SuiteName,count,ActionName);
									timer = utilfunc.getTimeTakenByModule(startTime);
									utilfunc.updateModuleDataForReportGeneration(sheetName+" - GCP_Assessment", Employee_namecheck, timer);
									if (GCP_Newquery_PassFlag3)
									{
										status="PASS";
										if(utilfunc.globalerrormessage.equals(""))
										{
											utilfunc.TestngReportPass(obj_CIMS_GCP_Assement.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_Assement.scenerio, ActionName,obj_CIMS_GCP_Assement.description, status);
											
											// now write it in a pass file..
											if(GCP_Newquery_PassFlag3==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName+"- GCP_Assessment","Pass");} catch (Exception e) {}
												 GCP_Newquery_PassFlag3=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardPassReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_Assement.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_Assement.scenerio, ActionName, obj_CIMS_GCP_Assement.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}

										}
										else
										{
											utilfunc.TestngReportNegativePassTestcase(obj_CIMS_GCP_Assement.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_Assement.scenerio,ActionName,obj_CIMS_GCP_Assement.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											// now write it in a negative pass dashboard file..
											if(GCP_Newquery_NegativePassFlag3==false){
												 try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName+"- GCP_Assessment","Negative Pass");} catch (Exception e) {}
												 GCP_Newquery_NegativePassFlag3=true;
											 }
											try {obj_Report_Dashboard.writeDashBoardNegativePassReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_Assement.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_Assement.scenerio,ActionName,obj_CIMS_GCP_Assement.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);}
											catch (Exception e) {System.out.println("unable to write dasboard negative pass report for : "+SuiteName);}

										}
										
										
									}
									else
									{
										status="FAIL";
										//													utilfunc.TakeScreenshot();
										utilfunc.TestngReportFail1(obj_CIMS_GCP_Assement.testcaseid, utilfunc.Actualbrw,obj_CIMS_GCP_Assement.scenerio,ActionName,obj_CIMS_GCP_Assement.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									
										// now write it in a fail dashboard file..
										if(GCP_Newquery_FailFlag3==false){
				    						obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName+"- GCP_Assessment","Fail");
				    						GCP_Newquery_FailFlag3	= true;
			    						}
										try {obj_Report_Dashboard.writeDashBoardFailReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_Assement.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_Assement.scenerio, ActionName, obj_CIMS_GCP_Assement.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
									}
								}catch(Exception s){
									System.out.println("some error occured in : "+ SuiteName);
									
								}
								
								// Step 3rd has been end here 
								
								//////////////////////////////////////////Final Report////////////////////////////////////
								//flag check to make testcase pass or fail
								
								
								//boolean GCP_New_Query_FlagStep1 = false;
								//boolean GCP_New_Query_FlagStep2 = false;
								//boolean GCP_New_Query_FlagStep3 = false;
								//boolean GCP_New_Query_FlagStep4 = false;

								
								if(!GCP_New_Query_FlagStep1 || !GCP_New_Query_FlagStep2
										||!GCP_New_Query_FlagStep3 ){
											
									
									GCP_Newquery_failTestCaseCounter++;
																				
									utilfunc.TestngReportFail1(obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio,ActionName, obj_CIMS_GCP_NewQuery.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);

									// now write it in a fail dashboard file START...
									if(GCP_Newquery_FailFlag1FINALREPORT==false){
										try{ obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, SuiteName+" - Final Report","Fail");
										}catch(Exception e){}
										GCP_Newquery_FailFlag1FINALREPORT= true;
									}// now write it in a fail dashboard file ENDS...
									try {
										obj_Report_Dashboard.writeDashBoardFailReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio,ActionName, obj_CIMS_GCP_NewQuery.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
									} catch (Exception e) {
										System.out.println("unable to write dasboard fail report for : "+SuiteName+" - Final Report");}

								
								}else{
									GCP_Newquery_passTestCaseCounter++;
									
									utilfunc.TestngReportPass(obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio, ActionName, obj_CIMS_GCP_NewQuery.description, status);
									// now write it in a pass file START...
									if(GCP_Newquery_PassFlag1FINALREPORT==false){
										try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, SuiteName+" - Final Report ", "Pass");
										}catch(Exception e){}
										GCP_Newquery_PassFlag1FINALREPORT=true;
									}
									// now write it in a pass file ENDS...

									//Write Positive Pass dashboard report 
									try {
										obj_Report_Dashboard.writeDashBoardPassReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_GCP_NewQuery.testcaseid, utilfunc.Actualbrw, obj_CIMS_GCP_NewQuery.scenerio, ActionName, obj_CIMS_GCP_NewQuery.description, status, timer);
									}catch(Exception e){
										System.out.println("unable to write dasboard pass report for : "+SuiteName+" - Final Report");}
									
								}

								
								
								
								
								
								
								
							
							}else{
								
								//means ProcessQuestionnaireAssignmentIsAssignOrNot==false
								try{
									Thread.sleep(3000);
									timer = utilfunc.getTimeTakenByModule(startTime);
									status="PASS";
									String GCP_New_Query_Errormessage="";
									String GCP_New_Query_NotAssignTestCaseID="";
									String GCP_New_Query_NotAssignScenerio="";
									String GCP_New_Query_NotAssignTestCaseDescription="";
									int GCP_New_Query_columnNumber_TCID;
									int GCP_New_Query_columnNumber_Scenario;
									int GCP_New_Query_columnNumber_TestCaseDescription;

									utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
									GCP_New_Query_Errormessage=""+SuiteName+" is not assigned to "+Employee_namecheck+" User";
									System.out.println(GCP_New_Query_Errormessage);

									GCP_New_Query_columnNumber_TCID						=		UtilFunction.getColumnWithCellData(fileName, sheetName, "TCID");
									GCP_New_Query_columnNumber_Scenario					=		UtilFunction.getColumnWithCellData(fileName, sheetName, "SCENARIO");
									GCP_New_Query_columnNumber_TestCaseDescription		=		UtilFunction.getColumnWithCellData(fileName, sheetName, "Test Case Description");

									GCP_New_Query_NotAssignTestCaseID=UtilFunction.getCellData(fileName, sheetName, GCP_New_Query_columnNumber_TCID, count);
									GCP_New_Query_NotAssignScenerio=UtilFunction.getCellData(fileName, sheetName, GCP_New_Query_columnNumber_Scenario, count);
									GCP_New_Query_NotAssignTestCaseDescription=UtilFunction.getCellData(fileName, sheetName, GCP_New_Query_columnNumber_TestCaseDescription, count);

									utilfunc.TestngReportFail(GCP_New_Query_NotAssignTestCaseID, utilfunc.Actualbrw, GCP_New_Query_NotAssignScenerio,ActionName,GCP_New_Query_NotAssignTestCaseDescription,status,GCP_New_Query_Errormessage);
									//now write it in a notAssign file START...
									if(GCP_Newquery_NotassignFlag==false){
										try{	obj_Report_Dashboard.writeReportHeader(SuiteName, SuiteName,"Not Assigned");
										}catch(Exception e){}
										GCP_Newquery_NotassignFlag=true;
									}//now write it in a notAssign file ENDS...
									GCP_Newquery_NotAssignedModuleCounter=1;	
									try {
										obj_Report_Dashboard.writeDashBoardNotAssignedReport(SuiteName, Employee_namecheck, GCP_New_Query_NotAssignTestCaseID, utilfunc.Actualbrw, GCP_New_Query_NotAssignScenerio, ActionName, GCP_New_Query_NotAssignTestCaseDescription, "Not Assigned", utilfunc.timer);
									} catch (InterruptedException e) {
										System.out.println("unable to write Not Assign report");
									}

								}catch(Exception e){
									System.out.println("");
								}
							
							}
								
							} 
							
							if(SuiteName.equals("Travel History")){

									startTime = System.currentTimeMillis();
								
									try{
										Page_flag	=	obj_CIMS_Travel_History.Travel_History(fileName,SuiteName,count,ActionName);
										timer = utilfunc.getTimeTakenByModule(startTime);
										utilfunc.updateModuleDataForReportGeneration(SuiteName, Employee_namecheck, timer);
										if (Page_flag)
										{
											status="PASS";
											passTestCaseCounter++;
											if(utilfunc.globalerrormessage.equals(""))
											{
												utilfunc.TestngReportPass(obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio, ActionName, obj_CIMS_Travel_History.description, status);
												// now write it in a pass file START...
												if(passCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName, "Pass");
													}catch(Exception e){}
													passCounter=true;
												}// now write it in a pass file ENDS...

												//Write Positive Pass dashboard report 
												try {
													obj_Report_Dashboard.writeDashBoardPassReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio, ActionName, obj_CIMS_Travel_History.description, status, timer);
												}catch(Exception e){
													System.out.println("unable to write dasboard pass report for : "+SuiteName);}
											}
											else
											{
												utilfunc.TestngReportNegativePassTestcase(obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw,obj_CIMS_Travel_History.scenerio,ActionName,obj_CIMS_Travel_History.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												// now write it in a negative pass dashboard file START...
												if(negativePassCounter==false){
													try {	obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName,"Negative Pass");
													}catch(Exception e){}
													negativePassCounter=true;
												}// now write it in a negative pass dashboard file ENDS...

												//Write negative pass dashboard report   obj_Project_Initiation.testcaseId
												try {
													obj_Report_Dashboard.writeDashBoardNegativePassReport(GlobalCheckPlus,Employee_namecheck,obj_CIMS_Travel_History.testcaseid,utilfunc.Actualbrw,obj_CIMS_Travel_History.scenerio,ActionName,obj_CIMS_Travel_History.description,status,timer,utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
												} catch (Exception e) {
													System.out.println("unable to write dasboard negative pass report for : "+ GlobalCheckPlus);}
											}
											/*if(passCounter==false){
											 try {	obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Pass");} catch (Exception e) {}
											 passCounter=true;
										 }
										try {obj_Report_Dashboard.writeDashBoardPassReport(RegressionSuites, Employee_namecheck, obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio, ActionName, obj_CIMS_Travel_History.description, status, timer);} catch (Exception e) {System.out.println("unable to write dasboard pass report for : "+SuiteName);}
											 */
										}
										else
										{
											status="FAIL";
											failTestCaseCounter++;
											utilfunc.TakeScreenshot();
											utilfunc.TestngReportFail1(obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio,ActionName, obj_CIMS_Travel_History.description, status, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											// now write it in a fail dashboard file START...
											if(negativePassCounter==false){
												try{ obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, sheetName,"Fail");
												}catch(Exception e){}
												negativePassCounter	= true;
											}// now write it in a fail dashboard file ENDS...
											try {
												obj_Report_Dashboard.writeDashBoardFailReport(GlobalCheckPlus, Employee_namecheck, obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio,ActionName, obj_CIMS_Travel_History.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);
											} catch (Exception e) {
												System.out.println("unable to write dasboard fail report for : "+GlobalCheckPlus);}
											/*if(failCounter==false){
				    						obj_Report_Dashboard.writeReportHeader(RegressionSuites, sheetName,"Fail");
				    						failCounter	= true;
			    						}
										try {obj_Report_Dashboard.writeDashBoardFailReport(RegressionSuites, Employee_namecheck, obj_CIMS_Travel_History.testcaseid, utilfunc.Actualbrw, obj_CIMS_Travel_History.scenerio,ActionName, obj_CIMS_Travel_History.description, status, timer, utilfunc.ErrorMessage2,utilfunc.ErrorMessage1,utilfunc.ErrorMessage4);} catch (Exception e) {System.out.println("unable to write dasboard fail report for : "+SuiteName);}
											 */
										}
									}catch(Exception e){
										ErrorUtil.addVerificationFailure(new Throwable("Error Occured !!"));
										System.out.println("Script Failed");
										utilfunc.assertion();			
										utilfunc.TakeScreenshot();
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
											 obj_Report_Dashboard.writeReportHeader(GlobalCheckPlus, SuiteName,"Not Assigned");
											 notAssignedCounter=true;
											 NotAssignedModuleCounter++;
										 }
										try {obj_Report_Dashboard.writeDashBoardNotAssignedReport(GlobalCheckPlus, Employee_namecheck, NotAssignTestCaseID, utilfunc.Actualbrw, 
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
		obj_Report_Dashboard.generateReportForSuite(GlobalCheckPlus,ModuleCount,TotalTestCaseCount,PositiveScenarioCount,NegativeScenarioCount,
				FinalPositiveCount,FinalNegativeCount,TotalTime,NotAssignedModuleCount);
		}catch(Exception e){
			System.out.println("unable to call & generate dashboard report..");
		}


		Employee_namecheck=null;
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

public void setobj_CIMS_GCP_NewQuery(CIMS_GCP_NewQuery setobj_CIMS_GCP_NewQuery) {
	this.obj_CIMS_GCP_NewQuery	=	setobj_CIMS_GCP_NewQuery;
}
public void setobj_CIMS_Travel_History(CIMS_Travel_History setobj_CIMS_Travel_History) {
	this.obj_CIMS_Travel_History=setobj_CIMS_Travel_History;
}

public void setobj_CIMS_GCP_project_Initiation(CIMS_GCP_project_Initiation setobj_CIMS_GCP_project_Initiation) {
	this.obj_CIMS_GCP_project_Initiation=setobj_CIMS_GCP_project_Initiation;
}

public void setobj_CIMS_GCP_Assement(CIMS_GCP_Assement setobj_CIMS_GCP_Assement) {
	this.obj_CIMS_GCP_Assement=setobj_CIMS_GCP_Assement;
}












public void setobj_dashboard(dashboard setobj_Report_Dashboard) {
	this.obj_Report_Dashboard = setobj_Report_Dashboard;
}

}
